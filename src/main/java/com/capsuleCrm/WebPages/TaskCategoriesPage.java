package com.capsuleCrm.WebPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capsuleCrm.TestBase.TestBase;
import com.capsuleCrm.TestUtil.TestUtil;

/**
 * Contains all the elements needed to automate the interaction with the Task
 * Categories page
 * 
 * @author Akhila Bandiki
 */

public class TaskCategoriesPage extends TestBase {
	/* WebElement Section */
	@FindBy(xpath = Locators.TASKCATEGORIESPAGEHEADER_XPATH)
	WebElement taskCategoriesPageHeader;

	@FindBy(xpath = Locators.ADDNEWCATEGORY_XPATH)
	WebElement addNewCategoryBtn;

	@FindBy(id = Locators.CATEGORYNAME_ID)
	WebElement newCategoryName;

	@FindBy(id = Locators.CATEGORYSAVEBTN_ID)
	WebElement saveBtn;

	@FindBy(xpath = Locators.CUSTOMFIELDS_XPATH)
	WebElement customFieldsLink;
	
	@FindBy(xpath = Locators.VERIFYCATEGORY_XPATH)
	List<WebElement> verifyCategory;
	
	

	/**
	 * Constructs a new Task Categories Page object, using the driver created in
	 * TestBase. It also initializes its web elements by using the PageFactory
	 * method, pointing to all elements defined in this very class.
	 */
	public TaskCategoriesPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on CustomFields link of Task Categories Page and It then waits for the
	 * results to be loaded and initializes the
	 * <class>com.capsuleCrm.WebPages.CustomFieldsPage</class>
	 * 
	 * @return <class>com.capsuleCrm.WebPages.CustomFieldsPage</class>
	 */
	public CustomFieldsPage OpenCustomFieldsPage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		customFieldsLink.click();
		return new CustomFieldsPage();
	}

	/**
	 * Verifies the page header values to the expected value
	 */

	public void VerifyHeader(String ExpectedPageHeader) {
		String ActualPageHeader = taskCategoriesPageHeader.getText();
		Assert.assertTrue(ActualPageHeader.equals(ExpectedPageHeader), "Account Page Header is not as expected");
		System.out.println("****Verified the Task Categories Page Header****");
	}

	/**
	 * Clicks on Add New Category Button of Task Categories Page and It then waits
	 * for the results to be loaded and enters Category name and clicks on save
	 * Button
	 * 
	 * @param New Category name
	 */

	public String AddNewCategory(String NewCategory) {
		addNewCategoryBtn.click();
		TestUtil.waitForElement(newCategoryName);
		String NewCategoryName = NewCategory + TestUtil.gettimestamp();
		newCategoryName.sendKeys(NewCategoryName);
		saveBtn.click();
		TestUtil.waitForElement(customFieldsLink);
		return NewCategoryName;
	}

	/**
	 *Verifies the New Category created in Task Categories Page 
	 * 
	 * @param New Category name
	 */

	public void VerifyTheCategoryCreated(String NewCategory) {
		for (int i = 0; i < verifyCategory.size(); i++) {
			if ((verifyCategory.get(i).getText()).equals(NewCategory)) {
				System.out.println("****Verified the new category created****");
			}
		}

	}

}
