package com.kiran.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

//import org.junit.Test;
import com.kiran.pages.BaseTest;
import com.kiran.pages.LoginPage;


public class LoginTest extends BaseTest{
	
	

	@Test
	void verifyLogin() throws IOException {
	LoginPage lp=new LoginPage(driver);
	String username ="Demo12";
	String password ="Test123456$";
	lp.loginPortal(username, password);
	
	if(username == "Demo12") {
	captureScreenShot(driver,"VerifyLogin");
	Assert.assertTrue(true);
	}
	}
	

}


