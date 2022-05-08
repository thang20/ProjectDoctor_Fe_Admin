package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewHomeoneDataGift implements Parcelable  {
    private String name, money;



    protected ItemNewHomeoneDataGift(Parcel in) {
        name = in.readString();
        money = in.readString();




    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(money);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemNewHomeoneDataGift> CREATOR = new Creator<ItemNewHomeoneDataGift>() {
        @Override
        public ItemNewHomeoneDataGift createFromParcel(Parcel in) {
            return new ItemNewHomeoneDataGift(in);
        }

        @Override
        public ItemNewHomeoneDataGift[] newArray(int size) {
            return new ItemNewHomeoneDataGift[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public static Creator<ItemNewHomeoneDataGift> getCREATOR() {
        return CREATOR;
    }

    public ItemNewHomeoneDataGift(String name, String money) {
        this.name = name;
        this.money = money;

    }


}
