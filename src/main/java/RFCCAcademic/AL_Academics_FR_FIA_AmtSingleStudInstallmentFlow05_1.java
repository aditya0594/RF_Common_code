package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 extends BaseClass{

	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC")
	private WebElement Academic;

	@FindBy(linkText = "Fee Related")
	private WebElement FeeRelated;

	@FindBy(id = "ctl00_repLinks_ctl20_lbLink")
	private WebElement FeeInstallmentAllotment;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblisintallmentconfig_0")
	private WebElement AmountwiseSingleStudnentFeeInstallment;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch")
	private WebElement SearchRRN;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch")
	private WebElement SearchButton;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")
	private WebElement StudentNameLink;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement Show;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRemove")
	private WebElement RemoveAllInstallment;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnsubmit")
	private WebElement Submit;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_grdinstalment_ctl03_btnAdd")
	private WebElement AddNewInstallment;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_grdinstalment_ctl02_txtDueDate")
	private WebElement InstallmentDue1;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_grdinstalment_ctl03_txtDueDate")
	private WebElement InstallmentDue2;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_grdinstalment_ctl02_txtAmount")
	private WebElement InstallmentAmt1;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_grdinstalment_ctl03_txtAmount")
	private WebElement InstallmentAmt2;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	Actions action = new Actions(driver);

	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 ClickAcademicTest() {
		System.out.println("Click on Academic menu");
		action.moveToElement(Academic).build().perform();
		return this;
	}

	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 ClickFeeRelatedTest() {
		System.out.println("Click Fee Related submenu");
		action.moveToElement(FeeRelated).click().build().perform();
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 ClickFeeInstallmentAllotmentTest() throws Exception {
		System.out.println("Click Fee Installment Allotment Page");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", FeeInstallmentAllotment);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", FeeInstallmentAllotment);
		return this;
	}

	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 AmountwiseSingleStudnentFeeInstallmentTabTest() {
		System.out.println("Click on AmountWise Single Student Fee Installment");
		if (!AmountwiseSingleStudnentFeeInstallment.isSelected())
		AmountwiseSingleStudnentFeeInstallment.click();
		return this;
	}

	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 SelectReceiptTypeTest() {
		System.out.println("Select Receipt Type -> ");

		WebElement receipt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReceiptType"));
		Select typ_receipt = new Select(receipt);
		typ_receipt.selectByVisibleText("Admission Fee");

		return this;
	}

	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 SelectSemesterTest() {
		System.out.println("Select Semester -> II");

		WebElement semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select typ_semester = new Select(semester);
		typ_semester.selectByVisibleText("II");

		return this;
	}
	
		
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 SearchRRNTest() {
		System.out.println("Search RRN No");
		SearchRRN.clear();
		SearchRRN.sendKeys("200011601006");
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 SearchButtonTest() {
		System.out.println("Click on Search");
		click(SearchButton);
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 ClickSubmitButtonTest() throws Throwable {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].scrollIntoView();", Submit);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Submit);

		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 ClickRemoveAllInstallmentButtonTest() throws Exception {
		System.out.println("Click on Remove all Installment Button");
		js.executeScript("arguments[0].scrollIntoView();", RemoveAllInstallment);
		Thread.sleep(2000);
		click(RemoveAllInstallment);
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 ClickShowButtonTest() {
		System.out.println("Click on Show Button");
		js.executeScript("arguments[0].scrollIntoView();",Show);

		click(Show);
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 ClickAddNewInstallmentButtonTest() {
		System.out.println("Click on Add New Installment Button");
		click(AddNewInstallment);
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 Installment1DueDateTest() {
		System.out.println("Select Installment 1 Due date");
		js.executeScript("arguments[0].value='29/11/2030';", InstallmentDue1);
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 Installment2DueDateTest() {
		System.out.println("Select Installment 2 Due date");
		js.executeScript("arguments[0].value='29/11/2031';", InstallmentDue2);
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 Installment1AmountTest() {
		System.out.println("Enter Installment 1 Amount => 75000");
		InstallmentAmt1.clear();
		InstallmentAmt1.sendKeys("75000");
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 Installment2AmountTest() {
		System.out.println("Enter Installment 2 Amount");
		InstallmentAmt2.clear();
		InstallmentAmt2.sendKeys("25000");
		return this;
	}
	
	public AL_Academics_FR_FIA_AmtSingleStudInstallmentFlow05_1 ClickStudentNameTest() {
		System.out.println("Click student Name Link");
		click(StudentNameLink);
		return this;
	}

}
