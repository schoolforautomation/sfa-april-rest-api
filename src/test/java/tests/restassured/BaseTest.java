package tests.restassured;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseTest {

    protected static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = "http://school-for-automation.tech/rest/auth.php";
    }
}
