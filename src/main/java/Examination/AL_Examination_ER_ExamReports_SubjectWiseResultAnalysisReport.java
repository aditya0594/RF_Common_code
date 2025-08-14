package Examination;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import utility.PDFUtility;

public class AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(linkText = "Exam Reports") private WebElement Exam_Report;
	
	PDFUtility pdfutility;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport EXAM_REPORT() throws InterruptedException {
		System.out.println(" Click On > Exam Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",Exam_Report);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Exam_Report);

		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport College_Scheme() {
		System.out.println("Select College and Scheme");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlClgname']"));
		Select select = new Select(clg);
		select.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport Session() {
		System.out.println("Select Session");
		WebElement session=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSession']"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport Semister() {
		System.out.println("Select Semister");
		WebElement semister=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSem']"));
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport Section() {
		System.out.println("Select Section");
		WebElement section=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSection']"));
		Select select = new Select(section);
		select.selectByVisibleText("A");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport Exam_Name() {
		System.out.println("Select Exam_Name");
		WebElement exam_name=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlExam']"));
		Select select = new Select(exam_name);
		select.selectByVisibleText("EXTERNAL");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport Sub_Exam() {
		System.out.println("Select Sub_Exam");
		WebElement sub_exam=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSubExam']"));
		Select select = new Select(sub_exam);
		select.selectByVisibleText("END SEM-Theory with Tutorial");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport Course() {
		System.out.println("Select Course");
		WebElement course=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcourse']"));
		Select select = new Select(course);
		select.selectByVisibleText("END 1281-English for Engineers");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport Click_SubjectWiseResultAnalysisReportBtn() throws InterruptedException, AWTException, IOException {
		System.out.println("Click Subject Wise Result Analysis Report btn");
		pdfutility =new PDFUtility(driver);
		WebElement sgpa_cgpa=driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_btnSubjectWiseResultanalysisReport'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();",sgpa_cgpa);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sgpa_cgpa);
		
		Thread.sleep(6000);
		pdfutility.downloadPDF(driver, "Examination - Subject Wise Result Analysis Report");
		pdfutility.readPDF("Examination - Subject Wise Result Analysis Report", "ABDUL");	

		return this;
	}


}
