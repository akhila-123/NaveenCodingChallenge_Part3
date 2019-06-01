package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Trash
 * Page
 * 
 * @author Akhila Bandiki
 */
public class TrashPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.TRASHPAGEHEADER_XPATH)
	WebElement trashPageHeader;

	/**
	 * Constructs a new Trash Page object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public TrashPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = trashPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Account Page Header is not as expected");
		System.out.println("****Verified the Trash Page Header  value****");
	}

}
