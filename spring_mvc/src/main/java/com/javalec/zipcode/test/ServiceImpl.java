package com.javalec.zipcode.test;

import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service("asd")
public class ServiceImpl implements Service {
	@Autowired
	private Test test;

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		System.out.println("test ¼ÂÆÃ");
		this.test = test;
	}

	
	
	
}
