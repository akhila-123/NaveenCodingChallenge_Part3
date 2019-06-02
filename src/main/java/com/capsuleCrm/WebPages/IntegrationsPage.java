package com.capsuleCrm.WebPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the
 * Integrations Page
 * 
 * @author Akhila Bandiki
 */
public class IntegrationsPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.INTEGRATIONSPAGEHEADER_XPATH)
	WebElement integrationsPageHeader;

	@FindBy(xpath = Locators.TRASH_XPATH)
	WebElement trashLink;
	
	@FindBy(xpath = Locators.CONFIGUREBTNLIST_XPATH)
	List<WebElement> configureBtnList;

	/**
	 * Constructs a new Integrations Page object, using the driver created in
	 * TestBase. It also initializes its web elements by using the PageFactory
	 * method, pointing to all elements defined in this very class.
	 */
	public IntegrationsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Trash link of Account Settings Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.TrashPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.TrashPage</class>
	 */
	public TrashPage OpenTrashPage() {
		trashLink.click();
		return new TrashPage();
	}

	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = integrationsPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Integrations Page Header is not as expected");
		System.out.println("23.Verified Integrations Page Header.");
	}
	/**
	 * Verifies the total number of Configure Buttons present in Integrations Page and prints them 
	 */

	public void VerfiyNumberOfConfigureButtons() {
		System.out.println("24.Total no of configure buttons on Integrations page are -"+configureBtnList.size());
		
	}

}
