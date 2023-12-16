package com.kiran.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kiran.pages.LoginPage;
import com.kiran.utility.ReadExcelFile;
import com.kiran.pages.BaseTest;

public class LoginTestDrivenData extends BaseTest{
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	
      

	@Test(priority =1,dataProvider="LoginDataProvider")
	void verifyLogin(String username, String password) throws IOException {
		System.out.println("hi, i have run..");
	LoginPage lp = new LoginPage(driver);
//	String username ="Demo12";
//	String password ="Test123456$";
	lp.loginPortal(username, password);
	
	lp.logout();
	}
	

	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		System.out.println("hello..hi");
		System.out.println(fileName);
		
		int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns= ReadExcelFile.getColCount(fileName, "LoginData");
		
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
	}


}
