package com.capsuleCrm.WebPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;
import com.capsuleCrm.TestUtil.TestUtil;

/**
 * Contains all the elements needed to automate the interaction with the People
 * And Organization page
 * 
 * @author Akhila Bandiki
 */
public class PeopleAndOrgPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.ADDPERSON_XPATH)
	WebElement addPersonBtn;

	@FindBy(xpath = Locators.HOMEICON_XPATH)
	WebElement homeIcon;

	@FindBy(xpath = Locators.VERIFYNAME_XPATH)
	List<WebElement> verifyName;

	/**
	 * Constructs a new People And Organization Page object, using the driver
	 * created in TestBase. It also initializes its web elements by using the
	 * PageFactory method, pointing to all elements defined in this very class.
	 */
	public PeopleAndOrgPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Add Person button of People and Organisation Page and It then waits
	 * for the results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.NewPersonPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.NewPersonPage</class>
	 */

	public NewPersonPage ClickOnAddPerson() {
		TestUtil.waitForElement(addPersonBtn);
		addPersonBtn.click();
		return new NewPersonPage();
	}

	/*
	 * Clicks on home icon of new person Page and It then waits for the results to
	 * be loaded and initializes the <class>com.capsuleCrm.WebPages.HomePage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.HomePage</class>
	 */
	public HomePage ClickOnHomeIcon() {
		homeIcon.click();
		return new HomePage();
	}

	/*
	 * Verifies the person created in New Person Page by passing below two
	 * parameters
	 * 
	 * @param firstName and lastName
	 */

	public void VerifyThePersonCreated(String firstName, String lastName) {
		for (int i = 0; i < verifyName.size(); i++) {
			if (verifyName.get(i).getText().equals((firstName + " " + lastName))) {
				System.out.println("****Verified the Person created with actual--" + verifyName.get(i).getText()
						+ ",expected--" + firstName + " " + lastName + "****");
			}

		}

	}

}
