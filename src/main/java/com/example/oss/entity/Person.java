package com.example.oss.entity;

public class Person {
    private String name;
    private int age;
    private boolean eligibleToVote;

    // Default constructor
    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    public boolean isEligibleToVote() {
		return eligibleToVote;
	}

	public void setEligibleToVote(boolean eligibleToVote) {
		this.eligibleToVote = eligibleToVote;
	}

	public String personDetails() {
        return "Hello, my name is " + name + " and I'm " + age + " years old.";
    }
}
