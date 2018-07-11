package Utilities;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;


public class ExcelUtilities {
	//Extracting test data from External excel sheet
	public static Map<String, String> getTestData(String file, String sheetName) throws Exception{
		int cols = 2;
		Workbook workbook = Workbook.getWorkbook(new File(file));
		Sheet sheet = workbook.getSheet(sheetName);
		int records = sheet.getRows()-1;
		int currentPosition = 1;
		String[][] values = new String[records][cols];
		for(int i = 0 ; i < records ; i++, currentPosition++){
			for(int j = 0 ; j < cols ; j++) values[i][j] = sheet.getCell(j, currentPosition).getContents();
		}
		workbook.close();
		//Convert 2D array to hashmap with Keys and Values
        Map<String, String> map = new HashMap<String, String>(values.length);
        for (Object[] mapping : values){
            map.put(mapping[0].toString(), mapping[1].toString());
        }
        return map;
	}
}
