package com.order.domain;

public class Finance {
	
	private int pay;
	private int income;
	
	public Finance(){
		
	}
	public Finance(int pay,int income){
		this.pay = pay;
		this.income = income;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	
}
