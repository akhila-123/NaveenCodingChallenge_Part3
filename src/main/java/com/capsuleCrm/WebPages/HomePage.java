package com.capsuleCrm.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCrm.TestBase.TestBase;
import com.capsuleCrm.TestUtil.TestUtil;

/**
 * Contains all the elements needed to automate the interaction with the Home
 * page
 * 
 * @author Akhila Bandiki
 */
public class HomePage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.PERSONICON_XPATH)
	WebElement personIcon;

	@FindBy(xpath = Locators.CASEICON_XPATH)
	WebElement caseIcon;

	@FindBy(xpath = Locators.USERNAME_XPATH)
	WebElement username;

	@FindBy(xpath = Locators.ACCOUNTSETTINGS_XPATH)
	WebElement accountSettings;
	/**
	 * Constructs a new HomePage object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on person icon of Home Page and It then waits for the results to be
	 * loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.PeopleAndOrgPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.PeopleAndOrgPage</class>
	 */
	public PeopleAndOrgPage ClickOnPersonIcon() {
		TestUtil.waitForElement(personIcon);
		personIcon.click();
		return new PeopleAndOrgPage();
	}

	/**
	 * Clicks on cases icon of Home Page and It then waits for the results to be
	 * loaded and initializes the <class>com.capsuleCrm.WebPages.CasesPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.CasesPage</class>
	 */
	public CasesPage ClickOnCaseIcon() {
		caseIcon.click();
		return new CasesPage();
	}
	/**
	 * Clicks on Account Settings link of Home Page and It then waits for the results to be
	 * loaded and initializes the <class>com.capsuleCrm.WebPages.AccountSettingsPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.AccountSettingsPage</class>
	 */
	public AccountSettingsPage OpenAccountSettingsPage() {
		username.click();
		Actions action = new Actions(driver);
		action.moveToElement(accountSettings).click().build().perform();
		return new AccountSettingsPage();
	}


}
