package com.hashmap.InvestmentPlanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	public static List<Plan> plans = new ArrayList<Plan>();
	static int planInc;
	
	//@CrossOrigin(origins = "*")
	@GetMapping("/index")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	//@CrossOrigin(origins = "*")
	@RequestMapping(value = "/savePlan", method = {RequestMethod.POST})
	public Integer savePlan(@RequestBody InvestmentSaveDto saveDto)
	{
		Plan p = new Plan();
		p.fdInvestPercentage = saveDto.getFdInvestPercentage();
		p.goldInvestPercentage = saveDto.getGoldInvestPercentage();
		p.mfInvestPercentage = saveDto.getMfInvestPercentage();
		p.niftyInvestPercentage = saveDto.getNiftyInvestPercentage();
		p.ppfInvestPercentage = saveDto.getPpfInvestPercentage();
		p.propertyInvestPercentage = saveDto.getPropertyInvestPercentage();
		p.totalAmount = saveDto.getTotalAmount();
		
		p.calculateAmountForPercentage();
		
		planInc = planInc + 1;
		p.planId = planInc;
		p.planName = "Plan " + p.planId;
		plans.add(p);
		return p.planId;
	}
	
	//@CrossOrigin(origins = "*")
	@GetMapping("/getAllPlans")
	public List<PlanListDto> getAllPlans()
	{
		List<PlanListDto> planList = new ArrayList<PlanListDto>();
		
		for(int i=0; i<plans.size(); i++)
		{
			PlanListDto plan = new PlanListDto();
			plan.setPlanId(plans.get(i).planId);
			plan.setPlanName(plans.get(i).planName);
			planList.add(plan);
		}
		return planList;
	}
	
	//@CrossOrigin(origins = "*")
	@GetMapping("/getReturnForPlan")
	public PlanReturnDto getReturnForPlan(@RequestParam("id") Optional<Integer> id)
	{
		int planId = id.get();
		Plan p = null;
		for(int i=0; i<plans.size(); i++)
		{
			if(plans.get(i).planId.equals(planId))
			{
				p = plans.get(i);
			}
		}
		
		PlanReturnDto plaR = new PlanReturnDto();
		plaR.goldInvestPercentage = p.goldInvestPercentage;
		plaR.fdInvestPercentage = p.fdInvestPercentage;
		plaR.mfInvestPercentage = p.mfInvestPercentage;
		plaR.niftyInvestPercentage = p.niftyInvestPercentage;
		plaR.propertyInvestPercentage = p.propertyInvestPercentage;
		plaR.fdInvestPercentage = p.fdInvestPercentage;
		
		plaR.returns =  p.calculateReturns();
		return plaR;
	}
	
	//@CrossOrigin(origins = "*")
	@GetMapping("/getInvestmentRisks")
	public InvestmentRisks getInvestmentRisks()
	{
		return new InvestmentRisks();
	}
}