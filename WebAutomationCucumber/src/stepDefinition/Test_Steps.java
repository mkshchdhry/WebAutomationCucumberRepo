package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import ApplicationFunctionality.*;
import cucumber.api.java.en.*;

public class Test_Steps 
{
	public static WebDriver driver = null;
	public static String orderRefNumber="";
	public static String url = "http://automationpractice.com";
	public static String username = "someone@example.com";
	public static String password = "Password123";
	public static String newFirstName="MukeshC";
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() 
	{
	    // Write code here that turns the phrase above into concrete actions
		try { driver = ApplicationFuction.CreateChromeDriverObject(url);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User clicks on SignIn Button$")
	public void user_clicks_on_SignIn_Button()
	{
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.NavigateToSignInpage(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@Then("^User navigates to SignIn page$")
	public void user_navigates_to_SignIn_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.SignInToWebsite(driver, username, password);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User searches for Product$")
	public void user_searches_for_Product() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.SearchProduct(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User adds product to cart$")
	public void user_adds_product_to_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.AddProductToCart(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User clicks on Checkout button$")
	public void user_clicks_on_Checkout_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.CheckoutAfterAddingProduct(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@Then("^User navigates to Summary page$")
	public void user_navigates_to_Summary_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User clicks on checkout button on Summary Tab$")
	public void user_clicks_on_checkout_button_on_Summary_Tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.PlaceOrderPart1(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User clicks on checkout button on Address Tab after Entering Additional Message$")
	public void user_clicks_on_checkout_button_on_Address_Tab_after_Entering_Additional_Message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.PlaceOrderPart2(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User clicks on checkout button on Shipping Tab after Selecting Term of Servcive option$")
	public void user_clicks_on_checkout_button_on_Shipping_Tab_after_Selecting_Term_of_Servcive_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.PlaceOrderPart3(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User select payment option$")
	public void user_select_payment_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.PlaceOrderPart4(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User confirms order$")
	public void user_confirms_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.PlaceOrderPart5(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@Then("^User should get Confirmation message for order along with Order reference number$")
	public void user_should_get_Confirmation_message_for_order_along_with_Order_reference_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.ValidateOrderConfirmationAfterPlcingOrder(driver);
		orderRefNumber=ApplicationFuction.GetOrderNumber(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User clicks on Order History option under my account$")
	public void user_clicks_on_Order_History_option_under_my_account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.NavigateToOrderHistorySection(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@Then("^User should get information about recently placed order$")
	public void user_should_get_information_about_recently_placed_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.ValidateOrderInOrderHistory(driver, orderRefNumber);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.SignOutFromWebsite(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			//Assert.fail();
		}
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.DestroyAnyDriverObject(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User navigates to personal information Section$")
	public void user_navigates_to_personal_information_Section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.NavigatePersonalInfoMyAccount(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@When("^User saves personal information after entering First name and Email id$")
	public void user_saves_personal_information_after_entering_First_name_and_Email_id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.UpdatePersonalInfoMyAccount(driver, newFirstName, password);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@Then("^User should get Confirmation message for personal information updation$")
	public void user_should_get_Confirmation_message_for_personal_information_updation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.ValidateConfirmationMessageForUpdation(driver);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}

	@Then("^User should able to see updated information for First Name$")
	public void user_should_able_to_see_updated_information_for_First_Name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try { ApplicationFuction.ValidateUpdatedPersonalInfoMyAccount(driver, newFirstName);} 
		catch (Exception e) 
		{ 
			System.out.println(e);
			ApplicationFuction.DestroyAnyDriverObject(driver);
			Assert.fail();
		}
	}
}
