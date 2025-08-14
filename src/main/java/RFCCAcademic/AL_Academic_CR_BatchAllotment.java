package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_BatchAllotment extends BaseClass
{
	public AL_Academic_CR_BatchAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl06_lbLink") private WebElement BatchAllotment;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement college;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement semister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubjectType") private WebElement coursetype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourse") private WebElement course;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement section;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnFilter") private WebElement filterbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_BatchAllotment Click_BatchAllotment() throws InterruptedException {
		System.out.println("Click on Batch Allotment");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",BatchAllotment);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", BatchAllotment);
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Select_CollegeScheme() throws InterruptedException {
		System.out.println("Select College Scheme => CSA - B. Arch-Architecture-2023-24-Crescent School of Architecture (New Scheme)");
		Select select = new Select(college);
		select.selectByVisibleText("CSA - B. Arch-Architecture-2023-24-Crescent School of Architecture (New Scheme)");
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Select_Session() throws InterruptedException {
		System.out.println("Select Session => 2023-2024");
		Select select = new Select(session);
		select.selectByVisibleText("2023-2024");
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Select_Semister() throws InterruptedException {
		System.out.println("Select Semister => I");
		Select select = new Select(semister);
		select.selectByVisibleText("I");
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Select_CourseType() throws InterruptedException {
		System.out.println("Select Course Type => Theory with Tutorial");
		Select select = new Select(coursetype);
		select.selectByVisibleText("Theory with Tutorial");
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Select_Course() throws InterruptedException {
		System.out.println("Select Course => AGCS-15 - Information Technology");
		Select select = new Select(course);
		select.selectByVisibleText("AGCS-15 - Information Technology");
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Select_Section() throws InterruptedException {
		System.out.println("Select Section => A");
		Select select = new Select(section);
		select.selectByVisibleText("A");
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Click_FilterBtn() throws InterruptedException {
		System.out.println("Click on Filter btn");
		click(filterbtn);
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Enter_SerialNo() throws InterruptedException {
		System.out.println("Enter Serial No From 1 To 10");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEnrollFrom")).sendKeys("1");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEnrollTo")).sendKeys("10");
		WebElement confirmstudentbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnConfirm"));
		click(confirmstudentbtn);
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Select_Batch() throws InterruptedException {
		System.out.println("Select Batch => 2023-2024");
		WebElement batch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBatch"));
		Select select = new Select(batch);
		select.selectByVisibleText("2023-2024");
		return this;
	}
	
	public AL_Academic_CR_BatchAllotment Click_SaveBtn() throws InterruptedException {
		System.out.println("Click on Save btn");
		WebElement savebtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		click(savebtn);
		return this;
	}
}
