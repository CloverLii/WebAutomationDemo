package util;

import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



/**
 * Utility class: get and save a screenshot to local when test failed
 * File name: screenshot-className-currentTime.png
 * 
 * @author cloverli
 * @date 12/02/2021
 *
 */
public class ScreenshotUtil {
	
	private static Logger log = LoggerFactory.getLogger(ScreenshotUtil.class);
	
	final static String SCREENSHOT_PATH = System.getProperty("user.dir") + "/output/screenshots";

	//System.out.println(SCREENSHOT_PATH);

    public static void capture(ITestResult iTestResult) {
      
        WebDriver driver = ((BaseTest)iTestResult.getInstance()).driver;

        File screenshotDir = new File(SCREENSHOT_PATH);
        // create directory if not exist
        if (!screenshotDir.exists() && !screenshotDir.isDirectory()) {
            screenshotDir.mkdir();
        }
        // get screenshot file format from properties file
        String screenshotFormat = PropertiesReader.getKey("output.screenshot.format");
        // get class name
        String className = iTestResult.getInstance().getClass().getSimpleName();	
        // get current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");	
        String dateStr = dateFormat.format(new Date());      
        // set screenshot name
        String screenshotName = "screenshot" + "-" + className + "-" + dateStr + screenshotFormat;
       
        try {
            // take screenshot and save to configured path
            File sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String outputFile = SCREENSHOT_PATH + File.separator + screenshotName;
            System.out.println("...screenshot file name: " + outputFile);
           
            FileUtils.copyFile(sourcefile, new File(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
            log.error("can not file [{}] to local path", screenshotName, e);
        }
    }
}
