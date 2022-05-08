package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapp.MyApplication;
import com.example.myapp.R;

public class AllInforDoctor extends AppCompatActivity {
    ImageView face, back, cc;
    TextView name, email, pass, phone,dateofb,  gender, address, money, point, carepay, namef, hospital, spec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_infor_doctor);
        face = findViewById(R.id.edt_all_doctor_image);
        name = findViewById(R.id.edt_all_doctor_name);
        email = findViewById(R.id.edt_all_doctor_email);
        pass = findViewById(R.id.edt_all_doctor_pass);
        phone = findViewById(R.id.edt_all_doctor_phone);
        dateofb = findViewById(R.id.edt_all_doctor_dateofb);
        gender = findViewById(R.id.edt_all_doctor_gender);
        address = findViewById(R.id.edt_all_doctor_address);
        money = findViewById(R.id.edt_all_doctor_money);
        point = findViewById(R.id.edt_all_doctor_point);
        carepay = findViewById(R.id.edt_all_doctor_carepay);
        namef = findViewById(R.id.edt_all_doctor_namefront);
        back = findViewById(R.id.imv_all_doctor_back);
        hospital = findViewById(R.id.edt_all_doctor_hospital);
        spec = findViewById(R.id.edt_all_doctor_spec);
        cc = findViewById(R.id.imv_all_doctor_cc);

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
            Glide.with(AllInforDoctor.this).load(MyApplication.getMyApplication().getDataUser().getAPI()+ facetake).into(face);
        }
        Glide.with(AllInforDoctor.this).load(MyApplication.getMyApplication().getDataUser().getAPI()+ MyApplication.myApplication.getDataUser().getAllDoctorcc()).into(cc);
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