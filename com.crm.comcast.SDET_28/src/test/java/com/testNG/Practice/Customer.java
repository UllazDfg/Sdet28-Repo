package com.testNG.Practice;

import org.testng.annotations.Test;

public class Customer {
@Test (groups = "smokeTest")
public void customerTest1() {
	System.out.println("This is Smoke");
}

@Test (groups = "reggressionTest")

public void customerTest2() {
	System.out.println("This is Reggression ");
}
}
