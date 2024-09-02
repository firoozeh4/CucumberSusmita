package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public static WebDriver driver;
	
	
	public static void openChrome()
	{
		System.setProperty("webdriver.chrome.driver", "src\\main\\driver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void screenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat formatter = new SimpleDateFormat("MMDDYY_hhmmss");
		Date date = new Date();
		String label = formatter.format(date);
		try
		{
			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir")+"/screenshot/" +label + ".png"));
		}catch (IOException e) {
		e.printStackTrace();
		}
	}
}
