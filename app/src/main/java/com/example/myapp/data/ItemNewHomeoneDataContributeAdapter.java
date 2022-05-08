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

public class ItemNewHomeoneDataContributeAdapter extends RecyclerView.Adapter<ItemNewHomeoneDataContributeAdapter.ItemNewHomeoneDataContributeViewHoder> {
    List<ItemNewHomeoneDataContribute> mListItemNewHomeoneDataContribute;
    Context mContext1;



    public ItemNewHomeoneDataContributeAdapter(Context context1, List<ItemNewHomeoneDataContribute> mListItemNewHomeoneDataContribute) {
        this.mContext1 = context1;
        this.mListItemNewHomeoneDataContribute = mListItemNewHomeoneDataContribute;

    }

    @NonNull
    @Override
    public ItemNewHomeoneDataContributeViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_data_contribute, parent, false);
        return new ItemNewHomeoneDataContributeViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewHomeoneDataContributeViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewHomeoneDataContribute ItemNewHomeoneDataContribute = mListItemNewHomeoneDataContribute.get(position);

        if(ItemNewHomeoneDataContribute==null){
            return;
        }
        holder.name.setText(ItemNewHomeoneDataContribute.getName());
        holder.content.setText(ItemNewHomeoneDataContribute.getContent());
        String checkFace = ItemNewHomeoneDataContribute.getAvatar();
        if(checkFace.equals("")){
            holder.avatar.setImageResource(R.drawable.profile);
        }else {
            Glide.with(mContext1).load(MyApplication.getMyApplication().getDataUser().getAPI() + ItemNewHomeoneDataContribute.getAvatar()).into(holder.avatar);
        }
//        Glide.with(mContext1).load(MyApplication.getMyApplication().getDataUser().getAPI()+ItemNewDataQADoctor.getImageFace()).into(holder.face);


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
        if(mListItemNewHomeoneDataContribute!=null){
            return mListItemNewHomeoneDataContribute.size();
        }
        return 0;
    }

    public class ItemNewHomeoneDataContributeViewHoder extends RecyclerView.ViewHolder{
        private TextView name, content;
        private ImageView avatar;






        public ItemNewHomeoneDataContributeViewHoder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_item_new_fullName_contribute);
            avatar = itemView.findViewById(R.id.rcv_item_new_imageFace_contribute);
            content = itemView.findViewById(R.id.txt_item_new_content_contribute);




        }
    }
}


