package activitylifecycle.example.com.sampleappnetworkcall;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    @POST("/api/users")
    Call<User> createUser(@Body User user);
    @GET("/api/users")
    Call<Customer>getList(@Query("page") String page);
}
