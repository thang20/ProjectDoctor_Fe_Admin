package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapp.home.AllClient;
import com.example.myapp.home.AllDoctor;
import com.example.myapp.home.AllHospital;
import com.example.myapp.home.AllTestAtHome;
import com.example.myapp.home.Allcontribute;
import com.example.myapp.home.Allgiftcode;
import com.example.myapp.home.Allservice;

public class HomeFragment extends Fragment {
    LinearLayout appointment, pharmacy, hera, call, QA, other, contribute;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        appointment = view.findViewById(R.id.ln_home1home);

        pharmacy = view.findViewById(R.id.ln_home3);
        hera = view.findViewById(R.id.ln_home4);
        call = view.findViewById(R.id.ln_home5);
        QA = view.findViewById(R.id.ln_home6);
        other = view.findViewById(R.id.ln_home7);
        contribute = view.findViewById(R.id.ln_home8);
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AllHospital.class);
                startActivity(intent);

            }
        });
        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AllClient.class);
                startActivity(intent);
            }
        });
        hera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setDoctorFree("0");
                Intent intent = new Intent(getActivity(), AllDoctor.class);
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AllTestAtHome.class);
                startActivity(intent);
            }
        });
        QA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Allgiftcode.class);
                startActivity(intent);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Allservice.class);
                startActivity(intent);
            }
        });
        contribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Allcontribute.class);
                startActivity(intent);
            }
        });






        return view;
    }
}
