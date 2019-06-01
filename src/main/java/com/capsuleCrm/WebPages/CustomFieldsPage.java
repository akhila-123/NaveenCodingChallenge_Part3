package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Custom
 * Fields Page
 * 
 * @author Akhila Bandiki
 */

public class CustomFieldsPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.CUSTOMFIELDSPAGEHEADER_XPATH)
	WebElement customFieldsPageHeader;
	@FindBy(xpath = Locators.TAGS_XPATH)
	WebElement tagsLink;

	/**
	 * Constructs a new Custom Fields Page object, using the driver created in
	 * TestBase. It also initializes its web elements by using the PageFactory
	 * method, pointing to all elements defined in this very class.
	 */
	public CustomFieldsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Tags link of Account Settings Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.TagsPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.TagsPage</class>
	 */
	public TagsPage OpenTagsPage() {
		tagsLink.click();
		return new TagsPage();
	}

	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = customFieldsPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Account Page Header is not as expected");
		System.out.println("****Verified Custom Fields Page Header*****");
	}

}
