package testNGcommands;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestNGAssignment1 {
	
  WebDriver driver;
  
  @Test(enabled = true,priority = 1)
  public void verifyTextOfSearchButton() {
	  WebElement userName=driver.findElement(By.id("loginform-username"));
	  userName.sendKeys("carol");
	  WebElement passWord=driver.findElement(By.id("loginform-password"));
	  passWord.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.name("login-button"));
	  login.click();
	  
	  WebElement worker=driver.findElement(By.xpath("//a[text()='Workers']"));
	  worker.click();
	  WebElement searchButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	  searchButton.click();
	  String searchButtonText=searchButton.getText();
	  System.out.println("Search Button Text : " + searchButtonText);
	  
	  String searchButtonExpectedResult="Search";
	  
	  Assert.assertEquals(searchButtonText, searchButtonExpectedResult);
	  
  }
  
  @Test(priority = 2,retryAnalyzer = testNGcommands.RetryAnalyser.class)  //retry used in this test
  public void verifyFontSizeOfSearchButton() {
	  WebElement userName=driver.findElement(By.id("loginform-username"));
	  userName.sendKeys("carol");
	  WebElement passWord=driver.findElement(By.id("loginform-password"));
	  passWord.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.name("login-button"));
	  login.click();
	  
	  WebElement worker=driver.findElement(By.xpath("//a[text()='Workers']"));
	  worker.click();
	  WebElement searchButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	  String fontSizeOfSearchButton=searchButton.getCssValue("font-size");
	  System.out.println("Font size of Search Button : " + fontSizeOfSearchButton);
	  
	  String expectedFontSize="1px";
	  
	  SoftAssert softAssert=new SoftAssert();
	  softAssert.assertEquals(fontSizeOfSearchButton, expectedFontSize);
	  softAssert.assertAll();
  }
  
 
  @Test(enabled = false,priority = 3)
  public void verifyTitleDropDown() {
	  WebElement userName=driver.findElement(By.id("loginform-username"));
	  userName.sendKeys("carol");
	  WebElement passWord=driver.findElement(By.id("loginform-password"));
	  passWord.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.name("login-button"));
	  login.click();
	  
	  WebElement worker=driver.findElement(By.xpath("//a[text()='Workers']"));
	  worker.click();
	  WebElement createWorker=driver.findElement(By.xpath("//a[text()='Create Worker']"));
	  createWorker.click();
	
	  WebElement titleDropDown=driver.findElement(By.id("worker-title"));
	  Select select=new Select(titleDropDown);
	  select.selectByValue("Mrs");
	  WebElement selectedTitle= select.getFirstSelectedOption();
	  String actualSelectedTitle=selectedTitle.getText();
	  System.out.println("Actual Title :" + actualSelectedTitle);
	  
	  String expectedTitle="Mrs";
	  Assert.assertEquals(actualSelectedTitle, expectedTitle);
	  
 }
  
  @Test(enabled = false,priority = 4)
  public void verifyCheckBoxIsSelected() {
	  WebElement userName=driver.findElement(By.id("loginform-username"));
	  userName.sendKeys("carol");
	  WebElement passWord=driver.findElement(By.id("loginform-password"));
	  passWord.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.name("login-button"));
	  login.click();
	  
	  WebElement clients=driver.findElement(By.xpath("//a[@href='/payrollapp/client/index']"));
	  clients.click();
	  WebElement createClient=driver.findElement(By.xpath("//a[text()='Create Client']"));
	  createClient.click();
	  
	  WebElement checkBox=driver.findElement(By.id("client-require_po"));
	  checkBox.click();
	  Boolean checkActual=checkBox.isSelected();
	  System.out.println("Is the check box selected : " + checkActual);
	  
	  Boolean checkBoxExpected=true;
	  Assert.assertEquals(checkActual, checkBoxExpected);
	  
  }
  
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String n){
	  if(n.equals("chrome"))
	  {
		  driver=new ChromeDriver();  
	  }
	  else if(n.equals("edge"))
	  {
		  driver=new EdgeDriver();
	  }
	  else if(n.equals("firefox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  
	  driver.get("https://www.qabible.in/payrollapp/site/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
