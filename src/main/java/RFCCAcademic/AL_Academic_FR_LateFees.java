package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_LateFees extends BaseClass{

	public AL_Academic_FR_LateFees(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl07_lbLink") private WebElement lateFees_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReceiptType") private WebElement receiptType_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ChkCollegeList_0") private WebElement school_Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_chkSemester") private WebElement semester_Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_chkDegree") private WebElement degree_checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_gvLateFees_ctl02_chkFixed") private WebElement isFixed_Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_gvLateFees_ctl02_txtDayNoFrom") private WebElement fromDate_Inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_gvLateFees_ctl02_txtDayNoTo") private WebElement toDate_Inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement lastDateForFees_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_gvLateFees_ctl02_txtFees") private WebElement LateFeesAmount_Inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnChargeLateFee") private WebElement lateFeesCharge_Button;


	JavascriptExecutor js = (JavascriptExecutor)driver;

	public AL_Academic_FR_LateFees click_LateFees() {
		click(lateFees_Link);
		System.out.println("Click on LATE FEES from sub menu");
		return this;
	}

	public AL_Academic_FR_LateFees select_ReceiptType() {
		//WebElement ReceiptType = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReceiptType"));
		Select Receipt = new Select(receiptType_Dropdown);
		Receipt.selectByVisibleText("Admission Fee");
		System.out.println("Select Receipt Type : Admission Fee");
		return this;
	}

	public AL_Academic_FR_LateFees select_Session() {
		//WebElement Session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select Sess = new Select(session_Dropdown);
		Sess.selectByVisibleText("2023-2024");
		System.out.println("Select Session : 2023-2024");
		return this;
	}

	public AL_Academic_FR_LateFees select_School() {
		//Select Institute
		click(school_Checkbox);
		System.out.println("Select Institute : Crescent School of Architecture");

		return this;
	}

	public AL_Academic_FR_LateFees select_Semester() {		
		click(semester_Checkbox);
		System.out.println("Click on Check Box of All Semester");
		return this;
	}

	public AL_Academic_FR_LateFees select_Degree() {
		if(!degree_checkbox.isSelected())
			js.executeScript("arguments[0].click();",degree_checkbox );
		System.out.println("Click on Check Box of All Degree");
		return this;
	}

	public AL_Academic_FR_LateFees select_Date() {
		js.executeScript("arguments[0].value = arguments[1]",lastDateForFees_inputfield, "13/02/2024");
		System.out.println("Selected Date is: 13/02/2024");
		return this;		
	}
	public AL_Academic_FR_LateFees click_IsFixed() {
		//WebElement chkbxisfixed = driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvLateFees_ctl02_chkFixed"));
		if(!isFixed_Checkbox.isSelected())
			js.executeScript("arguments[0].click();",isFixed_Checkbox );
		System.out.println("Click on Check Box of IsFixed");
		return this;
	}
	public AL_Academic_FR_LateFees enter_DayFrom() {
		//WebElement txt_dayfrm = driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvLateFees_ctl02_txtDayNoFrom"));
		sendKeys(fromDate_Inputfield,"1");
		System.out.println("Enter Day From - 1");
		return this;
	}
	public AL_Academic_FR_LateFees enter_DayTo() {
		//WebElement txt_dayto = driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvLateFees_ctl02_txtDayNoTo"));
		sendKeys(toDate_Inputfield,"5");
		System.out.println("Enter Day to - 5");
		return this;
	}
	public AL_Academic_FR_LateFees enter_Amount() {
		sendKeys(LateFeesAmount_Inputfield,"50");
		System.out.println("Enter Amount - 50");
		return this;
	}
	public AL_Academic_FR_LateFees click_lastFeesCharge_Button() {
		js.executeScript("arguments[0].scrollIntoView(true);", LateFeesAmount_Inputfield);
		lateFeesCharge_Button.click();
		System.out.println("Click on Charge Late Fee Button");
		return this;
	}
}
