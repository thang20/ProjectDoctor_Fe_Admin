package com.example.myapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.data.ItemProfileData01;
import com.example.myapp.data.ItemProfileData01Adapter;
import com.example.myapp.profile_interface.UpdateProfile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    TextView txtProfileFullName, txtProfilePhone;
    Button btnProfileUpdateProfile, logout;
    RecyclerView recyclerView1, recyclerView2;
    ImageView imvProfile;
    ItemProfileData01Adapter itemProfileData01Adapter, itemProfileData02Adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        txtProfileFullName = (TextView) view.findViewById(R.id.txt_profile_fullname);
        txtProfilePhone = (TextView) view.findViewById(R.id.txt_profile_phone);
        logout = (Button) view.findViewById(R.id.btn_profile_logout);
        btnProfileUpdateProfile = (Button) view.findViewById(R.id.btn_profile_upDateProfile);
        imvProfile = (ImageView) view.findViewById(R.id.rcv_profile_image);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });



        txtProfileFullName.setText(MyApplication.getMyApplication().getDataUser().getFullNameStatic());
        txtProfilePhone.setText( MyApplication.getMyApplication().getDataUser().getPhoneStatic());

        if(MyApplication.getMyApplication().getDataUser().getByteArrayImageStatic().equals("")) {
        }else {
            new LoadImage().execute(MyApplication.getMyApplication().getDataUser().getAPI() + MyApplication.getMyApplication().getDataUser().getByteArrayImageStatic());

        }


        recyclerView1 = view.findViewById(R.id.rcv_profile_data1);
        recyclerView2 = view.findViewById(R.id.rcv_profile_data2);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView1.addItemDecoration(itemDecoration);
        recyclerView2.addItemDecoration(itemDecoration);



        itemProfileData01Adapter = new ItemProfileData01Adapter(getContext() ,getListData01());
        itemProfileData02Adapter = new ItemProfileData01Adapter(getContext() ,getListData02());
        recyclerView1.setAdapter(itemProfileData01Adapter);
        recyclerView2.setAdapter(itemProfileData02Adapter);

        btnProfileUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setCarepay(false);
                MyApplication.getMyApplication().getDataUser().setActivedoctor(false);
                Intent intent = new Intent(getActivity(), UpdateProfile.class);
                startActivity(intent);
            }
        });




        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        txtProfileFullName.setText(MyApplication.getMyApplication().getDataUser().getFullNameStatic());
        txtProfilePhone.setText( MyApplication.getMyApplication().getDataUser().getPhoneStatic());
        if( MyApplication.getMyApplication().getDataUser().getByteArrayImageStatic().equals("")) {

        }else {

            new LoadImage().execute(MyApplication.getMyApplication().getDataUser().getAPI() + MyApplication.getMyApplication().getDataUser().getByteArrayImageStatic());

//            imvProfile.setImageURI(Uri.parse( MyApplication.getMyApplication().getDataUser().getByteArrayImageStatic()));
        }

    }

    private List<ItemProfileData01> getListData01() {
        List<ItemProfileData01> list = new ArrayList<>();
        list.add(new ItemProfileData01(R.drawable.img_3, "Health declaration",R.drawable.img_21 ));
        list.add(new ItemProfileData01(R.drawable.img_11, "Invite friends",R.drawable.img_21 ));
        list.add(new ItemProfileData01(R.drawable.img_12, "Remind",R.drawable.img_21 ));

        return list;


    }

    private List<ItemProfileData01> getListData02() {
        List<ItemProfileData01> list = new ArrayList<>();
        list.add(new ItemProfileData01(R.drawable.img_13, "Set screen lock",R.drawable.img_21 ));
        list.add(new ItemProfileData01(R.drawable.img_14, "Notification settings",R.drawable.img_21 ));
        list.add(new ItemProfileData01(R.drawable.img_16, "Change Password",R.drawable.img_21 ));
        list.add(new ItemProfileData01(R.drawable.img_17, "Call Customer Care(1900 1851)",R.drawable.img_21 ));
        list.add(new ItemProfileData01(R.drawable.img_18, "Facebook Y.DT",R.drawable.img_21 ));
        list.add(new ItemProfileData01(R.drawable.img_19, "Terms of use",R.drawable.img_21 ));
        list.add(new ItemProfileData01(R.drawable.img_20, "Introduction",R.drawable.img_21 ));
        return list;


    }


//    private void onClickGoToDetail(ItemProfileData01 itemProfileData01){
//        Intent intent = new Intent(getContext(), MainActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("object_profileData", itemProfileData01);
//        intent.putExtra(bundle);
//
//    }
private class LoadImage extends AsyncTask<String, Void, Bitmap> {
    Bitmap bitmapHinh = null;
    @Override
    protected Bitmap doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);
            InputStream inputStream = url.openConnection().getInputStream();

            bitmapHinh = BitmapFactory.decodeStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmapHinh;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imvProfile.setImageBitmap(bitmap);
    }
}
}

