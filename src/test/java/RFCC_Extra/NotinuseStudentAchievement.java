package RFCC_Extra; 

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;

public class NotinuseStudentAchievement extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "Starting : " + m.getName() + "*******" +  "\n");
	}

	@Test
	public void Student_Academic_Achievement() throws Exception {
		test = reports.createTest("Student_Academic_Achievement");
		Thread.sleep(2000);

		RF_StudentLoginPage.loginPage();
		
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(4000);
		//Click on main Academic menu
		WebElement accdemic = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(accdemic).perform();

		Thread.sleep(2000);
		// Click on student achievememt Submenu
		WebElement Academic_achiveSubMenu = driver.findElement(By.linkText("Student Achievement"));
		System.out.println("Student Achievement");
		action.moveToElement(Academic_achiveSubMenu);
		action.click().build().perform();
		
		Thread.sleep(2000); 
		//Select Club
		WebElement slctClub = driver.findElement(By.className("btn-group"));
		//slctClub.clear();
		slctClub.click();
		System.out.println("Click on Select club dropdown field");
		//System.out.println("Select Club -> 1.Crescent  Innovation & Startup Club, 2. Crescent Technocrats Club, 3.Crescent Model United Nations");
		
		Thread.sleep(2000); 
		List<WebElement> checkboxes = driver.findElements(By.id("ctl00_ContentPlaceHolder1_ddlclub"));
		
		 for (int i = 0; i <= 3; i++) {
             WebElement checkbox = checkboxes.get(i); 
             if (!checkbox.isSelected()) {
                 checkbox.click(); 
             }
         }
		
		
		
		/*		
		Thread.sleep(2000);
		Select club_list = new Select(slctClub);
		List<WebElement> t = club_list.getOptions();
		int itemsize = t.size();
		for (WebElement i : t) {
			System.out.println("List of club Items:" + i.getText());
		}
		System.out.println("Number of club Items:" + itemsize);
		
		 Collections.shuffle(t);
		 
		 List<WebElement> selectedCheckboxes = t.subList(0, 3);
		
		 for (WebElement checkbox : selectedCheckboxes) {
             if (!checkbox.isSelected()) {
                 checkbox.click();
             }
         }*/
		
		/*		
		Boolean b = club_list.isMultiple();
		System.out.println("Boolean value for dropdown:" + b);
		club_list.selectByValue("4");
		club_list.selectByValue("5");
		club_list.selectByValue("6");*/

        Thread.sleep(2000); 
		//Click Submit
        WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
        btn_submit.click();
        System.out.println("Click on submit");
		
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
		
		String Act_Msg = alert.getText();
		String Exp_Msg = "";
		
		 if (Exp_Msg.equals(Act_Msg)) {
             System.out.println("Assertion passed" + alert.getText());
             alert.accept();
         } else {
             System.out.println("Assertion failed: Expected '" + Exp_Msg + "' but got '" + Act_Msg + "'.");
             // Handle the alert (if any)
             try {
                 System.out.println("Alert found: " + alert.getText());
                 //Thread.sleep(2000);
                 alert.accept(); // Accept the alert
                 System.out.println("Alert accepted.");
             } catch (NoAlertPresentException e) {
                 System.out.println("No alert present.");
             }
         }

	
	}

}
