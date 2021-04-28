package tests.retrofit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.User;
import retrofit.AuthenticateService;

public class RetrieveExistingUser extends BaseTest {

    @Test
    public void retrieveExistingUser() throws IOException {
        logger.info("Prepare Authenticate Service");
        AuthenticateService authenticateService = retrofit.create(AuthenticateService.class);

        logger.info("Retrieve User");
        var response = authenticateService.getUser("cornel.rantes@endava.com").execute();
        User user = response.body();

        logger.info("Verify User");
        User expectedUser = User.builder().firstName("Cornel").build();
        Assert.assertEquals(user.getFirstName(), expectedUser.getFirstName());
    }
}
