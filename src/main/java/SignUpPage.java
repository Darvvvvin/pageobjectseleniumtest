import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[contains(@class, 'text-mono')]");
    private By signUpButton = By.xpath("//button[@id='signup_button']");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By emailField = By.xpath("//input[@id='user_email]");
    private By mainError = By.xpath("//form[@id='signup-form']/div[contains(@class, 'flash flash-error')]");
    private By userNameError = By.xpath("//dd[@id='description_4cab463bbc58']");
    private By emailError = By.xpath("//dd[@id='description_555ee370095c']");
    private By passwordError = By.xpath("//dd[@id='description_3192fe8bff80']");

    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        this.typeUserName(username);
        this.typePassword(password);
        this.typeEmail(email);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
       return driver.findElement(heading).getText();
    }

    public String getMainErrorText() {
       return driver.findElement(mainError).getText();
    }

    public String getUserNameErrorText() {
       return driver.findElement(userNameError).getText();
    }

    public String getPasswordErrorText() {
       return driver.findElement(passwordError).getText();
    }

    public String getEmailErrorText() {
       return driver.findElement(emailError).getText();
    }

}
