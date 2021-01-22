package excelTestData;


import TestImport.DarisniappReadData;


	public class DarsiniappExcel {

		String[] datatest;
		String[] fakedata;
	

		public String[] fullbannerdata() {
			datatest=new String[3];

			datatest[0]=DarisniappReadData.getValue(1, 0);//mail
			datatest[1]=DarisniappReadData.getValue(1, 1);//pass
		
			return datatest;
		}
	}
		

