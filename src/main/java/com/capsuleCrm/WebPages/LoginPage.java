package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Login
 * page
 * 
 * @author Akhila Bandiki
 */
public class LoginPage extends TestBase {

	/* WebElement Section */
	@FindBy(id = Locators.USERNAME_ID)
	WebElement username;

	@FindBy(id = Locators.PASSWORD_ID)
	WebElement password;

	@FindBy(id = Locators.LOGINBTN_ID)
	WebElement loginBtn;

	/**
	 * Constructs a new LoginPage object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Enters the username and password in respective fields of Login Page and
	 * clicks on Login Button. It then waits for theresults to be loaded and
	 * initializes the <class>com.capsuleCrm.WebPages.HomePage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.HomePage</class>
	 */
	public HomePage EnterCredentials(String Username,String Password) {
		System.out.println("**********Starting the Test**************");
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginBtn.click();
		return new HomePage();
	}

}
