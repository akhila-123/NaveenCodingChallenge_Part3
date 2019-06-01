package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;
import com.capsuleCrm.TestUtil.TestUtil;

/**
 * Contains all the elements needed to automate the interaction with the
 * Invoices page
 * 
 * @author Akhila Bandiki
 */

public class InvoicesPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.INVOICESPAGEHEADER_XPATH)
	WebElement invoicesPageHeader;

	@FindBy(xpath = Locators.EXPORT_XPATH)
	WebElement exportLink;

	/**
	 * Constructs a new Invoices Page object, using the driver created in TestBase.
	 * It also initializes its web elements by using the PageFactory method,
	 * pointing to all elements defined in this very class.
	 */
	public InvoicesPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Export link of Account Settings Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.ExportPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.ExportPage</class>
	 */
	public ExportPage OpenExportPage() {
		TestUtil.waitForElement(exportLink);
		exportLink.click();
		return new ExportPage();
	}

	/**
	 * Gets the invoices page header value and Verifies the page header values to
	 * the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		TestUtil.waitForElement(invoicesPageHeader);
		String ActualPageHeader = invoicesPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Invoices Page Header is not as expected");
		System.out.println("*****Verified Invoices Page Header*****");
	}

}
