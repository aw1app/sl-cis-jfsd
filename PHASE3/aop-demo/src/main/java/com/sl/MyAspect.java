package com.sl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(* com.sl.BankAccount.*(..))")
	public void aspectM1() {

		// System.out.println(" (LOG) Hi, this is an Before type INTERCEPTOR/ADVICE ");
		try {
			Files.writeString(Path.of("f:\\log.txt"),
					"\n(LOG) Hi, this is an Before type INTERCEPTOR/ADVICE coming from aspectM1 method",
					StandardOpenOption.APPEND);

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	@Before("execution(* com.sl.*.*(..))")
	public void aspectM2() {

		// System.out.println(" (LOG) Hi, this is an Before type INTERCEPTOR/ADVICE ");
		try {
			Files.writeString(Path.of("f:\\log.txt"),
					"\n (LOG-BEFORE) coming from aspectM2 method",
					StandardOpenOption.APPEND);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	// for any class and any method inside com.sl package
	@After("execution(* com.sl.X.*(..))")
	public void aspectM3() {

		// System.out.println(" (LOG) Hi, this is an Before type INTERCEPTOR/ADVICE ");
		try {
			Files.writeString(Path.of("f:\\log.txt"),
					"\n (LOG-AFTER) from aspectM3 method",
					StandardOpenOption.APPEND);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	
	@AfterReturning(pointcut = "execution(* com.sl.BankAccount.withdraw(..))", returning = "result")
	public void aspectM4(double result) {
        
		
		// System.out.println(" (LOG) Hi, this is an Before type INTERCEPTOR/ADVICE ");
		try {
			Files.writeString(Path.of("f:\\log.txt"),
					"\n (LOG-AFTER-RETURNING) from aspectM4 method. Withdrawal amount is " + result,
					StandardOpenOption.APPEND);
			
			if(result>100000)
				Files.writeString(Path.of("f:\\log.txt"),
						"\n (LOG-AFTER-RETURNING) ALERT!!!!! Withdrawal amount is greater than 1 Lakh!! " + result,
						StandardOpenOption.APPEND);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
