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

public class AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 extends BaseClass{

	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2(WebDriver rdriver) {
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
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	Actions action = new Actions(driver);

	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 ClickAcademicTest() {
		System.out.println("Click on Academic menu");
		action.moveToElement(Academic).build().perform();
		return this;
	}

	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 ClickFeeRelatedTest() {
		System.out.println("Click Fee Related submenu");
		action.moveToElement(FeeRelated).click().build().perform();
		return this;
	}
	
	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 ClickFeeInstallmentAllotmentTest() throws Exception {
		System.out.println("Click Fee Installment Allotment Page");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", FeeInstallmentAllotment);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", FeeInstallmentAllotment);
		return this;
	}

	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 AmountwiseSingleStudnentFeeInstallmentTabTest() {
		System.out.println("Click on AmountWise Single Student Fee Installment");
		if (!AmountwiseSingleStudnentFeeInstallment.isSelected())
		AmountwiseSingleStudnentFeeInstallment.click();
		return this;
	}

	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 SelectReceiptTypeTest() {
		System.out.println("Select Receipt Type -> ");

		WebElement receipt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReceiptType"));
		Select typ_receipt = new Select(receipt);
		typ_receipt.selectByVisibleText("Admission Fee");

		return this;
	}

	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 SelectSemesterTest() {
		System.out.println("Select Semester -> II");

		WebElement semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select typ_semester = new Select(semester);
		typ_semester.selectByVisibleText("II");

		return this;
	}
	
		
	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 SearchRRNTest() {
		System.out.println("Search RRN No");
		SearchRRN.clear();
		SearchRRN.sendKeys("200011601006");
		return this;
	}
	
	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 SearchButtonTest() {
		System.out.println("Click on Search");
		click(SearchButton);
		return this;
	}
	
	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 ClickSubmitButtonTest() throws Throwable {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].scrollIntoView();", Submit);
		Thread.sleep(2000);
		click(Submit);
		return this;
	}
	
	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 ClickRemoveAllInstallmentButtonTest() throws Exception {
		System.out.println("Click on Remove all Installment Button");
		js.executeScript("arguments[0].scrollIntoView();", RemoveAllInstallment);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", RemoveAllInstallment);

		return this;
	}
	
	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 ClickShowButtonTest() {
		System.out.println("Click on Show Button");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block : 'center'});", Show);
		click(Show);
		return this;
	}
	
	public AL_Academics_FR_FIA_CancelAmtSingleStudInstallmentFlow05_2 ClickStudentNameTest() {
		System.out.println("Click student Name Link");
		click(StudentNameLink);
		return this;
	}
}
