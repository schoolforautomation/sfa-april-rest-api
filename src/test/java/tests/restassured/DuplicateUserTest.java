package tests.restassured;

import org.testng.annotations.Test;

import model.User;

import static utils.restassured.RestAssuredUtils.delete;
import static utils.restassured.RestAssuredUtils.post;
import static utils.user.UserUtils.provideUser;

public class DuplicateUserTest extends BaseTest {

    @Test
    public void duplicateUserTest() {
        logger.info("Prepare User for test");
        User user = provideUser();

        logger.info("Create User in the DB");
        post(user, 201, "message", "User successfully created");

        logger.info("Create duplicate User in the DB");
        post(user, 400, "message", "User already exists");

        logger.info("Delete the User from the DB");
        delete("email", "teodor.pop@yahoo.com", "message", "User successfully deleted");
    }
}
