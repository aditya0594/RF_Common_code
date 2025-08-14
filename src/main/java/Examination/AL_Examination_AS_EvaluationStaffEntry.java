package Examination;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Examination_AS_EvaluationStaffEntry extends BaseClass{

	public AL_Examination_AS_EvaluationStaffEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl01_lbLink") private WebElement evaluationStaffEntry_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaffType") private WebElement evaluatorType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement dept_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtName") private WebElement staffName_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMobile") private WebElement mobileNo_Inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEmail") private WebElement emailId_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAddress") private WebElement address_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	
	public AL_Examination_AS_EvaluationStaffEntry click_EvaluationStaffEntry_Link() {
		System.out.println("Click on Evaluation Staff Entry");
		click(evaluationStaffEntry_Link);
		return this;
	}
	public AL_Examination_AS_EvaluationStaffEntry select_EvaluatorType() {
		System.out.println("Click on Evaluator Type");
		Select evaluator_typ = new Select(evaluatorType_dropdown);
		evaluator_typ.selectByVisibleText("EXTERNAL");
		System.out.println("Evaluator Type is : EXTERNAL");
		return this;
	}
	public AL_Examination_AS_EvaluationStaffEntry select_Department() {
		System.out.println("Click on Department");
		Select departmnt_typ = new Select(dept_dropdown);
		departmnt_typ.selectByVisibleText("Department of Aerospace Engineering - Aerospace");
		System.out.println("Department Type is : Department of Aerospace Engineering - Aerospace");
		return this;
	}
	public AL_Examination_AS_EvaluationStaffEntry enter_StaffName() {
		System.out.println("Click on Staff Name");
		//Staff Name ==> Random name
		Random random = new Random();
		String generatedName = RandomStringUtils.randomAlphabetic(8);
		String randomName = "AUTOMATION USER "+generatedName; 
		staffName_Inputbox.sendKeys(randomName);
		return this;
	}
	public AL_Examination_AS_EvaluationStaffEntry enter_mobileNo() {
		StringBuilder mobNum1 = new StringBuilder();
		Random random = new Random();
		for(int i=0; i<10; i++)
		{
			mobNum1.append(random.nextInt(10));
		}
		mobileNo_Inputfield.sendKeys(mobNum1);
		return this;
	}
	public AL_Examination_AS_EvaluationStaffEntry enter_emailId() {
		String generatedEmail = RandomStringUtils.randomAlphabetic(8);
		String randomEmail = generatedEmail+"@gmail.com";
		emailId_inputfield.sendKeys(randomEmail);
		return this;
	}
	
	public AL_Examination_AS_EvaluationStaffEntry enter_address() {
		address_inputfield.sendKeys("Address Details");
		return this;
	}
	public AL_Examination_AS_EvaluationStaffEntry click_submit_button() {
	System.out.println("Click on Submit Button");
	click(submit_button);
	return this;
	}
}
