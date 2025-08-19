package FeedBackTest;

import com.qa.pages.HomePageAdmin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_FeedBack_Type_Master_Add_edit extends BaseClass {

    public AL_FeedBack_Type_Master_Add_edit(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }


    @FindBy(linkText = "Admission Process")
    private WebElement AdmissionProcess;

    @FindBy(linkText = "FeedBack")
    private WebElement feedback;

    @FindBy(linkText = "Feedback Type Master")
    private WebElement feedbackMaster;


    @FindBy(linkText = "Academic") private WebElement academic;


    public AL_FeedBack_Type_Master_Add_edit feedbackSelect() throws InterruptedException {
        System.out.println("Feedback selected");
        Thread.sleep(1000);
        feedback.click();
        return this;
    }

    public AL_FeedBack_Type_Master_Add_edit FeedbackMasterSelect() {
        System.out.println("Feedback type master selected");
        feedbackMaster.click();
        return this;
    }

    By feedBacktype = By.id("ctl00_ContentPlaceHolder1_txtFeedbackName");
    public void feedBackTypeSelect(String feedBackTypetext) {
        System.out.println("click on feedBack Type");
        sendKeysBy(feedBacktype, feedBackTypetext);
    }

    By feedBacktypeedit = By.id("ctl00_ContentPlaceHolder1_txtFeedbackName");
    public void feedBackTypeSelectedit(String feedBackTypetext) {
        System.out.println("click on feedBack Type");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.CONTROL+"a").build().perform();
        clearTextBy(feedBacktypeedit);
        sendKeysBy(feedBacktypeedit, feedBackTypetext);
    }



    By feedBackMode = By.id("select2-ctl00_ContentPlaceHolder1_ddlfeedbackmode-container");
    public void feedBackModeSelect(String feedBackModetext) throws InterruptedException {
        System.out.println("click on feedBack Mode ");
        Thread.sleep(1000);
        clickBy(feedBackMode);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(feedBackModetext);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }



    By userType = By.xpath("//span[@class='multiselect-selected-text']");
    By studentOption = By.xpath("//input[@value='2']");
    By clickout = By.xpath("//body//form[@id='aspnetForm']//div[@class='row']//div[@class='row']//div[4]");
    public void userTypeSelect() throws InterruptedException {
        System.out.println("click on user type : Student ");
        Actions action = new Actions(driver);
        //action.click(driver.findElement(userType)).perform();
       // action.click(driver.findElement(userType)).perform();
        clickBy(userType);
        clickBy(studentOption);
        clickBy(clickout);

        Thread.sleep(1000);
    }


    By courseType = By.xpath("//span[@class='multiselect-selected-text']");
    By courseOption = By.xpath("//label[@class='checkbox']//input[@value='1']");
    By clickout1 = By.xpath("//body//form[@id='aspnetForm']//div[@class='row']//div[@class='row']//div[4]");
    public void CourseType() throws InterruptedException {
        System.out.println("click on user type : Student ");
        Actions action = new Actions(driver);
        //action.click(driver.findElement(userType)).perform();
        // action.click(driver.findElement(userType)).perform();
        clickBy(courseType);
        clickBy(courseOption);
        clickBy(clickout1);

        Thread.sleep(1000);
    }


    By addNoteClick = By.xpath("//a[@id='ctl00_ContentPlaceHolder1_btnNote']");
    By addbtn = By.xpath("//button[contains(text(),'Add')]");
    public void addNote(String note) throws InterruptedException {
        System.out.println("Click on Add Note to add note ");
        clickBy(addNoteClick);
        // Switch to the iframe by ID
        driver.switchTo().frame("ctl00_ContentPlaceHolder1_ftbDesc_designEditor");
        // Send keys to the body inside the iframe
        WebElement body = driver.findElement(By.tagName("body"));
        body.clear();
        body.sendKeys(note);
        // Switch back to the main page
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        clickBy(addbtn);

    }
    By submitBtn = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSave']");
    public void submitbtn()   {
        System.out.println("click on submit button ");
       clickBy(submitBtn);
    }



    //====================Edit =====================

    By searchBox = By.xpath("//input[@class='form-control form-control-sm']");
    By editbutton = By.xpath("//input[contains(@id,'ctl00_ContentPlaceHolder1_lvFeedback_ct')]");
    public void searchBox(String feedBackTypetext) throws InterruptedException {
        System.out.println("click on search box ");
       sendKeysBy(searchBox, feedBackTypetext);
       Thread.sleep(2000);
    }

    public void editBtn() {
        System.out.println("click on search box ");
        clickBy(editbutton);
    }









}
