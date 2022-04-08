package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import utils.Commons;


public class Contact_Us_Steps {
    private WebDriver driver;
    private  Commons commons = new Commons();
    private By filedName = By.xpath("//input[@name=\"first_name\"]");
    private By fieldLastName = By.xpath("//input[@name=\"last_name\"]");
    private By fieldEmail = By.xpath("//input[@name=\"email\"]");
    private By fieldComment = By.xpath("//textarea[@name=\"message\"]");
    private By buttonSubmit = By.xpath("//input[@value=\"SUBMIT\"]");
    private By successMenssageContactUs = By.xpath("//div[@id='contact_reply']/h1");



    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Given("I access the webDriver university contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(filedName).sendKeys("AutoFN" + commons.generateRandomNumber(5) );
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(fieldLastName).sendKeys("AutoLN" + commons.generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(fieldEmail).sendKeys("AutoEmail" + commons.generateRandomNumber(10)
        + "@mail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(fieldComment).sendKeys("AutoComment " + commons.generateRandomString(20));
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(buttonSubmit).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {

        WebElement contactUs_Submission_Message = driver.findElement(successMenssageContactUs);
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }

}
