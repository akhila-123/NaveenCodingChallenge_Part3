package com.capsuleCrm.WebPages;

import org.apache.xmlbeans.impl.tool.XSTCTester.TestCase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;
import com.capsuleCrm.TestUtil.TestUtil;

/**
 * Contains all the elements needed to automate the interaction with the cases
 * page
 * 
 * @author Akhila Bandiki
 */
public class CasesPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.ADDCASE_XPATH)
	WebElement addCaseBtn;

	@FindBy(xpath = Locators.HOMEICON_XPATH)
	WebElement homeIcon;

	@FindBy(xpath = Locators.CASENAME_XPATH)
	WebElement caseName;

	@FindBy(xpath = Locators.CASESTATUS_XPATH)
	WebElement caseStatus;

	@FindBy(xpath = Locators.PERSONNAME_XPATH)
	WebElement personName;

	/**
	 * Constructs a new CasesPage object, using the driver created in TestBase. It
	 * also initializes its web elements by using the PageFactory method, pointing
	 * to all elements defined in this very class.
	 */
	public CasesPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on Add Case button of Cases Page and It then waits for the results to
	 * be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.NewCasePage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.NewCasePage</class>
	 */
	public NewCasePage AddCase() {
		TestUtil.waitForElement(addCaseBtn);
		addCaseBtn.click();
		return new NewCasePage();

	}

	/*
	 * Clicks on home icon of cases Page and It then waits for the results to be
	 * loaded and initializes the <class>com.capsuleCrm.WebPages.HomePage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.HomePage</class>
	 */
	public HomePage ClickOnHomeIcon() {
		homeIcon.click();
		return new HomePage();
	}

	/*
	 * Verifies the new case created in the New Case page using the below parameters
	 * 
	 * @param name-case name, status- case status, firstName- firstName of the
	 * person,lastName - lastName of the person
	 */

	public void VerifyTheCaseCreated(String name, String status, String firstName, String lastName) {
		TestUtil.waitForElement(caseName);
		Assert.assertEquals(caseName.getText(), name);
		System.out.println("****Verified the case name with actual --" + caseName.getText() + ",expected--" + name+"****");
		Assert.assertEquals(caseStatus.getText(), status);
		System.out.println("****Verified the case status with actual --" + caseStatus.getText() + ",expected--" + status+"****");
		Assert.assertEquals(personName.getText(), firstName + " " + lastName);
		System.out.println("****Verified the case opened against person with actual --" + personName.getText()
				+ ",expected--" + firstName + " " + lastName+"****");

	}

}
