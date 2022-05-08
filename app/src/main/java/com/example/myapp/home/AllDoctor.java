package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.example.myapp.Home;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.ItemNewClient;
import com.example.myapp.data.ItemNewClientAdapter;
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

public class AllDoctor extends AppCompatActivity {
    RecyclerView rcvAllHospital;
    ImageView back;
    ItemNewDoctorAdapter itemNewDoctorAdapter;
    ProgressDialog progressDialog;
    Toolbar alldoctor;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_doctor);
        rcvAllHospital = findViewById(R.id.rcv_home_home2_allDoctor);
        back = findViewById(R.id.imv_home_home2_allDoctor_back);
        alldoctor = findViewById(R.id.tb_alldoctor);
        setSupportActionBar(alldoctor);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllDoctor.this, Home.class));
                finish();
            }
        });
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(AllDoctor.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.process_dialog);
        rcvAllHospital.setLayoutManager(new LinearLayoutManager(AllDoctor.this));


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

        Apiservice.apiservice.alldoctor(body).enqueue(new Callback<ResponseBody>() {
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
                    itemNewDoctorAdapter = new ItemNewDoctorAdapter(AllDoctor.this ,list);
                    rcvAllHospital.setAdapter(itemNewDoctorAdapter);


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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.actionsearch).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                itemNewDoctorAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                itemNewDoctorAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return true;
    }
}