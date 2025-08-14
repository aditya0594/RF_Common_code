package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_FR_CancelReceiptFlow06_2 extends BaseClass{

	public AL_Academic_FR_CancelReceiptFlow06_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(id = "ctl00_repLinks_ctl10_lbLink") private WebElement reprintOrCancelReceipt_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch") private WebElement searchString_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch") private WebElement search_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId") private WebElement studentName_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReprint") private WebElement reprint_button;
	@FindBy(id = "rdoSelectRecord") private WebElement record_radioButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCancel") private WebElement cancel_button;



	public AL_Academic_FR_CancelReceiptFlow06_2 click_reprintOrCancelReceipt_link() {
		click(reprintOrCancelReceipt_link);
		System.out.println("Click on Reprint or Cancel receipt");
		return this;
	}
	public AL_Academic_FR_CancelReceiptFlow06_2 select_searchString() {
		System.out.println("Search String -> 200292601031");
		searchString_dropdown.clear();
		searchString_dropdown.sendKeys("200292601031");
		return this;
	}
	public AL_Academic_FR_CancelReceiptFlow06_2 click_search_button() {
		System.out.println("Click on Search Button");
		click(search_button);
		return this;
	}
	public AL_Academic_FR_CancelReceiptFlow06_2 click_studentName_link() {
		System.out.println("Click on Student List ->  MOHAMED ARSATH. S");  ////
		click(studentName_link);
		return this;
	}
	public AL_Academic_FR_CancelReceiptFlow06_2 click_reprint_button() {
		System.out.println("Scroll down till Reprint Receipt button visible");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", reprint_button);
		return this;
	}
	public AL_Academic_FR_CancelReceiptFlow06_2 click_record_radioButton() {
		click(record_radioButton);
		System.out.println("Select Receipt No. -> BSACIST/20-06-2022/O/7009");
		return this;
	}
	public AL_Academic_FR_CancelReceiptFlow06_2 click_cancel_button() {
		System.out.println("Click on Cancel Receipt button");
		click(cancel_button);
		return this;
	}

}
