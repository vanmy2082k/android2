package com.example.vanmy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vanmy.api.apidemo.ITnutService;
import com.example.vanmy.api.requesthelper.*;
import com.example.vanmy.model.Content;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class Activity_Count extends AppCompatActivity implements View.OnClickListener {


    private TextView txtView;
    private Button btnAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        txtView = findViewById(R.id.txt);
        btnAPI = findViewById(R.id.btnClick);
        btnAPI.setOnClickListener(this);
    }

    private void clickCallAPI() {
        final String[] text = {""};
        Call<ResponseBody> bodyCall = ITnutService.SERVICE.getInfo("counter_online");
        RequestHelper.executeASyncRequest(bodyCall, new ResponseAPI<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody response, int code) {
                Log.e("", "alow");
                try {
                    text[0] = response.string();
                    txtView.setText(text[0]);
                } catch (Exception e) {
                    text[0] = e.getMessage();
                    txtView.setText("code: " + code + " message: " + text[0]);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int code, String message) {
                text[0] = "code " + code + " - message:" + message;
                Log.e("", "alo");
                txtView.setText(text[0]);
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnClick:
                clickCallAPI();
                break;
        }
    }
}
