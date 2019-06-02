package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the Tracks
 * page
 * 
 * @author Akhila Bandiki
 */

public class NewOpportunityTrackPage extends TestBase {
	public static final String NEWNAME_ID = "j_id123:trackDescriptionDecorate:trackDescription";
	public static final String TAG_ID = "j_id123:trackTagDecorate:trackTag";
	public static final String SAVE_XPATH = "//a[text()='Save']";
	/* WebElement Section */
	@FindBy(id = Locators.NEWNAME_ID)
	WebElement name;

	@FindBy(id = Locators.TAG_ID)
	WebElement tag;

	@FindBy(xpath = Locators.SAVE_XPATH)
	WebElement saveBtn;

	@FindBy(id = Locators.TASKDESCRIPTION_ID)
	WebElement taskDescription;

	@FindBy(id = Locators.DUEDAYS_ID)
	WebElement dueDays;

	@FindBy(xpath = Locators.ASSIGNEE_XPATH)
	WebElement assigneeDropdown;

	/**
	 * Constructs a new Opportunity Tracks Page object, using the driver created in
	 * TestBase. It also initializes its web elements by using the PageFactory
	 * method, pointing to all elements defined in this very class.
	 */
	public NewOpportunityTrackPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Enters name and tag in New Opportunity Track Page and clicks on save button.
	 * It then waits for the results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.TracksPage</class>
	 * 
	 * @param Name,Tag
	 * @return <class>com.capsuleCrm.WebPages.TracksPage</class>
	 */
	public TracksPage FillDetailsAndSave(String Name, String Tag,String TaskDescription,String DueDays,String UserName) {
		name.sendKeys(Name);
		tag.sendKeys(Tag);
		taskDescription.sendKeys(TaskDescription);
		dueDays.sendKeys(DueDays);
		Select select = new Select(assigneeDropdown);
		select.selectByVisibleText(UserName);
		saveBtn.click();
		System.out.println("14.New Opportunity Track is created.");
		return new TracksPage();
	}

}
