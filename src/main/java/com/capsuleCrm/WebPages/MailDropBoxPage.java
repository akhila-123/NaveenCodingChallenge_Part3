package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Mail
 * Drop Box page
 * 
 * @author Akhila Bandiki
 */
public class MailDropBoxPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.MAILDROPBOXPAGEHEADER_XPATH)
	WebElement mailDropBoxPageHeader;

	@FindBy(xpath = Locators.USERS_XPATH)
	WebElement usersLink;

	/**
	 * Constructs a new Mail Drop Box Page object, using the driver created in
	 * TestBase. It also initializes its web elements by using the PageFactory
	 * method, pointing to all elements defined in this very class.
	 */
	public MailDropBoxPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Users link of Account Settings Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.UsersPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.UsersPage</class>
	 */
	public UsersPage OpenUsersPage() {
		usersLink.click();
		return new UsersPage();
	}

	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = mailDropBoxPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Invoices Page Header is not as expected");
		System.out.println("6.Verified MailDropBox Page Header.");
	}

}
