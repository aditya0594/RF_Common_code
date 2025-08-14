package RFCC_Extra;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class FeeInstallmentAllotment extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@Test(priority = 2)
	public void Bulk_Student_Fees_Installment() throws InterruptedException {
		// Open Login page having login details
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);

		// Direct open Fees Related Page
		driver.get(
				"https://rfcautomationuat.mastersofterp.in/Academic/iitmsYto5Ax3XQNdhUAsoYbVpUnVxzmaOhCiyp7mdG9JAEs5pRvmg9fdS1IPWiFF7Ivhs?enc=fM43BhrdLEc+Q3PHRzoW7H6D08Gg0KbnfcJprY4h46o=");
		System.out.println("Go to Fees Related Page");
		Thread.sleep(2000);

		// Click on fee Installment Allotment
		WebElement wb = driver.findElement(By.xpath("//*[@id=\"ctl00_repLinks_ctl23_lbLink\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", wb);
		System.out.println("Click on fee Installment Allotment");
		Thread.sleep(2000);

		// Click on Bulk student Fees Installment
		WebElement wb1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblisintallmentconfig_1"));
		js.executeScript("arguments[0].click();", wb1);
		System.out.println("Go to Fees Related Page");
		Thread.sleep(2000);

		/////////////// Select School/Institute
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlColg-container")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("select2-search__field")).sendKeys("School of Infrastructure");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select School/Institute");
		Thread.sleep(2000);

		// Select Degree
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Bachelor of Technology");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Degree");
		Thread.sleep(2000);

		// Select Branch
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Civil Engineering");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Branch");
		Thread.sleep(2000);

		// Select Semester
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBulkSemester-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("III");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Semester");
		Thread.sleep(2000);

		// Select Receipt Type
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBulkReceiptType-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Tuition Fees");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Receipt Type");
		Thread.sleep(2000);

		// Select Payment Type
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("General");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Payment Type");
		Thread.sleep(2000);

		// Select Installment Type
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlinstallmenttype-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("FULL");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Installment Type");
		Thread.sleep(2000);

		// Click on show button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnBulkShow")).click();
		System.out.println("Click on show button");
		Thread.sleep(2000);

		// Select one student
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBulkStudent_ctrl1_cbRow")).click();
		System.out.println("Select one student");
		Thread.sleep(2000);

		// Click on Submit button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();
		System.out.println("Click on Submit button");
		Thread.sleep(2000);

		// Accept the Alert
		Alert alt = driver.switchTo().alert();
		alt.accept();
		System.out.println("Accept the Alert");
	}

	@Test(priority = 1)
	public void Amt_Wise_Single_Student_Fees_Installment() throws InterruptedException {
		// Open Login page having login details
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);

		// Direct open Fees Related Page
		driver.get(
				"https://crescentuat.mastersofterp.in/Academic/iitmsYto5Ax3XQNdhUAsoYbVpUnVxzmaOhCiyp7mdG9JAEs5pRvmg9fdS1IPWiFF7Ivhs?enc=fM43BhrdLEc+Q3PHRzoW7H6D08Gg0KbnfcJprY4h46o=");
		System.out.println("Go to Fees Related Page");
		Thread.sleep(2000);

		// Click on fee Installment Allotment
		WebElement wb = driver.findElement(By.xpath("//*[@id=\"ctl00_repLinks_ctl23_lbLink\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", wb);
		System.out.println("Click on fee Installment Allotment");
		Thread.sleep(2000);

		// Click on Amt_Wise_Single_Student_Fees_Installment
		WebElement wb1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblisintallmentconfig_0"));
		js.executeScript("arguments[0].click();", wb1);
		System.out.println("Click on Amt_Wise_Single_Student_Fees_Installment");
		Thread.sleep(2000);

		// Enter RRN no. of student
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch")).sendKeys("200011601006");
		System.out.println("Enter RRN no. of student");
		Thread.sleep(2000);

		// Click on Search Button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch")).click();
		System.out.println("Click on Search Button");
		Thread.sleep(2000);

		// Click on Student's name
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")).click();
		System.out.println("Click on Student's name");
		Thread.sleep(2000);

		// Click on Receipt type drop down
		Select dd = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReceiptType")));
		dd.selectByValue("TF");
		System.out.println("Click on fee Installment Allotment");
		Thread.sleep(2000);

		// Click on Semester drop down
		Select dd1 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester")));
		dd1.selectByValue("5");
		System.out.println("Click on Semester drop down");
		Thread.sleep(2000);

		// Click on submit button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		System.out.println("Click on submit button");
		Thread.sleep(2000);

		// Click on due date
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript(
				"document.getElementById('ctl00_ContentPlaceHolder1_grdinstalment_ctl02_txtDueDate').value='22/07/2024';");
		System.out.println("Click on due date");
		Thread.sleep(2000);

		// Enter installment amount
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdinstalment_ctl02_txtAmount")).sendKeys("37500");
		System.out.println("Enter installment amount");
		Thread.sleep(2000);

		// Click on add installment button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdinstalment_ctl03_btnAdd")).click();
		System.out.println("Click on add installment button");
		Thread.sleep(2000);

		// Click on due date
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript(
				"document.getElementById('ctl00_ContentPlaceHolder1_grdinstalment_ctl03_txtDueDate').value='22/08/2024';");
		System.out.println("Click on due date");
		Thread.sleep(2000);

		// Enter installment amount
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdinstalment_ctl03_txtAmount")).sendKeys("37500");
		System.out.println("Enter installment amount");
		Thread.sleep(2000);

		// Click on submit Button
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		WebElement wb3 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsubmit"));
		js3.executeScript("arguments[0].click();", wb3);
		System.out.println("Click on submit Button");
		Thread.sleep(2000);

		// Accept the alert
		Alert alt = driver.switchTo().alert();
		alt.accept();
		System.out.println("Accept Alert");

	}

	@Test(priority = 3)
	public void Single_Student_Fees_Discount() throws InterruptedException {
		// Open Login page having login details
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);

		// Direct open Fees Related Page
		driver.get(
				"https://crescentuat.mastersofterp.in/Academic/iitmsYto5Ax3XQNdhUAsoYbVpUnVxzmaOhCiyp7mdG9JAEs5pRvmg9fdS1IPWiFF7Ivhs?enc=fM43BhrdLEc+Q3PHRzoW7H6D08Gg0KbnfcJprY4h46o=");
		System.out.println("Go to Fees Related Page");
		Thread.sleep(2000);

		// Click on fee Installment Allotment
		WebElement wb = driver.findElement(By.xpath("//*[@id=\"ctl00_repLinks_ctl23_lbLink\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", wb);
		System.out.println("Click on fee Installment Allotment");
		Thread.sleep(2000);

		// Click on Single Student Fees Discount
		WebElement wb1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblisintallmentconfig_2"));
		js.executeScript("arguments[0].click();", wb1);
		System.out.println("Click on Single Student Fees Discount");
		Thread.sleep(2000);

		// Select RRN no. from Drop Down
		Select dd = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlsearchDisc")));
		dd.selectByVisibleText("RRN NO.");
		System.out.println("Select RRN no.");
		Thread.sleep(2000);

		// Enter RRN no. of student
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearchDis")).sendKeys("200011601006");
		System.out.println("Enter RRN no. of student");
		Thread.sleep(2000);

		// Click on Search Button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSerchDis")).click();
		System.out.println("Click on Search Button");
		Thread.sleep(2000);

		// Click on student name
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentDis_ctrl0_lnkIdDis")).click();
		System.out.println("Click on student's name");
		Thread.sleep(2000);

		// Select Receipt Type
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlreceipt-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Tuition Fees");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Receipt Type");
		Thread.sleep(2000);

		// Select Payment Type
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlpaymentsingle-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("General");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Payment Type");
		Thread.sleep(2000);

		// Select Semester
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlsemesterShow-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("V");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Semester");
		Thread.sleep(2000);

		// Click on Show button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowDisSingle")).click();
		System.out.println("Click on Show button");
		Thread.sleep(2000);

		// Click on AmountWise button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoSelect_0")).click();
		System.out.println("Select Amountwise button");
		Thread.sleep(2000);

		// Select student, click on checkbox
		WebElement wb3 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscountSingle_ctrl0_chktransfer"));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", wb3);
		System.out.println("Select student, click on checkbox");
		Thread.sleep(2000);

		// Select Discount Type
		Select dd1 = new Select(
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscountSingle_ctrl0_ddlConcession")));
		dd1.selectByVisibleText("Regular");
		System.out.println("Enter Discount Type");
		Thread.sleep(2000);

		// Enter Discount Amount
		driver.findElement(By.xpath(
				"/html/body/form/div[6]/div[2]/div/section/div/div/div[3]/div/div/div/div[3]/div[2]/div[2]/div[5]/div/div/div/div[2]/div[3]/div[1]/div/table/thead/tr/th[7]/input"))
				.sendKeys("500");
		System.out.println("Enter Discount Amount");
		Thread.sleep(2000);

		// Click on submit button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmitSingleDis")).click();
		System.out.println("Click on submit button");
		Thread.sleep(2000);

		// Accept the alert
		Alert alt = driver.switchTo().alert();
		alt.accept();
		System.out.println("Accept the Alert");
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void Bulk_Student_Fees_Discount() throws InterruptedException {
		// Open Login page having login details
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);

		// Direct open Fees Related Page
		driver.get(
				"https://crescentuat.mastersofterp.in/Academic/iitmsYto5Ax3XQNdhUAsoYbVpUnVxzmaOhCiyp7mdG9JAEs5pRvmg9fdS1IPWiFF7Ivhs?enc=fM43BhrdLEc+Q3PHRzoW7H6D08Gg0KbnfcJprY4h46o=");
		System.out.println("Go to Fees Related Page");
		Thread.sleep(2000);

		// Click on fee Installment Allotment
		WebElement wb = driver.findElement(By.xpath("//*[@id=\"ctl00_repLinks_ctl23_lbLink\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", wb);
		System.out.println("Click on fee Installment Allotment");
		Thread.sleep(2000);

		// Click on Bulk Student Fees Discount
		WebElement wb1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblisintallmentconfig_3"));
		js.executeScript("arguments[0].click();", wb1);
		System.out.println("Click on Bulk Student Fees Discount");
		Thread.sleep(2000);

		// Select School/Institute
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlschool-container")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("select2-search__field")).sendKeys("School of Infrastructure");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select School/Institute");
		Thread.sleep(2000);

		// Select Degree
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddldegreedis-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Bachelor of Technology");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Degree");
		Thread.sleep(2000);

		// Select Branch
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlbranchdis-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Civil Engineering");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Branch");
		Thread.sleep(2000);

		// Select Semester
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlsemesterdis-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("III");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Semester");
		Thread.sleep(2000);

		// Select Receipt Type
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlreceiptdis-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Tuition Fees");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Receipt Type");
		Thread.sleep(2000);

		// Select Payment Type
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlpaymentdis-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("General");
		Thread.sleep(900);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Payment Type");
		Thread.sleep(2000);

		// Click on show button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnshowdis")).click();
		System.out.println("Click on show button");
		Thread.sleep(2000);

		// Click on AmountWise button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdConcessionOption_0")).click();
		System.out.println("Select Amountwise button");
		Thread.sleep(2000);

		// Select student, click on checkbox
		WebElement wb3 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscount_ctrl0_chktransfer"));
		WebElement wb4 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscount_ctrl1_chktransfer"));
		WebElement wb5 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscount_ctrl2_chktransfer"));
		WebElement wb6 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscount_ctrl3_chktransfer"));

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", wb3);
		js3.executeScript("arguments[0].click();", wb4);
		js3.executeScript("arguments[0].click();", wb5);
		js3.executeScript("arguments[0].click();", wb6);
		System.out.println("Select student, click on checkbox");
		Thread.sleep(2000);

