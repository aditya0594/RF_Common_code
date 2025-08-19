package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.testng.Assert;
import utility.BaseClass;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utility.ExcelUtility;

import java.io.*;

public class AL_Academic_AP_NewStudent extends BaseClass {

    public AL_Academic_AP_NewStudent(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // Navigation elements
    @FindBy(linkText = "ACADEMIC")
    private WebElement ACADEMIC;

    @FindBy(linkText = "Admission Process")
    private WebElement AdmissionProcess;

    @FindBy(linkText = "New Student")
    private WebElement NewStudent;

    @FindBy(linkText = "Pre Admission")
    private WebElement preAdmission;

    @FindBy(linkText = "Demand Creation")
    private WebElement demandCreation;

    // Form elements
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnNewStu")
    private WebElement btnNewStudent;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtStudentfullName")
    private WebElement txtStudentName;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtFatherName")
    private WebElement txtFatherName;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtStudMobile")
    private WebElement txtMobileNumber;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtStudMobile2")
    private WebElement txtAlternateMobileNumber;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtStudEmail")
    private WebElement txtEmailId;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlNationality")
    private WebElement nationality;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlstate")
    private WebElement state;


    @FindBy(id = "ctl00_ContentPlaceHolder1_rdoMale")
    private WebElement gender;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")
    private WebElement session;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchool")
    private WebElement school;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree")
    private WebElement degree;
    //
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch")
    private WebElement branchvvx;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddladmthrough")
    private WebElement admthrough;
    //
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmType")
    private WebElement admType;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlYear")
    private WebElement year;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester")
    private WebElement semester;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlBatch")
    private WebElement ddlBatch;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtDateOfBirth")
    private WebElement txtDateOfBirth;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlAllotedCat")
    private WebElement ddlCategory;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtDateOfReporting")
    private WebElement txtDateOfReporting;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlPaymentType")
    private WebElement ddlPaymentType;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
    private WebElement btnSubmit;

    By dropdownInput = By.xpath("//input[@class='select2-search__field']");

    By districtDropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddlDistrict-container");
    By cityDropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddlCity-container");
    // JavaScript executor for scrolling
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // WebDriverWait for explicit waits
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    /**
     * Navigate to Academic menu
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent academic() {
        System.out.println("Admin ACADEMIC menu selected");
        Actions action = new Actions(driver);
        action.moveToElement(ACADEMIC).build().perform();
        return this;
    }

    /**
     * Click on Admission Process submenu
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent admissionProcess() {
        System.out.println("Admission Process submenu selected");
        AdmissionProcess.click();
        return this;
    }

    /**
     * Click on New Student option
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent newStudent() {
        System.out.println("New Student option selected");
        NewStudent.click();
        return this;
    }

    public AL_Academic_AP_NewStudent preAdmission() {
        System.out.println("Pre Admission option selected");
        preAdmission.click();
        return this;
    }

    public AL_Academic_AP_NewStudent demandCreationMenu() {
        System.out.println("Demand creation option selected");
        demandCreation.click();
        return this;
    }


    /**
     * Click on New Student button
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent clickNewStudentButton() {
        System.out.println("Click on New Student Button");
        click(btnNewStudent);
        return this;
    }

    /**
     * Enter student full name with hardcoded value
     *
     * @return this class instance for method chaining
     */

    public AL_Academic_AP_NewStudent enterStudentName(String studentName) {

        System.out.println("Entering student name: " + studentName);
        wait.until(ExpectedConditions.elementToBeClickable(txtStudentName));
        txtStudentName.click();
        txtStudentName.clear();
        txtStudentName.sendKeys(studentName);
        return this;
    }


    public AL_Academic_AP_NewStudent enterFatherName(String fatherName) {

        System.out.println("Entering father's name: " + fatherName);
        txtFatherName.click();
        txtFatherName.clear();
        txtFatherName.sendKeys(fatherName);
        return this;
    }


    String mobileNumber = generateMobileNumber();

    public AL_Academic_AP_NewStudent enterMobileNumber(String mobileNumber) {

        System.out.println("Entering mobile number: " + mobileNumber);
        txtMobileNumber.click();
        txtMobileNumber.clear();
        txtMobileNumber.sendKeys(mobileNumber);
        return this;
    }


    public AL_Academic_AP_NewStudent enterAlternateMobileNumber(String alternateMobileNumber) {

        System.out.println("Entering alternate mobile number: " + alternateMobileNumber);
        txtAlternateMobileNumber.click();
        txtAlternateMobileNumber.clear();
        txtAlternateMobileNumber.sendKeys(alternateMobileNumber);
        return this;
    }

    /**
     * Enter email ID with hardcoded value
     *
     * @return this class instance for method chaining
     */


    public AL_Academic_AP_NewStudent enterEmailId(String email) {

        System.out.println("Entering email ID: " + email);
        waitUntilElementIsClickable(txtEmailId);
        txtEmailId.click();
        txtEmailId.clear();
        txtEmailId.sendKeys(email);
        return this;
    }

    String nationalityName = "Indian";

    public AL_Academic_AP_NewStudent selectNationality() {

        System.out.println("Selecting nationality: " + nationalityName);
        waitUntilElementIsClickable(nationality);
        Select nationalitySelect = new Select(nationality);
        nationalitySelect.selectByVisibleText(nationalityName);
        return this;
    }


    /**
     * Select campus with hardcoded value
     *
     * @return this class instance for method chaining
     */

    String stateName = "Maharashtra";

    public AL_Academic_AP_NewStudent selectState() {

        System.out.println("Selecting State: " + stateName);
        waitUntilElementIsClickable(state);
        Select stateSelect = new Select(state);
        stateSelect.selectByVisibleText(stateName);

        return this;
    }

    static By loader = By.xpath("(//div[@id='loader-img'])[3]");

    public static void loader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

    }

