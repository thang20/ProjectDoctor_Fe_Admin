package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewClient implements Parcelable  {
    private String name, email, pass, phone, image,dateofb,  gender, address, money, point, carepay;



    protected ItemNewClient(Parcel in) {
        name = in.readString();
        email = in.readString();
        pass = in.readString();
        phone = in.readString();
        image = in.readString();
        dateofb = in.readString();
        gender = in.readString();
        address = in.readString();
        money = in.readString();
        point = in.readString();
        carepay = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(pass);
        dest.writeString(phone);

        dest.writeString(image);
        dest.writeString(dateofb);
        dest.writeString(gender);
        dest.writeString(address);
        dest.writeString(money);
        dest.writeString(point);
        dest.writeString(carepay);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemNewHomeoneDataHospital> CREATOR = new Creator<ItemNewHomeoneDataHospital>() {
        @Override
        public ItemNewHomeoneDataHospital createFromParcel(Parcel in) {
            return new ItemNewHomeoneDataHospital(in);
        }

        @Override
        public ItemNewHomeoneDataHospital[] newArray(int size) {
            return new ItemNewHomeoneDataHospital[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateofb() {
        return dateofb;
    }

    public void setDateofb(String dateofb) {
        this.dateofb = dateofb;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getCarepay() {
        return carepay;
    }

    public void setCarepay(String carepay) {
        this.carepay = carepay;
    }

    public static Creator<ItemNewHomeoneDataHospital> getCREATOR() {
        return CREATOR;
    }
    //name, email, pass, phone, image,dateofb,  gender, address, money, point, carepay;
    public ItemNewClient(String name, String email, String pass, String phone, String image,
                         String dateofb, String gender, String address, String money, String point,
                         String carepay) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.image = image;
        this.dateofb = dateofb;
        this.gender = gender;
        this.address = address;
        this.money = money;
        this.point = point;
        this.carepay = carepay;


    }


}
