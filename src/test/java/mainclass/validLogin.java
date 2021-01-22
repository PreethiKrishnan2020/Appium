package mainclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.SetUp;
import TestImport.DarisniappReadData;
import excelTestData.DarsiniappExcel;
import objectRepo.validloginRepo;

public class validLogin extends SetUp{
	
	validloginRepo log;
	DarsiniappExcel element;
	String[] datatest;
	SetUp startUp = new SetUp();
	
	@BeforeClass 
	public void Start() 
	{
		startUp.precondition();
		log = new validloginRepo(androidDriver);
		DarisniappReadData toRead = new DarisniappReadData();
	 	toRead.readExcel("Sheet1");
		element = new DarsiniappExcel();
		
		
     }
	@Test
	
	public void loginTest(){
		datatest=element.fullbannerdata();
	try {
		
		log.login(datatest[0],datatest[1]);
		log.negativeLogin(datatest[2], datatest[3]);
		log.HomePg();
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	}
	@ AfterClass
	public void Quit() 
	{
		androidDriver.quit();

		System.out.println("The driver got exit");
     }

}
