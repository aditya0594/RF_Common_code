package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

/**
 * Page Object class for Academic Post Admission Section/Enrollment No. Allotment functionality
 * Contains methods to interact with Section/Enrollment No. Allotment page elements
 */
public class AL_Academic_PA_SectionEnrollmentNoAllotment extends BaseClass {

    /**
     * Constructor to initialize WebElements
     * @param rdriver WebDriver instance
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    // WebElement locators using FindBy annotations
    @FindBy(linkText = "ACADEMIC")
    private WebElement academicMenu;
    
    @FindBy(linkText = "Post Admission")
    private WebElement postAdmissionMenu;
    
    @FindBy(linkText = "Section/Enrollment No. Allotment")
    private WebElement sectionEnrollmentNoAllotment;
    
    @FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlInsName-container")
    private WebElement schoolInstituteDropdown;
    
    @FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container")
    private WebElement degreeDropdown;
    
    @FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBranch-container")
    private WebElement branchDropdown;
    
    @FindBy(className = "select2-search__field")
    private WebElement searchField;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnFilter")
    private WebElement filterButton;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvStudents_ctrl0_TextBox1")
    private WebElement rollNoField;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
    private WebElement submitButton;
    
    /**
     * Click on Academic main menu
     * @return this class instance for method chaining
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment clickAcademicMenu() {
        System.out.println("Click on Academic");
        Actions action = new Actions(driver);
        action.moveToElement(academicMenu).perform();
        return this;
    }
    
    /**
     * Click on Post Admission submenu
     * @return this class instance for method chaining
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment clickPostAdmissionMenu() {
        System.out.println("Click on Post Admission option");
        Actions action = new Actions(driver);
        action.moveToElement(postAdmissionMenu);
        action.click().build().perform();
        return this;
    }
    
    /**
     * Click on Section/Enrollment No. Allotment menu item
     * @return this class instance for method chaining
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment clickSectionEnrollmentNoAllotment() {
        System.out.println("Click on Section/Enrollment No. Allotment from sub menu");
        sectionEnrollmentNoAllotment.click();
        return this;
    }
    
    /**
     * Select School/Institute with hardcoded value
     * @return this class instance for method chaining
     * @throws InterruptedException if thread sleep is interrupted
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment selectSchoolInstitute() throws InterruptedException {
        String schoolInstituteText = "School of Computer Information and Mathematical Sciences";
        System.out.println("Select School Institute: " + schoolInstituteText);
        schoolInstituteDropdown.click();
        searchField.sendKeys(schoolInstituteText);
        searchField.sendKeys(Keys.ENTER);
        threadWait1();
        return this;
    }
    
    /**
     * Select Degree with hardcoded value
     * @return this class instance for method chaining
     * @throws InterruptedException if thread sleep is interrupted
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment selectDegree() throws InterruptedException {
        String degreeText = "Bachelor of Technology";
        System.out.println("Select Degree: " + degreeText);
        degreeDropdown.click();
        searchField.sendKeys(degreeText);
        searchField.sendKeys(Keys.ENTER);
        threadWait1();
        return this;
    }
    
    /**
     * Select Branch with hardcoded value
     * @return this class instance for method chaining
     * @throws InterruptedException if thread sleep is interrupted
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment selectBranch() throws InterruptedException {
        String branchText = "Computer Science and Engineering";
        System.out.println("Select Branch: " + branchText);
        branchDropdown.click();
        searchField.sendKeys(branchText);
        searchField.sendKeys(Keys.ENTER);
        threadWait1();
        return this;
    }
    
    /**
     * Click filter button
     * @return this class instance for method chaining
     * @throws InterruptedException if thread sleep is interrupted
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment clickFilterButton() throws InterruptedException {
        System.out.println("Click on Filter Button");
        filterButton.click();
        Thread.sleep(8000); // Using longer sleep as in the test
        return this;
    }
    
    /**
     * Enter roll number with hardcoded value
     * @return this class instance for method chaining
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment enterRollNumber() {
        String rollNumber = "0603001";
        System.out.println("Enter Roll No.: " + rollNumber);
        String clearKeys = Keys.chord(Keys.CONTROL, "A");
        rollNoField.sendKeys(clearKeys, rollNumber);
        return this;
    }
    
    /**
     * Click submit button
     * @return this class instance for method chaining
     * @throws InterruptedException if thread sleep is interrupted
     */
    public AL_Academic_PA_SectionEnrollmentNoAllotment clickSubmitButton() throws InterruptedException {
        System.out.println("Click on Submit Button");
        submitButton.click();
        Thread.sleep(5000); // Using longer sleep as in the test
        return this;
    }
    
    /**
     * Get expected alert message
     * @return expected alert message
     */
    public String getExpectedAlertMessage() {
        return "Updated Successfully!!!";
    }
}
