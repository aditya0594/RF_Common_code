package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Stores_Trans_DeadStockEntry extends BaseClass {
    
    public AL_Stores_Trans_DeadStockEntry(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(linkText = "Dead Stock Entry")
    private WebElement deadStockEntryLink;

    @FindBy(xpath = "//input[@title='Edit']")
    private WebElement editButton;

    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
    private WebElement submitButton;
    
    @FindBy(id = "select2-ctl00_ContentPlaceHolder1_lvitems_ctrl0_ddlStoreName-container")
    private WebElement clickStoreName;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchStorename;
    
    
    /**
     * Click on Dead Stock Entry link
     * 
     * @return instance of AL_Stores_Trans_DeadStockEntry
     * @throws Exception
     */
    public AL_Stores_Trans_DeadStockEntry Click_DeadStockEntry() throws Exception {
        System.out.println("Click on Dead Stock Entry");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", deadStockEntryLink);
        threadWait1();
        js.executeScript("arguments[0].click();", deadStockEntryLink);
        return this;
    }

    /**
     * Click on Edit button
     * 
     * @return instance of AL_Stores_Trans_DeadStockEntry
     * @throws Exception
     */
    public AL_Stores_Trans_DeadStockEntry Click_EditButton() throws Exception {
        System.out.println("Click on Edit Button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", editButton);
        threadWait1();
        js.executeScript("arguments[0].click();", editButton);
        return this;
    }
    
    public AL_Stores_Trans_DeadStockEntry Select_StoreName() throws Exception {
        System.out.println("Select Store Name");
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        clickStoreName.click();
        threadWait1();
        searchStorename.sendKeys(Keys.ARROW_DOWN.ENTER);
        return this;
    }

    public AL_Stores_Trans_DeadStockEntry Click_SubmitButton() throws Exception {
        System.out.println("Click on Submit Button");
        threadWait1();
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        threadWait1();
        js.executeScript("arguments[0].click();", submitButton);
        
        return this;
    }
}
