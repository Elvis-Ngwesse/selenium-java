package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class BaseClass {
    private WebDriver _driver;

    public BaseClass(WebDriver _driver){
        this._driver = _driver;
    }

    public void elementWait(By by){

        try{
            Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
                    .withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public WebElement getElement(By by){
        this.elementWait(by);
        WebElement element = null;

        try{
            element = _driver.findElement(by);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }
    public void click(By by){
        try{
            this.getElement(by).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void enterTEXT(By by,String text){
        try{
            this.click(by);
            this.getElement(by).clear();
            this.getElement(by).sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getElementText(By by){
        String text = null;
        try{
            text = this.getElement(by).getText();
        }catch (Exception e){
            e.printStackTrace();
        }

        return text;
    }
}
