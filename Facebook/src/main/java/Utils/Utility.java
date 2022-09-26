package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	
	public static String getTD(int rowIndex ,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\selenium project\\facebookdata.xlsx");
		Sheet sh=WorkbookFactory.create(file).getSheet("Sheet1");
		String value =sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}


}
