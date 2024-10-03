package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkerPage {
	public WorkerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(xpath ="//button[@class='btn btn-primary']")
	WebElement searchButton;
	
	public String getTextFromSearchButton() {
		String text=searchButton.getText();
		return text;
	}
	
	

}
