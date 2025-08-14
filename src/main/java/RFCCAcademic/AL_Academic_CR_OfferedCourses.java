package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_CR_OfferedCourses extends BaseClass {

	public AL_Academic_CR_OfferedCourses(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Coordinator Related")
	private WebElement CoOrdinatorRelated;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlClgname-container")
	private WebElement CollegeAndScheme;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container")
	private WebElement Session;

	@FindBy(xpath = "//span[@class='multiselect-selected-text']")
	private WebElement Semester;
	@FindBy(className = "checkbox")
	private WebElement CheckBoxA;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement ShowButton;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAd")
	private WebElement SubmitForOfferedCourse;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;
	
	Actions action = new Actions(driver);

	public AL_Academic_CR_OfferedCourses CollegeAndScheme() {
		System.out.println("CSA - B. Arch-Architecture-2015-16-Crescent School of Architecture (Old Scheme)");
		click(CollegeAndScheme);
		sendKeys(ddlSearchBox, "CSA - B. Arch-Architecture-2023-24-Crescent School of Architecture (New Scheme)");
		ddlSearchBox.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_CR_OfferedCourses Session() {
		System.out.println("2023-2024");
		click(Session);
		sendKeys(ddlSearchBox, "2023-2024");
		ddlSearchBox.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_CR_OfferedCourses Semester() {
		System.out.println("checkbox");
		click(Semester);
		driver.findElement(By.className("checkbox")).click();
		return this;
	}

	public AL_Academic_CR_OfferedCourses ShowButton() {
		//////// Click on Search button because when click on semester then showBtn over
		//////// shadow
		//driver.findElement(By.xpath("//input[@class='live-search-box']")).click();
		System.out.println("ShowButton"); 
		click(ShowButton);
		return this;
	}

	public AL_Academic_CR_OfferedCourses ElectiveIntakeCourseList() {
		System.out.println("CheckBoxA");
		click(CheckBoxA);
		return this;
	}

	public AL_Academic_CR_OfferedCourses SubmitForOfferedCourse() {
		System.out.println("SubmitForOfferedCourse");
		click(SubmitForOfferedCourse);
		return this;
	}
	
	public AL_Academic_CR_OfferedCourses ACADEMIC() 
	{
		System.out.println("Click on Academic");
		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Academic_CR_OfferedCourses ClickCordinatorRelatedTest() {
		System.out.println("Click Coordinator Related submenu");
		action.moveToElement(CoOrdinatorRelated).click().build().perform();
		return this;
	}

}
