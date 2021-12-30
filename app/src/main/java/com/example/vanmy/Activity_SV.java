package com.example.vanmy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vanmy.api.apidemo.ITnutService;
import com.example.vanmy.api.requesthelper.RequestHelper;
import com.example.vanmy.api.requesthelper.ResponseAPI;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class Activity_SV extends AppCompatActivity implements View.OnClickListener {

    private Button Check;
    private EditText edit;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv);
        Check = findViewById(R.id.btnCheck);
        edit = findViewById(R.id.editTxt);
        textView = findViewById(R.id.textView1);
        Check.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnClick:
                String str = edit.getText().toString();
                clickCheck(str);
                break;

        }
    }
    private void clickCheck(String str){
        final String[] text = {""};
        Call<ResponseBody> bodyCall = ITnutService.SERVICE1.getInfoMSSV(str);
        RequestHelper.executeASyncRequest(bodyCall, new ResponseAPI<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody response, int code) {
                Log.e("", "alow");
                try {
                    text[0] = response.string();
                    if (text[0].isEmpty()){
                        textView.setText("có gì đâu mà lấy");
                    }else {
                        textView.setText(text[0]);
                    }
                } catch (Exception e) {
                    text[0] = e.getMessage();
                    textView.setText("code: " + code + " message: " + text[0]);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int code, String message) {
                text[0] = "code " + code + " - message:" + message;
                Log.e("", "alo");
                textView.setText(text[0]);
            }
        });
    }
}