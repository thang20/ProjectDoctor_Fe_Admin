package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.myapp.Home;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.ItemNewAtHome;
import com.example.myapp.data.ItemNewAtHomeAdapter;
import com.example.myapp.data.ItemNewHomeoneDataHospital;
import com.example.myapp.data.ItemNewHomeoneDataHospitalAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllTestAtHome extends AppCompatActivity {
    RecyclerView rcvAlltesthome;
    ImageView back;
    ItemNewAtHomeAdapter itemNewAtHomeAdapter ;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_test_at_home);

        rcvAlltesthome = findViewById(R.id.rcv_home_home1_alltesthome);
        back = findViewById(R.id.imv_home_home1_alltesthome_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllTestAtHome.this, Home.class));
                finish();
            }
        });



        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(AllTestAtHome.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.process_dialog);
        rcvAlltesthome.setLayoutManager(new LinearLayoutManager(AllTestAtHome.this));
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
//        hospital.addItemDecoration(itemDecoration);

        String semail =  MyApplication.getMyApplication().getDataUser().getEmailStatic();
        JSONObject jsonObject = new JSONObject();
        String jsonStr = null;
        try {

            jsonObject = new JSONObject();
            jsonObject.put("email", semail);
            jsonStr = jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), jsonStr);

        Apiservice.apiservice.alllichathome(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String notice = "";
                try {
                    notice = response.body().string();
                    List<ItemNewAtHome> list = new ArrayList<ItemNewAtHome>();
                    List<String> data = new ArrayList<String>(Arrays.asList(notice.split(",-,")));
                    for (int i = 0; i < data.size(); i++) {

                        String datajson = data.get(i);
                        JSONObject obj = new JSONObject(datajson);
//                        Log.d("data123", obj.toString());
                        String image = obj.get("image").toString();
                        String time = obj.get("time").toString();
                        String date = obj.get("date").toString();
                        String td = time + " " + date;
                        ///
                        String name = obj.get("name").toString();
                        String year = obj.get("age").toString();
                        /////////
                        String address = obj.get("address").toString();
                        String gender = obj.get("gender").toString();

                        String phone = obj.get("phone").toString();
                        String active = obj.get("active").toString();
                        String idl = obj.get("idl").toString();
                        //idclient
                        String idclient = obj.get("idclient").toString();

                        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                        String[] parts = currentDate.split("/");
                        String result = parts[2];

                        int tt = Integer.parseInt(result) - Integer.parseInt(year);
                        String age = String.valueOf(tt);

//                        MyApplication.myApplication.getDataUser().setBenhnhanaddress(address);
//                        MyApplication.myApplication.getDataUser().setBenhnhangender(gender);
//                        MyApplication.myApplication.getDataUser().setBenhnhanphone(phone);
//                        MyApplication.myApplication.getDataUser().setBenhnhananame(name);//
//                        MyApplication.myApplication.getDataUser().setBenhnhanage(age);
//                        MyApplication.myApplication.getDataUser().setBenhnhanDate(date);
//                        MyApplication.myApplication.getDataUser().setBenhnhanTime(time);
//                        MyApplication.myApplication.getDataUser().setBenhnhanActive(active);//
//                        MyApplication.myApplication.getDataUser().setBenhnhanIDL(idl);



                        list.add(new ItemNewAtHome(name,
                                td, image, active, address, gender, phone, age, date, time, idl, idclient));

                    }
                    progressDialog.dismiss();
                    itemNewAtHomeAdapter = new ItemNewAtHomeAdapter(AllTestAtHome.this ,list);
                    rcvAlltesthome.setAdapter(itemNewAtHomeAdapter);


                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
}