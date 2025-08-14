package Stores;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Stores_Trans_POApprovalFlow04_5 extends BaseClass {
    
    public AL_Stores_Trans_POApprovalFlow04_5(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Locators
    @FindBy(linkText = "PO Approval")
    private WebElement poApprovalLink;

    @FindBy(xpath = "//td[contains(text(),'BSACIST/MAIN STORE/2025/')]/parent::tr//td[contains(text(),'A2S SUPPLY')]/parent::tr//input[@type='checkbox']")
    private WebElement purchaseOrderCheckbox;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
    private WebElement submitBtn;
    
    /**
     * Click on PO Approval link
     * @return this object for method chaining
     */
    public AL_Stores_Trans_POApprovalFlow04_5 Click_POApproval() throws Exception {
        System.out.println("Click on PO Approval");
        js.executeScript("arguments[0].scrollIntoView();", poApprovalLink);
        threadWait1();
        js.executeScript("arguments[0].click();", poApprovalLink);
        return this;
    }
    
    /**
     * Click on Purchase Order Checkbox for PO132
     * @return this object for method chaining
     */
    public AL_Stores_Trans_POApprovalFlow04_5 Click_PurchaseOrderCheckbox() throws Exception {
        System.out.println("Clicking on Purchase Order Checkbox for PO132");
        js.executeScript("arguments[0].scrollIntoView();", purchaseOrderCheckbox);
        threadWait1();
        js.executeScript("arguments[0].click();", purchaseOrderCheckbox);
        return this;
    }
    
    /**
     * Click on Submit button
     * @return this object for method chaining
     */
    public AL_Stores_Trans_POApprovalFlow04_5 Click_SubmitBtn() throws Exception {
        System.out.println("Click on Submit button");
        js.executeScript("arguments[0].scrollIntoView();", submitBtn);
        threadWait1();
        js.executeScript("arguments[0].click();", submitBtn);
        
        // Handle alert
        try {
            Thread.sleep(2000); 
            Alert alert = driver.switchTo().alert();
            String expectedMsg = "PO Approved Successfully";
            String actualMsg = alert.getText();
            Assert.assertEquals(actualMsg, expectedMsg);
            System.out.println("Actual Message - " + actualMsg + "\n" + "Expected Message - " + expectedMsg);
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present or unexpected alert message: " + e.getMessage());
        }
        
        return this;
    }
}
