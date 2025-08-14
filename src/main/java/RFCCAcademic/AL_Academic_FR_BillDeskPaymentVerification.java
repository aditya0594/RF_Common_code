package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_BillDeskPaymentVerification extends BaseClass
{
	@FindBy(linkText = "BillDesk Payment Verification/Query API") private WebElement billdeskverification;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlActivityName") private WebElement activityname;
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlCode") private WebElement receiptcode;

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtprnno") private WebElement rrnNo;
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;

    public AL_Academic_FR_BillDeskPaymentVerification(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
    public AL_Academic_FR_BillDeskPaymentVerification Click_BillDeskPaymentVerification() throws InterruptedException {
        System.out.println("Click on BillDesk Payment Verification/Query API");
        Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",billdeskverification);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", billdeskverification);

        return this;
    }
    
    public AL_Academic_FR_BillDeskPaymentVerification Select_ActivityName() throws InterruptedException {
       System.out.println("Select Activity Name => Exam Fee");
       Select select = new Select(activityname);
       select.selectByVisibleText("Exam Fee");
       return this;
    }
    
    public AL_Academic_FR_BillDeskPaymentVerification Select_ReceiptCode() throws InterruptedException {
        System.out.println("Select Receipt code Name => Examination Fees");
        Select select = new Select(receiptcode);
        select.selectByVisibleText("Examination Fees");
        return this;
     }
    
    public AL_Academic_FR_BillDeskPaymentVerification Enter_RRNNo() throws InterruptedException {
        System.out.println("Enter RRN NO => 200101601001");
        sendKeys(rrnNo, "200101601001");
        return this;
     }
    
    public AL_Academic_FR_BillDeskPaymentVerification Click_ShowBtn() throws InterruptedException {
        System.out.println("Click on Show btn");
        click(showbtn);
        return this;
     }
}
