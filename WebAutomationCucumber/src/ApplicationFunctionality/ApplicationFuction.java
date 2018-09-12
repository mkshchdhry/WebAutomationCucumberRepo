package ApplicationFunctionality;

import java.io.File;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

public class ApplicationFuction 
{
	public static WebDriver driver = null;
	public static WebDriver CreateChromeDriverObject(String url) throws Exception
	{
		System.out.println("*****Entering into CreateChromeDriverObject");
		System.out.println("Executing...");
		System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath()+"\\RequiredFile\\ChromeDriver\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
		Thread.sleep(3000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from CreateChromeDriverObject");
		return driver;
	}
	
	public static void DestroyAnyDriverObject(WebDriver driver)
	{
		System.out.println("*****Entering into DestroyAnyDriverObject");
		System.out.println("Executing...");
		driver.close();
		driver.quit();
		System.out.println("Executed...");
		System.out.println("*****Exiting from DestroyAnyDriverObject");
	}
	
	public static void NavigateToSignInpage(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into NavigateToSignInpage");
		System.out.println("Executing...");	
		HighLightElementAndPerformAction(driver,"//a[contains(text(),'Sign in')]");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from NavigateToSignInpage");
	}
	
	public static void SignInToWebsite(WebDriver driver, String username, String password) throws Exception 
	{
		System.out.println("*****Entering into SignInToWebsite");
		System.out.println("Executing...");
		HighLightElementAndEnterInput(driver,"//INPUT[@id='email']","someone@example.com");
		Thread.sleep(2000);
		HighLightElementAndEnterInput(driver,"//INPUT[@id='passwd']","Password123");
		Thread.sleep(2000);
		HighLightElementAndPerformAction(driver,"//BUTTON[@id='SubmitLogin']");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from SignInToWebsite");
	}

	public static void HighLightElementAndEnterInput(WebDriver driver, String elementXPath, String inputValue)
	{
		WebElement ele = driver.findElement(By.xpath(elementXPath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		ele.clear();
		ele.sendKeys(inputValue);
	}
	
	public static void HighLightElementAndPerformAction(WebDriver driver, String elementXPath) throws Exception
	{
		WebElement ele = driver.findElement(By.xpath(elementXPath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		ele.click();
	}

	public static void HighLightElementAndValidateConfirmationMessage(WebDriver driver, String elementXPath, String message, String displayMessage) throws Exception 
	{
		WebElement ele = driver.findElement(By.xpath(elementXPath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		if(message.equalsIgnoreCase(ele.getText().trim()))
			System.out.println(displayMessage+" had been Validated Successfully.");
		else
			{
				System.out.println(displayMessage+" had not been Validated.");
				throw new ValidationException(displayMessage+" had not been Validated.");
			}
	}

	public static void HighLightElementAndValidateInputText(WebDriver driver, String elementXPath, String message, String displayMessage) throws Exception 
	{
		WebElement ele = driver.findElement(By.xpath(elementXPath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		if(message.equalsIgnoreCase(ele.getAttribute("value")))
			System.out.println(displayMessage+" had been Validated Successfully.");
		else
			{
				System.out.println(displayMessage+" had not been Validated.");
				throw new ValidationException(displayMessage+" had not been Validated.");
			}
	}

	public static void SearchProduct(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into SearchProduct");
		System.out.println("Executing...");
		HighLightElementAndPerformAction(driver,"//div[@id='block_top_menu']/ul/li[3]/a");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from SearchProduct");
	}

	public static void AddProductToCart(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into AddProductToCart");
		System.out.println("Executing...");
		WebElement element = driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//SPAN[text()='More']")).click();
        Thread.sleep(2000);
        
        HighLightElementAndPerformAction(driver,"//SPAN[text()='Add to cart']");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from AddProductToCart");
	}
	
	public static void CheckoutAfterAddingProduct(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into CheckoutAfterAddingProduct");
		System.out.println("Executing...");
		HighLightElementAndPerformAction(driver,"//a[@title='Proceed to checkout']");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from CheckoutAfterAddingProduct");
	}
	
	public static void PlaceOrderPart1(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into PlaceOrderPart1 - Summary Tab");
		System.out.println("Executing...");
		// Clicking on "Proceed to checkout" on Summary Tab 
		HighLightElementAndPerformAction(driver,"//a[@title='Proceed to checkout'][@class='button btn btn-default standard-checkout button-medium']");
		Thread.sleep(2000);	
		System.out.println("Executed...");
		System.out.println("*****Exiting from PlaceOrderPart1 - Summary Tab");
	}
	
	public static void PlaceOrderPart2(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into PlaceOrderPart2 - Address Tab");
		System.out.println("Executing...");
		//Enter Additional Message in Address tab
		HighLightElementAndEnterInput(driver,"//textarea[@name='message']","T-shirt should be as per image");
		Thread.sleep(2000);
		
		// Clicking on "Proceed to checkout" on Address Tab 
		HighLightElementAndPerformAction(driver,"//button[@name='processAddress']");
		Thread.sleep(2000);	
		System.out.println("Executed...");
		System.out.println("*****Exiting from PlaceOrderPart2 - Address Tab");
	}
	
	public static void PlaceOrderPart3(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into PlaceOrderPart3 - Shipping Tab");
		System.out.println("Executing...");
		// Selecting on "Service of Term" on Shipping Tab 
		HighLightElementAndPerformAction(driver,"//input[@id='cgv']");
		Thread.sleep(2000);
		
		// Clicking on "Proceed to checkout" on Shipping Tab
		HighLightElementAndPerformAction(driver,"//button[@name='processCarrier']");
		Thread.sleep(2000);	
		System.out.println("Executed...");
		System.out.println("*****Exiting from PlaceOrderPart3 - Shipping Tab");
	}
	
	public static void PlaceOrderPart4(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into PlaceOrderPart4 - Payment tab");
		System.out.println("Executing...");
		// Clicking on "Pay by bank wire" on Payment Tab 
		HighLightElementAndPerformAction(driver,"//A[@class='bankwire']");
		Thread.sleep(2000);	
		System.out.println("Executed...");
		System.out.println("*****Exiting from PlaceOrderPart4 - Payment tab");
	}

	public static void PlaceOrderPart5(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into PlaceOrderPart5 - Payment tab: I Confirm");
		System.out.println("Executing...");
		// Clicking on "I confirm my order" on Payment Tab 
		HighLightElementAndPerformAction(driver,"//p[@id='cart_navigation']/button");
		Thread.sleep(2000);	
		System.out.println("Executed...");
		System.out.println("*****Exiting from PlaceOrderPart5 - Payment tab: I Confirm");
	}

	public static void ValidateOrderConfirmationAfterPlcingOrder(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into ValidateOrderConfirmationAfterPlcingOrder");
		System.out.println("Executing...");
		//Validate "ORDER CONFIRMATION" label.
		HighLightElementAndValidateConfirmationMessage(driver,"//H1[@class='page-heading']","ORDER CONFIRMATION","Order Confirmation Message");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from ValidateOrderConfirmationAfterPlcingOrder");
	}

	public static String GetOrderNumber(WebDriver driver) 
	{
		System.out.println("*****Entering into GetOrderNumber");
		System.out.println("Executing...");
		WebElement ele = driver.findElement(By.xpath("//div[@id='center_column']/div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		String ConfirmMessage =ele.getText();
		String[] splitMessage = ConfirmMessage.split(" ");
		System.out.println("Order Ref Number => "+splitMessage[Arrays.asList(splitMessage).indexOf("reference")+1]);
		System.out.println("Executed...");
		System.out.println("*****Exiting from GetOrderNumber");
		return splitMessage[Arrays.asList(splitMessage).indexOf("reference")+1];
		
	}
	
	public static void NavigateToOrderHistorySection(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into NavigateToOrderHistorySection");
		System.out.println("Executing...");
		// Clicking on "Return to Home" option
		HighLightElementAndPerformAction(driver,"//a[@title='Return to Home']");
		Thread.sleep(2000);
		
		// Clicking on "View my customer account" option
		HighLightElementAndPerformAction(driver,"//a[@title='View my customer account']");
		Thread.sleep(2000);
		
		// Clicking on "Orders" option
		HighLightElementAndPerformAction(driver,"//a[@title='Orders']");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from NavigateToOrderHistorySection");
	}
	
	public static void ValidateOrderInOrderHistory(WebDriver driver, String orderNum) throws Exception 
	{
		System.out.println("*****Entering into ValidateOrderInOrderHistory");
		System.out.println("Executing...");
		//Validate Created Order in Order History.
		HighLightElementAndValidateConfirmationMessage(driver,"//table[@id=\"order-list\"]/tbody/tr[1]/td[1]/a",orderNum.trim(),"Order in Order History");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from ValidateOrderInOrderHistory");
	}
	
	public static void SignOutFromWebsite(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into SignOutFromWebsite");
		System.out.println("Executing...");
		HighLightElementAndPerformAction(driver,"//a[contains(text(),'Sign out')]");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from SignOutFromWebsite");
	}

	public static void NavigatePersonalInfoMyAccount(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into NavigatePersonalInfoMyAccount");
		System.out.println("Executing...");
		// Clicking on "View my customer account" option
		HighLightElementAndPerformAction(driver,"//a[@title='View my customer account']");
		Thread.sleep(2000);
				
		// Clicking on "Orders" option
		HighLightElementAndPerformAction(driver,"//a[@title='Information']");
		Thread.sleep(2000);
		
		//Validate "YOUR PERSONAL INFORMATION" label.
		HighLightElementAndValidateConfirmationMessage(driver,"//H1[@class='page-subheading']","YOUR PERSONAL INFORMATION","YOUR PERSONAL INFORMATION PAGE");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from NavigatePersonalInfoMyAccount");
	}

	public static void UpdatePersonalInfoMyAccount(WebDriver driver, String newFirstName, String password) throws Exception 
	{
		System.out.println("*****Entering into UpdatePersonalInfoMyAccount");
		System.out.println("Executing...");
		//Enter New First Name
		HighLightElementAndEnterInput(driver,"//input[@id='firstname']",newFirstName);
		Thread.sleep(2000);
				
		//Enter email address.
		HighLightElementAndEnterInput(driver,"//input[@id='old_passwd']",password);
		Thread.sleep(2000);
		
		// Clicking on "Save" option
		HighLightElementAndPerformAction(driver,"//button[@name='submitIdentity']");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from UpdatePersonalInfoMyAccount");
	}

	public static void ValidateConfirmationMessageForUpdation(WebDriver driver) throws Exception 
	{
		System.out.println("*****Entering into ValidateConfirmationMessageForUpdation");
		System.out.println("Executing...");
		//Validate Confirmation Message
		HighLightElementAndValidateConfirmationMessage(driver,"//p[@class='alert alert-success']","Your personal information has been successfully updated.","Confirmation Message for Personal infomation updation");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from ValidateConfirmationMessageForUpdation");
	}

	public static void ValidateUpdatedPersonalInfoMyAccount(WebDriver driver, String newFirstName) throws Exception 
	{
		System.out.println("*****Entering into ValidateUpdatedPersonalInfoMyAccount");
		System.out.println("Executing...");
		//Validate New First name.
		HighLightElementAndValidateInputText(driver,"//input[@id='firstname']",newFirstName,"Updated First Name under Personal infomation");
		Thread.sleep(2000);
		System.out.println("Executed...");
		System.out.println("*****Exiting from ValidateUpdatedPersonalInfoMyAccount");
	}
	
}
