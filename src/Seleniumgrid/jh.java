package Seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class jh {


	@Test
	public void test() throws MalformedURLException{
		
		
		DesiredCapabilities des= new DesiredCapabilities();
		des.setBrowserName("chrome");
		des.setPlatform(Platform.WIN10);
		
		ChromeOptions options= new ChromeOptions();
		options.merge(des);
		
		String nodeurl="http://192.168.0.125:8686/wd/hub";
		WebDriver driver= new RemoteWebDriver(new URL(nodeurl),options);
		driver.get("http://orangehrm.qedgetech.com/");
		String ul=driver.getCurrentUrl();
		System.out.println(ul);
		
	}
}
