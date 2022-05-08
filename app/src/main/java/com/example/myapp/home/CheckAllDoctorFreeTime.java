package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapp.Home;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.ItemNewDoctor;
import com.example.myapp.data.ItemNewDoctorAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckAllDoctorFreeTime extends AppCompatActivity {
    RecyclerView rcvAllHospital;
    ImageView back;
    ItemNewDoctorAdapter itemNewDoctorAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_all_doctor_free_time);
        rcvAllHospital = findViewById(R.id.rcv_home_home2_allDoctorfree);
        back = findViewById(R.id.imv_home_home2_allDoctorfree_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(CheckAllDoctorFreeTime.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.process_dialog);
        rcvAllHospital.setLayoutManager(new LinearLayoutManager(CheckAllDoctorFreeTime.this));


        String semail =  MyApplication.getMyApplication().getDataUser().getEmailStatic();
        JSONObject jsonObject = new JSONObject();
        String jsonStr = null;
        try {

            jsonObject = new JSONObject();
            jsonObject.put("email", semail);
            jsonObject.put("date", MyApplication.getMyApplication().getDataUser().getBenhnhanDate());
            jsonObject.put("time", MyApplication.getMyApplication().getDataUser().getBenhnhanTime());
            jsonStr = jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), jsonStr);

        Apiservice.apiservice.alldoctorfree(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String notice = "";
                try {
                    notice = response.body().string();
                    List<ItemNewDoctor> list = new ArrayList<ItemNewDoctor>();
                    List<String> data = new ArrayList<String>(Arrays.asList(notice.split(",-,")));
                    for (int i = 0; i < data.size(); i++) {
                        String datajson = data.get(i);
                        JSONObject obj = new JSONObject(datajson);
//                        Log.d("data123", obj.toString());
                        String name = obj.get("name").toString();
                        String email = obj.get("email").toString();
                        String password = obj.get("password").toString();

                        String phone = obj.get("phone").toString();
                        String image = obj.get("image").toString();
                        String dateofbirth = obj.get("dateofbirth").toString();

                        String gender = obj.get("gender").toString();
                        String address = obj.get("address").toString();
                        String money = obj.get("money").toString();

                        String point = obj.get("point").toString();
                        String carepayactive = obj.get("carepayactive").toString();

                        String hospital = obj.get("hospital").toString();
                        String spec = obj.get("spec").toString();
                        String cc = obj.get("cc").toString();
                        String iddoctor = obj.get("iddoctor").toString();


                        list.add(new ItemNewDoctor(name,
                                email, password, phone, image, dateofbirth, gender, address, money, point, carepayactive, hospital, spec, cc, iddoctor));

                    }
                    progressDialog.dismiss();
                    itemNewDoctorAdapter = new ItemNewDoctorAdapter(CheckAllDoctorFreeTime.this ,list);
                    rcvAllHospital.setAdapter(itemNewDoctorAdapter);


                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}