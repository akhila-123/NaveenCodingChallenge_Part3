package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;
import com.capsuleCrm.TestUtil.TestUtil;

/**
 * Contains all the elements needed to automate the interaction with the
 * Opportunities page
 * 
 * @author Akhila Bandiki
 */
public class OpportunitiesPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.OPPORTUNITIESPAGEHEADER_XPATH)
	WebElement opportunitiesPageHeader;
	
	@FindBy(xpath = Locators.ADDNEWMILESTONE_XPATH)
	WebElement addNewMilestone;
	
	@FindBy(xpath = Locators.MILESTONENAME_XPATH)
	WebElement name;
	
	@FindBy(xpath = Locators.MILESTONESAVEBTN_XPATH)
	WebElement saveBtn;
	
	@FindBy(xpath = Locators.PB_XPATH)
	WebElement probabilityOfWinning;

	@FindBy(xpath = Locators.TRACKS_XPATH)
	WebElement tracksLink;

	/**
	 * Constructs a new Opportunities Page object, using the driver created in
	 * TestBase. It also initializes its web elements by using the PageFactory
	 * method, pointing to all elements defined in this very class.
	 */
	public OpportunitiesPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Tracks link of Account Settings Page and It then waits for the results to be
	 * loaded and initializes the <class>com.capsuleCrm.WebPages.TracksPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.TracksPage</class>
	 */
	public TracksPage OpenTracksPage() {
		tracksLink.click();
		return new TracksPage();
	}
	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		TestUtil.waitForElement(opportunitiesPageHeader);
		String ActualPageHeader = opportunitiesPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Invoices Page Header is not as expected");
		System.out.println("*****Verified Opportunities Page Header*****");
	}
	/**
	 * Clicks on Add New Category Button of Opportunities Page and It then waits for the results to be
	 * loaded and enters mandatory fields and saves it
	 * 
	 * @param MilestoneName,PB(Probability Of Winning)
	 */

	public void AddNewCategory(String MilestoneName,String PB) {
		addNewMilestone.click();
		TestUtil.waitForElement(name);
		name.sendKeys(MilestoneName+TestUtil.gettimestamp());
		probabilityOfWinning.sendKeys(PB);
		saveBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
