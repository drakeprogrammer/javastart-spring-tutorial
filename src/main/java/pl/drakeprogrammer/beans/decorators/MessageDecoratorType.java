package pl.drakeprogrammer.beans.decorators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MessageDecoratorType {

	DecoratorType value();

	enum DecoratorType {
		LOWER_CASE_MESSAGE_DECORATOR,
		UPPER_CASE_MESSAGE_DECORATOR
	}
}
