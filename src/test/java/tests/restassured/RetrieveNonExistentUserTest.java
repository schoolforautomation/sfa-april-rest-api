package tests.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.User;

import static utils.restassured.RestAssuredUtils.get;

public class RetrieveNonExistentUserTest extends BaseTest {

    @Test
    public void retrieveNonExistentUserTest() {
        logger.info("Retrieve non existent User from the DB");
        User actualUser = get("email", "nonexistent@yahoo.com");
        User expectedUser = User.builder().errorMessage("User not found").build();

        logger.info("Verify the duplicate User couldn't be created");
        Assert.assertEquals(actualUser.getErrorMessage(), expectedUser.getErrorMessage());
    }
}
