package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;


public class FeesRelatedTest extends BaseClass{
	
		ExtentReports reports;
		ExtentTest test;
		
		@BeforeTest
		public void configureReport() {
			reports=Reports.createReport();
		}
		
		@BeforeMethod
		public void launchBrowser(Method m) throws Exception {
			driver=Browser.openBrowser("url_RF_LoginAdmin");
			System.out.println("\n" + "******Starting Test : "+ m.getName() + "*****" + "\n");
		}
		
		@Test
		public void feesRelatedTest() throws Exception {
			test=reports.createTest("feesRelatedTest");
	
			RF_AdminLoginPage.loginPage();
		    Thread.sleep(2000);
		    driver.get("https://crescentuat.mastersofterp.in/Academic/iitmsYto5Ax3XQNdhUAsoYbVpUnVxzmaOhCiyp7mdG9JAEs5pRvmg9fdS1IPWiFF7Ivhs?enc=fM43BhrdLEc+Q3PHRzoW7H6D08Gg0KbnfcJprY4h46o=");
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearchPanel")).click();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearchPanel")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearchPanel")).sendKeys("210071601003");
		    Thread.sleep(2000);
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearchPanel")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentPanel_ctrl0_lnkIdPanel")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTotalAmount")).click();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTotalAmount")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTotalAmount")).sendKeys("1");
		    Thread.sleep(2000);
		    WebElement totalCash=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTotalCashAmt"));
		    try {
		        totalCash.click();
		     } catch (Exception e) {
		        JavascriptExecutor executor = (JavascriptExecutor) driver;
		        executor.executeScript("arguments[0].click();", totalCash);
		     }
		    Thread.sleep(2000);
		    WebElement submit=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		    try {
		        submit.click();
		     } catch (Exception e) {
		        JavascriptExecutor executor = (JavascriptExecutor) driver;
		        executor.executeScript("arguments[0].click();", submit);
		     }
		    Thread.sleep(3000);
		    try {
			    driver.get("https://crescentuat.mastersofterp.in/Academic/iitmsYto5Ax3XQNdhUAsoYbVpUnVxzmaOhCiyp7mdG9JAEs5pRvmg9fdS1IPWiFF7Ivhs?pageno=63");
		    } catch (UnhandledAlertException f) {
		        try {
		            Alert alert = driver.switchTo().alert();
		            String alertText = alert.getText();
		            System.out.println("Alert data : " + alertText);
		            alert.accept();
//		            Thread.sleep(1000);
//		            alert.accept();
		        } catch (NoAlertPresentException e) {
		            e.printStackTrace();
		        }
		    }
		    Thread.sleep(3000);
		    //driver.get("https://crescentuat.mastersofterp.in/Reports/iitmsv5XMCpPnVOa+AxqycUQ/JHi5sj8OaFqtsmjW8lRfm2Jj9pMkVK7iLNMmKoHy7gNC?enc=nO1yUl57bAfpYLjk6w0qrzhMOcoNRFgEFfBeBl7mCnaiaM+AzXfqt2cIYCNyWo6PC19SJLTjx6LbA48rPFZcDSWcg8S43KNQH1lG9Xnp9gvF3V37RJqnQ0CDU+ap/77cFuvodBcEWqfhuS5FhUwzRrtItSzWdX2TaIOEGm6S/c8dfW8gFjnWyDaCVC12hXUeDmxer21Hvgm2S+CosmPvlCBjyO2eL7LR8fMRJ70qjtnA9Oxj8vvKVmpHVN0F3EY5pglHyTBguKxrzcjOezCxqQCAXor36qtfeVRTfAFpzuhkH8UcLQZXUMv3qjgA/ZxT7clkQNHtTuKKJygmVELXQ4kxcbIedfNYzLgv2rP/P46tILb7/jUsWAfwuD33mh2OHu+lMrWNa5jwnFFCiWrdaXk56Zz/RGs4Tlq54a3ZiuybN5aIgsEVSqdDxqMFEQAIoSAyJDeP7OSJI9EcX4oKdcDx5lgXeUacWfiXbJPAnfzn5I7uQh40D7g+LQn3e+Cob68eIdwpCZlcBHogSzvoTyxftQgy/RDA84PMZb36U/c0usltMMRKcO4U+CeOoe9Y9IdAaSD2FkaRO6d/MEB34Q==");
		    Thread.sleep(2000);
		    driver.close();
		    
	  }
		
		@AfterMethod
		public void getTestResult(ITestResult result) throws IOException {
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(Status.PASS, result.getName());
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL, result.getName());
			}
			else 
			{
				test.log(Status.SKIP, result.getName());
			}
		}
		
		@AfterTest
		public void publishResult() {
			reports.flush();
		}

	}



