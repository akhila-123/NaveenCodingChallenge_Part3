package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the new
 * person page
 * 
 * @author Akhila Bandiki
 */

public class NewPersonPage extends TestBase {

	/* WebElement Section */
	@FindBy(name = Locators.TITLE_NAME)
	WebElement title;
	@FindBy(id = Locators.FIRSTNAME_ID)
	WebElement firstName;
	@FindBy(id = Locators.LASTNAME_ID)
	WebElement lastName;
	@FindBy(id = Locators.JOBTITLE_ID)
	WebElement jobTitle;
	@FindBy(id = Locators.ORGANISATION_ID)
	WebElement organisation;
	@FindBy(id = Locators.PERSONTAGS_ID)
	WebElement tags;
	@FindBy(id = Locators.PERSONADDTAG_ID)
	WebElement addTags;
	@FindBy(id = Locators.PHONENUMBER_ID)
	WebElement phoneNumber;
	@FindBy(id = Locators.EMAILADD_ID)
	WebElement emailAddress;
	@FindBy(id = Locators.WEBSITE_ID)
	WebElement website;
	@FindBy(id = Locators.SAVEBTN_ID)
	WebElement saveBtn;

	/**
	 * Constructs a new Person Page object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public NewPersonPage() {
		PageFactory.initElements(driver, this);
	}

	public PeopleAndOrgPage FillPersonDetailsAndSave(String Title, String FirstName, String LastName, String JobTitle,
			String Organisation, String PersonTag, String PhoneNumber, String EmailId, String Website) {
		Select select = new Select(title);
		select.selectByVisibleText(Title);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		jobTitle.sendKeys(JobTitle);
		organisation.sendKeys(Organisation);
		tags.sendKeys(PersonTag);
		addTags.click();
		phoneNumber.sendKeys(PhoneNumber);
		emailAddress.sendKeys(EmailId);
		website.sendKeys(Website);
		saveBtn.click();
		System.out.println("1.New Person is sucessfully created.");
		return new PeopleAndOrgPage();

	}
}
