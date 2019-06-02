package com.capsuleCrm.WebPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Contains all the elements needed to automate the interaction with the new case
 * page
 * 
 * @author Akhila Bandiki
 */

public class NewCasePage extends TestBase{
	/* WebElement Section */
	@FindBy(id = Locators.CASERELATESTO_ID)
	WebElement caseRelatesTo;
	
	@FindBy(id = Locators.NAME_ID)
	WebElement name;
	
	@FindBy(id = Locators.DESCRIPTION_ID)
	WebElement description;
	
	@FindBy(id = Locators.CASETAGS_ID)
	WebElement caseTags;
	
	@FindBy(id = Locators.CASEADDTAG_ID)
	WebElement caseAddTags;
	
	@FindBy(name = Locators.TRACK_NAME)
	WebElement track;
	
	@FindBy(id = Locators.CASESAVEBTN_ID)
	WebElement saveBtn;

	/**
	 * Constructs a new Case Page object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public NewCasePage() {
		PageFactory.initElements(driver, this);
	}
	
	public CasesPage FillNewCaseDetails(String CaseRelatesTo,String Name,String Description,String CaseTags) {
		caseRelatesTo.sendKeys(CaseRelatesTo);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		caseRelatesTo.sendKeys(Keys.ARROW_DOWN);
		caseRelatesTo.sendKeys(Keys.ENTER);
		name.sendKeys(Name);
		description.sendKeys(Description);
		caseTags.sendKeys(CaseTags);
		caseAddTags.click();
		saveBtn.click();
		System.out.println("3.New Case is sucessfully created.");
		return new CasesPage();
	}

}
