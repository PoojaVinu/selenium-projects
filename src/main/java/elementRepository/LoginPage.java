package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {   //constructor
		this.driver=driver;
		PageFactory.initElements(driver, this); //in order initialize values in webElements
	}
	
	WebDriver driver;
	
	//By userName=By.id("loginform-username");   //without pagefactory
	@FindBy(id = "loginform-username")        //with pagefactory
	WebElement userName;
	
	//By passWord=By.id("loginform-password");
	@FindBy(id ="loginform-password")
	WebElement passWord;
	
	//By loginButton=By.name("login-button");
	@FindBy(name = "login-button")
	WebElement loginButton;
	
	
	public void inputUserName() {
		//driver.findElement(userName).sendKeys("carol");  //no need of driver in pagefactory
		userName.sendKeys("carol");
	}
	public void inputPassword() {
		//driver.findElement(passWord).sendKeys("1q2w3e4r");
		passWord.sendKeys("1q2w3e4r");
	}
	public void clickLoginButton() {
		//driver.findElement(loginButton).click();
		loginButton.click();
	}
			

}
