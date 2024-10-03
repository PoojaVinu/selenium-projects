package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	// By payrollApplicationHeading=By.xpath("//h1[text()='Payroll Application']");
	@FindBy(xpath = "//h1[text()='Payroll Application']")
	WebElement payrollApplicationHeading;

	@FindBy(xpath = "//a[text()='Workers']")
	WebElement worker;

	public String getTextFromHeading() {
		String text = payrollApplicationHeading.getText();
		return text;
	}

	public void clickOnWorker() {
		worker.click();

	}

}
