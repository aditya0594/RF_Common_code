package Finance;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

/**
 * AL_Finance_CreateCompany class handles operations related to Company creation in Finance module
 */
public class AL_Finance_CreateCompany extends BaseClass {

    public AL_Finance_CreateCompany(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(linkText = "Create Company") private WebElement createCompanyLink;
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtCode") private WebElement codeInput;
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtName") private WebElement nameInput;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitButton;
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
    /**
     * Click on Create Company link
     * @return this instance for method chaining
     * @throws InterruptedException if thread is interrupted
     */
    public AL_Finance_CreateCompany clickCreateCompanyLink() throws InterruptedException {
        System.out.println("Click on Create Company link");
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", createCompanyLink);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", createCompanyLink);
        return this;
    }
    
    /**
     * Enter Company Code with hardcoded value
     * @return this instance for method chaining
     * @throws InterruptedException if thread is interrupted
     */
    public AL_Finance_CreateCompany enterCode() throws InterruptedException {
        String code = "MS-14";
        System.out.println("Enter Company Code ==> " + code);
        Thread.sleep(1000);
        codeInput.clear();
        codeInput.sendKeys(code);
        return this;
    }
    
    /**
     * Enter Company Name with hardcoded value
     * @return this instance for method chaining
     * @throws InterruptedException if thread is interrupted
     */
    public AL_Finance_CreateCompany enterName() throws InterruptedException {
        String name = "1990001 - MR.TAMIL SELVANR";
        System.out.println("Enter Company Name ==> " + name);
        Thread.sleep(1000);
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }
    
    /**
     * Click Submit button
     * @return this instance for method chaining
     * @throws InterruptedException if thread is interrupted
     */
    public AL_Finance_CreateCompany clickSubmitButton() throws InterruptedException {
        System.out.println("Click on Submit button");
        Thread.sleep(1000);
        click(submitButton);
        return this;
    }
    
    /**
     * Handle alert after form submission
     * @return this instance for method chaining
     * @throws InterruptedException if thread is interrupted
     */
    public AL_Finance_CreateCompany handleAlert() throws InterruptedException {
        System.out.println("Handling alert message");
        Thread.sleep(2000);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert message: " + alertText);
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present or error handling alert: " + e.getMessage());
        }
        return this;
    }
}
