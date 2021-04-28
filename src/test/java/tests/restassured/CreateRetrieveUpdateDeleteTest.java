package tests.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.User;

import static utils.restassured.RestAssuredUtils.delete;
import static utils.restassured.RestAssuredUtils.get;
import static utils.restassured.RestAssuredUtils.post;
import static utils.restassured.RestAssuredUtils.put;
import static utils.user.UserUtils.provideUser;

public class CreateRetrieveUpdateDeleteTest extends BaseTest {

    @Test
    public void createRetrieveUpdateDeleteTest() {
        logger.info("Prepare User for test");
        User user = provideUser();

        logger.info("Create User in the DB");
        post(user, 201, "message", "User successfully created");

        logger.info("Verify the previously created User");
        User actualUser = (User) get("email", "teodor.pop@yahoo.com");
        Assert.assertEquals(actualUser, user);

        logger.info("Update the previously created User");
        user.setFirstName("Gabriel");
        put(user, 200, "message", "User successfully updated");

        logger.info("Delete the User from the DB");
        delete("email", "teodor.pop@yahoo.com", "message", "User successfully deleted");
    }
}
