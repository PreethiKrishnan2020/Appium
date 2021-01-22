package objectRepo;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.SetUp;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class darisniObjRepo extends SetUp  {
	AndroidDriver<MobileElement> androidDriver;	
	
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/eng")public AndroidElement Eng;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/sign_in_txt2")public AndroidElement Login;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter account email']")public AndroidElement MailId;
	@AndroidFindBy(xpath="//android.widget.EditText [@text='Enter account password']")public AndroidElement password;
	@AndroidFindBy(id = "com.betacom.bcmsf.dars:id/go_button") public AndroidElement SignIN;
	@AndroidFindBy(xpath ="//android.widget.TextView[@class='android.widget.TextView']")public AndroidElement errorMsg;

	public darisniObjRepo(AndroidDriver<MobileElement> androidDriver){
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);	
	}
	public void negativeLogin(String mail,String pass) throws Exception {
//		WebDriverWait wait = new WebDriverWait(androidDriver, 20);
		
		Eng.click();
	
		Login.click();
	
		MailId.sendKeys(mail);
		
		password.sendKeys(pass);
		
		SignIN.click();
		
		Assert.assertEquals(errorMsg.getText(), "Unable to login");
		
		System.out.println("SucessFully Verified the Error Msg");
		
		androidDriver.quit();
		System.out.println("The driver got exit");
	}
	
	
	
}
