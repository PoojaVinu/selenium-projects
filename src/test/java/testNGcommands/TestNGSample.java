package testNGcommands;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestNGSample {
  WebDriver driver=new ChromeDriver();
  @Test
  public void verifyLoginIsWorkingWithValidUser() {
	  WebElement userName=driver.findElement(By.id("loginform-username"));
	  userName.sendKeys("carol");
	  WebElement passWord=driver.findElement(By.id("loginform-password"));
	  passWord.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.name("login-button"));
	  login.click();
	  
	  WebElement homePageText=driver.findElement(By.xpath("//h1[text()='Payroll Application']"));
	  String actual=homePageText.getText();
	  System.out.println("The text from home page : " + actual);
	  
	  String expectedResult="PAYROLL APPLICATIONN";
	  
	  //Assert.assertEquals(actual, expectedResult);  //compare actual and expected hard assertion ,if it fails then execution fails and rest of the code will not execute
	  
	  SoftAssert softAssert=new SoftAssert();       //class for soft assertion
	  softAssert.assertEquals(actual, expectedResult);  //soft assertion
	  System.out.println("***********"); 
	  softAssert.assertAll();             //mandatory for soft assertion       
  }
  @BeforeMethod
  public void beforeMethod() {
	 
	  driver.get("https://www.qabible.in/payrollapp/site/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
   driver.close();
  }

}
