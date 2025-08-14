package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Academic_FR_FeesRefund extends BaseClass{

	public AL_Academic_FR_FeesRefund(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink") private WebElement feesRefund_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch") private WebElement rrnNo_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch") private WebElement search_button;
	@FindBy(linkText = "AADIL MUHAMMAD") private WebElement studentName_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAllCollections_ctrl0_btnRefund") private WebElement refund_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvFeeItems_ctrl0_txtFeeItemAmount") private WebElement tutuionfee;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvFeeItems_ctrl0_txtFeeItemAmount") private WebElement refundAmount_Inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRemark") private WebElement remark_inputfield;
	

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Academic_FR_FeesRefund click_feesRefund_link() {
		click(feesRefund_link);
		System.out.println("Click on Fees Refund from Sub menu   "); 
		return this;
	}
	public AL_Academic_FR_FeesRefund enter_RRNNo() {
		rrnNo_dropdown.sendKeys("201431601001");
		System.out.println("Enter RRN no. - 201431601001");
		return this;
	}
	public AL_Academic_FR_FeesRefund click_search_button() {
		js.executeScript("arguments[0].scrollIntoView();",search_button);
		js.executeScript("arguments[0].click();", search_button);
		System.out.println("Click on search button");
		return this;
	}
	public AL_Academic_FR_FeesRefund click_studentName() {
		click(studentName_link);
		System.out.println("Click on student name");
		return this;
	}
	public AL_Academic_FR_FeesRefund click_refund_button() {
		click(refund_button);
		System.out.println("Click on refund button");
		return this;
	}
	
	public AL_Academic_FR_FeesRefund Enter_TutionFee() {
		clearText(tutuionfee);
		sendKeys(tutuionfee, "90000");
		System.out.println("Enter Tution Fee");
		return this;
	}
	
	public AL_Academic_FR_FeesRefund enter_refundAmount() {
		refundAmount_Inputfield.sendKeys("89990.00");
		System.out.println("Enter Refund amount");
		return this;
	}
	
	public AL_Academic_FR_FeesRefund enter_remark() {
		remark_inputfield.sendKeys("@test");
		System.out.println("Enter Remark - @test");
		return this;
	}
	
	public AL_Academic_FR_FeesRefund click_submit_button() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submit_button); 
		js.executeScript("arguments[0].click();", submit_button);
		return this;
	}

}


