package CommonDefinitions;

import Utilities.ExcelUtilities;

import java.util.Map;

public class mainDefinition {
    /*
    1. This class handles Data-driven framework with initializing EXCEL_FILE and EXCEL_SHEET that have the test data
    2. Test data is added to testData map to be reused all over the definitions files
    3. All definitions should extend this class to maintain reusable test data
    4. You can customize this class to have your own behaviour
     */
    public String EXCEL_FILE = "TestData.xls";
    public String EXCEL_SHEET = "Sample";
    public Map<String, String> testData = null;

    public mainDefinition(){
        try {
            testData = ExcelUtilities.getTestData(EXCEL_FILE, EXCEL_SHEET);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
