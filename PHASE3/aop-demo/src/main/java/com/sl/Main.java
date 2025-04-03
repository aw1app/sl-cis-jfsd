package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan({ "com.sl" })
@Configuration
@EnableAspectJAutoProxy
public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

		BankAccount bankAcct = context.getBean(BankAccount.class);
		
		bankAcct.deposit(10000000);
		
		double amtWithdrawn = bankAcct.withdraw(500);
		
		
		
		
		//  Create a X object
		X x1 = context.getBean(X.class);
		
		x1.methodX1();
		
		
		double amtWithdrawn1 = bankAcct.withdraw(1000000);

	}

}
