package com.example.myapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.example.myapp.home.AllInforDoctor;
import com.example.myapp.home.TakeDoctorFree;

import java.util.ArrayList;
import java.util.List;

public class ItemNewDoctorAdapter extends RecyclerView.Adapter<ItemNewDoctorAdapter.ItemNewDoctorViewHoder> implements Filterable {
    List<ItemNewDoctor> mListItemNewDoctor;
    List<ItemNewDoctor> mListItemNewDoctorold;
    Context mContext1;



    public ItemNewDoctorAdapter(Context context1, List<ItemNewDoctor> mListItemNewDoctor) {
        this.mContext1 = context1;
        this.mListItemNewDoctor = mListItemNewDoctor;
        this.mListItemNewDoctorold = mListItemNewDoctor;

    }

    @NonNull
    @Override
    public ItemNewDoctorViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_client_admin, parent, false);
        return new ItemNewDoctorViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewDoctorViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewDoctor ItemNewDoctor = mListItemNewDoctor.get(position);

        if(ItemNewDoctor==null){
            return;
        }
        holder.name.setText(ItemNewDoctor.getName());

        String checkFace = ItemNewDoctor.getImage();
        if(checkFace.equals("null")){
            holder.image.setImageResource(R.drawable.profile);
        }
        else {
            Glide.with(mContext1).load(MyApplication.getMyApplication().getDataUser().getAPI()+ ItemNewDoctor.getImage()).into(holder.image);
        }
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name, email, pass, phone, image,dateofb,  gender, address, money, point, carepay;
                MyApplication.myApplication.getDataUser().setAllDoctorname(ItemNewDoctor.getName());
                MyApplication.myApplication.getDataUser().setAllDoctoremail(ItemNewDoctor.getEmail());
                MyApplication.myApplication.getDataUser().setAllDoctorpass(ItemNewDoctor.getPass());
                MyApplication.myApplication.getDataUser().setAllDoctorphone(ItemNewDoctor.getPhone());
                MyApplication.myApplication.getDataUser().setAllDoctorimage(ItemNewDoctor.getImage());
                MyApplication.myApplication.getDataUser().setAllDoctordateofb(ItemNewDoctor.getDateofb());
                MyApplication.myApplication.getDataUser().setAllDoctorgender(ItemNewDoctor.getGender());
                MyApplication.myApplication.getDataUser().setAllDoctoraddress(ItemNewDoctor.getAddress());
                MyApplication.myApplication.getDataUser().setAllDoctormoney(ItemNewDoctor.getMoney());
                MyApplication.myApplication.getDataUser().setAllDoctorpoint(ItemNewDoctor.getPoint());
                MyApplication.myApplication.getDataUser().setAllDoctorcarepayat(ItemNewDoctor.getCarepay());

                MyApplication.myApplication.getDataUser().setAllDoctorhospital(ItemNewDoctor.getHospital());
                MyApplication.myApplication.getDataUser().setAllDoctorspec(ItemNewDoctor.getSpec());
                MyApplication.myApplication.getDataUser().setAllDoctorcc(ItemNewDoctor.getCc());
                MyApplication.myApplication.getDataUser().setAllDoctorID(ItemNewDoctor.getIddoctor());

                String check =  MyApplication.getMyApplication().getDataUser().getDoctorFree();
                if(check.equals("0")) {
                    mContext1.startActivity(new Intent(view.getContext(), AllInforDoctor.class));
                }else {
                    mContext1.startActivity(new Intent(view.getContext(), TakeDoctorFree.class));
                }
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
        if(mListItemNewDoctor!=null){
            return mListItemNewDoctor.size();
        }
        return 0;
    }



    public class ItemNewDoctorViewHoder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView image;
        private LinearLayout next;





        public ItemNewDoctorViewHoder(@NonNull View itemView) {
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
                    mListItemNewDoctor = mListItemNewDoctorold;
                }else {
                    List<ItemNewDoctor> list = new ArrayList<>();
                    for (ItemNewDoctor itemNewDoctor : mListItemNewDoctorold) {
                        if (itemNewDoctor.getName().toLowerCase().contains(search)){
                            list.add(itemNewDoctor);

                        }

                    }
                    mListItemNewDoctor = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListItemNewDoctor;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListItemNewDoctor = (List<ItemNewDoctor>) filterResults.values;
                notifyDataSetChanged();

            }
        };
    }
}



