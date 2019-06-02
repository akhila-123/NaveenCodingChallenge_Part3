package com.capsuleCrm.WebPages;

import com.capsuleCrm.TestUtil.TestUtil;

/**
 * Keeps track of all the locators
 * 
 * @author Akhila Bandiki
 *
 */
public class Locators {

	/* Login Page locators */
	public static final String USERNAME_ID = "login:usernameDecorate:username";
	public static final String PASSWORD_ID = "login:passwordDecorate:password";
	public static final String LOGINBTN_ID = "login:login";
	/* Home Page locators */
	public static final String PERSONICON_XPATH = "//a[@aria-label='People & Organisations']";
	public static final String CASEICON_XPATH = "//a[@aria-label='Cases']";
	public static final String USERNAME_XPATH = "//span[@class='nav-bar-username']";
	public static final String ACCOUNTSETTINGS_XPATH = "//a[text()='Account Settings']";
	/* People And Organisation Page locators */
	public static final String ADDPERSON_XPATH = "//a[text()='Add Person']";
	public static final String SELECTPERSON_XPATH = "//a[text()='' and @id='ember348']";
	public static final String HOMEICON_XPATH = "//a[@aria-label='Dashboard']";
	public static final String VERIFYNAME_XPATH = "//span[@class='party-details-title']";
	/* New Person Page locators */
	public static final String TITLE_NAME = "party:j_id108:j_id116";
	public static final String FIRSTNAME_ID = "party:fnDecorate:fn";
	public static final String LASTNAME_ID = "party:lnDecorate:ln";
	public static final String JOBTITLE_ID = "party:roleDecorate:jobTitle";
	public static final String ORGANISATION_ID = "party:orgDecorate:org";
	public static final String PERSONTAGS_ID = "party:tagsDecorate:tagComboBox";
	public static final String PERSONADDTAG_ID = "party:tagsDecorate:j_id187";
	public static final String PHONENUMBER_ID = "party:j_id325:0:phnDecorate:number";
	public static final String EMAILADD_ID = "party:j_id342:0:emlDecorate:nmbr";
	public static final String WEBSITE_ID = "party:j_id370:0:webDecorate:web";
	public static final String SAVEBTN_ID = "party:save";
	/* Cases Page locators */
	public static final String ADDCASE_XPATH = "//a[text()='Add Case']";
	public static final String CASENAME_XPATH = "//div[@class='entity-details-title']";
	public static final String CASESTATUS_XPATH = "//span[@class='kase-summary-status-open']";
	public static final String PERSONNAME_XPATH = "//*[@class='ember-view' and contains(@href,'/party/')]";
	/* New Person Page locators */
	public static final String CASERELATESTO_ID = "partySearch";
	public static final String NAME_ID = "caseNameDecorate:name";
	public static final String DESCRIPTION_ID = "caseDescriptionDecorate:description";
	public static final String CASETAGS_ID = "tagsDecorate:tagComboBox";
	public static final String CASEADDTAG_ID = "tagsDecorate:j_id191";
	public static final String TRACK_NAME = "caseTypeDecorate:j_id197:j_id205";
	public static final String CASESAVEBTN_ID = "save";
	/* Account Settings Page locators */
	public static final String ACCOUNT_XPATH = "//a[text()='Account']";
	public static final String ACCOUNTSETTINGSPAGEHEADER_XPATH = "//span[@class='settings-content-menu-title']";
	/* Account Page Locators */
	public static final String ACCOUNTPAGEHEADER_XPATH = "//h1[@class='settings-page-header']";
	public static final String INVOICES_XPATH = "//a[text()='Invoices']";
	/* Invoices Page Locators */
	public static final String INVOICESPAGEHEADER_XPATH = "//*[@class='page-box-header']";
	public static final String EXPORT_XPATH = "//a[@href='/settings/account/export']";
	/* Export Page Locators */
	public static final String EXPORTPAGEHEADER_XPATH = "//h1[@class='settings-page-header']";
	public static final String APPEARANCE_XPATH = "//a[text()='Appearance']";
	/* Appearance Page Locators */
	public static final String APPEARANCEPAGEHEADER_XPATH = "//h1[@class='settings-page-header']";
	public static final String MAILDROPBOX_XPATH = "//a[text()='Mail Drop Box']";
	public static final String UPLOADLOGO_XPATH = "//input[@id='appearance:uploadDecorate:logoImage']";
	public static final String SAVEBTN_XPATH = "//a[text()='Save']";
	/* Mail drop box Page Locators */
	public static final String MAILDROPBOXPAGEHEADER_XPATH = "//h2[@class='settings-page-header']";
	public static final String USERS_XPATH = "//a[text()='Users']";
	/* Users Page Locators */
	public static final String USERSPAGEHEADER_XPATH = "//h2[@class='settings-page-header']";
	public static final String OPPORTUNITIES_XPATH = "//a[@href='/settings/opportunities']";
	public static final String NEWUSER_XPATH = "//a[text()='Add new User']";
	public static final String VERIFYUSER_XPATH = "//table/tbody/tr[2]/td/a";
	public static final String DELETEUSERNAME_XPATH = "//td/a[contains(@href,'/settings/users/')]";
	public static final String DELETEUSER_XPATH = "//a[contains(@href,'#deleteUser')]";
	public static final String DELETEUSERBTN_XPATH = "//a[text()='Delete']";
	/* NewUser Page Locators */
	public static final String FIRSTNAME_NU_ID = "register:firstnameDecorate:firstName";
	public static final String LASTNAME_NU_ID = "register:lastNameDecorate:lastName";
	public static final String EMAILADDRESS_ID = "register:emailDecorate:email";
	public static final String USERNAME_NU_ID = "register:usernameDecorate:username";
	public static final String INVITEUSER_ID = "register:save";
	/* Opportunities Page Locators */
	public static final String OPPORTUNITIESPAGEHEADER_XPATH = "//header[@class='page-box-header']";
	public static final String TRACKS_XPATH = "//a[@href='/settings/tracks/opportunities']";
	public static final String ADDNEWMILESTONE_XPATH = "//button[text()='Add new Milestone']";
	public static final String MILESTONENAME_XPATH = "//*[@class='form-input-text milestone-modal-name']";
	public static final String PB_XPATH = "//input[@class='form-input-text milestone-modal-probability']";
	public static final String MILESTONESAVEBTN_XPATH = "//button[text()='Save']";
	public static final String VERIFYMILESTONE_XPATH = "//button[@class='hyperlink-button milestone-item-edit']";
	/* Tracks Page Locators */
	public static final String TRACKSPAGEHEADER_XPATH = "//h2[@class='settings-page-header']";
	public static final String TASKCATEGORIES_XPATH = "//a[text()='Task Categories']";
	public static final String ADDNEWTRACK_XPATH = "//a[text()='Add new Track']";
	public static final String VERIFYTRACK_XPATH = "//td/a";
	/* New Opportunity Track Page Locators */
	public static final String NEWNAME_ID = "j_id123:trackDescriptionDecorate:trackDescription";
	public static final String TAG_ID = "j_id123:trackTagDecorate:trackTag";
	public static final String TASKDESCRIPTION_ID = "j_id123:taskLines:0:taskDescriptionDecorate:taskDescription";
	public static final String DUEDAYS_ID = "j_id123:taskLines:0:taskDaysAfterDecorate:taskDaysAfter";
	public static final String ASSIGNEE_XPATH = "//*[@name='j_id123:taskLines:0:taskAssignmentDecorate:j_id218']";
	public static final String SAVE_XPATH = "//a[text()='Save']";
	/* Task Categories Page Locators */
	public static final String TASKCATEGORIESPAGEHEADER_XPATH = "//h2[@class='settings-page-header']";
	public static final String ADDNEWCATEGORY_XPATH = "//a[text()='Add new Category']";
	public static final String CATEGORYNAME_ID = "editCategoryForm:taskCategoryNameDecorate:taskCategoryName";
	public static final String CATEGORYSAVEBTN_ID = "editCategoryForm:j_id175";
	public static final String CUSTOMFIELDS_XPATH = "//a[@href='/settings/customfields/party']";
	public static final String VERIFYCATEGORY_XPATH = "//td[@class=' list-column-left']/a";
	/* Custom Fields Page Locators */
	public static final String CUSTOMFIELDSPAGEHEADER_XPATH = "//h2[@class='settings-page-header']";
	public static final String TAGS_XPATH = "//a[text()='Tags']";
	/* Tags Page Locators */
	public static final String TAGSPAGEHEADER_XPATH = "//h2[@class='settings-page-header']";
	public static final String ADDNEWTAG_XPATH = "//a[text()='Add new Tag']";
	public static final String NEWTAGNAME_ID = "j_id177:tagNameDecorate:tagName";
	public static final String SAVE_ID = "j_id177:j_id210";
	public static final String INTEGRATIONS_XPATH = "//a[text()='Integrations']";
	public static final String VERIFYTAG_XPATH = "//table/tbody/tr/td/span/a";
	/* Integrations Page Locators */
	public static final String INTEGRATIONSPAGEHEADER_XPATH = "//h2[@class='settings-page-header']";
	public static final String TRASH_XPATH = "//a[text()='Trash']";
	public static final String CONFIGUREBTNLIST_XPATH = "//a[text()='Configure']";
	/* Trash Page Locators */
	public static final String TRASHPAGEHEADER_XPATH = "//h2[@class='settings-page-header']";
}
