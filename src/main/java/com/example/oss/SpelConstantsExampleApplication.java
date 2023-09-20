package com.example.oss;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@SpringBootApplication
public class SpelConstantsExampleApplication {

	public static void main(String[] args) {
		// Create the SpEL parser
		ExpressionParser parser = new SpelExpressionParser();

		double piival = (double) parser.parseExpression("T(com.example.oss.entity.LogicConstants).PI").getValue();
		String code = (String) parser.parseExpression("T(com.example.oss.entity.LogicConstants).code_test").getValue();

		System.out.println("Constant val: " + piival);
		System.out.println("Constant code: " + code);

	}

}
