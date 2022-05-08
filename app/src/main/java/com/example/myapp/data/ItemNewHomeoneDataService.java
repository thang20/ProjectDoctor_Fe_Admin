package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewHomeoneDataService implements Parcelable  {
    private String name, money, image;



    protected ItemNewHomeoneDataService(Parcel in) {
        name = in.readString();
        money = in.readString();
        image = in.readString();



    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(money);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemNewHomeoneDataService> CREATOR = new Creator<ItemNewHomeoneDataService>() {
        @Override
        public ItemNewHomeoneDataService createFromParcel(Parcel in) {
            return new ItemNewHomeoneDataService(in);
        }

        @Override
        public ItemNewHomeoneDataService[] newArray(int size) {
            return new ItemNewHomeoneDataService[size];
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Creator<ItemNewHomeoneDataService> getCREATOR() {
        return CREATOR;
    }

    public ItemNewHomeoneDataService(String name, String money, String image) {
        this.name = name;
        this.money = money;
        this.image = image;


    }


}
