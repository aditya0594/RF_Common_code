package Stores;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_ItemSaleApproval_Flow01_2 extends BaseClass {
	
    public AL_Stores_Trans_ItemSaleApproval_Flow01_2(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    AL_Stores_Trans_ItemSale_Flow01_1 itemsale = new AL_Stores_Trans_ItemSale_Flow01_1(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(linkText = "Item Sale Approval")
    private WebElement itemSaleApprovalLink;

    @FindBy(xpath = "//input[@class='form-control form-control-sm']")
    private WebElement dateField;

    @FindBy(xpath = "//input[@value='Select']")
    private WebElement selectButton;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnApprove")
    private WebElement savebtn;

    public AL_Stores_Trans_ItemSaleApproval_Flow01_2 Click_ItemSaleApproval() throws Exception {
        System.out.println("Click on Item Sale Approval");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", itemSaleApprovalLink);
        threadWait1();
        js.executeScript("arguments[0].click();", itemSaleApprovalLink);
        return this;
    }
    
    
    public AL_Stores_Trans_ItemSaleApproval_Flow01_2 Search_TRno() throws Exception {
        System.out.println("Enter TR number in search bar");
        try {
            // Get the stored Item Sale TR NO. from Excel
            String savedItemSaleTRNo = TestDataExcelUtil.readData("ItemSaleTRNo");
            
            System.out.println("Enter Item Sale TR NO. in search field: " + savedItemSaleTRNo);
            threadWait1();
            clearText(dateField);
            threadWait1();
            sendKeys(dateField, savedItemSaleTRNo);
        } catch (IOException e) {
            System.out.println("Error reading Item Sale TR NO. from Excel: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }

    public AL_Stores_Trans_ItemSaleApproval_Flow01_2 Click_SelectButton() throws Exception {
        System.out.println("Click on Select Button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", selectButton);
        threadWait1();
        js.executeScript("arguments[0].click();", selectButton);
        return this;
    }

    public AL_Stores_Trans_ItemSaleApproval_Flow01_2 Click_SaveButton() throws Exception {
        System.out.println("Click on Save Button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", savebtn);
        threadWait1();
        js.executeScript("arguments[0].click();", savebtn);
        return this;
    }
}
