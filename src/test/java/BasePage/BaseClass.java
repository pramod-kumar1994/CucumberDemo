package BasePage;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
    private static WebDriver driver;
    public static WebDriver getDriver() {	
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver; 
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset to prevent NullPointerException
        }
    }

    public void setup()
	{
		System.out.println("before method execute");
		 driver = BaseClass.getDriver(); 
	}
    
    public static  String generateEmail()
    
    {
    	return(RandomStringUtils.randomAlphabetic(5));
    }
   
	@AfterStep
	public void teardown(Scenario sc) throws IOException
	{
		System.out.println("after method executed");
		if (sc.isFailed()==true)
		{
			String filewithPath="C:\\Users\\kumar\\eclipse-workspace\\Cucumber_Demo\\Screenshots\\Test.png";
			TakesScreenshot scrShot=((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(filewithPath);
			FileUtils.copyFile(SrcFile, DestFile);
		}
		 closeDriver();
		
	}

}
