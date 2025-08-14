package Stores;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import utility.TestDataExcelUtil;

public class AL_Stores_Trans_IndentPreparationFlow04_3 extends BaseClass {
	
    public AL_Stores_Trans_IndentPreparationFlow04_3(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(linkText = "Indent Prepration")
    private WebElement indentPreprationLink;

    @FindBy(id = "ctl00_ContentPlaceHolder1_chkDept")
    private WebElement departmentWiseCheckbox;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepts")
    private WebElement departmentDropdown;
    
    @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr//td//input")
    private WebElement showItemsButton;
    
    @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr//td//input[@type='checkbox']")
    private WebElement itemCheckbox;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd")
    private WebElement addButton;
    
    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_divItemList']//input")
    private WebElement quantityField;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnDivIDNext")
    private WebElement nextButton;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_rdbtnList_2")
    private WebElement directPORadioButton;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_Button1")
    private WebElement saveIndentButton;
    
    // New elements for requisition slip number functionality
    @FindBy(id = "ctl00_ContentPlaceHolder1_chkReqNo")
    private WebElement requisitionNumberCheckbox;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtReqNo")
    private WebElement requisitionNumberField;
    
    @FindBy(xpath = "//input[@class='form-control form-control-sm']")
    private WebElement searchSlipField;

    public AL_Stores_Trans_IndentPreparationFlow04_3 Click_IndentPrepration() throws Exception {
        System.out.println("Click on Indent Prepration");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", indentPreprationLink);
        threadWait1();
        js.executeScript("arguments[0].click();", indentPreprationLink);
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Click_DepartmentWiseCheckbox() throws Exception {
        System.out.println("Click on Department Wise checkbox");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", departmentWiseCheckbox);
        threadWait1();
        js.executeScript("arguments[0].click();", departmentWiseCheckbox);
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Select_Department() throws Exception {
        System.out.println("Selecting Information Technology from department dropdown");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", departmentDropdown);
        threadWait1();
        WebElement departmentfield = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDepts-container"));
        departmentfield.click();
        WebElement department_search = driver.findElement(By.xpath("//input[@role='textbox']"));
        department_search.sendKeys("Information Technology");
        department_search.sendKeys(Keys.ENTER);
       
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Click_ShowItems() throws Exception {
        System.out.println("Click on Show Items button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", showItemsButton);
        threadWait1();
        js.executeScript("arguments[0].click();", showItemsButton);
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Select_Item() throws Exception {
        System.out.println("Selecting item from the list");
        js.executeScript("arguments[0].scrollIntoView();", itemCheckbox);
        js.executeScript("arguments[0].click();", itemCheckbox);
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Click_AddButton() throws Exception {
        System.out.println("Click on Add button");
        js.executeScript("arguments[0].scrollIntoView();", addButton);
        js.executeScript("arguments[0].click();", addButton);
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Enter_Quantity() throws Exception {
        System.out.println("Entering quantity");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", quantityField);
        threadWait1();
        clearText(quantityField);
        threadWait1();
        sendKeys(quantityField, "1");
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Click_NextButton() throws Exception {
        System.out.println("Click on Next button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", nextButton);
        threadWait1();
        js.executeScript("arguments[0].click();", nextButton);
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Select_DirectPO() throws Exception {
        System.out.println("Selecting Direct PO option");
        js.executeScript("arguments[0].scrollIntoView();", directPORadioButton);
        threadWait1();
        js.executeScript("arguments[0].click();", directPORadioButton);
        return this;
    }
    
    public AL_Stores_Trans_IndentPreparationFlow04_3 Click_SaveIndent() throws Exception {
        System.out.println("Click on Save Indent button");
        js.executeScript("arguments[0].scrollIntoView();", saveIndentButton);
        threadWait1();
        js.executeScript("arguments[0].click();", saveIndentButton);
        return this;
    }
    
    /**
     * Click on requisition number checkbox to enable requisition slip number search
     * @return this object for method chaining
     */
    public AL_Stores_Trans_IndentPreparationFlow04_3 Click_RequisitionNumberCheckbox() throws Exception {
        System.out.println("Click on Requisition Number checkbox");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", requisitionNumberCheckbox);
        threadWait1();
        js.executeScript("arguments[0].click();", requisitionNumberCheckbox);
        return this;
    }
    
    /**
     * Enter requisition slip number in the field
     * @return this object for method chaining
     */
    public AL_Stores_Trans_IndentPreparationFlow04_3 Enter_RequisitionNumber() throws Exception {
        System.out.println("Enter Requisition Number");
        try {
            // Get requisition slip number from Excel
            String requisitionSlipNo = TestDataExcelUtil.readData("RequisitionSlipNumber");
            System.out.println("Using Requisition Slip No.: " + requisitionSlipNo + " from Excel");
            
            threadWait1();
            js.executeScript("arguments[0].scrollIntoView();", requisitionNumberField);
            threadWait1();
            sendKeys(requisitionNumberField, requisitionSlipNo);
        } catch (IOException e) {
            System.out.println("Error reading Requisition Slip No. from Excel: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }
    
    /**
     * Enter a specific requisition slip number in the field
     * @param requisitionSlipNo the requisition slip number to enter
     * @return this object for method chaining
     */
    public AL_Stores_Trans_IndentPreparationFlow04_3 Enter_RequisitionNumber(String requisitionSlipNo) throws Exception {
        System.out.println("Enter Requisition Number: " + requisitionSlipNo);
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", requisitionNumberField);
        threadWait1();
        sendKeys(requisitionNumberField, requisitionSlipNo);
        return this;
    }
    
    /**
     * Search by requisition slip number and select department
     * @return this object for method chaining
     */
    public AL_Stores_Trans_IndentPreparationFlow04_3 searchBySlipNo() throws Exception {
        System.out.println("Searching by Requisition Slip Number");
        try {
            // Get requisition slip number from Excel
            String requisitionSlipNo = TestDataExcelUtil.readData("RequisitionSlipNumber");
            return searchBySlipNo(requisitionSlipNo);
        } catch (IOException e) {
            System.out.println("Error reading Requisition Slip No. from Excel: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }
    
    /**
     * Search by a specific requisition slip number and select department
     * @param requisitionSlipNo the specific requisition slip number to search for
     * @return this object for method chaining
     */
    public AL_Stores_Trans_IndentPreparationFlow04_3 searchBySlipNo(String requisitionSlipNo) throws Exception {
        System.out.println("Searching for Requisition Slip No.: " + requisitionSlipNo);
        
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", searchSlipField);
        threadWait1();
        clearText(searchSlipField);
        threadWait1();
        sendKeys(searchSlipField, requisitionSlipNo);
        threadWait1();
        
        // Include department selection as requested
//        Select_Department();
        
        return this;
    }
}
