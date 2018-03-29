package retrofit_inteface;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by niejingwei on 2018/3/29.
 */

public interface UpLoadImages {
    @Multipart
    @POST("Test")
    Call<String> uploadimage(@Part MultipartBody.Part photo, @Part("description")RequestBody description);
}
