package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Account
 * Settings page
 * 
 * @author Akhila Bandiki
 */

public class AccountSettingsPage extends TestBase {

	/* WebElement Section */
	@FindBy(xpath = Locators.ACCOUNT_XPATH)
	WebElement accountLink;
	
	@FindBy(xpath = Locators.ACCOUNTSETTINGSPAGEHEADER_XPATH)
	WebElement accountSettingsPageHeader;
	
	

	/**
	 * Constructs a new Account Settings Page object, using the driver created in
	 * TestBase. It also initializes its web elements by using the PageFactory
	 * method, pointing to all elements defined in this very class.
	 */
	public AccountSettingsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Account link of Account Settings Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.AccountPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.AccountPage</class>
	 */
	public AccountPage OpenAccountPage() {
		accountLink.click();
		return new AccountPage();
	}
	
	/**
	 * Gets Text from account settings page header element and verifies it against the expected value.
	 * @param AccountSettingsPageHeader - expected value for the page header
	 */
	public void VerifyPageHeader(String AccountSettingsPageHeader) {
		Assert.assertTrue(accountSettingsPageHeader.getText().equals( AccountSettingsPageHeader),"Account Settings Page Header is not as expected");
		System.out.println("*****Verified Account Settings Page Header*****");
		
	}

}
