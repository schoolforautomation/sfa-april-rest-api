package retrofit;

import model.Message;
import model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthenticateService {

    @GET("rest/auth.php")
    Call<User> getUser(@Query(value = "email", encoded = true) String email);

    @POST("/rest/auth.php")
    Call<Message> createUser(@Body User user);
}
