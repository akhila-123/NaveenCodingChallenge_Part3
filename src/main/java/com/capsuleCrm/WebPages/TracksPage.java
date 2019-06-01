package com.capsuleCrm.WebPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Tracks
 * page
 * 
 * @author Akhila Bandiki
 */

public class TracksPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.TRACKSPAGEHEADER_XPATH)
	WebElement tracksPageHeader;

	@FindBy(xpath = Locators.TASKCATEGORIES_XPATH)
	WebElement taskCategoriesLink;
	

	@FindBy(xpath = Locators.ADDNEWTRACK_XPATH)
	WebElement addNewTrack;
	
	@FindBy(xpath = Locators.VERIFYTRACK_XPATH)
	List<WebElement> verifyTrack;
	
	/**
	 * Constructs a new Tracks Page object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public TracksPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on TaskCategories link of Tracks Page and It then waits for
	 * the results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.TaskCategoriesPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.TaskCategoriesPage</class>
	 */
	public TaskCategoriesPage OpenTaskCategoriesPage() {
		taskCategoriesLink.click();
		return new TaskCategoriesPage();
	}

	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = tracksPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Account Page Header is not as expected");
		System.out.println("****Verified the Tracks Page Header****");
	}
	/**
	 * Clicks on Add new Track link of Tracks Page and It then waits for
	 * the results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.NewOpportunityTrackPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.NewOpportunityTrackPage</class>
	 */
	public NewOpportunityTrackPage OpenAddNewTrackLink() {
		addNewTrack.click();
		return new NewOpportunityTrackPage();
	}
	
	/**
	 * Verifies the new Track created in New Opportunity Track Page using the below parametersC
	 */

	public void VerifyTheTrackCreated(String Name) {
		for (int i = 0; i < verifyTrack.size(); i++) {
			if ((verifyTrack.get(i).getText()).equals(Name)){
				System.out.println("****Verified the new track created****");
			}
		}
		
		
	}
}
