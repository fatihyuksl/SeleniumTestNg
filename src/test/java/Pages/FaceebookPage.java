package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceebookPage {
    public FaceebookPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "email")
    public WebElement mailkutus;
    @FindBy(id ="pass")
    public WebElement sifreKutusu;
    @FindBy(name = "login")
    public WebElement login;
    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement  girilemediYaziElementi;

}
