package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import helper.Driver;


public class Hook extends Driver{

    @Before
    public void setup(){
    }
    
    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
            
            
        }
    }
    
    @After(order = 0)
    public void tearDown() throws InterruptedException {
        closeBrowser();
    }

}
