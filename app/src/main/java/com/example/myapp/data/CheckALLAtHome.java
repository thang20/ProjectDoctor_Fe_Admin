package com.example.myapp.data;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapp.Home;
import com.example.myapp.Login;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.home.CheckAllDoctorFreeTime;
import com.example.myapp.home.TakeDoctorFree;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckALLAtHome extends AppCompatActivity {
    ImageView back, iamgedt;
    Button next0, next1;
    TextView name, gender, age, phone, address, hDay, hTime, hService, namedt;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_allat_home);
        back = findViewById(R.id.imv_home_home1_checkAllAtHome_back);
        next0 = findViewById(R.id.btn_home_home1_checkAllAtHome_next0);
        name = findViewById(R.id.txt_home_home1_checkAllAtHome_name);
        gender = findViewById(R.id.txt__home_home1_checkAllAtHome_gender);
        age = findViewById(R.id.txt__home_home1_checkAllAtHome_age);
        phone = findViewById(R.id.txt__home_home1_checkAllAtHome_phone);
        address = findViewById(R.id.txt__home_home1_checkAllAtHome_address);
        hDay = findViewById(R.id.txt__home_home1_checkAllAtHome_date);
        hTime = findViewById(R.id.txt__home_home1_checkAllAtHome_time);
        hService = findViewById(R.id.txt__home_home1_checkAllAtHome_service);
        next1 = findViewById(R.id.btn_home_home1_checkAllAtHome_next1);
        iamgedt = findViewById(R.id.img_home_home1_checkAllAtHome_imgdoctor);
        namedt = findViewById(R.id.txt__home_home1_checkAllAtHome_namedt);
        Glide.with(CheckALLAtHome.this).load(MyApplication.getMyApplication().getDataUser().getAPI()+ MyApplication.myApplication.getDataUser().getDoctorDcchonImage()).into(iamgedt);
        namedt.setText(MyApplication.getMyApplication().getDataUser().getDoctorDcchonName());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        gender.setText(MyApplication.getMyApplication().getDataUser().getBenhnhangender());
        name.setText(MyApplication.getMyApplication().getDataUser().getBenhnhananame());
        age.setText(MyApplication.getMyApplication().getDataUser().getBenhnhanage());
        phone.setText(MyApplication.getMyApplication().getDataUser().getBenhnhanphone());
        address.setText(MyApplication.getMyApplication().getDataUser().getBenhnhanaddress());
        hDay.setText(MyApplication.getMyApplication().getDataUser().getBenhnhanDate());
        hTime.setText(MyApplication.getMyApplication().getDataUser().getBenhnhanTime());
        next0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setDoctorFree("1");
                startActivity(new Intent(CheckALLAtHome.this, CheckAllDoctorFreeTime.class));
                finish();
            }
        });
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (namedt.getText().toString().equals("")) {
                    Toast.makeText(CheckALLAtHome.this, "Please choose a doctor", Toast.LENGTH_SHORT).show();
                } else {
                    ///////////////
                    String semail = MyApplication.getMyApplication().getDataUser().getEmailStatic();
                    JSONObject jsonObject = new JSONObject();
                    String jsonStr = null;
                    try {

                        jsonObject = new JSONObject();
                        jsonObject.put("id", MyApplication.myApplication.getDataUser().getBenhnhanIDL());
                        jsonObject.put("idclient", MyApplication.myApplication.getDataUser().getBenhnhanID());
                        jsonObject.put("iddoctor", MyApplication.myApplication.getDataUser().getAllDoctorID());

                        jsonObject.put("date", MyApplication.myApplication.getDataUser().getBenhnhanDate());
                        jsonObject.put("time", MyApplication.myApplication.getDataUser().getBenhnhanTime());


                        jsonStr = jsonObject.toString();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    RequestBody body =
                            RequestBody.create(MediaType.parse("text/plain"), jsonStr);

                    Apiservice.apiservice.testhomefinish(body).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            String notice = null;

                            try {
                                notice = response.body().string();
                                if(notice.equals("success")){
                                    Toast.makeText(CheckALLAtHome.this, "turned on notifications from calls", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(CheckALLAtHome.this, Home.class));
                                    finish();
                                }else {
                                    Toast.makeText(CheckALLAtHome.this, "Fail", Toast.LENGTH_LONG).show();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });


                }
            }
        });

    }
}