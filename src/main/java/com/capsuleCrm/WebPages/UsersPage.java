package com.capsuleCrm.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Users
 * page
 * 
 * @author Akhila Bandiki
 */
public class UsersPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.USERSPAGEHEADER_XPATH)
	WebElement usersPageHeader;

	@FindBy(xpath = Locators.OPPORTUNITIES_XPATH)
	WebElement opportunitiesLink;
	
	@FindBy(xpath = Locators.NEWUSER_XPATH)
	WebElement newUserLink;
	
	@FindBy(xpath = Locators.VERIFYUSER_XPATH)
	WebElement verifyUser;
	
	@FindBy(xpath = Locators.DELETEUSERNAME_XPATH)
	WebElement deleteUserName;
	
	@FindBy(xpath = Locators.DELETEUSER_XPATH)
	WebElement deleteUser;
	
	@FindBy(xpath = Locators.DELETEUSERBTN_XPATH)
	WebElement deleteUserBtn;

	/**
	 * Constructs a new Users Page object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Opportunities link of User Page and It then waits for
	 * the results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.OpportunitiesPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.OpportunitiesPage</class>
	 */
	public OpportunitiesPage OpenOpportunitiesPage() {
		opportunitiesLink.click();
		return new OpportunitiesPage();
	}

	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = usersPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Users Page Header is not as expected");
		System.out.println("****Verified the user page header****");
	}
	/**
	 * Clicks on Add new User link of User Page and It then waits for
	 * the results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.NewUserPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.NewUserPage</class>
	 */
	public NewUserPage AddNewUser() {
		if(deleteUserName.isDisplayed()) {
			deleteUserName.click();
			deleteUser.click();
			deleteUserBtn.click();
		}
		newUserLink.click();
		return new NewUserPage();
	}
	
	/**
	 * Verifies the new User created using New User page using below parameters
	 * @param FirstName,LastName
	 */

	public void VerifyUserCreated(String FirstName, String LastName) {
		String ActualUser=verifyUser.getText();
		String ExpectedUser=FirstName+" "+LastName;
		Assert.assertTrue(ActualUser.equals(ExpectedUser), "UserCreated is not as expected");
		System.out.println("****Verified the user created****");
		
		
	}
	

}
