package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.data.CheckALLAtHome;

public class TakeDoctorFree extends AppCompatActivity {
    ImageView face, back, cc;
    Button chon;
    TextView name, email, pass, phone,dateofb,  gender, address, money, point, carepay, namef, hospital, spec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_doctor_free);
        face = findViewById(R.id.edt_all_freedoctor_image);
        name = findViewById(R.id.edt_all_freedoctor_name);
        email = findViewById(R.id.edt_all_freedoctor_email);
        pass = findViewById(R.id.edt_all_freedoctor_pass);
        phone = findViewById(R.id.edt_all_freedoctor_phone);
        dateofb = findViewById(R.id.edt_all_freedoctor_dateofb);
        gender = findViewById(R.id.edt_all_freedoctor_gender);
        address = findViewById(R.id.edt_all_freedoctor_address);
        money = findViewById(R.id.edt_all_freedoctor_money);
        point = findViewById(R.id.edt_all_freedoctor_point);
        carepay = findViewById(R.id.edt_all_freedoctor_carepay);
        namef = findViewById(R.id.edt_all_freedoctor_namefront);
        back = findViewById(R.id.imv_allfree_doctor_back);
        hospital = findViewById(R.id.edt_all_freedoctor_hospital);
        spec = findViewById(R.id.edt_all_freedoctor_spec);
        cc = findViewById(R.id.imv_all_freedoctor_cc);
        chon = findViewById(R.id.btn__all_freedoctor_chon);
        chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setDoctorDcchonImage(MyApplication.myApplication.getDataUser().getAllDoctorimage());
                MyApplication.getMyApplication().getDataUser().setDoctorDcchonName(MyApplication.getMyApplication().getDataUser().getAllDoctorname());
                startActivity(new Intent(TakeDoctorFree.this, CheckALLAtHome.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        String facetake = MyApplication.myApplication.getDataUser().getAllDoctorimage();
        if(facetake.equals("null")){
            face.setImageResource(R.drawable.profile);
        }else {
            Glide.with(TakeDoctorFree.this).load(MyApplication.getMyApplication().getDataUser().getAPI()+ facetake).into(face);
        }
        Glide.with(TakeDoctorFree.this).load(MyApplication.getMyApplication().getDataUser().getAPI()+ MyApplication.myApplication.getDataUser().getAllDoctorcc()).into(cc);
        String dateofbtake = MyApplication.getMyApplication().getDataUser().getAllDoctordateofb();
        if(dateofbtake.equals("null")){
            dateofb.setText("");
        }else {
            dateofb.setText(MyApplication.getMyApplication().getDataUser().getAllDoctordateofb());
        }
        String gendertake = MyApplication.getMyApplication().getDataUser().getAllDoctorgender();
        if(dateofbtake.equals("null")){
            gender.setText("");
        }else {
            gender.setText(MyApplication.getMyApplication().getDataUser().getAllDoctorgender());
        }
        name.setText(MyApplication.getMyApplication().getDataUser().getAllDoctorname());
        namef.setText(MyApplication.getMyApplication().getDataUser().getAllDoctorname());
        email.setText(MyApplication.getMyApplication().getDataUser().getAllDoctoremail());
        pass.setText(MyApplication.getMyApplication().getDataUser().getAllDoctorpass());
        phone.setText(MyApplication.getMyApplication().getDataUser().getAllDoctorphone());

        address.setText(MyApplication.getMyApplication().getDataUser().getAllDoctoraddress());
        money.setText(MyApplication.getMyApplication().getDataUser().getAllDoctormoney());
        point.setText(MyApplication.getMyApplication().getDataUser().getAllDoctorpoint());
        String takecp = MyApplication.getMyApplication().getDataUser().getAllDoctorcarepayat();
        if(takecp.equals("0")){
            carepay.setText("Non active");
        }else {
            carepay.setText("Active");
        }
        hospital.setText(MyApplication.getMyApplication().getDataUser().getAllDoctorhospital());
        spec.setText(MyApplication.getMyApplication().getDataUser().getAllDoctorspec());

    }
}