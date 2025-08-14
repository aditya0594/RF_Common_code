package RFCC_Extra;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class NewStudent extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}
	
	@Test
	public void New_Student() throws Exception {
		
		RF_AdminLoginPage.loginPage();
	

		WebElement ele = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Main academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Admission Process"));
		System.out.println("Admission Process submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		Thread.sleep(2000);
		System.out.println("Click on New student Page");
		WebElement new_Stud = driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink"));
		new_Stud.click();
		
		Thread.sleep(2000);
		WebElement btn_newStud = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnNewStu"));
		btn_newStud.click();
		System.out.println("Click on New student Button");
	
	
		WebElement StudentName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudentfullName"));
	    String StudentNameText = "ASHUTOSH SHARMA";
		System.out.println("Select Student Name: "+ StudentNameText);
		StudentName.sendKeys(StudentNameText);
		System.out.println("Student Name ->ASHUTOSH SHARMA ");
	
		WebElement FatherName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFatherName"));
	    String FatherNameText = "VILAS SHARMA";
		System.out.println("Enter Student Name: "+ FatherNameText);
		FatherName.sendKeys(FatherNameText);
		System.out.println("Father Name -> VILAS SHARMA");
		
		WebElement StudentMobileNo= driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile"));
	    String StudentMobileNoText = "8479379383";
		System.out.println("Enter Student Mobile Number: "+ StudentMobileNoText);
		StudentMobileNo.sendKeys(StudentMobileNoText);
		System.out.println("Mobile No. -> 8479379383");
		
		WebElement StudentMobileNo2= driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile2"));
	    String StudentMobileNo2Text = "7894562185";
		System.out.println("Enter Student Mobile Number2: "+ StudentMobileNo2Text);
		StudentMobileNo2.sendKeys(StudentMobileNo2Text);
		System.out.println("Mobile No.2 -> 7894562185");
		
		WebElement StudentPersonalEmail= driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudEmail"));
	    String StudentPersonalEmailText = "ashutosh1@gmail.com";
		System.out.println("Enter Personal Email: "+ StudentPersonalEmailText);
		StudentPersonalEmail.sendKeys(StudentPersonalEmailText);
		System.out.println("Email ->ashutosh1@gmail.com ");
		
//	Select Stateddl= new Select(driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlstate-container")));
//	Stateddl.selectByVisibleText("Maharashtra");
//  WebElement showStateddl = Stateddl.getFirstSelectedOption();
//	System.out.println("Select State: "+ showStateddl.getText());
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlstate-container")).click();
		WebElement Stateddl = driver.findElement(By.className("select2-search__field"));
		String StateText = "Maharashtra";
		Stateddl.sendKeys(StateText);
	    System.out.println("Select State: " + StateText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
	
		Thread.sleep(1000);
		WebElement GenderRdo= driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoMale"));
		GenderRdo.click();
	    String GenderRdoText = "Male";
		System.out.println("Select Gender: "+ GenderRdoText);
	
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSchool-container")).click();
		WebElement SchoolInstituteddl = driver.findElement(By.className("select2-search__field"));
		String SchoolInstituteText = "School of Computer Information and Mathematical Sciences";
		SchoolInstituteddl.sendKeys(SchoolInstituteText);
		System.out.println("Select School Institute: " + SchoolInstituteText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
		WebElement Degreeddl = driver.findElement(By.className("select2-search__field"));
		String DegreeText = "Bachelor of Technology";
		Degreeddl.sendKeys(DegreeText);
		System.out.println("Select Degree: " + DegreeText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
		WebElement Branchddl = driver.findElement(By.className("select2-search__field"));
		String BranchText = "Computer Science and Engineering";
		Branchddl.sendKeys(BranchText);
		System.out.println("Select Branch: " + BranchText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddladmthrough-container")).click();
		WebElement AdmissionThroughddl = driver.findElement(By.className("select2-search__field"));
		String AdmissionThroughText = "CAP 1";
		AdmissionThroughddl.sendKeys(AdmissionThroughText);
		System.out.println("Select Admission Through: " + AdmissionThroughText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmType-container")).click();
		WebElement AdmissionTypeddl = driver.findElement(By.className("select2-search__field"));
		String AdmissionTypeText = "REGULAR";
		AdmissionTypeddl.sendKeys(AdmissionTypeText);
		System.out.println("Select Admission Type: " + AdmissionTypeText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlYear-container")).click();
		WebElement AdmissionYearddl = driver.findElement(By.className("select2-search__field"));
		String AdmissionYearText = "First Year";
		AdmissionYearddl.sendKeys(AdmissionYearText);
		System.out.println("Select Admission Year: " + AdmissionYearText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container")).click();
		WebElement Semesterddl = driver.findElement(By.className("select2-search__field"));
		String SemesterText = "First Semester";
		Semesterddl.sendKeys(SemesterText);
		System.out.println("Select Semester: " +  SemesterText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBatch-container")).click();
		WebElement AdmissionBatchddl = driver.findElement(By.className("select2-search__field"));
		String AdmissionBatchText = "2024-25";
	    AdmissionBatchddl.sendKeys(AdmissionBatchText);
		System.out.println("Select Admission Batch: " +  AdmissionBatchText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		WebElement DOB= driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateOfBirth"));
		String DOBText = "13/02/2002";
		DOB.sendKeys(DOBText);
		System.out.println("Enter Date Of Birth: "+ DOBText);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAllotedCat-container")).click();
		WebElement Categoryddl = driver.findElement(By.className("select2-search__field"));
		String  CategoryText = "General/OC";
		Categoryddl.sendKeys(CategoryText);
		System.out.println("Select Category: " +  CategoryText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		WebElement  DOE = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateOfReporting"));
		String DOEText = "28/02/2024";
		String n = Keys.chord(Keys.CONTROL, "A");
		DOE.sendKeys(n,DOEText);
		System.out.println("Select  Date of Entry: " +  DOEText);
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container")).click();
		WebElement PaymentTypeddl = driver.findElement(By.className("select2-search__field"));
		String  PaymentTypeText = "General";
		PaymentTypeddl.sendKeys(PaymentTypeText);
		System.out.println("Select Payment Type: " + PaymentTypeText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		
	
		WebElement element = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();
		System.out.println("Click on submit button");
		Thread.sleep(1000);
		
		
        Alert alert = driver.switchTo().alert();
		
		String Act_Msg = alert.getText();
		String Exp_Msg = "Student Data Saved And Demand Created for Amount  2.00  Successfully.Your Temporary ID No is 9067 Now you can print Admission Slip.Report Generate Successfully";
		
		 if (Exp_Msg.equals(Act_Msg)) {
			 System.out.println("Assertion passed"+ alert.getText());
			 alert.accept();
         } else {
             System.out.println("Assertion failed: Expected '" + Exp_Msg + "' but got '" + Act_Msg + "'.");

             // Handle the alert (if any)
             try {
                 
                 System.out.println("Alert found: " + alert.getText());
                 alert.accept(); // Accept the alert
                 System.out.println("Alert accepted.");
             } catch (NoAlertPresentException e) {
                 System.out.println("No alert present.");
             }
         }
		 
		 Thread.sleep(2000);
		WebElement btn_report = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		btn_report.click();
		System.out.println("Report Generate Successfully");
		
		Thread.sleep(1000);
		String originalWindow = driver.getWindowHandle();
		driver.switchTo().window(originalWindow);
		
}
}
