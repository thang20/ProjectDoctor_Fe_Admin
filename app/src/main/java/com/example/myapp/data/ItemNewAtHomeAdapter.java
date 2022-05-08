package com.example.myapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.MyApplication;
import com.example.myapp.R;

import java.util.List;

public class ItemNewAtHomeAdapter extends RecyclerView.Adapter<ItemNewAtHomeAdapter.ItemNewAtHomeViewHoder> {
    List<ItemNewAtHome> mListItemNewAtHome;
    Context mContext1;



    public ItemNewAtHomeAdapter(Context context1, List<ItemNewAtHome> mListItemNewAtHome) {
        this.mContext1 = context1;
        this.mListItemNewAtHome = mListItemNewAtHome;

    }

    @NonNull
    @Override
    public ItemNewAtHomeViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_athome, parent, false);
        return new ItemNewAtHomeViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewAtHomeViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewAtHome ItemNewAtHome = mListItemNewAtHome.get(position);

        if(ItemNewAtHome==null){
            return;
        }
        holder.name.setText(ItemNewAtHome.getName());
        holder.time.setText(ItemNewAtHome.getTd());
        String check = ItemNewAtHome.getActive();
        if(check.equals("not yet")) {
            holder.active.setText(ItemNewAtHome.getActive());
            holder.active.setTextColor(Color.parseColor("#F40132"));
        }else {
            holder.active.setText(ItemNewAtHome.getActive());
            holder.active.setTextColor(Color.parseColor("#01F40D"));
        }
//        holder.image.setImageURI(Uri.parse(ItemNewAtHome.getImage()));
        String checkFace = ItemNewAtHome.getImage();
        if(checkFace.equals("")){
            holder.image.setImageResource(R.drawable.profile);
        }
        else {
            Glide.with(mContext1).load(MyApplication.getMyApplication().getDataUser().getAPI()+ ItemNewAtHome.getImage()).into(holder.image);
        }
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.myApplication.getDataUser().setBenhnhanaddress(ItemNewAtHome.getAddress());
                MyApplication.myApplication.getDataUser().setBenhnhangender(ItemNewAtHome.getGender());
                MyApplication.myApplication.getDataUser().setBenhnhanphone(ItemNewAtHome.getPhone());
                MyApplication.myApplication.getDataUser().setBenhnhananame(ItemNewAtHome.getName());//
                MyApplication.myApplication.getDataUser().setBenhnhanage(ItemNewAtHome.getAge());
                MyApplication.myApplication.getDataUser().setBenhnhanDate(ItemNewAtHome.getDate());
                MyApplication.myApplication.getDataUser().setBenhnhanTime(ItemNewAtHome.getTime());
                MyApplication.myApplication.getDataUser().setBenhnhanActive(ItemNewAtHome.getActive());//
                MyApplication.myApplication.getDataUser().setBenhnhanIDL(ItemNewAtHome.getIdl());
                MyApplication.myApplication.getDataUser().setBenhnhanID(ItemNewAtHome.getIdclient());

//                MyApplication.myApplication.getDataUser().setHomeOneNameHospital(ItemNewAtHome.getName());
                MyApplication.getMyApplication().getDataUser().setDoctorDcchonImage("");
                MyApplication.getMyApplication().getDataUser().setDoctorDcchonName("");
                mContext1.startActivity(new Intent(view.getContext(), CheckALLAtHome.class));
            }
        });



//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//                Log.d("100", String.valueOf(position));
//
//                JSONObject jsonObject = new JSONObject();
//                String jsonStr = null;
//                try {
//                    String email = MyApplication.getMyApplication().getDataUser().getEmailStatic();
//                    jsonObject = new JSONObject();
//                    jsonObject.put("email", email);
//                    jsonObject.put("position", String.valueOf(position));
//                    jsonStr = jsonObject.toString();
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                RequestBody body =
//                        RequestBody.create(MediaType.parse("text/plain"), jsonStr);
//
//                Apiservice.apiservice.profilescheduledelete(body).enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                        String notice = null;
//
//                        try {
//                            notice = response.body().string();
//                            if(notice.equals("success")){
//                                Toast.makeText(view.getContext(), "Success", Toast.LENGTH_LONG).show();
//                                mContext1.startActivity(new Intent(view.getContext(), ProfileDataSchedule.class));
//
//                            }else {
//                                Toast.makeText(view.getContext(), "Fail to Delete", Toast.LENGTH_LONG).show();
//                            }
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Toast.makeText(view.getContext(), "Fail to call API", Toast.LENGTH_LONG).show();
//
//                    }
//                });
//            }
//        });
    }

    public void release(){
        mContext1 = null;
    }
    @Override
    public int getItemCount() {
        if(mListItemNewAtHome!=null){
            return mListItemNewAtHome.size();
        }
        return 0;
    }

    public class ItemNewAtHomeViewHoder extends RecyclerView.ViewHolder{
        private TextView name, time, active;
        private ImageView image;
        private LinearLayout next;





        public ItemNewAtHomeViewHoder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_book_athome_dt_name);
            time = itemView.findViewById(R.id.txt_book_athome_dt_time);
            image = itemView.findViewById(R.id.img_book_athome_dt_img);
            next = itemView.findViewById(R.id.ln_book_athome_dt_next);
            active = itemView.findViewById(R.id.txt_book_athome_dt_active);




        }
    }
}

