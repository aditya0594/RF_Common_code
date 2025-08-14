package pojo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class DonwloadPDF{
	public WebDriver driver;
	// TODO Auto-generated constructor stub
	
	public DonwloadPDF(WebDriver driver) 
	{
		this.driver= driver;
	//	PageFactory.initElements(rdriver, this);

	}
	
public void clickBeforePDF() throws InterruptedException
{
	Thread.sleep (7000);
	Set<String>id=driver.getWindowHandles();
	Iterator<String> ids=id.iterator();
	String Parent=ids.next();
	String Child=ids.next();
	driver.switchTo().window(Child);
	Thread.sleep(7000);
	System.out.println("Files download successfully"); 
	Thread.sleep(1000); 
	driver.close() ;
	driver.switchTo().window(Parent);
	Thread.sleep (1000);

}}
