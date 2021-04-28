package tests.retrofit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BaseTest {

    protected Retrofit retrofit;

    protected static Logger logger = LogManager.getLogger(tests.restassured.BaseTest.class);

    @BeforeSuite
    public void setup() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://school-for-automation.tech/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
