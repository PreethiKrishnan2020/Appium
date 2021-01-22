package mainclass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.SetUp;
import objectRepo.darisniObjRepo;

public class DarisniLogin extends SetUp {
		
	darisniObjRepo obj;
	SetUp starting = new SetUp();

	@BeforeClass 
	public void Start() 
	{
		starting.precondition();
		obj = new darisniObjRepo(androidDriver);
		
     }
@Test
	
	public  void loginTest() throws Throwable {
	obj.negativeLogin("radhakrishnaned@gmail.com", "pass");	
	
	
	}
	
	
}