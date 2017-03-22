package com.ultra.app.network;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by qiaofc on 2017/1/23 0023.
 */

public interface Api {
    @GET("http://a3.qpic.cn/psb?/V11WQpq043qxcU/Nxc84hUDBG0iF9hjl1x5xzYX2DX0AQAzmEYrp.elDus!/b/dGcBAAAAAAAA&bo=KgQgAwAAAAAFAC4!&rf=viewer_4")
    Observable<String> Baidu();
}