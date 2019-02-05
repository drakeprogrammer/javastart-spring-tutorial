package pl.drakeprogrammer.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	@Before("execution(* pl.drakeprogrammer.repository.BookRepository.*(..))")
	public void logInfoBefore() {
		System.out.println("Log before ");
	}

	@After("execution(* pl.drakeprogrammer.repository.BookRepository.*(..))")
	public void logInfoAfter() {
		System.out.println("Method executed ");
	}

	@AfterThrowing("execution(* pl.drakeprogrammer.repository.BookRepository.*(..))")
	public void logError() {
		System.out.println("Method finished with error ");
	}

	@AfterReturning("execution(* pl.drakeprogrammer.repository.BookRepository.*(..))")
	public void logSuccess() {
		System.out.println("Method successfully returned");
	}
}
