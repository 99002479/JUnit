package com.training.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.training.examples.Bank;
import com.training.examples.ExceedingException;
import com.training.examples.NegValException;

class BankTest {
	
	Bank bank;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Init");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Destroy");
	}

	@BeforeEach
	void setUp() throws Exception {
		bank = new Bank(8000);
		System.out.println("Before each testcases");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		bank = null;
		System.out.println("After each testcases");
	}

	@Test
	void testWithdraw() throws ExceedingException {
		double balance = bank.withdraw(2000);
		assertEquals(6000, balance,"should be 6000");
	}
	
	@Test
	void testWithdrawExceeding() {
		assertThrows(ExceedingException.class, 
		()-> bank.withdraw(4000));
	}
	
	@Test
	void testWithdrawNeg() {
		assertThrows(NegValException.class, 
		()-> bank.withdraw(-100));
	}
	
	@Test
	@DisplayName("WITHDRAW EQUAL")
	void testWithdrawEq() {
		assertThrows(ExceedingException.class, 
		()-> bank.withdraw(8000));
	}
	
	@Test
	void testDeposit() throws ExceedingException {
		double balance = bank.deposit(2000);
		assertEquals(10000, balance,"should be 10000");
	}
	
	@Test
	void testDepositNeg() {
		assertThrows(NegValException.class, 
		()-> bank.deposit(-100));
	}
	
	@Test
	void testDepositExceeding() {
		assertThrows(ExceedingException.class, 
		()-> bank.deposit(100000));
	}

}




















