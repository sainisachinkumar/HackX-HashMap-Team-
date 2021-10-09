package com.hashmap.InvestmentPlanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	public static List<Plan> plans = new ArrayList<Plan>();
	static int planInc;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/index")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/savePlan", method = {RequestMethod.POST})
	public Integer savePlan(@RequestBody InvestmentSaveDto saveDto)
	{
		Plan p = new Plan();
		p.fdInvestPercentage = saveDto.getFdInvestPercentage();
		p.goldInvestPercentage = saveDto.getGoldInvestPercentage();
		p.mfInvestAmount = saveDto.getMfInvestPercentage();
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
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getAllPlans")
	public HashMap<Integer, String> getAllPlans()
	{
		HashMap<Integer, String> plansMap = new HashMap<Integer, String>();
		
		for(int i=0; i<plans.size(); i++)
		{
			plansMap.put(plans.get(i).planId, plans.get(i).planName);
		}
		return plansMap;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getReturnForPlan")
	public List<InvestmentReturns> getReturnForPlan()
	{
		int planId = 1;
		Plan p = new Plan();
		for(int i=0; i<plans.size(); i++)
		{
			if(plans.get(i).planId.equals(planId))
			{
				p = plans.get(i);
			}
		}
		List<InvestmentReturns> r =  p.calculateReturns();
		return r;
	}
}