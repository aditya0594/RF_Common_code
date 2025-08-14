package Stores;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Trans_ItemSale_Flow01_1 extends BaseClass {
    public AL_Stores_Trans_ItemSale_Flow01_1(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    String trNumber="";
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(linkText = "Item Sale")
    private WebElement itemSaleLink;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnAddN")
    private WebElement addNewButton;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlItemType")
    private WebElement itemTypeDropdown;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubCategory")
    private WebElement subCategoryDropdown;

    @FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlItem-container")
    private WebElement itemselectClick;
    
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchfield;
    
//    @FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlItem-container")
//    private WebElement itemselectClick;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate")
    private WebElement saleDateField;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlVendorName")
    private WebElement vendorNameDropdown;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
    private WebElement showButton;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered nowrap']//input")
    private WebElement checkBox;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd")
    private WebElement addButton;

    @FindBy(id = "ctl00_ContentPlaceHolder1_lvItemSale_ctrl0_lblSaleValue")
    private WebElement saleValueField;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//label[contains(text(),'Item Sale TR NO.')]/following::input[1]")
    private WebElement itemSaleTRNoField;

    
    public AL_Stores_Trans_ItemSale_Flow01_1 Click_ItemSale() throws Exception {
        System.out.println("Click on Item Sale");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", itemSaleLink);
        threadWait1();
        js.executeScript("arguments[0].click();", itemSaleLink);
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Click_AddNewButton() throws Exception {
        System.out.println("Click on Add New button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", addNewButton);
        threadWait1();
        js.executeScript("arguments[0].click();", addNewButton);
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Select_ItemType() throws Exception {
        System.out.println("Select Item Type ==> ALL");
        threadWait1();
        Select select = new Select(itemTypeDropdown);
        select.selectByVisibleText("ALL");
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Select_SubCategory() throws Exception {
        System.out.println("Select SubCategory ==> ELECTRONIC");
        threadWait1();
        Select select = new Select(subCategoryDropdown);
        select.selectByVisibleText("ELECTRONIC");
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Select_Item() throws Exception {
        System.out.println("Select Item ==> FAN");
        itemselectClick.click();
        threadWait1();
        searchfield.sendKeys("FAN");
        searchfield.sendKeys(Keys.ENTER);
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Enter_SaleDate() throws Exception {
        System.out.println("Enter Item Sale Date ==> 07/04/2025");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.xpath("//i[@class='fa fa-calendar text-blue']"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_month_0_3"));
		month_select.click();  // month=April
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_day_0_5"));
		date_select.click();    // day=4


        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Select_VendorName() throws Exception {
        System.out.println("Select Vendor Name ==> VENKYS");
        threadWait1();
        Select select = new Select(vendorNameDropdown);
        select.selectByVisibleText("VENKYS");
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Click_ShowButton() throws Exception {
        System.out.println("Click on Show Button");
        threadWait1();
//        js.executeScript("arguments[0].scrollIntoView();", showButton);
        threadWait1();
        js.executeScript("arguments[0].click();", showButton);
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Click_CheckBox() throws Exception {
        System.out.println("Click on Check Box");
        threadWait1();
//        js.executeScript("arguments[0].scrollIntoView();", checkBox);
        threadWait1();
        js.executeScript("arguments[0].click();", checkBox);
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Click_AddButton() throws Exception {
        System.out.println("Click on Add Button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", addButton);
        threadWait1();
        js.executeScript("arguments[0].click();", addButton);
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Enter_SaleValue() throws Exception {
        System.out.println("Enter Sale Value ==> 0.30");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", saleValueField);
        clearText(saleValueField);
        sendKeys(saleValueField, "0.30");
        return this;
    }

    public AL_Stores_Trans_ItemSale_Flow01_1 Click_SaveButton() throws Exception {
        System.out.println("Click on Save Button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", saveButton);
        threadWait1();
        js.executeScript("arguments[0].click();", saveButton); 
        return this;
    }
    
    /**
     * Method to get the text from Item Sale TR NO. field
     * @return String - The text in the Item Sale TR NO. field
     */
    public String getItemSaleTRNumber() {
        try {
            System.out.println("Getting Item Sale TR NO.");
            threadWait1();
            // Get text using JavascriptExecutor
            String trNumber = (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].value;", itemSaleTRNoField);
            
            System.out.println("Item Sale TR NO.: " + trNumber);
            return trNumber;
        } catch (Exception e) {
            System.out.println("Exception while getting Item Sale TR NO.: " + e.getMessage());
            return null;
        }
    }
    
}
