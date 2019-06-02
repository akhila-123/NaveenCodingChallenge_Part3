package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the
 * Appearance page
 * 
 * @author Akhila Bandiki
 */

public class AppearancePage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.APPEARANCEPAGEHEADER_XPATH)
	WebElement appearancePageHeader;

	@FindBy(xpath = Locators.UPLOADLOGO_XPATH)
	WebElement uploadLogoBtn;
	
	@FindBy(xpath = Locators.MAILDROPBOX_XPATH)
	WebElement mailDropBoxLink;

	@FindBy(xpath = Locators.SAVEBTN_XPATH)
	WebElement saveBtn;

	/**
	 * Constructs a new Appearance Page object, using the driver created in
	 * TestBase. It also initializes its web elements by using the PageFactory
	 * method, pointing to all elements defined in this very class.
	 */
	public AppearancePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on MailDropBox link of Account Settings Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.MailDropBox</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.MailDropBox</class>
	 */
	public MailDropBoxPage OpenMailDropBoxPage() {
		mailDropBoxLink.click();
		return new MailDropBoxPage();
	}

	/**
	 * Gets the appearance page header value and Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = appearancePageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Appearance Page Header is not as expected");
		System.out.println("5.Verified Appearances Page Header.");
	}
	
	/**
	 * Uploads logo file and clicks on save button
	 */

	public void UploadLogoAndSave() {
		uploadLogoBtn.sendKeys(System.getProperty("user.dir")+prop.getProperty("FileUploadPath"));
		saveBtn.click();
		
	}

}
