package retrofit_inteface;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by niejingwei on 2018/4/13.
 * 获得商品信息
 *
 */

public interface GoodsInfo {
    /**
     *
     * @param type 你要获得的商品类型
     * @return 返回一个实现了string泛型的Call接口的对象
     */
    @GET("getgoods")
    Call<String> getGoodsList(@Query("type") String type);
}
