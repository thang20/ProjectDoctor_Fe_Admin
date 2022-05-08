package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewHomeoneDataContribute implements Parcelable  {
    private String name, avatar, content;



    protected ItemNewHomeoneDataContribute(Parcel in) {
        name = in.readString();
        avatar = in.readString();
        content = in.readString();



    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(avatar);
        dest.writeString(content);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemNewHomeoneDataContribute> CREATOR = new Creator<ItemNewHomeoneDataContribute>() {
        @Override
        public ItemNewHomeoneDataContribute createFromParcel(Parcel in) {
            return new ItemNewHomeoneDataContribute(in);
        }

        @Override
        public ItemNewHomeoneDataContribute[] newArray(int size) {
            return new ItemNewHomeoneDataContribute[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Creator<ItemNewHomeoneDataContribute> getCREATOR() {
        return CREATOR;
    }

    public ItemNewHomeoneDataContribute(String name, String avatar, String content) {
        this.name = name;
        this.avatar = avatar;
        this.content = content;


    }


}
