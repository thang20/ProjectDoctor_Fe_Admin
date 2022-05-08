package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapp.MainActivity;
import com.example.myapp.MyApplication;
import com.example.myapp.R;

public class AllInforClient extends AppCompatActivity {
    ImageView face, back;
    TextView name, email, pass, phone,dateofb,  gender, address, money, point, carepay, namef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_infor_client);
        face = findViewById(R.id.edt_all_client_image);
        name = findViewById(R.id.edt_all_client_name);
        email = findViewById(R.id.edt_all_client_email);
        pass = findViewById(R.id.edt_all_client_pass);
        phone = findViewById(R.id.edt_all_client_phone);
        dateofb = findViewById(R.id.edt_all_client_dateofb);
        gender = findViewById(R.id.edt_all_client_gender);
        address = findViewById(R.id.edt_all_client_address);
        money = findViewById(R.id.edt_all_client_money);
        point = findViewById(R.id.edt_all_client_point);
        carepay = findViewById(R.id.edt_all_client_carepay);
        namef = findViewById(R.id.edt_all_client_namefront);
        back = findViewById(R.id.imv_all_client_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        String facetake = MyApplication.myApplication.getDataUser().getAllClientimage();
        if(facetake.equals("null")){
            face.setImageResource(R.drawable.profile);
        }else {
            Glide.with(AllInforClient.this).load(MyApplication.getMyApplication().getDataUser().getAPI()+ facetake).into(face);
        }
        String dateofbtake = MyApplication.getMyApplication().getDataUser().getAllClientdateofb();
        if(dateofbtake.equals("null")){
            dateofb.setText("");
        }else {
            dateofb.setText(MyApplication.getMyApplication().getDataUser().getAllClientdateofb());
        }
        String gendertake = MyApplication.getMyApplication().getDataUser().getAllClientgender();
        if(dateofbtake.equals("null")){
            gender.setText("");
        }else {
            gender.setText(MyApplication.getMyApplication().getDataUser().getAllClientgender());
        }
        name.setText(MyApplication.getMyApplication().getDataUser().getAllClientname());
        namef.setText(MyApplication.getMyApplication().getDataUser().getAllClientname());
        email.setText(MyApplication.getMyApplication().getDataUser().getAllClientemail());
        pass.setText(MyApplication.getMyApplication().getDataUser().getAllClientpass());
        phone.setText(MyApplication.getMyApplication().getDataUser().getAllClientphone());

        address.setText(MyApplication.getMyApplication().getDataUser().getAllClientaddress());
        money.setText(MyApplication.getMyApplication().getDataUser().getAllClientmoney());
        point.setText(MyApplication.getMyApplication().getDataUser().getAllClientpoint());
        String takecp = MyApplication.getMyApplication().getDataUser().getAllClientcarepayat();
        if(takecp.equals("0")){
            carepay.setText("Non active");
        }else {
            carepay.setText("Active");
        }

    }
}