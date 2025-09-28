package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")  //getting data provider from diffrent class
	public void verfy_loginDDT(String email,String pwd,String exp)
	{
		
		logger.info("*****Starting data driven testing******");
		try {
		//page1 homepage
				logger.info("starting account login");
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//page2 login page
				logger.info("providing credential");
				LoginPage lp=new LoginPage(driver);
				lp.setEmailAddress(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				//page3 myaccount page
				MyAccountPage mp=new MyAccountPage(driver);
				boolean targetPage=mp.MyAccountPageExist();
				
				
				/* Data is valid---login succes---test pass---logout
				                   login fail---test fail
				 
				 *   Data is invalid---login succes---test fail---logout
				                       login failed---test pass--
				 */
				
				if(exp.equalsIgnoreCase("valid"))
				{
					if(targetPage==true)
					{
						mp.clickLogout();
						Assert.assertTrue(true);
						
					}
					else
					{
						//lp.clickLogin();
						Assert.assertTrue(false);
						
					}
				}
				
				if(exp.equalsIgnoreCase("invalid"))
				{
					if(targetPage==true)
					{
						mp.clickLogout();
						Assert.assertTrue(true);
						
					}
					else
					{
						//lp.clickLogin();
						Assert.assertTrue(true);
						
					}
				}
				
		}
		
	catch(Exception e)
	 {
		 Assert.fail();
	 }
		
	 logger.info("*****Starting data driven testing******");
		
	}
}
