package com.hashmap.InvestmentPlanner;

import java.util.ArrayList;
import java.util.List;

public class Plan {

	String planName;
	Integer planId;
	
	double goldInvestPercentage;
	double goldInvestAmount;
	
	double propertyInvestPercentage;
	double propertyInvestAmount;
	
	double niftyInvestPercentage;
	double niftyInvestAmount;
	
	double ppfInvestPercentage;
	double ppfInvestAmount;
	
	double mfInvestPercentage;
	double mfInvestAmount;
	
	double fdInvestPercentage;
	double fdInvestAmount;
	
	double totalAmount;
	
	public Plan()
	{
	}
	
	public void calculateAmountForPercentage()
	{
		goldInvestAmount = (goldInvestPercentage * totalAmount) / 100;
		propertyInvestAmount = (propertyInvestPercentage * totalAmount) / 100;
		niftyInvestAmount = (niftyInvestPercentage * totalAmount) / 100;
		ppfInvestAmount = (ppfInvestPercentage * totalAmount) / 100;
		mfInvestAmount = (mfInvestPercentage * totalAmount) / 100;
		fdInvestAmount = (fdInvestPercentage * totalAmount) / 100;
	}
		
	public List<InvestmentReturns> calculateReturns()
	{
		List<InvestmentReturns> returns = new ArrayList<InvestmentReturns>();
		for(int i=1; i<=50; i++)
		{
			InvestmentReturns r = new InvestmentReturns();
			r.year = 2020 + i;
			r.yearNumber = i;
//			r.setFdReturnsAmount((Investment.fdGrowthRate * i) * fdInvestAmount);
//			r.setMfReturnsAmount((Investment.mfGrowthRate * i) * mfInvestAmount);
//			r.setPpfReturnsAmount((Investment.ppfGrowthRate * i) * ppfInvestAmount);
//			r.setNiftyReturnsAmount((Investment.niftyGrowthRate * i) * niftyInvestAmount);
//			r.setPropertyReutrnsAmount((Investment.propertyGrowthRate * i) * propertyInvestPercentage);
//			r.setGoldReturnsAmount((Investment.goldGrowthRate * i) * goldInvestAmount);
			
			r.fdReturnsAmount =  fdInvestAmount;
			r.mfReturnsAmount = mfInvestAmount;
			r.ppfReturnsAmount =  ppfInvestAmount;
			r.niftyReturnsAmount = niftyInvestAmount;
			r.propertyReutrnsAmount =  propertyInvestAmount;
			r.goldReturnsAmount =  goldInvestAmount;
			
			for(int j=1; j<=i;j++)
			{
				r.fdReturnsAmount = ((Investment.fdGrowthRate ) * r.fdReturnsAmount) + r.fdReturnsAmount;
				r.mfReturnsAmount = ((Investment.mfGrowthRate ) * r.mfReturnsAmount) + r.mfReturnsAmount;
				r.ppfReturnsAmount = ((Investment.ppfGrowthRate ) * r.ppfReturnsAmount) + r.ppfReturnsAmount;
				r.niftyReturnsAmount = ((Investment.niftyGrowthRate ) * r.niftyReturnsAmount) + r.niftyReturnsAmount;
				r.propertyReutrnsAmount = ((Investment.propertyGrowthRate ) * r.propertyReutrnsAmount) + r.propertyReutrnsAmount;
				r.goldReturnsAmount = ((Investment.goldGrowthRate ) * r.goldReturnsAmount) + r.goldReturnsAmount;
			}
			
			
			double totalReturnAmount = (r.fdReturnsAmount + r.mfReturnsAmount + r.ppfReturnsAmount
					+ r.niftyReturnsAmount + r.propertyReutrnsAmount + r.goldReturnsAmount);
			
			r.fdReturnsPercentage = (r.fdReturnsAmount * 100) / totalReturnAmount;
			r.mfReturnsPercentage = (r.mfReturnsAmount * 100) / totalReturnAmount;
			r.ppfReturnsPercentage = (r.ppfReturnsAmount * 100) / totalReturnAmount;
			r.niftyReturnsPercentage = (r.niftyReturnsAmount * 100) / totalReturnAmount;
			r.propertyReturnsPercentage = (r.propertyReutrnsAmount * 100) / totalReturnAmount;
			r.goldReturnsPercentage = (r.goldReturnsAmount * 100) / totalReturnAmount;
			
			r.setPlanId(planId);
			//r.setTotalReturns(totalReturnAmount);
			returns.add(r);
		} 
		return returns;
	}
}
