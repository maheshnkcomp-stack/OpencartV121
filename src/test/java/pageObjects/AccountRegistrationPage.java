package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	//locators
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	//input[@name='agree']
	
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	

	@FindBy(xpath="	//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	///action methods
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPasswoword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chkdPolicy);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkdPolicy);
		} catch (Exception e) {
			throw new RuntimeException("Failed to click Privacy Policy checkbox: " + e.getMessage());
		}
	}
	
	public void ClickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return(msgConfirmation.getText());
		} catch(Exception e ) {
			return(e.getMessage());
		}
	}
}
