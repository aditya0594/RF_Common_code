package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_StudentDisciplinaryAction_SingleStudent extends BaseClass
{
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Student Disciplinary Action") private WebElement StudentDisciplinaryAction;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement schoolInstitute;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearch") private WebElement searchcriteria;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDropdown") private WebElement branch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showdetailbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId") private WebElement stud_rishab;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement downloadPDFbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcel") private WebElement downloadEXCELbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSingleRemark") private WebElement remarkbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitbtn;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Click_StudentDisciplinaryAction() throws InterruptedException {
		System.out.println("Click on Student Disciplinary Action");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",StudentDisciplinaryAction);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", StudentDisciplinaryAction);
		return this;
	}
	
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Select_SchoolInstitute() throws InterruptedException {
		System.out.println("Select School Institute ==> Crescent School of Architecture");
		Select select = new Select(schoolInstitute);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Select_Session() throws InterruptedException {
		System.out.println("Select Session ==> 2023-2024");
		Select select = new Select(session);
		select.selectByVisibleText("2023-2024");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Select_SearchCriteria() throws InterruptedException {
		System.out.println("Select Search Criteria");
		Select select = new Select(searchcriteria);
		select.selectByVisibleText("BRANCH");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Select_Branch() throws InterruptedException {
		System.out.println("Select Branch => ");
		Select select = new Select(branch);
		select.selectByVisibleText("Architecture");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Click_ShowDetailsBtn() throws InterruptedException {
		System.out.println("Click on Show Details btn");
		click(showdetailbtn);
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Click_StudentName() throws InterruptedException {
		System.out.println("Click on Student Name => Rishab Bajirao");
		js.executeScript("arguments[0].scrollIntoView();",stud_rishab);

		click(stud_rishab);
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Click_DownloadPDFbtn() throws InterruptedException {
		System.out.println("Click on DownloadPDF btn");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",downloadPDFbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", downloadPDFbtn);
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Click_DownloadExcelbtn() throws InterruptedException {
		System.out.println("Click on DownloadPDF btn");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",downloadEXCELbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", downloadEXCELbtn);
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Set_FromDate() throws InterruptedException {
		System.out.println("Set From Date => 05/03/2025");
		js.executeScript("arguments[0].scrollIntoView();",branch);
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_dvcal1"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceStartDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceStartDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceStartDate_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceStartDate_month_0_2"));
		month_select.click();  // month= March
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceStartDate_day_1_3"));
		date_select.click();    // day=5

		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent To_Date() throws InterruptedException {
		System.out.println("Set To Date => 05/03/2027");
	
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_dvcal2"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_year_2_0"));
		year_select.click(); //year = 2027
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_month_0_2"));
		month_select.click();  // month= March
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_day_0_5"));
		date_select.click();    // day=5

		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Select_Remark() throws InterruptedException {
		System.out.println("Select Remark => Misconduct");
		js.executeScript("arguments[0].scrollIntoView();",remarkbtn);

		Select select = new Select(remarkbtn);
		select.selectByVisibleText("Misconduct");
		return this;
	}
	
	public AL_Academic_CR_StudentDisciplinaryAction_SingleStudent Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		js.executeScript("arguments[0].scrollIntoView();",submitbtn);

		js.executeScript("arguments[0].click();", submitbtn);
		return this;
	}
}
