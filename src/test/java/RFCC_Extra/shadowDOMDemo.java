package RFCC_Extra;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class shadowDOMDemo extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "***** Starting " + m.getName() + " *******" + "\n");
	}

	@Test
	public void studentLedgerReportTest() throws Exception {

		test = reports.createTest("studentLedgerReportTest");

		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();

//		driver.get(
//				"https://rfcautomationuat.mastersofterp.in/ACADEMIC/iitms+3B5VIwAvHSlGEKzSxr/dXBroEDsD8cFjN/uvgPY5GpHOxtI/1lTjSuOZkBfo4Gihqgldcg6f3kHSNV81IZsXA==?enc=J/hOimnKXjYzzJYY1c51QiLbM8aOc8ZUC7bnQHcVZFc=");

		// Click on Academic
		WebElement ele = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Click on Academic");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);

		// Click on Fees Related Reports
		driver.findElement(By.partialLinkText("Fees Related Reports")).click();
		System.out.println("Click on Student Related");
		Thread.sleep(2000);

		// Click on Student ledger report
		driver.findElement(By.id("ctl00_repLinks_ctl03_lbLink")).click();
		System.out.println("Click on Student ledger report");

		Thread.sleep(2000);
		System.out.println("Search Criteria -> RRN NO.");
		WebElement SearchCriteria = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSearch-container"));
		SearchCriteria.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("RRN NO.", Keys.ENTER);

		Thread.sleep(2000);
		System.out.println("Search String -> 170101601014");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch")).clear();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch")).sendKeys("170101601014");

		Thread.sleep(2000);
		System.out.println("Click on Search Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearchCriteria")).click();

		Thread.sleep(2000);
		System.out.println("Click on Name -> KEERTHANA PRIYA. R");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")).click();

		Thread.sleep(2000);
		System.out.println("Click on Ledger Report");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowReport")).click();

		switchToNextWindow();
		Thread.sleep(8000);
				
		  try {
	            // Navigate to the page with shadow DOM
	          //  driver.get("");

			  
	            // Define JavaScript scripts
	            String scriptToGetShadowRoot = "return arguments[0].shadowRoot;";
	            String scriptToGetSvgElement = "return arguments[0].querySelector('svg');";

	            // Locate the shadow host element
	            WebElement shadowHost = driver.findElement(By.cssSelector("viewer-toolbar#downloads"));

	            // Execute JavaScript to get the shadow root
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            WebElement shadowRoot = (WebElement) js.executeScript(scriptToGetShadowRoot, shadowHost);

	            // Execute JavaScript to get the SVG element inside the shadow DOM
	            WebElement svgElement = (WebElement) js.executeScript(scriptToGetSvgElement, shadowRoot);

	            // Click the SVG element
	            svgElement.click();
	          
	            System.out.println("Clicked on SVG element successfully.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            //driver.quit();
	        }
	/*	System.out.println("Click on Download Button");
		driver.findElement(By.id("download")).click();
		Thread.sleep(2000);*/

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);

		// Screenshot.takesScreenshotReports(getCurrentDateAndTime());

		////////////////// pdf
		Thread.sleep(2000);
		testcomdi();
		// driver.close();

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

//		PDDocument document = PDDocument
//				.load(new File(".\\src\\test\\resources\\documentsForTesting\\StudentLedgerReport.pdf"));
		PDDocument document = PDDocument.load(new File("C:\\Users\\LENOVO\\Downloads\\document.pdf"));
		if (!document.isEncrypted()) {
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(document);
			System.out.println("Text: " + text);
			String searchString = "170101601014"; //////// Enrollment No. : 170101601014
			if (text.contains(searchString))
				// System.out.println("Found the string: " + searchString); }
				return true;
		}
		return false;
	}// document.close();

	@AfterMethod
	public void getTestResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		} else {
			test.log(Status.SKIP, result.getName());
		}
	}

	@AfterTest
	public void publishResult() {
		reports.flush();
	}
}