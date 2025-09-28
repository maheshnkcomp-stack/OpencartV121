package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistration extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_Account_Registration() throws InterruptedException
	{ try {
		logger.info("starting account registration");
		///page1 
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("click on myaccount");
		hp.ClickRegister();
		logger.info("click on register");
		
		///page2
		logger.info("providing customer info");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase() );
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+("@gmail.com"));
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumeric();
		
		regpage.setPassword(password);
		
		regpage.setConfirmPasswoword(password);
		Thread.sleep(5000);
		regpage.setPrivacyPolicy();
		regpage.ClickContinue();
		Thread.sleep(5000);
	
		logger.info("Validating expected msg");
		String confmsg=regpage.getConfirmationMsg();
		Thread.sleep(5000);
	    //Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		if(confmsg.equals("Your Account Has Been Created!"))
				{
			Assert.assertTrue(true);
				}
		else
		{
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
	}
	catch(Exception e)
	{
		
		Assert.fail();
	}
	logger.info("account registration succefully");
	
	}
	
	
	
}