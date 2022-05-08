package com.example.myapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.home.AllInforClient;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemNewClientAdapter extends RecyclerView.Adapter<ItemNewClientAdapter.ItemNewClientViewHoder> implements Filterable {
    List<ItemNewClient> mListItemNewClient;
    List<ItemNewClient> mListItemNewClientold;
    Context mContext1;



    public ItemNewClientAdapter(Context context1, List<ItemNewClient> mListItemNewClient) {
        this.mContext1 = context1;
        this.mListItemNewClient = mListItemNewClient;
        this.mListItemNewClientold = mListItemNewClient;

    }

    @NonNull
    @Override
    public ItemNewClientViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_client_admin, parent, false);
        return new ItemNewClientViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewClientViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewClient ItemNewClient = mListItemNewClient.get(position);

        if(ItemNewClient==null){
            return;
        }
        holder.name.setText(ItemNewClient.getName());

        String checkFace = ItemNewClient.getImage();
        if(checkFace.equals("null")){
            holder.image.setImageResource(R.drawable.profile);
        }
        else {
            Glide.with(mContext1).load(MyApplication.getMyApplication().getDataUser().getAPI()+ ItemNewClient.getImage()).into(holder.image);
        }
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name, email, pass, phone, image,dateofb,  gender, address, money, point, carepay;
                MyApplication.myApplication.getDataUser().setAllClientname(ItemNewClient.getName());
                MyApplication.myApplication.getDataUser().setAllClientemail(ItemNewClient.getEmail());
                MyApplication.myApplication.getDataUser().setAllClientpass(ItemNewClient.getPass());
                MyApplication.myApplication.getDataUser().setAllClientphone(ItemNewClient.getPhone());
                MyApplication.myApplication.getDataUser().setAllClientimage(ItemNewClient.getImage());
                MyApplication.myApplication.getDataUser().setAllClientdateofb(ItemNewClient.getDateofb());
                MyApplication.myApplication.getDataUser().setAllClientgender(ItemNewClient.getGender());
                MyApplication.myApplication.getDataUser().setAllClientaddress(ItemNewClient.getAddress());
                MyApplication.myApplication.getDataUser().setAllClientmoney(ItemNewClient.getMoney());
                MyApplication.myApplication.getDataUser().setAllClientpoint(ItemNewClient.getPoint());
                MyApplication.myApplication.getDataUser().setAllClientcarepayat(ItemNewClient.getCarepay());

                mContext1.startActivity(new Intent(view.getContext(), AllInforClient.class));
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
        if(mListItemNewClient!=null){
            return mListItemNewClient.size();
        }
        return 0;
    }



    public class ItemNewClientViewHoder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView image;
        private LinearLayout next;





        public ItemNewClientViewHoder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_book_athospital_dt_name);
            image = itemView.findViewById(R.id.img_book_athospital_dt_img);
            next = itemView.findViewById(R.id.ln_book_athospital_dt_next);




        }
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String search = charSequence.toString();
                if(search.isEmpty()){
                    mListItemNewClient = mListItemNewClientold;
                }else {
                    List<ItemNewClient> list = new ArrayList<>();
                    for (ItemNewClient itemNewClient : mListItemNewClientold) {
                        if (itemNewClient.getName().toLowerCase().contains(search)){
                            list.add(itemNewClient);

                        }
                        
                    }
                    mListItemNewClient = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListItemNewClient;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListItemNewClient = (List<ItemNewClient>) filterResults.values;
                notifyDataSetChanged();

            }
        };
    }
}


