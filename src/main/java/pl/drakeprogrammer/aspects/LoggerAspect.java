package pl.drakeprogrammer.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import pl.drakeprogrammer.model.Book;

@Aspect
@Component
public class LoggerAspect {

	@Before("execution(* pl.drakeprogrammer.repository.BookRepository.*(..))")
	public void logInfoBefore(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.printf("Log before %s with args: %s\n", joinPoint.getSignature(), Arrays.toString(args));
	}

	@After("execution(* pl.drakeprogrammer.repository.BookRepository.*(..))")
	public void logInfoAfter() {
		System.out.println("Method executed ");
	}

	@AfterThrowing("execution(* pl.drakeprogrammer.repository.BookRepository.*(..))")
	public void logError() {
		System.out.println("Method finished with error ");
	}

	@AfterReturning(value = "execution(* pl.drakeprogrammer.repository.BookRepository.get(..)) && args(isbn)",
					returning = "book")
	public void logSuccess(JoinPoint joinPoint, String isbn, Book book) {
		if (book != null) {
			// if you want to use JoinPoint object this object must be first argument in method signature
			System.out.println(joinPoint.getSignature());
			System.out.printf("Method get() successfully returned value %s for isbn %s\n", book, isbn);
		}
	}
}
