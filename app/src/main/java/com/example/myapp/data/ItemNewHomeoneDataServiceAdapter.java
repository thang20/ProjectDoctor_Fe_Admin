package com.example.myapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.Home;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemNewHomeoneDataServiceAdapter extends RecyclerView.Adapter<ItemNewHomeoneDataServiceAdapter.ItemNewHomeoneDataServiceViewHoder> {
    List<ItemNewHomeoneDataService> mListItemNewHomeoneDataService;
    Context mContext1;



    public ItemNewHomeoneDataServiceAdapter(Context context1, List<ItemNewHomeoneDataService> mListItemNewHomeoneDataService) {
        this.mContext1 = context1;
        this.mListItemNewHomeoneDataService = mListItemNewHomeoneDataService;

    }

    @NonNull
    @Override
    public ItemNewHomeoneDataServiceViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_service_data, parent, false);
        return new ItemNewHomeoneDataServiceViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewHomeoneDataServiceViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewHomeoneDataService ItemNewHomeoneDataService = mListItemNewHomeoneDataService.get(position);

        if(ItemNewHomeoneDataService==null){
            return;
        }
        holder.name.setText(ItemNewHomeoneDataService.getName());
        holder.money.setText(ItemNewHomeoneDataService.getMoney());
        Glide.with(mContext1).load(MyApplication.getMyApplication().getDataUser().getAPI()+ItemNewHomeoneDataService.getImage()).into(holder.image);
        Log.d("999", ItemNewHomeoneDataService.getImage());
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObject = new JSONObject();
                String jsonStr = null;
                try {
                    //Toast.makeText(mContext1, ItemNewHomeoneDataService.getName(), Toast.LENGTH_SHORT).show();
                    jsonObject = new JSONObject();
                    jsonObject.put("name", ItemNewHomeoneDataService.getName());
                    jsonStr = jsonObject.toString();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody body =
                        RequestBody.create(MediaType.parse("text/plain"), jsonStr);

                Apiservice.apiservice.deleteservice(body).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String notice = null;

                        try {
                            notice = response.body().string();
                            if(notice.equals("success")){
                                Toast.makeText(view.getContext(), "Success to delete", Toast.LENGTH_LONG).show();
                                mContext1.startActivity(new Intent(view.getContext(), Home.class));

                            }else {
                                Toast.makeText(view.getContext(), "you can not delete this service", Toast.LENGTH_LONG).show();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(view.getContext(), "Fail to call API", Toast.LENGTH_LONG).show();
                    }
                });
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
        if(mListItemNewHomeoneDataService!=null){
            return mListItemNewHomeoneDataService.size();
        }
        return 0;
    }

    public class ItemNewHomeoneDataServiceViewHoder extends RecyclerView.ViewHolder{
        private TextView name, money;
        private ImageView image;
        private Button next;





        public ItemNewHomeoneDataServiceViewHoder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_home_home1_data_allService_name);
            money = itemView.findViewById(R.id.txt_home_home1_data_allService_money);
            image = itemView.findViewById(R.id.imv_home_home1_data_allService_image);
            next = itemView.findViewById(R.id.btn_home_home1_data_allService_book);



        }
    }
}

