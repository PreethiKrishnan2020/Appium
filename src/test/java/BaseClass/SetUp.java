package BaseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class SetUp {
	public static AndroidDriver<MobileElement> androidDriver;
//	public String projectFolder = System.getProperty("user.dir");
//	public String excelPath = projectFolder+"/Excel/appium.xls";///appiumtest/Excel/appium.xlsx
//	public String excelPath = projectFolder+"/appiumtest/Excel/appium.xlsx";
	@BeforeSuite
	
	public void precondition() {
				
			System.out.println("before suite");
			 mobileDriver();
		
		
	}


	public void mobileDriver() {
		try {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "galaxy M31");
		cap.setCapability("udid", "RZ8N60CGJ1M");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("app", "C:\\Users\\user\\Downloads\\file\\Darisni-v457-dars_staging-release.apk");
		
		
			androidDriver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			System.out.println("Error occurred");
			e.printStackTrace();
		}
	}	
}
