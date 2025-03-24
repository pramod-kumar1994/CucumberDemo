package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
public  LoginPage(WebDriver driver)

{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement Login1;

@FindBy(xpath="//a[normalize-space()='Login']")
WebElement loginbtn;

@FindBy(xpath="//input[@placeholder='E-Mail Address']")
WebElement Email;

@FindBy(xpath="//input[@placeholder='Password']")
WebElement Password;

@FindBy(xpath="//input[@value='Login']")
WebElement Login;
@FindBy(xpath="//body//div//div//aside//div//a[normalize-space()='Logout']")
WebElement Logout;

public void clickToLogin()
{
	Login1.click();
}
public void clickloginbtn()
{
	loginbtn.click();
}
public void enterEmail(String EmailId)
{
	Email.sendKeys(EmailId);
}
public void enterPassword(String pwd)
{
	Password.sendKeys(pwd);
}
public void clickLogin()
{
	Login.click();
}




}
