package com.example.kakyunglee.boostcamp_ass;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface NaverApiInterface {
    @Headers({"X-Naver-Client-Id: 아이디 입력해야함",
            "X-Naver-Client-Secret: 키 값입력 해야함"})
    @GET("v1/search/movie.json")
    Call<NaverDTO> getNaverItem(@QueryMap Map<String, String> option
    );


}
