package com.example.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.oss.entity.*;
import com.example.oss.beans.*;

@SpringBootApplication
public class SpringExpressionsApplication {

	public static void main(String[] args) {

		// Create the SpEL parser
		ExpressionParser parser = new SpelExpressionParser();
		
		
		System.out.println("********************************************");

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				BeanPersonConfig.class)) {

			// Retrieve the Person bean by name
			// Person person = (Person) context.getBean("personBean");
			Person person = context.getBean("personBean", Person.class);

			// Define SpEL expressions
			Expression nameExpression = parser.parseExpression("name");
			Expression ageExpression = parser.parseExpression("age");
			Expression detailsExpression = parser.parseExpression("personDetails()");

			// Evaluate SpEL expressions
			String name = nameExpression.getValue(person, String.class);
			int age = ageExpression.getValue(person, Integer.class);
			String details = detailsExpression.getValue(person, String.class);

			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Person details: " + details);
			
			
			System.out.println("********************************************");
			ConfigurableApplicationContext cont = new AnnotationConfigApplicationContext(VotingConfig.class);

	        // Retrieve the Person bean from the context
	        Person personVote = cont.getBean(Person.class);
	        
			//Opérateurs conditionnels
			 if (personVote.isEligibleToVote()) {
		            System.out.println("This person is eligible to vote.");
		        } else {
		            System.out.println("This person is not eligible to vote.");
		        }
			 cont.close();
			 System.out.println("********************************************");
		}
		
		// set variables with StandardEvaluationContext
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setVariable("a", 2);
		context.setVariable("b", 3);

		// Arithmetic Operation
		int resultAddition = (int) parser.parseExpression("#a + #b").getValue(context); // resultAddition = 5
		int resultAddition2 = (int) parser.parseExpression("2 + 3").getValue(); // resultAddition = 5
		int resultSubtraction = (int) parser.parseExpression("5 - 2").getValue(); // resultSubtraction = 3
		int resultMultiplication = (int) parser.parseExpression("4 * 6").getValue(); // resultMultiplication = 24
		double resultDivision = (double) parser.parseExpression("10.0 / 2").getValue(); // resultDivision = 5.0

		System.out.println("resultAddition 1 : " + resultAddition);
		System.out.println("resultAddition 2 : " + resultAddition2);
		System.out.println("resultSubtraction: " + resultSubtraction);
		System.out.println("resultMultiplication: " + resultMultiplication);
		System.out.println("resultDivision: " + resultDivision);

		System.out.println("********************************************");
		
		// access to variable from the context spring
		try (AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(
				BeanVariableConfig.class)) {
			// Access the variable using SpEL
			String result = context2.getBean("myVariable", String.class);
			System.out.println("var result: " + result);
		}
		
		SpringApplication.run(SpringExpressionsApplication.class, args);
	}

}
