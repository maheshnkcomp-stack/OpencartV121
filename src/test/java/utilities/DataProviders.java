package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);// creating object for excel utility
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalrows-1][totalcols]; // ignoring header

		for(int i=1; i<totalrows; i++) {      // start from 1 to skip header
		    for(int j=0; j<totalcols; j++) {
		        loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);
		    }
		}
		return loginData;
	}

}
