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
import android.widget.TextView;

import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.ItemNewHomeoneDataGift;
import com.example.myapp.data.ItemNewHomeoneDataGiftAdapter;
import com.example.myapp.data.ItemNewHomeoneDataHospital;
import com.example.myapp.data.ItemNewHomeoneDataHospitalAdapter;

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

public class Allgiftcode extends AppCompatActivity {
    RecyclerView rcvAllGiftCode;
    ImageView back;
    ItemNewHomeoneDataGiftAdapter itemNewHomeoneDataGiftAdapter;
    ProgressDialog progressDialog;
    TextView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgiftcode);
        rcvAllGiftCode = findViewById(R.id.rcv_home_home1_allgiftcode);
        back = findViewById(R.id.imv_home_home1_allgiftcode_back);
        add = findViewById(R.id.txt_home1_allgiftcode_add);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Allgiftcode.this, AddGift.class));
                finish();
            }
        });
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(Allgiftcode.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.process_dialog);
        rcvAllGiftCode.setLayoutManager(new LinearLayoutManager(Allgiftcode.this));
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

        Apiservice.apiservice.allgift(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String notice = "";
                try {
                    notice = response.body().string();
                    List<ItemNewHomeoneDataGift> list = new ArrayList<ItemNewHomeoneDataGift>();
                    List<String> data = new ArrayList<String>(Arrays.asList(notice.split(",-,")));
                    for (int i = 0; i < data.size(); i++) {

                        String datajson = data.get(i);
                        Log.d("data", String.valueOf(i));
                        JSONObject obj = new JSONObject(datajson);

                        String money = obj.get("money").toString();
                        String name = obj.get("name").toString();
                        money = "Money : " +  money + " USD";
                        name = "Code : " + name;
                        list.add(new ItemNewHomeoneDataGift(name
                                , money));
                        
                    }
                    progressDialog.dismiss();
                    itemNewHomeoneDataGiftAdapter = new ItemNewHomeoneDataGiftAdapter(Allgiftcode.this ,list);
                    rcvAllGiftCode.setAdapter(itemNewHomeoneDataGiftAdapter);


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