package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

//import day47.LoginPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
@Test(groups={"Sanity","Master"})	
public void verify_Account_Login()
{
	try 
	{
		//page1 homepage
		logger.info("starting account login");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//page2 login page
		logger.info("providing credential");
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//page3 myaccount page
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetPage=mp.MyAccountPageExist();
		Assert.assertTrue(targetPage);
		
		
		
		
	}
	
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("*********finished tc002_loginttest****");
	
}
}