    /**
     * Select branch/program with hardcoded value
     *
     * @return this class instance for method chaining
     */


    String DistrictName = "Nagpur";

    public AL_Academic_AP_NewStudent selectDistrict() throws InterruptedException {
        loader();

        System.out.println("Selecting District: " + DistrictName);
        waitUntilElementIsClickableBy(districtDropdown);
        dropdownByEnter(districtDropdown, dropdownInput, "Nagpur");
        return this;
    }

    String cityName = "NAGPUR";

    public AL_Academic_AP_NewStudent selectCity() throws InterruptedException {

        loader();
        System.out.println("Selecting city: " + cityName);
        waitUntilElementIsClickableBy(cityDropdown);
        dropdownByEnter(cityDropdown, dropdownInput, "NAGPUR");
        return this;
    }

    public AL_Academic_AP_NewStudent clickGender() {
        System.out.println("Selecting Gender: Male");
        waitUntilElementIsClickable(gender);
        click(gender);
        return this;
    }

    By schooldropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddlSchool-container");
    By degreedropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container");
    By branchdropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container");
    By admissiondropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddladmthrough-container");
    By admissionType = By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmType-container");
    By admissionYear = By.id("select2-ctl00_ContentPlaceHolder1_ddlYear-container");
    By semesterdropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container");
    By admissionBranchDropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddlBatch-container");

    By admissioncategoryDropdown = By.id("select2-ctl00_ContentPlaceHolder1_ddlAllotedCat-container");
    By DateOFEntryField = By.id("ctl00_ContentPlaceHolder1_txtDateOfReporting");
    By paymentTypeField = By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container");

    By receiptTypeField = By.id("select2-ctl00_ContentPlaceHolder1_ddlReceiptType-container");


    String schooltext = "Crescent School of Architecture";

    public AL_Academic_AP_NewStudent SchoolInstitution() throws InterruptedException {
        loader();

        System.out.println("Selecting school: " + school);
        dropdownByEnter(schooldropdown, dropdownInput, schooltext);
        return this;
    }

    String degreeoption = "Bachelor of Architecture";

