package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

/**
 * Page Object class for Student Information functionality
 * Contains methods to interact with Student Information page elements
 */
public class AL_Academic_SR_StudentInformation extends BaseClass {

    /**
     * Constructor to initialize WebElements
     * @param rdriver WebDriver instance
     */
    public AL_Academic_SR_StudentInformation(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    // WebElement locators using FindBy annotations
    @FindBy(linkText = "Student Related")
    private WebElement studentRelated;
    
    @FindBy(id = "ctl00_repLinks_ctl06_lbLink")
    private WebElement studentInformation;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearch")
    private WebElement searchCriteria;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlDropdown")
    private WebElement branchDropdown;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_Button1")
    private WebElement searchButton;
    
    @FindBy(xpath = "//*[text()='Student List']")
    private WebElement studentListHeader;
    
    /**
     * Click on Student Related submenu
     * @return this class instance for method chaining
     */
    public AL_Academic_SR_StudentInformation clickStudentRelated() {
        System.out.println("Click on Student Related");
        studentRelated.click();
        return this;
    }
    
    /**
     * Click on Student Information link
     * @return this class instance for method chaining
     */
    public AL_Academic_SR_StudentInformation clickStudentInformation() {
        System.out.println("Click on Student Information");
        studentInformation.click();
        return this;
    }
    
    /**
     * Select search criteria with hardcoded value
     * @return this class instance for method chaining
     */
    public AL_Academic_SR_StudentInformation selectSearchCriteria() {
        String criteria = "BRANCH";
        System.out.println("Search Criteria -> " + criteria);
        Select criteriaSelect = new Select(searchCriteria);
        criteriaSelect.selectByVisibleText(criteria);
        return this;
    }
    
    /**
     * Select branch with hardcoded value
     * @return this class instance for method chaining
     */
    public AL_Academic_SR_StudentInformation selectBranch() {
        String branch = "Architecture";
        System.out.println("BRANCH -> " + branch);
        Select branchSelect = new Select(branchDropdown);
        branchSelect.selectByVisibleText(branch);
        return this;
    }
    
    /**
     * Click on Search button
     * @return this class instance for method chaining
     */
    public AL_Academic_SR_StudentInformation clickSearchButton() {
        System.out.println("Click on Search Button");
        searchButton.click();
        return this;
    }
    
    /**
     * Scroll the branch dropdown into view
     * @return this class instance for method chaining
     */
    public AL_Academic_SR_StudentInformation scrollBranchIntoView() {
        System.out.println("Scrolling branch dropdown into view");
        scrollIntoView(branchDropdown, 50, 200);
        return this;
    }
    
    /**
     * Verify Student List header is displayed
     * @return true if header is displayed with correct text
     */
    public boolean verifyStudentListHeader() {
        System.out.println("Verifying Student List header");
        String expectedText = "Student List";
        String actualText = studentListHeader.getText();
        System.out.println("Expected: " + expectedText + ", Actual: " + actualText);
        return expectedText.equals(actualText);
    }
    
    /**
     * Get text of Student List header
     * @return text of the header
     */
    public String getStudentListHeaderText() {
        return studentListHeader.getText();
    }
}
