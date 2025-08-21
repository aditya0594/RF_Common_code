package FeedBackTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_AD_FB_Question extends BaseClass {

    public AL_AD_FB_Question(WebDriver rdriver) {
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


    public AL_AD_FB_Question feedbackSelect() throws InterruptedException {
        System.out.println("Feedback selected");
        Thread.sleep(1000);
        feedback.click();
        return this;
    }

    public AL_AD_FB_Question FeedbackMasterSelect() {
        System.out.println("Feedback type master selected");
        feedbackMaster.click();
        return this;
    }




    By feedBacktypeedit = By.id("ctl00_ContentPlaceHolder1_txtFeedbackName");
    public void feedBackTypeSelectedit(String feedBackTypetext) throws InterruptedException {
        System.out.println("click on feedBack Type");
        Thread.sleep(2000);
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
    By courseOptionTheory = By.xpath("//label[@class='checkbox']//input[@value='1']");
    By clickout1 = By.xpath("//body//form[@id='aspnetForm']//div[@class='row']//div[@class='row']//div[4]");
    public void CourseType() throws InterruptedException {
        System.out.println("click on user type : Student ");
        Actions action = new Actions(driver);
        //action.click(driver.findElement(userType)).perform();
        // action.click(driver.findElement(userType)).perform();
        Thread.sleep(2000);
        clickBy(courseType);
        clickBy(courseOptionTheory);
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

    @FindBy(linkText = "Feedback Question")
    private WebElement feedbackQuestion;




    //=====================quetions========

    public AL_AD_FB_Question feedBackQuestion() {
        System.out.println("Feedback type master selected");
        feedbackQuestion.click();
        return this;
    }
    By feedbackQuestiondrop = By.id("select2-ctl00_ContentPlaceHolder1_ddlCT-container");
    public void setFeedbackQuestionTypeSelect(String feedbackQuestionTypetext) throws InterruptedException {
        System.out.println("Select the Feed Question type : " + feedbackQuestionTypetext);
        Thread.sleep(1000);
        clickBy(feedbackQuestiondrop);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(feedbackQuestionTypetext);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }


    By feedbackQution = By.id("ctl00_ContentPlaceHolder1_txtQuestion");
    public AL_AD_FB_Question feedBackQuestionFieldAdd(String Question) {
        System.out.println("Enter the question ");
        sendKeysBy(feedbackQution, Question);
        return this;
    }

    By ansOptionDrop = By.id("select2-ctl00_ContentPlaceHolder1_ddlAnsoption-container");
    public void setAnsOptionType(String ansOptionType) throws InterruptedException {
        System.out.println("Select the ans option type: " + ansOptionType);
        Thread.sleep(1000);
        clickBy(ansOptionDrop);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(ansOptionType);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    By SequenceNoField = By.id("ctl00_ContentPlaceHolder1_txtseqno");
    public AL_AD_FB_Question sequenceField(String sequence) {
        System.out.println("Enter the question ");
        sendKeysBy(SequenceNoField, sequence);
        return this;
    }

    By headQuesetiondrop = By.id("select2-ctl00_ContentPlaceHolder1_ddlHeaderQue-container");
    public void headQuestion(String headertext) throws InterruptedException {
        System.out.println("Select the ans option type: " + headertext);
        Thread.sleep(1000);
        clickBy(headQuesetiondrop);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(headertext);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    By answerField1 = By.id("ctl00_ContentPlaceHolder1_gvAnswers_ctl02_txtAnsOption");
    By valueField1 = By.id("ctl00_ContentPlaceHolder1_gvAnswers_ctl02_txtValue");

    By answerField2 = By.id("ctl00_ContentPlaceHolder1_gvAnswers_ctl03_txtAnsOption");
    By valueField2 = By.id("ctl00_ContentPlaceHolder1_gvAnswers_ctl03_txtValue");

    By AddNewOption = By.id("ctl00_ContentPlaceHolder1_gvAnswers_ctl03_btnAdd");
    public AL_AD_FB_Question answerOpt(String Answers1, String Value1 , String Answers2, String Value2) {
        System.out.println("Enter the answer option :  ");
        sendKeysBy(answerField1, Answers1);
        waitUntilElementIsClickableBy(valueField1);
        sendKeysBy(valueField1, Value1);
        clickBy(AddNewOption);
        sendKeysBy(answerField2, Answers2);
        waitUntilElementIsClickableBy(valueField2);
        sendKeysBy(valueField2, Value2);
        return this;
    }

    By quesubmitBtn = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']");
    public void submitbtn()   {
        System.out.println("click on submit button ");
        scrollIntoElementBy(quesubmitBtn);
        clickBy(quesubmitBtn);
    }














}
