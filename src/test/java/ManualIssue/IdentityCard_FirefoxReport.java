package ManualIssue;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class IdentityCard_FirefoxReport extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*******Starting Test : " + m.getName() + "*****" + "\n");
	}

	@Test
	public void identityCardReportTest() throws Exception {

		test = reports.createTest("identityCardReportTest");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();

		// Hover on Academic from Navigation bar
		WebElement ele = driver.findElement(By.partialLinkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		System.out.println("Hover on Academic from Navigation bar");
		Thread.sleep(2000);

		// Click on Academic Reports from Drop Down
		driver.findElement(By.partialLinkText("Academic Reports")).click();
		System.out.println("Click on Academic Reports from Drop Down");
		Thread.sleep(3000);

		// Click on Identity Card from subMenu
		driver.findElement(By.id("ctl00_repLinks_ctl04_lbLink")).click();
		System.out.println("Click on Identity Card from subMenu");
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement admissionBatch = driver
				.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmbatch-container"));
		admissionBatch.click();

		Thread.sleep(2000);
		driver.findElement(By.className("select2-search__field")).sendKeys("2023-24", Keys.DOWN);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Admission Batch -> 2023-24");

		Thread.sleep(2000);
		WebElement school = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlClg-container"));
		school.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Architecture - Chennai",
				Keys.ENTER);
		System.out.println("School/Institute -> Crescent School of Architecture - Chennai");

		Thread.sleep(2000);
		WebElement degree = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container"));
		degree.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Bachelor of Architecture", Keys.ENTER);
		System.out.println("Degree -> Bachelor of Architecture");

		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();

//		Thread.sleep(2000);
//		scrollIntoView(semester, 50, 200);

		Thread.sleep(2000);
		WebElement text = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Panel1\"]/div[1]/h5"));
		Assert.assertEquals(text.getText(), "Search Results");

		Thread.sleep(2000);
		System.out.println("Select student -> Click on 1st CheckBox -> Nayan Sharma -> RRNO -> 232AT004 ");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl0_chkReport")).click();

		System.out.println("Click on Print Front Back ID Card");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnFrontBackIdentityCard")).click();

		Thread.sleep(2000);
		switchToNextWindow();
		Thread.sleep(5000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());

		Thread.sleep(8000);
		System.out.println("Click on Download Button");
		driver.findElement(By.id("downloadButton")).click();
		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		testcomdi();
	}

	public void testcomdi() throws Exception {
		boolean result = readPDF();
		System.out.println("Result : " + result);

		if (readPDF() == false) {
			fail("Condition check failed.");
			System.out.println("Script is failed");
		}

	}

	public boolean readPDF() throws IOException {

		PDDocument document = PDDocument.load(new File("C:\\Users\\LENOVO\\Downloads\\document.pdf"));
		if (!document.isEncrypted()) {
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(document);
			System.out.println("Text: " + text);
			String searchString = "NAYAN"; //////// Enrollment No. : 170101601014
			if (text.contains(searchString))
				return true;
		}
		fail("Condition check failed.");
		return false; 
	}
}
