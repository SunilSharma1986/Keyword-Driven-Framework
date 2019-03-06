package com.qa.yt.keyword.test;

import org.testng.annotations.Test;

import com.qa.yt.keyword.engine.KeyWordEngine;

public class LoginTest {

	
	
	public KeyWordEngine kWEngine;
	
	@Test
	public void loginTest()
	{
		kWEngine=new KeyWordEngine();
		kWEngine.startExecution("login");
	}
}
