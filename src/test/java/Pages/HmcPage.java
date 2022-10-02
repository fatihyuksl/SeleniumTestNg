package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HmcPage {
    public HmcPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement login;

    @FindBy(id="UserName")
    public WebElement userNameTexti;

    @FindBy(id ="Password")
    public WebElement passwordTexti;
    @FindBy(id="btnSubmit")
    public WebElement LoginButtonu;
    @FindBy(xpath="//*[@class='username username-hide-on-mobile']")
    public WebElement LoginKullanıcı;//

    @FindBy(xpath = "//*[@class='username username-hide-on-mobile']")
    public WebElement girisYapildi;
    @FindBy(id = "divMessageResult")
    public WebElement girisYapilamadiElementi;


}
