package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePage.BaseClass;

public class Registration {
	WebDriver driver;
	public Registration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}/////////locations////////
	@FindBy(xpath="//span[normalize-space()='My Account']")WebElement Myaccount;
	@FindBy(xpath="//body//nav//div//div//ul//li//ul//li//a[normalize-space()='Register']")WebElement register;
	@FindBy(xpath="//input[@placeholder='First Name']")WebElement Fname;
	@FindBy(xpath="//input[@placeholder='Last Name']")WebElement Lname;
	@FindBy(xpath="//input[@placeholder='E-Mail']")WebElement Email;
	@FindBy(xpath="//input[@placeholder='Telephone']")WebElement Mobnumber ;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement Password;
	@FindBy(xpath="//input[@placeholder='Password Confirm']")WebElement CNFpassword;
	@FindBy(xpath="//input[@type='checkbox']")WebElement Checkbox;
	@FindBy(xpath="//input[@value='Continue']")WebElement continueBtn;
//////////actions//////////
	public void clickMyaccount()
	{
		Myaccount.click();
	}
	;public void clickRegister()
	{
		register.click();
	}
	public void enterFname(String name)
	{
		Fname.sendKeys(name);
	}
	public void enterLname(String lastname)
	{
		Lname.sendKeys(lastname);
		
	}
	public void enterEmail(String EmailId)
	{
		 String randomEmail = BaseClass.generateEmail();
		Email.sendKeys(randomEmail+"@gmail.com" );
	}
	public void enterMobnumber(String number)
	{
		Mobnumber.sendKeys(number);
	}
	public void enterPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	public void enterCNFpassword(String cnpwd)
	{
		CNFpassword.sendKeys(cnpwd);
	}
	public void clickCheckBox()
	{
		Checkbox.click();
	}
	public void clickOnContinue()
	{
		continueBtn.click();
	}
}
