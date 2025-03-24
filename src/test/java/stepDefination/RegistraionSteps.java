package stepDefination;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BasePage.BaseClass;
import PageObject.Registration;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
public class RegistraionSteps{
    WebDriver driver;
    Registration rs;
    public RegistraionSteps() throws IOException {
        driver = BaseClass.getDriver(); 
        rs = new Registration(driver);      
    }

    @Given("the user launches Chrome browser")
    public void the_user_launches_chrome_browser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        rs = new Registration(driver);
    }
    @When("user opens URL {string}")
    public void user_open_url(String URL) {
        driver.get(URL);
        driver.manage().deleteAllCookies();
    }

    @When("user clicks on Register")
    public void user_clicks_on_register() {
        rs.clickMyaccount();
        rs.clickRegister();
    }

    @When("user enters First Name {string}")
    public void user_enters_first_name(String Name) {
        rs.enterFname(Name);
    }

    @When("user enters Last Name {string}")
    public void user_enters_last_name(String LastName) {
        rs.enterLname(LastName);
    }

    @When("user enters Email {string}")
    public void user_enters_email(String email) {
        rs.enterEmail(email);
    }

    @When("user enters Mobile Number {string}")
    public void user_enters_mobile_number(String Number) {
        rs.enterMobnumber(Number);
    }

    @When("user enters Password {string}")
    public void user_enters_password(String pwd) {
        rs.enterPassword(pwd);
    }

    @When("user enters Confirm Password {string}")
    public void user_enters_confirm_password(String CnfP) {
        rs.enterCNFpassword(CnfP);
    }

    @When("user checks the checkbox")
    public void user_checks_the_checkbox() {
        rs.clickCheckBox();
    }

    @When("user clicks on Continue")
    public void user_clicks_on_continue() {
        rs.clickOnContinue();
    }

    @Then("user should see the registration success message")
    public void user_should_see_the_registration_success_message() {
        WebElement msg = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        String actualMsg = msg.getText();
        String expectedMsg = "Your Account Has Been Created!";

        Assert.assertEquals(expectedMsg, actualMsg);
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        try {
            if (scenario.isFailed() && driver != null) {  // Only take screenshot on failure
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } catch (org.openqa.selenium.NoSuchSessionException e) {
            System.out.println("Skipping screenshot: WebDriver session is already closed.");
        } catch (Exception e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
    }
    @Then("user closes the browser")
    public void user_closes_the_browser() {
        BaseClass.closeDriver(); 
    }

}
