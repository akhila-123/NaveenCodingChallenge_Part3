package com.capsuleCrm.WebPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;
import com.capsuleCrm.TestUtil.TestUtil;

/**
 * Contains all the elements needed to automate the interaction with the Tags
 * Page
 * 
 * @author Akhila Bandiki
 */
public class TagsPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.TAGSPAGEHEADER_XPATH)
	WebElement tagsPageHeader;

	@FindBy(xpath = Locators.ADDNEWTAG_XPATH)
	WebElement addnewtag;

	@FindBy(id = Locators.NEWTAGNAME_ID)
	WebElement newTagName;

	@FindBy(id = Locators.SAVE_ID)
	WebElement saveBtn;

	@FindBy(xpath = Locators.INTEGRATIONS_XPATH)
	WebElement integrationsLink;

	@FindBy(xpath = Locators.VERIFYTAG_XPATH)
	List<WebElement> verifyTag;

	/**
	 * Constructs a new Tags Page object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public TagsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Integrations link of Tags Page and It then waits for the results to
	 * be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.IntegrationsPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.IntegrationsPage</class>
	 */
	public IntegrationsPage OpenIntegrationsPage() {
		integrationsLink.click();
		return new IntegrationsPage();
	}

	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = tagsPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Tags Page Header is not as expected");
		System.out.println("****Verfied the Tags Page Header****");
	}

	/**
	 * Clicks on Add New Tag Button of Tags Page and It then waits for the results
	 * to be loaded and enters tagName then clicks on save Button
	 * 
	 * @param TagName- New tag name
	 */

	public String AddNewTag(String TagName) {
		addnewtag.click();
		TestUtil.waitForElement(newTagName);
		String NewTagName = TagName + TestUtil.gettimestamp();
		newTagName.sendKeys(NewTagName);
		saveBtn.click();
		return NewTagName;

	}

	/**
	 * Verifies the New Tag created with its name on Tags Page
	 * 
	 * @param TagName- New tag name
	 */

	public void VerifyTheTagCreated(String NewTagName) {
		for (int i = 0; i < verifyTag.size(); i++) {
			if ((verifyTag.get(i).getText()).equals(NewTagName)) {
				System.out.println("****Verified the new tag created****");
			}
		}

	}

}
