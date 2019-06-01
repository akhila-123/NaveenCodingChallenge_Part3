package com.capsuleCrm.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capsuleCrm.TestBase.TestBase;
import com.capsuleCrm.TestUtil.TestUtil;
import com.capsuleCrm.WebPages.AccountPage;
import com.capsuleCrm.WebPages.AccountSettingsPage;
import com.capsuleCrm.WebPages.AppearancePage;
import com.capsuleCrm.WebPages.CasesPage;
import com.capsuleCrm.WebPages.CustomFieldsPage;
import com.capsuleCrm.WebPages.ExportPage;
import com.capsuleCrm.WebPages.HomePage;
import com.capsuleCrm.WebPages.IntegrationsPage;
import com.capsuleCrm.WebPages.InvoicesPage;
import com.capsuleCrm.WebPages.LoginPage;
import com.capsuleCrm.WebPages.MailDropBoxPage;
import com.capsuleCrm.WebPages.NewCasePage;
import com.capsuleCrm.WebPages.NewOpportunityTrackPage;
import com.capsuleCrm.WebPages.NewPersonPage;
import com.capsuleCrm.WebPages.NewUserPage;
import com.capsuleCrm.WebPages.OpportunitiesPage;
import com.capsuleCrm.WebPages.PeopleAndOrgPage;
import com.capsuleCrm.WebPages.TagsPage;
import com.capsuleCrm.WebPages.TaskCategoriesPage;
import com.capsuleCrm.WebPages.TracksPage;
import com.capsuleCrm.WebPages.TrashPage;
import com.capsuleCrm.WebPages.UsersPage;

/**
 * Tests capsulecrm application related functionality. It uses TestNg
 * Annotations.
 * 
 * @author Akhila Bandiki
 */

