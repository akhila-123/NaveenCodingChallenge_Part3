package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the New User
 * page
 * 
 * @author Akhila Bandiki
 */
public class NewUserPage extends TestBase{
	/* WebElement Section */
	@FindBy(id = Locators.FIRSTNAME_NU_ID)
	WebElement firstName;

	@FindBy(id = Locators.LASTNAME_NU_ID)
	WebElement lastName;
	
	@FindBy(id = Locators.EMAILADDRESS_ID)
	WebElement emailAddress;
	
	@FindBy(id = Locators.USERNAME_NU_ID)
	WebElement username;
	
	@FindBy(id = Locators.INVITEUSER_ID)
	WebElement inviteUserBtn;

	/**
	 * Constructs a new New User Page object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public NewUserPage() {
		PageFactory.initElements(driver, this);
	}
	/**
	 * Fills required Details and Clicks on Invite User Button of New User Page and It then waits for
	 * the results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.OpportunitiesPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.OpportunitiesPage</class>
	 */
	public UsersPage FillDetailsAndSave(String FirstName,String LastName,String EmailAddress, String Username) {
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		emailAddress.sendKeys(EmailAddress);
		username.sendKeys(Username);
		inviteUserBtn.click();
		System.out.println("****New User is sucessfully created****");
		return new UsersPage();
	}

}
