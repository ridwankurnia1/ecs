package id.amfg.ecs.api;

import java.util.List;

import id.amfg.ecs.model.LoginModel;
import id.amfg.ecs.model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CoreApiInterface {

    @POST("auth/login/")
    Call<ResponseBody> login(
            @Header("Content-Type") String contentType
            , @Body LoginModel loginModel
    );

    //region User Api

    @GET("user/")
    Call<List<User>> getListUser();

    @GET("user/{UserId}")
    Call<User> getUser(@Path("UserId") String UserId);

    //endregion

}
