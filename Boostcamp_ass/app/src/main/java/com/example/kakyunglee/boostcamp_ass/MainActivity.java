package com.example.kakyunglee.boostcamp_ass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.edit_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNaverItem(editText.getText()+"");
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            }
        });

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true); //레이아웃 사이즈 고정

        layoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void getNaverItem(String message){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://openapi.naver.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map map = new HashMap();
        map.put("query",message);
        map.put("display","100");

        NaverApiInterface naverApiInterface = retrofit.create(NaverApiInterface.class);
        Call<NaverDTO> call = naverApiInterface.getNaverItem(map);
        call.enqueue(new Callback<NaverDTO>() {
            @Override
            public void onResponse(Call<NaverDTO> call, Response<NaverDTO> response) {
                NaverDTO naverDTO = response.body();
                Log.d("hello","연결");
                movieAdapter = new MovieAdapter((List<MovieDTO>) naverDTO.getList());
                recyclerView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<NaverDTO> call, Throwable t) {
                Log.d("hello","연결X");
            }
        });

    }





}