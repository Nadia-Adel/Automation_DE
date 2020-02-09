package mobileUtilities;

/*import com.github.romankh3.image.comparison.ImageComparisonUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String captureScreenShot(String testContext)
    {
        TakesScreenshot ts = (TakesScreenshot) DriverHandler.getInstance().getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dest = Paths.TEST_SCREENSHOTS+testContext+".png";
        //Adding time stamp else it will replace the previous screenshots
        try
        {
            FileUtils.copyFile(src, new File(dest));
        }
        catch (IOException e) {
            System.out.println("Failed to get screenshot"+e.getMessage());
            e.printStackTrace();
        }
        return dest;
    }
    public static void captureMobileScreenShot(String fileName)
    {
        TakesScreenshot ts = (TakesScreenshot) DriverHandler.getInstance().getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dest = Paths.TEST_ACTUAL_SCREENSHOTS+fileName;
        try
        {
            FileUtils.copyFile(src, new File(dest));

        }
        catch (IOException e) {
            System.out.println("Failed to get screenshot"+e.getMessage());
            e.printStackTrace();
        }
    }
}*/
