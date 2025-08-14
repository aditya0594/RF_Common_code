package Examination;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Payroll.AL_Payroll_Rpt_StaffWiseSalaryData;
import utility.BaseClass;
import utility.ExcelFileValidator;
import utility.SearchExcelFile;
import utility.ExcelUtility;

public class AL_Examination_Convocation_ConvocationPassoutStudentList extends BaseClass {
	@FindBy(linkText = "EXAMINATION")
	private WebElement Examination;
	@FindBy(linkText = "Convocation")
	private WebElement convocation;
	@FindBy(id = "ctl00_repLinks_ctl03_lbLink")
	private WebElement passoutstudentlist;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnPassStudList")
	private WebElement passoutstudentlistbtn;

	public AL_Examination_Convocation_ConvocationPassoutStudentList(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Examination_Convocation_ConvocationPassoutStudentList EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Examination).build().perform();
		return this;
	}

	public AL_Examination_Convocation_ConvocationPassoutStudentList Click_Convocation() {
		System.out.println("Click on Convocation ");
		Actions action = new Actions(driver);
		action.moveToElement(convocation).click().build().perform();
		return this;
	}

	public AL_Examination_Convocation_ConvocationPassoutStudentList Click_ConvocationPassoutStudentList() {
		System.out.println("Click on Convocation / Passout Student List ");
		Actions action = new Actions(driver);
		action.moveToElement(passoutstudentlist).click().build().perform();
		return this;
	}

	public AL_Examination_Convocation_ConvocationPassoutStudentList Select_CollegeSession() {
		System.out.println("Select College Session => Select All");
		WebElement sch = driver.findElement(By.xpath("(//span[@class='multiselect-selected-text'])[1]"));
		sch.click();

		WebElement select = driver.findElement(By.xpath("//label[normalize-space()='Select all']"));
		select.click();
		return this;
	}

	public AL_Examination_Convocation_ConvocationPassoutStudentList Select_ConvocationType() {
		System.out.println("Select Session => 11 th Convocation");
		WebElement session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlConvocationNo"));
		Select select = new Select(session);
		select.selectByVisibleText("11 th Convocation");
		return this;
	}

	public AL_Examination_Convocation_ConvocationPassoutStudentList Click_PassoutStudentExcelReportbtn() {
		System.out.println("Click on Pass out Student Excel Report btn");
		WebElement btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPassStudList"));
		click(btn);
		return this;
	}

}