//	  String arr[] = {"wb3","wb4","wb5","wb6"};
//	  for(int i=0; i<=arr.length; i++) 
//	  {
//		  JavascriptExecutor js3 = (JavascriptExecutor)driver;
//		  js3.executeScript("arguments[0].click();",arr[i]);
//		  Thread.sleep(2000);
//	  }

		// Select Discount Type
		Select dd1 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscount_ctrl0_ddlConcession")));
		dd1.selectByVisibleText("Regular");
		Thread.sleep(1000);
		Select dd2 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscount_ctrl1_ddlConcession")));
		dd2.selectByVisibleText("Regular");
		Thread.sleep(1000);
		Select dd3 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscount_ctrl2_ddlConcession")));
		dd3.selectByVisibleText("Regular");
		Thread.sleep(1000);
		Select dd4 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_LvDiscount_ctrl3_ddlConcession")));
		dd4.selectByVisibleText("Regular");
		System.out.println("Enter Discount Type");
		Thread.sleep(1000);

		// Enter Discount Amount
		driver.findElement(By.xpath(
				"/html/body/form/div[6]/div[2]/div/section/div/div/div[3]/div/div/div/div[3]/div[2]/div/div[3]/div/div/div/div[2]/div[3]/div[1]/div/table/thead/tr/th[7]/input"))
				.sendKeys("500");
		System.out.println("Enter Discount Amount");
		Thread.sleep(2000);

		// Click on submit button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsubmitdis")).click();
		System.out.println("Click on submit button");
		Thread.sleep(2000);

		// Accept the alert
		Alert alt = driver.switchTo().alert();
		alt.accept();
		System.out.println("Accept the Alert");
		Thread.sleep(2000);
	}

	@BeforeMethod
	public void launchBrowser() throws Exception {
		// Open browser with given link
		driver = Browser.openBrowser("url_RF_LoginAdmin");
	}

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

}
