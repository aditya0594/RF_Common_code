package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_EM_ExaminationRules extends BaseClass
{
    @FindBy(linkText = "Examination Rules") private WebElement examinationRules;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement collegeDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement sessionDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlsubjecttype") private WebElement subjectTypeDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semesterDropdown;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showButton;
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvCourseExamRule_ctrl0_chkAccept") private WebElement acceptCheckbox;
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvCourseExamRule_ctrl0_txtCat1") private WebElement cat1Marks;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitButton;
    
    public AL_Examination_EM_ExaminationRules(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    public AL_Examination_EM_ExaminationRules Click_ExaminationRules() {
        System.out.println("Click on Examination Rules");
        Actions action = new Actions(driver);
        action.moveToElement(examinationRules).click().build().perform();
        return this;
    }
    
    public AL_Examination_EM_ExaminationRules Select_College() {
        System.out.println("Select College => SLS - B.Sc.-School of Life Sciences-Biotechnology-2021-22 (New Scheme)");
        waitForVisibility(collegeDropdown);
        Select select = new Select(collegeDropdown);
        select.selectByVisibleText("SLS - B.Sc.-School of Life Sciences-Biotechnology-2021-22 (New Scheme)");
        return this;
    }
    
    public AL_Examination_EM_ExaminationRules Select_Session() {
        System.out.println("Select Session => May 2022");
        waitForVisibility(sessionDropdown);
        Select select = new Select(sessionDropdown);
        select.selectByVisibleText("May 2022");
        return this;
    }
    
    public AL_Examination_EM_ExaminationRules Select_SubjectType() {
        System.out.println("Select Subject Type => Theory with Tutorial");
        waitForVisibility(subjectTypeDropdown);
        Select select = new Select(subjectTypeDropdown);
        select.selectByVisibleText("Theory with Tutorial");
        return this;
    }
    
    public AL_Examination_EM_ExaminationRules Select_Semester() {
        System.out.println("Select Semester => I");
        waitForVisibility(semesterDropdown);
        Select select = new Select(semesterDropdown);
        select.selectByVisibleText("I");
        return this;
    }
    
    public AL_Examination_EM_ExaminationRules Click_ShowButton() {
        System.out.println("Click on Show Button");
        waitForVisibility(showButton);
        click(showButton);
        return this;
    }
    
    public AL_Examination_EM_ExaminationRules Click_AcceptCheckbox() {
        System.out.println("Click on Accept Checkbox");
        waitForVisibility(acceptCheckbox);
        click(acceptCheckbox);
        return this;
    }
    
    public AL_Examination_EM_ExaminationRules Set_CAT1Marks() {
        System.out.println("Set CAT1 Marks => 50");
        waitForVisibility(cat1Marks);
        clearText(cat1Marks);
        sendKeys(cat1Marks, "50");
        return this;
    }
    
    public AL_Examination_EM_ExaminationRules Click_SubmitButton() throws InterruptedException {
        System.out.println("Click on Submit Button");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", submitButton);
        
        threadWait1();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblmessageShow")).getText();
        
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Button1")).click();
        return this;
    }
}
