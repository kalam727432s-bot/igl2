package com.service.igl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ThirdActivity extends BaseActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        int form_id = getIntent().getIntExtra("form_id", -1);
        TextView fullname = findViewById(R.id.fullname);
        String jsonString = getIntent().getStringExtra("data");
        try {
            assert jsonString != null;
            JSONObject data = new JSONObject(jsonString);
            String fullName = data.optString("etFullName", "N/A");
            Object bpObj = data.get("consumenum");
            String bpNum = String.valueOf(bpObj);
            fullname.setText("Full Name: " + fullName + "\nConsumer Number: " + bpNum);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Button submit = findViewById(R.id.btnProceed);
        submit.setOnClickListener(v -> {
            Intent intent = new Intent(this, FourthActivity.class);
            intent.putExtra("form_id", form_id);
            startActivity(intent);
        });
    }
}
