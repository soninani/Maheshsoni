package Seleniumgrid;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class seleniumgridclas {

	@Test
	public void authenticate() throws MalformedURLException{


		//desiredcapabilites

		DesiredCapabilities dcap= new DesiredCapabilities();
		dcap.setBrowserName("chrome");
		dcap.setPlatform(Platform.WIN10);
		
		//options class
		ChromeOptions opt=new ChromeOptions();
		opt.merge(dcap);


		//remotewebdriver
		String huburl="http://192.168.0.125:7878/wd/hub";
		WebDriver driver= new RemoteWebDriver(new URL(huburl),opt);

		//useractionco
		driver.get("http://orangehrm.qedgetech.com");
		String url=driver.getCurrentUrl();
		System.out.println(url);

	}

}