    public AL_Academic_AP_NewStudent degreeSelect() throws InterruptedException {
        loader();

        System.out.println("Selecting degree: " + school);
        Thread.sleep(2000);
        waitForElementVisible(degreedropdown);
        dropdownByEnter(degreedropdown, dropdownInput, degreeoption);
        return this;
    }

    String branch = "Architecture";

    public AL_Academic_AP_NewStudent branchselect() throws InterruptedException {
        loader();

        System.out.println("Selecting branch: " + branch);
        Thread.sleep(1000);
        waitForElementVisible(branchdropdown);
        dropdownByEnter(branchdropdown, dropdownInput, branch);
        return this;
    }

    String admissionth = "CAP 1";

    public AL_Academic_AP_NewStudent admissionThroughSelect() throws InterruptedException {
        loader();

        System.out.println("Selecting Admission Through: " + admissionth);
        Thread.sleep(1000);
        waitForElementVisible(admissiondropdown);
        dropdownByEnter(admissiondropdown, dropdownInput, admissionth);
        return this;
    }

    String admissiontypetxt = "REGULAR";

    public AL_Academic_AP_NewStudent admissionType() throws InterruptedException {
        loader();

        System.out.println("Selecting Admission Type: " + admissiontypetxt);
        Thread.sleep(1000);
        waitForElementVisible(admissionType);
        dropdownByEnter(admissionType, dropdownInput, admissiontypetxt);
        return this;
    }

    String admissionYeartxt = "First Year";

    public AL_Academic_AP_NewStudent admissionYear() throws InterruptedException {

        Thread.sleep(2000);
        System.out.println("Selecting Admission Year: " + admissionYeartxt);
        Thread.sleep(1000);
        waitForElementVisible(admissionYear);
        dropdownByEnter(admissionYear, dropdownInput, admissionYeartxt);
        return this;
    }

    String semestertxt = "I";

    public AL_Academic_AP_NewStudent semesterselect() throws InterruptedException {

        System.out.println("Selecting Admission Year: " + semestertxt);
        Thread.sleep(1000);
        waitForElementVisible(semesterdropdown);
        dropdownByEnter(semesterdropdown, dropdownInput, semestertxt);
        return this;
    }

    String admissionBranchtext = "2024-25";

    public AL_Academic_AP_NewStudent admissionBranchSelect() throws InterruptedException {

        System.out.println("Selecting Admission Branch: " + admissionBranchtext);
        Thread.sleep(1000);
        waitForElementVisible(admissionBranchDropdown);
        dropdownByEnter(admissionBranchDropdown, dropdownInput, admissionBranchtext);
        return this;
    }


    By DoBCalenderClick = By.id("txtDateOfBirth1");
    By MonthandyearText = By.xpath("(//div[@id='ctl00_ContentPlaceHolder1_ceDateOfBirth_title'])");
    String Dobselect = "05/04/1994";
    String expectedDay = "13";
    String expectedMonthYear = "August, 2025";

    public void DobSelect() throws InterruptedException {

        System.out.println("Selecting Date of Birth: " + Dobselect);
        // Open the date picker
        driver.findElement(DoBCalenderClick).click();
        while (true) {
            String currentMonthYear = driver.findElement(MonthandyearText).getText();
            System.out.println("Current date is : " + currentMonthYear);

            if (currentMonthYear.equals(expectedMonthYear)) {
                break;
            }

            // Compare month-year to decide direction
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM, yyyy", Locale.ENGLISH);
            YearMonth current = YearMonth.parse(currentMonthYear, formatter);
            YearMonth target = YearMonth.parse(expectedMonthYear, formatter);

            if (target.isAfter(current)) {
                // Click next arrow for future date
                driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
            } else {
                // Click previous arrow for past date
                driver.findElement(By.cssSelector(".ui-datepicker-prev")).click();
            }
        }
        // Select the day (excluding days from other months)
        driver.findElement(By.xpath("//div[contains(@title, ' August " + expectedDay + ", 2025')]")).click();

    }


