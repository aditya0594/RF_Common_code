package Stores;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_RequisitionApprovalFlow04_2 extends BaseClass {
	
    public AL_Stores_Trans_RequisitionApprovalFlow04_2(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(linkText = "Requisition Approval")
    private WebElement requisitionApprovalLink;

    @FindBy(xpath = "//div[@id='DataTables_Table_0_filter']//input")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='table-responsive']//input[@type='image']")
    private WebElement editButton;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
    private WebElement submitBtn;

    public AL_Stores_Trans_RequisitionApprovalFlow04_2 Click_RequisitionApproval() throws Exception {
        System.out.println("Click on Requisition Approval");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", requisitionApprovalLink);
        threadWait1();
        js.executeScript("arguments[0].click();", requisitionApprovalLink);
        return this;
    }
    
    public AL_Stores_Trans_RequisitionApprovalFlow04_2 Search_RequisitionSlipNo() throws Exception {
        System.out.println("Enter Requisition Slip number in search bar");
        try {
            // Get the stored Requisition Slip No. from Excel
            String requisitionSlipNo = TestDataExcelUtil.readData("RequisitionSlipNo");
            
            System.out.println("Enter Requisition Slip No. in search field: " + requisitionSlipNo);
            threadWait1();
            sendKeys(searchField, requisitionSlipNo);
        } catch (IOException e) {
            System.out.println("Error reading Requisition Slip No. from Excel: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }
    
    // New method that accepts a requisition slip number parameter
    public AL_Stores_Trans_RequisitionApprovalFlow04_2 Search_RequisitionSlipNo(String requisitionSlipNo) throws Exception {
        System.out.println("Enter Requisition Slip number in search bar: " + requisitionSlipNo);
        threadWait1();
        sendKeys(searchField, requisitionSlipNo);
        return this;
    }

    public AL_Stores_Trans_RequisitionApprovalFlow04_2 Click_EditButton() throws Exception {
        System.out.println("Click on Edit Button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", editButton);
        threadWait1();
        js.executeScript("arguments[0].click();", editButton);
        return this;
    }

    public AL_Stores_Trans_RequisitionApprovalFlow04_2 Click_SubmitButton() throws Exception {
        System.out.println("Click on Submit Button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", submitBtn);
        threadWait1();
        js.executeScript("arguments[0].click();", submitBtn);
        return this;
    }
}
