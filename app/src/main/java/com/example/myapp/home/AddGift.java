package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.github.dhaval2404.imagepicker.ImagePicker;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddGift extends AppCompatActivity {
    EditText name, money;
    Button addG;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gift);

        name = findViewById(R.id.edt_add_gift_name);
        money = findViewById(R.id.edt_add_gift_money);
        back = findViewById(R.id.imv_home_home1_addGift_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        addG = findViewById(R.id.btn_add_gift);

        addG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameHH = name.getText().toString();
                String moneyHH = money.getText().toString();
                if(nameHH.equals("")||moneyHH.equals("")){
                    Toast.makeText(AddGift.this, "Please enter enough information", Toast.LENGTH_SHORT).show();
                }else {
                    JSONObject jsonObject = new JSONObject();
                    String jsonStr = null;
                    try {
                        String email = MyApplication.getMyApplication().getDataUser().getEmailStatic();
                        jsonObject = new JSONObject();
                        jsonObject.put("name", nameHH);
                        jsonObject.put("money", moneyHH);


                        jsonStr = jsonObject.toString();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    RequestBody body =
                            RequestBody.create(MediaType.parse("text/plain"), jsonStr);

                    Apiservice.apiservice.addgift(body).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            String notice = null;

                            try {
                                notice = response.body().string();
                                if(notice.equals("success")){
                                    Toast.makeText(AddGift.this, "Success to add Gift code", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(AddGift.this, Allgiftcode.class));
                                    finish();
                                }else {
                                    Toast.makeText(AddGift.this, "Fail to add Gift code", Toast.LENGTH_LONG).show();
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(AddGift.this, "Fail to call API", Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
        });
    }
}