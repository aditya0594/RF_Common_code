package Stores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 extends BaseClass {
	
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(linkText = "Purchase Order Prepration")
    private WebElement purchaseOrderPreprationLink;

    @FindBy(id = "ctl00_ContentPlaceHolder1_radSelType_2")
    private WebElement directPurchaseOrderBtn;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnShowPanel")
    private WebElement showdetails;
    
    
    @FindBy(xpath = "(//a[normalize-space()='Order For DP/RC PO'])[1]")
    private WebElement dprcpo;
    
    @FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlInd-container")
    private WebElement indentnumselect;
    
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement indentnumsearch;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlVendor")
    private WebElement vendername;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtDtSendDPO")
    private WebElement dateofsending;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtSdateDPO")
    private WebElement supplybeforedate;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_id5")
    private WebElement termandcondition;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_chkSignatureAuthority_0")
    private WebElement signture;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
    private WebElement savepo;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_id8")
    private WebElement poOrderLockLink;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lstPOForLock")
    private WebElement purchaseServiceOrderDropdown;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnLock")
    private WebElement poServiceOrderBtn;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlAppUser")
    private WebElement authorityDropdown;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnAppSubmit")
    private WebElement addAuthorityBtn;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnCreateApp")
    private WebElement submitBtn;

    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_PurchaseOrderPrepration() throws Exception {
        System.out.println("Click on Purchase Order Prepration");
        js.executeScript("arguments[0].scrollIntoView();", purchaseOrderPreprationLink);
        threadWait1();
        js.executeScript("arguments[0].click();", purchaseOrderPreprationLink);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_DirectPurchaseOrderBtn() throws Exception {
        System.out.println("Click on Direct Purchase Order button");
        js.executeScript("arguments[0].scrollIntoView();", directPurchaseOrderBtn);
        threadWait1();
        js.executeScript("arguments[0].click();", directPurchaseOrderBtn);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_ShowDetailsBtn() throws Exception {
        System.out.println("Click on Show Details Btn");
//        js.executeScript("arguments[0].scrollIntoView();", dprcpo);
        js.executeScript("arguments[0].click();", showdetails);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_OrderForDPRCPO() throws Exception {
        System.out.println("Click on Order For DP RC PO button");
//        js.executeScript("arguments[0].scrollIntoView();", dprcpo);
        js.executeScript("arguments[0].click();", dprcpo);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Select_IndentNumber() throws Exception {
        System.out.println("Select Indent Number -> BSACIST/MAIN STORE/2025/06/IND180");
        indentnumselect.click();
        threadWait1();
        indentnumsearch.sendKeys(Keys.ARROW_DOWN);
        indentnumsearch.sendKeys(Keys.ENTER);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Select_VenderName() throws Exception {
        System.out.println("Select Vender Name -> A2S SUPPLY");
        Select select = new Select(vendername);
        select.selectByVisibleText("A2S SUPPLY");
        return this;
    }
    
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Enter_DateOfSending() throws Exception {
        System.out.println("Enter Date Of Sending (Current Date)");
        
        // Get current date
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(currentDate);
        
        System.out.println("Setting Date of Sending to current date: " + formattedDate);
        js.executeScript("arguments[0].value = arguments[1]", dateofsending, formattedDate);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Enter_SupplyBeforeDate() throws Exception {
        System.out.println("Enter Supply Before Date (Current Date + 3 days)");
        
        // Get current date and add 3 days
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        Date futureDate = calendar.getTime();
        
        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(futureDate);
        
        System.out.println("Setting Supply Before Date to current date + 3 days: " + formattedDate);
        js.executeScript("arguments[0].value = arguments[1]", supplybeforedate, formattedDate);
        return this;
    }
    
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_TermCondition() throws Exception {
        System.out.println("Click on Term and Condition");
        js.executeScript("arguments[0].scrollIntoView();", termandcondition);
        js.executeScript("arguments[0].click();", termandcondition);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_SignatureAuth() throws Exception {
        System.out.println("Click Signature Authority");
        js.executeScript("arguments[0].scrollIntoView();", signture);
        js.executeScript("arguments[0].click();", signture);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_SavePO() throws Exception {
        System.out.println("Click Save PO");
        js.executeScript("arguments[0].click();", savepo);
        
        // Handle alert
        Thread.sleep(3000); 
        Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Purchase/ Service Order Saved Successfully"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg, Expected_Msg);
        System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_POOrderLock() throws Exception {
        System.out.println("Click on PO Order Lock");
        js.executeScript("arguments[0].scrollIntoView();", poOrderLockLink);
        threadWait1();
        js.executeScript("arguments[0].click();", poOrderLockLink);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Select_PurchaseServiceOrder() throws Exception {
        System.out.println("Selecting purchase service order");
        js.executeScript("arguments[0].scrollIntoView();", purchaseServiceOrderDropdown);
        threadWait1();
        // Assuming we select the first option available
        Select purchaseServiceOrderSelect = new Select(purchaseServiceOrderDropdown);
        purchaseServiceOrderSelect.selectByIndex(1);
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_POServiceOrderBtn() throws Exception {
        System.out.println("Click on PO Service Order button");
        js.executeScript("arguments[0].scrollIntoView();", poServiceOrderBtn);
        threadWait1();
        js.executeScript("arguments[0].click();", poServiceOrderBtn);
        
        // Handle alert
        Thread.sleep(2000); 
        Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Are You Sure. You Want To Lock PO/ Service Order?"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg, Expected_Msg);
        System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
        alert.accept();
        
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Select_Authority() throws Exception {
        System.out.println("Selecting authority");
        js.executeScript("arguments[0].scrollIntoView();", authorityDropdown);
        threadWait1();
        Select authoritySelect = new Select(authorityDropdown);
        authoritySelect.selectByValue("1");
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_AddAuthorityBtn() throws Exception {
        System.out.println("Click on Add Authority button");
        js.executeScript("arguments[0].scrollIntoView();", addAuthorityBtn);
        threadWait1();
        js.executeScript("arguments[0].click();", addAuthorityBtn);
        
        // Handle alert
        Thread.sleep(2000); 
        Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Record Saved Successfully"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg, Expected_Msg);
        System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
        alert.accept();
       
        return this;
    }
    
    public AL_Stores_Trans_PurchaseOrderPreperationFlow04_4 Click_SubmitBtn() throws Exception {
        System.out.println("Click on Submit button");
        js.executeScript("arguments[0].scrollIntoView();", submitBtn);
        threadWait1();
        js.executeScript("arguments[0].click();", submitBtn);
        
        // Handle alert
        
        Thread.sleep(2000); 
        Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Authority Created and Purchase/ Service Order Locked Successfully"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg, Expected_Msg);
        System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
}
