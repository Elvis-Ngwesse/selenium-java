package Pages;
import org.openqa.selenium.By;
import utils.BaseClass;

public class StatusCodePage extends BaseClass {

    public StatusCodePage(){
    }


    public void clickStatusCodeLink(String statusCode){
        By _statusCode = this.getStatusCodeLocator(statusCode);
        click(_statusCode);
    }

    public String getStatusCodePageUrl() {
        String text = getPageUrl();
        return text;
    }

    private By getStatusCodeLocator(String statusCode) {
        String status = String.format("a[href='status_codes/%s']", statusCode);

        By element = By.cssSelector(status);
        return element;
    }
}
