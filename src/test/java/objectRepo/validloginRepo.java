package objectRepo;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class validloginRepo {
AndroidDriver<MobileElement> androidDriver;	

	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/eng")public AndroidElement Eng;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/sign_in_txt2")public AndroidElement Login;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter account email']")public AndroidElement MailId;
	@AndroidFindBy(xpath="//android.widget.EditText [@text='Enter account password']")public AndroidElement password;
	@AndroidFindBy(id = "com.betacom.bcmsf.dars:id/go_button") public AndroidElement SignIN;
	@AndroidFindBy(id = "android:id/button1") public AndroidElement Yes;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/profile_picture")public AndroidElement profile;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/right_image_burger") public AndroidElement editProfile;
	@AndroidFindBy(id ="com.betacom.bcmsf.dars:id/logout_text") public AndroidElement SignOut;
	@AndroidFindBy(xpath ="//android.widget.TextView[@class='android.widget.TextView']")public AndroidElement errorMsg;
	
	
	public validloginRepo(AndroidDriver<MobileElement> androidDriver){
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);	
	}
	
	public void login(String mail,String pass) throws Exception {
		
		WebDriverWait wait = new WebDriverWait (androidDriver,20);
		
		Eng.click();
		wait.until(ExpectedConditions.visibilityOf(Eng));
		Login.click();

		MailId.sendKeys(mail);

		password.sendKeys(pass);

		SignIN.click();
		
		Yes.click();
		
		System.out.println("Sucessfully logged in");
	}

		public void HomePg() {
			WebDriverWait wait = new WebDriverWait (androidDriver,20);		
		wait.until(ExpectedConditions.visibilityOf(profile));
		
		profile.click();
		
		System.out.println("Clicked Profile Button");
		sleep(3000);
		editProfile.click();
		
//		TouchActions action = new TouchActions(androidDriver);
//		action.scroll(SignOut, 10, 100);
//		action.perform();
		sleep(3000);
		scrollToAnElementByText(androidDriver, SignOut);
//		JavascriptExecutor js = (JavascriptExecutor) androidDriver;
//		HashMap<String, String> scrollObject = new HashMap<String, String>();
//		scrollObject.put("direction", "down");
//		js.executeScript("mobile: scroll", scrollObject);
		SignOut.click();
		sleep(3000);
		System.out.println("SignOut from the application");
				
	}
		public void negativeLogin(String mail,String pass) throws Exception {
//			WebDriverWait wait = new WebDriverWait(androidDriver, 20);
			
			Eng.click();
		
			Login.click();
		
			MailId.sendKeys(mail);
			
			password.sendKeys(pass);
			
			Assert.assertEquals(errorMsg.getText(), "Unable to login");
			
			System.out.println("SucessFully Verified the Error Msg");
			
}

public WebElement scrollToAnElementByText(AndroidDriver<MobileElement>androidDriver2, AndroidElement signOut2){
  
  return androidDriver2.findElement(MobileBy.
  AndroidUIAutomator("new UiScrollable(new UiSelector())" +
  ".scrollIntoView(new UiSelector().text(\"" + signOut2 + "\"));")); }
 
	public static void sleep(long m) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
