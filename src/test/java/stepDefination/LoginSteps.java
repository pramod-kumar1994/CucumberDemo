package stepDefination;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import BasePage.BaseClass;
import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
public class LoginSteps {
	WebDriver driver;
	LoginPage lp;
	@Given("the user launches the Chrome browser")
	public void the_user_launches_the_chrome_browser() {
		lp=new LoginPage(driver);
		 driver = BaseClass.getDriver(); 
	}
	@When("the user navigates to {string}")
	public void the_user_navigates_to(String URL) {
	   driver.get(URL);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.manage().window().maximize();
	}
	@When("the user enters valid credentials \\(Username: {string}, Password: {string})")
	public void the_user_enters_valid_credentials_username_password(String EML, String PWD) {
		lp.clickToLogin();
		lp.clickloginbtn();
		lp.enterEmail(EML);
		lp.enterPassword(PWD);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		lp.clickLogin();
	   
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String expTitle) {
	String Title=driver.getTitle();
	if(Title.equals(expTitle))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	}

	@Then("the browser is closed")
	public void the_browser_is_closed() {
		
		driver.close();
		driver.quit();
	}

	

}
