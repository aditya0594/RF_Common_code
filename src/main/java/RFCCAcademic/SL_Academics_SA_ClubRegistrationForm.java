package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class SL_Academics_SA_ClubRegistrationForm extends BaseClass{

	public SL_Academics_SA_ClubRegistrationForm(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC")
	private WebElement Academic;

	@FindBy(linkText = "Student Achievement")
	private WebElement StudentAchievement;

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink")
	private WebElement ClubRegistrationForm;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submit;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	Actions action = new Actions(driver);

	public SL_Academics_SA_ClubRegistrationForm ClickAcademicTest() {
		System.out.println("Click on Academic menu");
		action.moveToElement(Academic).build().perform();
		return this;
	}

	public SL_Academics_SA_ClubRegistrationForm ClickStudentAchievementTest() {
		System.out.println("Click Student Achievement submenu");
		action.moveToElement(StudentAchievement).click().build().perform();
		return this;
	}

	public SL_Academics_SA_ClubRegistrationForm ClickClubRegistrationFormTest() {
		System.out.println("Click on Club Registration Form");
		ClubRegistrationForm.click();
		return this;
	}

	public SL_Academics_SA_ClubRegistrationForm SelectClubTest() throws Exception {
		System.out.println("Select Club");

		WebElement club = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlclub"));
		Select typ_club = new Select(club);
		
		Thread.sleep(1000);
		typ_club.selectByValue("1");
		
		Thread.sleep(1000);
		typ_club.selectByValue("2");
		
		Thread.sleep(1000);
		typ_club.selectByValue("3");

		return this;
	}

	public SL_Academics_SA_ClubRegistrationForm ClickSubmitButtonTest() {
		System.out.println("Click on Submit Button");
		click(Submit);
		return this;
	}
	
}
