package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Export
 * page
 * 
 * @author Akhila Bandiki
 */

public class ExportPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.EXPORTPAGEHEADER_XPATH)
	WebElement exportPageHeader;

	@FindBy(xpath = Locators.APPEARANCE_XPATH)
	WebElement appearanceLink;

	/**
	 * Constructs a new Export Page object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public ExportPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Appearance link of Account Settings Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.AppearancePage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.AppearancePage</class>
	 */
	public AppearancePage OpenAppearancePage() {
		appearanceLink.click();
		return new AppearancePage();
	}

	/**
	 * Gets the export page header value and Verifies the page header values to the
	 * expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = exportPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Export Page Header is not as expected");
		System.out.println("*****Verified Export Page Header*****");
	}

}
