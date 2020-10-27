package com.training.examples;

public class Bank {

	double balance;

	public Bank(double balance) {
		super();
		this.balance = balance;
	}
	
	public double withdraw(double amount) throws ExceedingException {
		if(amount<0) {
			throw new NegValException("Amount less than 0");
		}
		if(amount>=4000 || amount==balance) {
			throw new ExceedingException("Amount beyond limit");
		}
		balance = balance-amount;
		return balance;
	}
	
	public double deposit(double amount) throws ExceedingException {
		if(amount<0) {
			throw new NegValException("Amount less than 0");
		}
		if(amount>=100000) {
			throw new ExceedingException("Amount beyond limit");
		}
		balance = balance+amount;
		return balance;
	}
	
}
