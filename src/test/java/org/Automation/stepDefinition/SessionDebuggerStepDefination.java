package org.Automation.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.Automation.util.Util;
import org.apache.velocity.runtime.directive.Foreach;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.List;

public class SessionDebuggerStepDefination {


    @Given("Run remote debugging port command from chromedevtools")
    public void runRemoteDebuggingPortCommandFromChromedevtools() {
        try {

            Process pro = Util.runRemoteDebuggingPortCommandSession();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    @When("Verify the session started on port")
    public void verify_the_session_started_on_port() {
        System.out.println("run_remote_debugging_port_command  : Started");

    }
    @Given("Perform create account on Facebook")
    public void perform_create_account_on_facebook() {
        System.setProperty("webdriver.chrome.driver","F:\\BDDcucumber\\MavenSeleniumJenkins\\chromedriver.exe");
       ChromeOptions opt = new ChromeOptions();
       opt.setExperimentalOption("debuggerAddress", "localhost:9222");
        opt.addArguments();
       WebDriver dr = new ChromeDriver(opt);
        dr.get("https://www.amazon.in/");
        dr.findElement(By.id("nav-link-accountList")).click();
        dr.findElement(By.id("ap_email")).sendKeys("aniketfarkase51@gmail.com");
        dr.findElement(By.id("continue")).click();
        dr.findElement(By.id("ap_password")).sendKeys("@nIket51!!");
        dr.findElement(By.id("signInSubmit")).click();
        Assert.assertEquals("Login unsucccesfull","Online Shopping site in India: Shop Online for Mobiles, " +
                "Books, Watches, Shoes and More - Amazon.in",dr.getTitle().trim());

        dr.findElement(By.id("twotabsearchtextbox")).sendKeys("pendrive");
        dr.findElement(By.id("nav-search-submit-button")).click();
      List<WebElement> pendrivelist = dr.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

            System.out.println("pendrive list");
        System.out.println("pendrive list");
       
        
            pendrivelist.forEach((n) -> System.out.println(n.getText()));

System.out.println("pendrive list");

    }

}
