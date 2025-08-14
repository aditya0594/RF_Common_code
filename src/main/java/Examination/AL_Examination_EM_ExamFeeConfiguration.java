package Examination;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Examination_EM_ExamFeeConfiguration extends BaseClass
{
	@FindBy(linkText = "Exam Fee Configuration") private WebElement examfeeconfig;
    @FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]") private WebElement searchbar;
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvLoad_ctrl16_btnEdit") private WebElement editbtn;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement updatebtn;

    public AL_Examination_EM_ExamFeeConfiguration(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
    public AL_Examination_EM_ExamFeeConfiguration Click_ExamFeeConfiguration() throws InterruptedException {
        System.out.println("Click on Examination Fee Configuration");
        Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",examfeeconfig);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", examfeeconfig);

        return this;
    }
    
    public AL_Examination_EM_ExamFeeConfiguration Search_EnterSession() throws InterruptedException {
       System.out.println("Search Session => May 2022");
		js.executeScript("arguments[0].scrollIntoView();",searchbar);

       sendKeys(searchbar, "May 2022");
       threadWait1();
       click(editbtn);
       return this;
    }
    
    public AL_Examination_EM_ExamFeeConfiguration Click_UpdateBtn() throws InterruptedException {
        System.out.println("Click on Update Btn");
        Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",updatebtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", updatebtn);

        return this;
    }
}