public class TestCase extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	PeopleAndOrgPage PAndOpage;
	CasesPage casespage;
	NewPersonPage newpersonpage;
	NewCasePage newcasepage;
	AccountSettingsPage accountsettingspage;
	AccountPage accountpage;
	InvoicesPage invoicespage;
	ExportPage exportpage;
	AppearancePage appearancepage;
	MailDropBoxPage MDBpage;
	UsersPage userspage;
	OpportunitiesPage opportunitiespage;
	TracksPage trackspage;
	TaskCategoriesPage taskCategoriespage;
	CustomFieldsPage customFieldspage;
	TagsPage tagspage;
	IntegrationsPage integrationspage;
	TrashPage trashpage;
	NewUserPage newuserpage;
	NewOpportunityTrackPage newopportunitytrackpage;
	String PersonAndCaseSheetName = prop.getProperty("PersonAndCaseSheetName");

	String UserSheetName = prop.getProperty("UserSheetName");

	/* To initialize browser and properties file */
	@BeforeMethod
	public void SetUp() {
		InitialSetUp();
	}

	@DataProvider
	public Object[][] getPersonAndCaseTestData() {
		Object data[][] = TestUtil.getTestData(PersonAndCaseSheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getPersonAndCaseTestData")
	public void AgentVerification(String Title, String FirstName, String LastName, String JobTitle, String Organisation,
			String PersonTag, String PhoneNumber, String EmailId, String Website, String CaseRelatesTo, String Name,
			String Description, String CaseTags, String Status) {
		loginpage = new LoginPage();
		homepage = loginpage.EnterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		PAndOpage = homepage.ClickOnPersonIcon();
		newpersonpage = PAndOpage.ClickOnAddPerson();
		PAndOpage = newpersonpage.FillPersonDetailsAndSave(Title, FirstName, LastName, JobTitle, Organisation,
				PersonTag, PhoneNumber, EmailId, Website);
		PAndOpage.VerifyThePersonCreated(FirstName, LastName);
		homepage = PAndOpage.ClickOnHomeIcon();
		casespage = homepage.ClickOnCaseIcon();
		newcasepage = casespage.AddCase();
		casespage = newcasepage.FillNewCaseDetails(CaseRelatesTo, Name, Description, CaseTags);
		casespage.VerifyTheCaseCreated(Name, Status, FirstName, LastName);
	}

	@DataProvider
	public Object[][] getNewUserData() {
		Object data[][] = TestUtil.getTestData(UserSheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getNewUserData")
	public void VerifyAccountSettingsOptionsTest(String FirstName, String LastName, String EmailAddress,
			String Username) {
		loginpage = new LoginPage();
		homepage = loginpage.EnterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		accountsettingspage = homepage.OpenAccountSettingsPage();
		accountsettingspage.VerifyPageHeader(prop.getProperty("AccountSettingsPageHeader"));
		accountpage = accountsettingspage.OpenAccountPage();
		accountpage.VerifyHeader(prop.getProperty("AccountPageHeader"));
		invoicespage = accountpage.OpenInvoicesPage();
		invoicespage.VerifyHeader(prop.getProperty("InvoicesPageHeader"));
		exportpage = invoicespage.OpenExportPage();
		exportpage.VerifyHeader(prop.getProperty("ExportPageHeader"));
		appearancepage = exportpage.OpenAppearancePage();
		appearancepage.VerifyHeader(prop.getProperty("AppearancePageHeader"));
		appearancepage.UploadLogoAndSave();
		MDBpage = appearancepage.OpenMailDropBoxPage();
		MDBpage.VerifyHeader(prop.getProperty("MailDropBoxPageHeader"));
		userspage = MDBpage.OpenUsersPage();
		userspage.VerifyHeader(prop.getProperty("UsersPageHeader"));
		newuserpage = userspage.AddNewUser();
		userspage = newuserpage.FillDetailsAndSave(FirstName, LastName, EmailAddress, Username);
		userspage.VerifyUserCreated(FirstName, LastName);
		opportunitiespage = userspage.OpenOpportunitiesPage();
		opportunitiespage.VerifyHeader(prop.getProperty("OpportunitiesPageHeader"));
		opportunitiespage.AddNewCategory(prop.getProperty("NewMilestoneName"),
				prop.getProperty("ProbabilityOfWinning"));
		trackspage = opportunitiespage.OpenTracksPage();
		trackspage.VerifyHeader(prop.getProperty("TracksPageHeader"));
		newopportunitytrackpage = trackspage.OpenAddNewTrackLink();
		trackspage = newopportunitytrackpage.FillDetailsAndSave(prop.getProperty("Name"), prop.getProperty("Tag"),
				prop.getProperty("TaskDescription"), prop.getProperty("DueDays"), prop.getProperty("UserName"));
		trackspage.VerifyTheTrackCreated(prop.getProperty("Name"));
		taskCategoriespage = trackspage.OpenTaskCategoriesPage();
		taskCategoriespage.VerifyHeader(prop.getProperty("TaskCategoriesPageHeader"));
		String NewCategoryName = taskCategoriespage.AddNewCategory(prop.getProperty("NewCategory"));
		taskCategoriespage.VerifyTheCategoryCreated(NewCategoryName);
		customFieldspage = taskCategoriespage.OpenCustomFieldsPage();
		customFieldspage.VerifyHeader(prop.getProperty("CustomFieldsPageHeader"));
		tagspage = customFieldspage.OpenTagsPage();
		tagspage.VerifyHeader(prop.getProperty("TagsPageHeader"));
		String NewTagName = tagspage.AddNewTag(prop.getProperty("NewTag"));
		tagspage.VerifyTheTagCreated(NewTagName);
		integrationspage = tagspage.OpenIntegrationsPage();
		integrationspage.VerifyHeader(prop.getProperty("IntegrationsPageHeader"));
		integrationspage.VerfiyNumberOfConfigureButtons();
		trashpage = integrationspage.OpenTrashPage();
		trashpage.VerifyHeader(prop.getProperty("TrashPageHeader"));
	}

	/* Takes screenshot of failed test cases and Closes Browser */

	@AfterMethod
	public void TearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//screenshots//screenshot.png"));
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
		driver.quit();
		System.out.println("**********End Of Test********");
	}

}
