package com.example.sunrin_08.myapplication12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GithubService  githubService = GithubService.retrofit.create(GithubService.class);

                Call<List<Item>> call = githubService.repoContributons("MOCK_DATA.json");
                call.enqueue(new Callback<List<Item>>() {
                    @Override
                    public void onResponse(Call<List<Item>> call, retrofit2.Response<List<Item>> response) {
                        tv.setText(response.body().toString());

                    }

                    @Override
                    public void onFailure(Call<List<Item>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }
}
