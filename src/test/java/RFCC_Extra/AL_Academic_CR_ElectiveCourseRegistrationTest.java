package RFCC_Extra;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import RFCCExtra.AL_Establishment_Trans_DirectLeaveApprovalReject;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_CR_ElectiveCourseRegistrationTest extends BaseClass {
	// private WebDriver driver;
	// private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;

	ExtentReports reports;
	ExtentTest test;
//	AL_Establishment_Trans_DirectLeaveApprovalReject ApproveLeaveReject;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}

	@Test
	public void aL_Academic_CR_ElectiveCourseRegistrationTest() throws Exception {

		test = reports.createTest("aL_Academic_CR_ElectiveCourseRegistrationTest");

		// ApproveLeaveReject = new
		// AL_Establishment_Trans_DirectLeaveApprovalReject(driver);

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();

		// System.out.println("ESTBALISHMENT > Transactions > Leave Approwal > Select >
		// RejectLeave > Submit ");

		System.out.println("ACADEMIC->Coordinator related->Elective Course Registration");

		// Click on Academic from navigation bar
		WebElement ele = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		System.out.println("Click on Academic from navigation bar");
		Thread.sleep(3000);

		// Click on Coordinator related option
		driver.findElement(By.linkText("Coordinator Related")).click();
		System.out.println("Click on Coordinator related option");
		Thread.sleep(3000);

		// Click on Faculty Advisor Allotment from sub menu
		WebElement sub_menu = driver.findElement(By.linkText("Elective Course Registration"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", sub_menu);
		sub_menu.click();
		System.out.println("Click on Faculty Advisor Allotment from sub menu");

		Thread.sleep(3000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlClgname-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys(
				"SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)", Keys.ENTER);
		System.out.println(" Select college and scheme ");
		
		Thread.sleep(3000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("May 2022", Keys.ENTER);
		System.out.println("Select session");
		
		Thread.sleep(3000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("V", Keys.ENTER);
		System.out.println("Select semester");
					
		Thread.sleep(2000); 
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlcourselist-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("CECX 20-Industrial Health and Safety - ", Keys.ENTER);
		System.out.println("Select elective course"); 
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		//driver.findElement(By.className("select2-search__field")).sendKeys(Keys.DOWN, Keys.ENTER);
		System.out.println("Click show student button");
		
		Thread.sleep(2000);
		driver.findElement(By.id("FilterData")).sendKeys("200011601001");
		System.out.println("Search student");
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"fa fa-search\"]")).click();
		System.out.println("click Search icon");
		
		WebElement check_box = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_cbRow"));
		
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",check_box);
		
		
		Thread.sleep(2000);
		check_box.click();
		System.out.println("click check box from");
		
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		System.out.println("click submit button");
		
			
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport")).click();
		System.out.println(" Click on Registration Slip Report button");
		
		Thread.sleep(3000);
		switchToNextWindow();
		
		Thread.sleep(2000);
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "Common Feedback Report");
		
		Thread.sleep(1000);
		switchToFrameOrDefault(); 
	}
}
