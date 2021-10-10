package com.hashmap.InvestmentPlanner;

import java.util.List;

public class PlanReturnDto {
	
	double goldInvestPercentage;
	
	double propertyInvestPercentage;

	
	double niftyInvestPercentage;

	
	double ppfInvestPercentage;

	
	double mfInvestPercentage;

	
	double fdInvestPercentage;

	
	double totalAmount;
	
	List<InvestmentReturns> returns;

	public double getGoldInvestPercentage() {
		return goldInvestPercentage;
	}

	public void setGoldInvestPercentage(double goldInvestPercentage) {
		this.goldInvestPercentage = goldInvestPercentage;
	}

	public double getPropertyInvestPercentage() {
		return propertyInvestPercentage;
	}

	public void setPropertyInvestPercentage(double propertyInvestPercentage) {
		this.propertyInvestPercentage = propertyInvestPercentage;
	}

	public double getNiftyInvestPercentage() {
		return niftyInvestPercentage;
	}

	public void setNiftyInvestPercentage(double niftyInvestPercentage) {
		this.niftyInvestPercentage = niftyInvestPercentage;
	}

	public double getPpfInvestPercentage() {
		return ppfInvestPercentage;
	}

	public void setPpfInvestPercentage(double ppfInvestPercentage) {
		this.ppfInvestPercentage = ppfInvestPercentage;
	}

	public double getMfInvestPercentage() {
		return mfInvestPercentage;
	}

	public void setMfInvestPercentage(double mfInvestPercentage) {
		this.mfInvestPercentage = mfInvestPercentage;
	}

	public double getFdInvestPercentage() {
		return fdInvestPercentage;
	}

	public void setFdInvestPercentage(double fdInvestPercentage) {
		this.fdInvestPercentage = fdInvestPercentage;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<InvestmentReturns> getReturns() {
		return returns;
	}

	public void setReturns(List<InvestmentReturns> returns) {
		this.returns = returns;
	}
	
	
	
}