    String admissioncategorytext = "General/OC";

    public AL_Academic_AP_NewStudent admissionCategorySelect() throws InterruptedException {

        System.out.println("Selecting Admission category: " + admissioncategorytext);
        dropdownByEnter(admissioncategoryDropdown, dropdownInput, admissioncategorytext);
        return this;
    }

    public AL_Academic_AP_NewStudent DateOFEntrySelect() {
        String DateofEntryselect = "12/08/2025";
        System.out.println("Selecting Date of Entry: " + DateofEntryselect);
        driver.findElement(DateOFEntryField).sendKeys(Keys.TAB); //DateOFEntryField
        return this;
    }

    public AL_Academic_AP_NewStudent paymentTypeSelect() throws InterruptedException {
        String paymentTypetext = "50% OBC";
        System.out.println("Selecting Payment type: " + paymentTypetext);
        dropdownByEnter(paymentTypeField, dropdownInput, paymentTypetext);
        return this;
    }

    public AL_Academic_AP_NewStudent receptTypeSelect() throws InterruptedException {
        String receiptTypeFieldtext = "Admission Fee";
        System.out.println("Selecting Payment type: " + receiptTypeFieldtext);
        dropdownByEnter(paymentTypeField, dropdownInput, receiptTypeFieldtext);
        return this;
    }


    By sessionfield = By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container");
    //select2-ctl00_ContentPlaceHolder1_ddlSessionSingle-container
    By Sessiontitle = By.id("ctl00_ContentPlaceHolder1_lblDYddlSession_Tab");

    public void sessiontitle() {
        //clickBy(Sessiontitle);
        WebElement element = driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'] //*[normalize-space()='Please Select'])[10]"));
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", element);
        //clickBy(sessionfield);
    }

    public AL_Academic_AP_NewStudent sessionSelection(String sessionTypeFieldtext) throws InterruptedException {
        //String sessionTypeFieldtext = "2023-2024";
        loader();

        System.out.println("Selecting Admission category: " + sessionTypeFieldtext);
        waitForElementVisible(sessionfield);
        dropdownByEnter(sessionfield, dropdownInput, sessionTypeFieldtext);
        Thread.sleep(1000);
        scrollIntoElementBy(submitStundentBtn);
        return this;
    }


    By submitStundentBtn = By.id("ctl00_ContentPlaceHolder1_btnSave");

    public AL_Academic_AP_NewStudent SubmitStudent() {
        System.out.println("Submitting the student ");
        loader();
        waitUntilElementIsClickableBy(submitStundentBtn);
        clickBy(submitStundentBtn);
        acceptAlert();
        return this;
    }


    //================================Demand============================================

    By singleStudentDemandClick = By.xpath("//a[@href='#tab_2']");
    By searchCriteriaClick = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlSearch-container']");
    By searchname = By.id("ctl00_ContentPlaceHolder1_txtSearch");
    By searchbutton = By.id("ctl00_ContentPlaceHolder1_btnSearch");
    By clickOnSearchStudent = By.xpath("//a[@id='ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId']");
    By demandVerifyText = By.xpath("//*[contains(text(),'CREATED')]");
    By createDemandbutton = By.id("ctl00_ContentPlaceHolder1_btnCreateDemand");
    By semesterselectDemandDropdown = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlForSemesterN-container']");
    By receptTypeSelectdemandDropDown = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlRecType-container']");

    public AL_Academic_AP_NewStudent singleStudentDemand() {
        System.out.println("Click on the single student demand option");
        waitUntilElementIsClickableBy(singleStudentDemandClick);
        clickBy(singleStudentDemandClick);
        return this;
    }

    public void searchCreatria() throws InterruptedException {
        System.out.println("Search By name ");
        waitUntilElementIsClickableBy(searchCriteriaClick);
        dropdownByEnter(searchCriteriaClick, dropdownInput, "NAME");
        Thread.sleep(1000);
    }

