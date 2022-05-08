package com.example.myapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

public class ItemNewHomeoneDataGiftAdapter extends RecyclerView.Adapter<ItemNewHomeoneDataGiftAdapter.ItemNewHomeoneDataGiftViewHoder> {
    List<ItemNewHomeoneDataGift> mListItemNewHomeoneDataGift;
    Context mContext1;



    public ItemNewHomeoneDataGiftAdapter(Context context1, List<ItemNewHomeoneDataGift> mListItemNewHomeoneDataGift) {
        this.mContext1 = context1;
        this.mListItemNewHomeoneDataGift = mListItemNewHomeoneDataGift;

    }

    @NonNull
    @Override
    public ItemNewHomeoneDataGiftViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_gift_data, parent, false);
        return new ItemNewHomeoneDataGiftViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewHomeoneDataGiftViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewHomeoneDataGift ItemNewHomeoneDataGift = mListItemNewHomeoneDataGift.get(position);

        if(ItemNewHomeoneDataGift==null){
            return;
        }
        holder.name.setText(ItemNewHomeoneDataGift.getName());
        holder.money.setText(ItemNewHomeoneDataGift.getMoney());
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObject = new JSONObject();
                String jsonStr = null;
                try {
                    //Toast.makeText(mContext1, ItemNewHomeoneDataGift.getName(), Toast.LENGTH_SHORT).show();
                    jsonObject = new JSONObject();
                    jsonObject.put("name", ItemNewHomeoneDataGift.getName());
                    jsonStr = jsonObject.toString();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody body =
                        RequestBody.create(MediaType.parse("text/plain"), jsonStr);

                Apiservice.apiservice.deletegift(body).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String notice = null;

                        try {
                            notice = response.body().string();
                            if(notice.equals("success")){
                                Toast.makeText(view.getContext(), "Success to delete", Toast.LENGTH_LONG).show();
                                mContext1.startActivity(new Intent(view.getContext(), Home.class));

                            }else {
                                Toast.makeText(view.getContext(), "fail delete gift", Toast.LENGTH_LONG).show();
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
        if(mListItemNewHomeoneDataGift!=null){
            return mListItemNewHomeoneDataGift.size();
        }
        return 0;
    }

    public class ItemNewHomeoneDataGiftViewHoder extends RecyclerView.ViewHolder{
        private TextView name, money;
        private Button next;





        public ItemNewHomeoneDataGiftViewHoder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_home_home1_data_allGift_code);
            money = itemView.findViewById(R.id.txt_home_home1_data_allGift_money);
            next = itemView.findViewById(R.id.btn_home_home1_data_allGift_book);



        }
    }
}

