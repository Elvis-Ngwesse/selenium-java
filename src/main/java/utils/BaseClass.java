package utils;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class BaseClass {
    protected WebDriver _driver = DriverFactory.getDriver();

    public BaseClass(){

    }

    protected void elementWait(){

        try{
            new FluentWait<>(_driver)
                    .withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected WebElement getElement(By by){
        this.elementWait();
        WebElement element = null;

        try{
            element = _driver.findElement(by);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }
    protected void click(By by){
        try{
            WebElement element = this.getElement(by);
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void enterTEXT(By by,String text){
        try{
            WebElement element = this.getElement(by);
            element.click();
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected String getElementText(By by){
        String text = null;
        try{
            WebElement element = this.getElement(by);
            text = element.getText();
        }catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }

    protected String getPageUrl(){
        String url = null;
        try{
            url = _driver.getCurrentUrl();
        }catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }
}
