package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Account
 * page
 * 
 * @author Akhila Bandiki
 */

public class AccountPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.ACCOUNTPAGEHEADER_XPATH)
	WebElement accountPageHeader;
	@FindBy(xpath = Locators.INVOICES_XPATH)
	WebElement invoicesLink;

	/**
	 * Constructs a new Account Page object, using the driver created in TestBase.
	 * It also initializes its web elements by using the PageFactory method,
	 * pointing to all elements defined in this very class.
	 */
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Gets the account page header value and Verifies the account page header
	 * values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = accountPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Account Page Header is not as expected");
		System.out.println("2.Verified Account Page Header.");
	}

	/**
	 * Clicks on Invoices link of Account Settings Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.InvoicesPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.InvoicesPage</class>
	 */
	public InvoicesPage OpenInvoicesPage() {
		invoicesLink.click();
		return new InvoicesPage();
	}
}
