package Payroll;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_BD_EmpolyeeInformation extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;

	@FindBy(linkText = "Transactions") private WebElement Transactions;

	@FindBy(linkText = "Basic Details") private WebElement BasicDetails;

	@FindBy(linkText = "Employee Information") private WebElement EmployeeInformation;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	String mobNum1;
	
	public StringBuilder getRandomMobileNumber() {
		Random random = new Random();
		StringBuilder mobNum1 = new StringBuilder();
		for(int i=0; i<10; i++)
		{
			mobNum1.append(random.nextInt(10));
		}
		
		return mobNum1; 
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Trans_BD_EmpolyeeInformation Transactions() {
		System.out.println("Admin PAYROLL menu selected > Transactions ");
		Actions action = new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation BasicDetails() {
		System.out.println(" Transactions > Monthly Work");
		Actions action = new Actions(driver);
		action.moveToElement(BasicDetails).click().build().perform();
		return this;
	}
	
	// Search Employee for Modification
	public AL_Payroll_Trans_BD_EmpolyeeInformation Click_PersonalDetails() {
		System.out.println("Click on Personal Deails");
		WebElement basicdetails = driver.findElement(By.xpath("//h5[normalize-space()='Personal Details']"));
		click(basicdetails);
		return this;
	}
	// Personal Details
	public StringBuilder generateRandomEmployeeCode() {
		Random random = new Random();
		StringBuilder mobNum1 = new StringBuilder();
		for(int i=0; i<4; i++)
		{
			mobNum1.append(random.nextInt(4));
		}
		
		return mobNum1; 
	}
	public AL_Payroll_Trans_BD_EmpolyeeInformation Enter_StaffId_EmpCode() {
		System.out.println("Enter Staff Id or Employee Code");
		StringBuilder emp_no;	
		emp_no =generateRandomEmployeeCode();
		
		WebElement staffId = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPersonalFileNo"));
		clearText(staffId);
		staffId.sendKeys(String.valueOf(emp_no));
		return this;
		//String.valueOf(pros_no)
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Enter_BioId_RfID() {
		System.out.println("Enter Bio Id or RF ID");
		WebElement bioId = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtRFIDno"));
		clearText(bioId);
		int number;
		Random random = new Random();
		number = random.nextInt(10000);
		int RanName = number;
		bioId.sendKeys(String.valueOf(RanName));
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_Title() {
		System.out.println("Select Title > Mr.");
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlTitle"));
		Select c1 = new Select(title);
		c1.selectByVisibleText("Mr.");
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Enter_FirstName() {
		System.out.println("Enter First Name=> Sachin");
		WebElement fname = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName"));
		clearText(fname);
		sendKeys(fname, "Sachin");
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Enter_LastName() {
		System.out.println("Enter First Name=> Kale");
		WebElement Lname = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtLastName']"));

		sendKeys(Lname, "Kale");
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Enter_DepatSenorityNo() throws InterruptedException {
		System.out.println("Enter Department Seniority/Sequence No => 25251256");
		WebElement deptSen = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSeqNo"));

		js.executeScript("arguments[0].scrollIntoView();",deptSen);
		Thread.sleep(2000);
		sendKeys(deptSen, "250");
		return this;
	}
	
	public StringBuilder generateRandomMobileNumber() {
		Random random = new Random();
		StringBuilder mobNum1 = new StringBuilder();
		for(int i=0; i<10; i++)
		{
			mobNum1.append(random.nextInt(10));
		}
		
		return mobNum1; 
	}
	public AL_Payroll_Trans_BD_EmpolyeeInformation Enter_MobNum() {
		StringBuilder pros_no;	
		pros_no =generateRandomMobileNumber();
		System.out.println("Enter Mobile Number => 9874563210");
		WebElement mbnm = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhoneNumber"));
		clearText(mbnm);
		mbnm.sendKeys(String.valueOf(pros_no));
		return this;
		
		
	}
	
	// Service Type Details
	public AL_Payroll_Trans_BD_EmpolyeeInformation Click_ServiceTypeDetails() throws InterruptedException {
		System.out.println("Click Service Type Details");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement serTyDet = driver.findElement(By.xpath("//h5[normalize-space()='Service Type Details']"));
//		js.executeScript("arguments[0].scrollIntoView();",serTyDet);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", serTyDet);
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_College() {
		System.out.println("Select College > Crescent School of Architecture");
		WebElement selectcollege = driver.findElement(By.id("select2-ddlCollege-container"));
		selectcollege.click();
		WebElement searchcollege = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		sendKeys(searchcollege, "Crescent School of Architecture");
		searchcollege.sendKeys(Keys.ENTER);
		
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_SchemeStaff() {
		System.out.println("Select Scheme > Teaching Staff");
		WebElement scheme = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlStaff-container"));
		scheme.click();
		WebElement searchscheme = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		sendKeys(searchscheme, "Teaching Staff");
		searchscheme.sendKeys(Keys.ENTER);
		
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_Designation() {
		System.out.println("Select Designation > ACADEMIC COORDINATOR");
		WebElement desig = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDesignation-container"));
		desig.click();
		WebElement searchdesig = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		sendKeys(searchdesig, "ACADEMIC COORDINATOR");
		searchdesig.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_LeaveCategory() {
		System.out.println("Select Leave Category > Teaching Staff");
		WebElement leaveCat = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlVacational-container"));
		leaveCat.click();
		WebElement searchleaveCat = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		sendKeys(searchleaveCat, "Teaching Staff");
		searchleaveCat.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_Department() {
		System.out.println("Select Department > Information Technology");
		WebElement dept = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDepartment-container"));
		dept.click();
		WebElement searchdept = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		sendKeys(searchdept, "Information Technology");
		searchdept.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_Appointment() {
		System.out.println("Select Appointment > Confirmed");
		WebElement appoint = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAppointment-container"));
		appoint.click();
		WebElement searchappoint = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		sendKeys(searchappoint, "Confirmed");
		searchappoint.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_UserType() {
		System.out.println("Select User Type > Faculty");
		WebElement usertype = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlUserType-container"));
		usertype.click();
		WebElement searchusertype = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		sendKeys(searchusertype, "Faculty");
		searchusertype.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_EmployeeType() {
		System.out.println("Select Employee Type > Teaching Staff");
		WebElement emptype = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlEmpType-container"));
		emptype.click();
		WebElement searchemptype = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		sendKeys(searchemptype, "Teaching Staff");
		searchemptype.sendKeys(Keys.ENTER);
		return this;
	}
	
	// Pay-Scale Details
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Click_PayScaleDetails() throws InterruptedException {
		System.out.println("Click Pay-Scale Details");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement payScaleDet = driver.findElement(By.xpath("//h5[normalize-space()='Pay-Scale Details']"));
		js.executeScript("arguments[0].scrollIntoView();",payScaleDet);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", payScaleDet);
		return this;
	}
	public AL_Payroll_Trans_BD_EmpolyeeInformation Select_Rule() {
		System.out.println("Select Rule > R6");
		WebElement rule = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlPayRule"));
		Select c1 = new Select(rule);
		c1.selectByVisibleText("R6");
		return this;
	}
	public AL_Payroll_Trans_BD_EmpolyeeInformation Enter_PresentBasic() { 
		System.out.println("Enter Present Basic => 20500");
		WebElement preBase = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBasic"));
		clearText(preBase);
		sendKeys(preBase, "1500");
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmpolyeeInformation Click_SubmiBtn() throws InterruptedException {
		System.out.println("Click Submit btn");
		WebElement submitbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",submitbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitbtn);
		return this;
	}
}
