package Examination;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Examination_EM_SubExamCreation extends BaseClass
{
    @FindBy(linkText = "Sub Exam Creation") private WebElement subExamCreation;
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvGradeType_ctrl0_btnEdit") private WebElement editButton;
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtMaxMark") private WebElement maxMarks;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement saveButton;
    
    public AL_Examination_EM_SubExamCreation(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    public AL_Examination_EM_SubExamCreation Click_SubExamCreation() {
        System.out.println("Click on Sub Exam Creation");
        Actions action = new Actions(driver);
        action.moveToElement(subExamCreation).click().build().perform();
        return this;
    }
    
    public AL_Examination_EM_SubExamCreation Click_EditButton() {
        System.out.println("Click on Edit Button");
        waitForVisibility(editButton);
        click(editButton);
        return this;
    }
    
    public AL_Examination_EM_SubExamCreation Set_MaxMarks() {
        System.out.println("Set Max Marks => 50");
        waitForVisibility(maxMarks);
        clearText(maxMarks);
        sendKeys(maxMarks, "50");
        return this;
    }
    
    public AL_Examination_EM_SubExamCreation Click_SaveButton() throws InterruptedException {
        System.out.println("Click on Save Button");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", saveButton);
        
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", saveButton);
        
        return this;
    }
}
