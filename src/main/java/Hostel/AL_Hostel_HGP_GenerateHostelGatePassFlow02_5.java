package Hostel;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_HGP_GenerateHostelGatePassFlow02_5 extends BaseClass 
{
	// Class variable to store gate pass number
	private String gatePassNum;
	
	@FindBy(linkText = "Generate Hostel Gate Pass") private WebElement generateHostelGatePass;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchBox;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//tr[1]//td[3]") private WebElement gatePassCell;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPass") private WebElement gatePassNumberInput;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch") private WebElement searchBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement gatePassReportBtn;
	
	public AL_Hostel_HGP_GenerateHostelGatePassFlow02_5(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Hostel_HGP_GenerateHostelGatePassFlow02_5 clickGenerateHostelGatePass() {
		System.out.println("Click on Generate Hostel Gate Pass");
		click(generateHostelGatePass);
		return this;
	}
	
	public AL_Hostel_HGP_GenerateHostelGatePassFlow02_5 enterCurrentDateInSearch() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String currentDate = dateFormat.format(new Date());
		System.out.println("Entering current date in search: " + currentDate);
		sendKeys(searchBox, currentDate);
//		sendKeys(searchBox, "MOHAMED FAISAL 18");
		return this;
	}
	
	public AL_Hostel_HGP_GenerateHostelGatePassFlow02_5 storeGatePassNumber() {
		System.out.println("Storing Gate Pass Number");
		gatePassNum = gatePassCell.getText();
		System.out.println("Gate Pass Number => " + gatePassNum);
		return this;
	}
	
	public AL_Hostel_HGP_GenerateHostelGatePassFlow02_5 enterStoredGatePassNumber() {
		System.out.println("Entering stored Gate Pass Number: " + gatePassNum);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]", gatePassNumberInput, gatePassNum);
		return this;
	}
	
	public AL_Hostel_HGP_GenerateHostelGatePassFlow02_5 clickSearchBtn() {
		System.out.println("Click on Search Button");
		click(searchBtn);
		return this;
	}
	
	public AL_Hostel_HGP_GenerateHostelGatePassFlow02_5 clickGatePassReportBtn() {
		System.out.println("Click on Gate Pass Report Button");
		click(gatePassReportBtn);
		return this;
	}
}
