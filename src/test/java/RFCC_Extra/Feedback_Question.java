package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Feedback_Question extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void FeedbackQuestion() throws Exception {

		RF_AdminLoginPage.loginPage();
		
		WebElement link_academic = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(link_academic).perform();
		System.out.println("Click on Academic");
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		WebElement link_feedback = driver.findElement(By.linkText("FeedBack"));
		action.moveToElement(link_feedback);
		action.click().build().perform();
		System.out.println("Click on Feedback option");
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Feedback Question"));
		System.out.println("Click on Feedback Question from sub menu");
		action.moveToElement(subMenu);
		action.click().build().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCT-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Practical course Feedback", Keys.ENTER);
		System.out.println("Select Feedback Type - Practical course Feedback");
		Thread.sleep(2000);
		
		WebElement txt_que = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtQuestion"));
		txt_que.sendKeys("Which activities in the classroom do you enjoy the most?  ");
		System.out.println("Enter Feedback Question");
		Thread.sleep(2000);
		
		WebElement chk_box = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAnsoption-container"));
//		if(!chk_box.isSelected()==true)
//		{
//			chk_box.sendKeys(Keys.ENTER);;
//		}
//		
		chk_box.click();
		Thread.sleep(2000);
		WebElement txt_type = driver.findElement(By.className("select2-search__field"));
		txt_type.sendKeys("Text Box", Keys.ENTER);
		System.out.println("Select Answer option type - Text Box");
		Thread.sleep(2000);
		/*
		 * String randomValue = generateRandomValue(); WebElement field =
		 * driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtseqno"));
		 * field.sendKeys(randomValue);
		 */
	
		WebElement seq_no = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtseqno"));
		seq_no.sendKeys("56", Keys.ENTER);
		System.out.println("Enter Sequence number - 56");
		Thread.sleep(2000);
		
		WebElement chk_theory = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCondition"));
		Select theory = new Select(chk_theory);
		theory.selectByVisibleText("Theory");
		System.out.println("\"Select Course Type - Theory");
		Thread.sleep(2000);
		
		WebElement chk_status = driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkActiveStatus"));
		if(!chk_status.isSelected()==true)
		{
			chk_status.click();
			System.out.println("Check on Active Status Checkbox");
		}
		Thread.sleep(2000);
		
		WebElement chk_man = driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkMandatory"));
		if(!chk_man.isSelected() == true )
		{
		    chk_man.click();
		    System.out.println("Check on Mandatory Checkbox");
		}
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		js.executeScript("arguments[0].scrollIntoView();",btn_submit);
		Thread.sleep(2000);
		btn_submit.click();
		Thread.sleep(2000);
		
		Alert alert =  driver.switchTo().alert();
		Thread.sleep(1000);
		String Expected_Msg = "Feedback question added successfully";
		String Actual_Msg =alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		if(Actual_Msg.equals(Expected_Msg))
		{
			Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
			Thread.sleep(1000);
			alert.accept();
		}
		else
		{
			System.out.println("Actual and Expected Message mismatched");
			alert.accept();
		}
		


	}

}