    public void searchStringName(String name) {
        System.out.println("Enter Student name: " + name);
        loader();
        waitUntilElementIsClickableBy(searchname);
        sendKeysBy(searchname, name);
        driver.findElement(searchname).sendKeys(Keys.TAB);
    }

    public AL_Academic_AP_NewStudent searchBtn() {
        System.out.println("Click on the search button");
        waitUntilElementIsClickableBy(searchname);
        clickBy(searchbutton);
        //loader();
        return this;
    }

    public AL_Academic_AP_NewStudent clickonSearchStudent() {
        System.out.println("Click on the searched Student Name");
        waitUntilElementIsClickableBy(clickOnSearchStudent);
        clickBy(clickOnSearchStudent);
        return this;
    }

    public void verifyDemandStatus() {
        System.out.println("Verify the demand status");
        String demandStatus = driver.findElement(demandVerifyText).getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(demandVerifyText));
        Assert.assertEquals(demandStatus, "CREATED");
    }

    public void CreateDemandbutton() {
        System.out.println("Click on the create demand button");

        waitUntilElementIsClickableBy(createDemandbutton);
        scrollIntoElementBy(createDemandbutton);
        clickBy(createDemandbutton);
        acceptAlert();
    }

    public void sessionSelectiondemand(String sessionTypeFieldtext) throws InterruptedException {

        System.out.println("Selecting Admission category: " + sessionTypeFieldtext);
        By element = By.xpath("(//span[@class='select2-selection select2-selection--single'] //*[normalize-space()='Please Select'])[10]");
        clickBy(element);
        dropdownByEnter(element, dropdownInput, sessionTypeFieldtext);
        clickBy(semesterselectDemandDropdown);

    }


    public void semesterselectDemand() throws InterruptedException {

        Thread.sleep(1000);

        System.out.println("Selecting Admission category: " + semestertxt);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(semesterselectDemandDropdown));
        clickBy(semesterselectDemandDropdown);
        dropdownByEnter(semesterselectDemandDropdown, dropdownInput, semestertxt);
       // clickBy(receptTypeSelectdemandDropDown);
        WebElement element1 = driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])[15]"));
        waitUntilElementIsClickable(element1);
        Thread.sleep(1000);

    }

    String receiptSelectText = "Admission Fee";

    public void receptTypeSelectdemand() throws InterruptedException {
        System.out.println("Selecting Recept Type: receiptSelectText ");
        WebElement element = driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])[15]"));
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.moveToElement(element).click().perform();
        action.moveToElement(element).click().perform();
        Thread.sleep(1000);
        System.out.println("Selecting Admission category: " + receiptSelectText);

        Thread.sleep(1000);
        dropdownByEnter(receptTypeSelectdemandDropDown, dropdownInput, receiptSelectText);
    }


    //---------------------------------old-----------------------------------------


    /**
     * Select admission through with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent selectSession() {
        String sessionSelect = "2023-2024";
        System.out.println("Selecting session: " + sessionSelect);
        Select sessionSelectSelect = new Select(session);
        sessionSelectSelect.selectByVisibleText(sessionSelect);
        return this;
    }

    /**
     * Select admission type with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent selectSchool() {
        String schoolName = "Crescent School of Architecture";
        System.out.println("Selecting school: " + schoolName);
        Select schoolSelect = new Select(school);
        schoolSelect.selectByVisibleText(schoolName);
        return this;
    }

    /**
     * Select admission year with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent selectDegree() {
        String degreeName = "Bachelor of Architecture";
        System.out.println("Selecting degree: " + degreeName);
        Select degreeSelect = new Select(degree);
        degreeSelect.selectByVisibleText(degreeName);
        return this;
    }


    public AL_Academic_AP_NewStudent selectAdmThrough() {
        String admThroughName = "CAP 1";
        System.out.println("Selecting Admission Through: " + admThroughName);
        Select admthroughSelect = new Select(admthrough);
        admthroughSelect.selectByVisibleText(admThroughName);
        return this;
    }

    public AL_Academic_AP_NewStudent selectAdmType() {
        String admTypeName = "REGULAR";
        System.out.println("Selecting Admission Type: " + admTypeName);
        Select admtypeSelect = new Select(admType);
        admtypeSelect.selectByVisibleText(admTypeName);
        return this;
    }

    public AL_Academic_AP_NewStudent selectYear() {
        String yearName = "Second Year";
        System.out.println("Selecting Year: " + yearName);
        Select yearSelect = new Select(year);
        yearSelect.selectByVisibleText(yearName);
        return this;
    }

    /**
     * Select semester with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent selectSemester() {
        String semesterName = "III";
        System.out.println("Selecting semester: " + semesterName);
        Select semesterSelect = new Select(semester);
        semesterSelect.selectByVisibleText(semesterName);
        return this;
    }

    /**
     * Select batch with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent selectBatch() {
        String batch = "2024-25";
        System.out.println("Selecting batch: " + batch);
        Select batchSelect = new Select(ddlBatch);
        batchSelect.selectByVisibleText(batch);
        return this;
    }

    /**
     * Enter date of birth with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent enterDateOfBirth() {
        String dateOfBirth = "18/03/2000";
        System.out.println("Entering date of birth: " + dateOfBirth);
        txtDateOfBirth.clear();
        txtDateOfBirth.sendKeys(dateOfBirth);
        return this;
    }

    /**
     * Select category with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent selectCategory() {
        String category = "OBC/BC";
        System.out.println("Selecting category: " + category);
        Select categorySelect = new Select(ddlCategory);
        categorySelect.selectByVisibleText(category);
        return this;
    }

    /**
     * Enter date of reporting with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent enterDateOfReporting() {
        String dateOfReporting = "24/08/2024";
        System.out.println("Entering date of reporting: " + dateOfReporting);
        txtDateOfReporting.clear();
        txtDateOfReporting.sendKeys(dateOfReporting);
        return this;
    }

    /**
     * Select payment type with hardcoded value
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent selectPaymentType() {
        String paymentType = "50% OBC";
        System.out.println("Selecting payment type: " + paymentType);
        Select paymentTypeSelect = new Select(ddlPaymentType);
        paymentTypeSelect.selectByVisibleText(paymentType);
        return this;
    }

    /**
     * Scroll to the bottom of the page
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent scrollToBottom() {
        System.out.println("Scrolling to the bottom of the page");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    /**
     * Click submit button
     *
     * @return this class instance for method chaining
     */
    public AL_Academic_AP_NewStudent clickSubmit() {
        System.out.println("Clicking submit button");
        btnSubmit.sendKeys(Keys.ENTER);
        return this;
    }

    private static final String FILE_NAME = "AL_Academic_AP_NewStudent_StudentData.xlsx";

    public static void writeStudentDataToExcel(
            String firstName, String lastName, String email, String mobileNo, String studentId,
            String gender, String campus, String studyLevel, String school, String program,
            String semester, String modality, String intake) throws IOException {

        File file = new File(FILE_NAME);
        Workbook workbook;
        Sheet sheet;

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("StudentData");
            Row header = sheet.createRow(0);
            String[] headers = {"First Name", "Last Name", "Email", "Mobile No", "Student ID", "Gender",
                    "Campus", "Study Level", "School", "Program", "Semester", "Modality", "Intake"};
            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
            }
        }

        int rowCount = sheet.getLastRowNum();
        Row row = sheet.createRow(rowCount + 1);
        row.createCell(0).setCellValue(firstName);
        row.createCell(1).setCellValue(lastName);
        row.createCell(2).setCellValue(email);
        row.createCell(3).setCellValue(mobileNo);
        row.createCell(4).setCellValue(studentId);
        row.createCell(5).setCellValue(gender);
        row.createCell(6).setCellValue(campus);
        row.createCell(7).setCellValue(studyLevel);
        row.createCell(8).setCellValue(school);
        row.createCell(9).setCellValue(program);
        row.createCell(10).setCellValue(semester);
        row.createCell(11).setCellValue(modality);
        row.createCell(12).setCellValue(intake);

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}
