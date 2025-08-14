package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Examination_EM_ExamConfiguration extends BaseClass
{
		@FindBy(linkText = "Exam Configuration") private WebElement examconfig;
	    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement savebtn;
	   
	    public AL_Examination_EM_ExamConfiguration(WebDriver rdriver) {
	        driver = rdriver;
	        PageFactory.initElements(rdriver, this);
	    }
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    public AL_Examination_EM_ExamConfiguration Click_ExamConfiguration() throws InterruptedException {
	        System.out.println("Click on Examination Configuration");
	        Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();",examconfig);

			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", examconfig);

	        return this;
	    }
	    
	    public AL_Examination_EM_ExamConfiguration Click_SaveBtn() throws InterruptedException {
	        System.out.println("Click on Save Btn");
	        Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();",savebtn);

			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", savebtn);

	        return this;
	    }
}
