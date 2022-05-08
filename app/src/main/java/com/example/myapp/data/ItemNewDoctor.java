package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewDoctor implements Parcelable  {
    private String name, email, pass, phone, image,dateofb,  gender, address, money, point, carepay, hospital, spec, cc, iddoctor;



    protected ItemNewDoctor(Parcel in) {
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

        hospital = in.readString();
        spec = in.readString();
        cc = in.readString();
        iddoctor = in.readString();

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

        dest.writeString(hospital);
        dest.writeString(spec);
        dest.writeString(cc);
        dest.writeString(iddoctor);


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

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

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

    public String getIddoctor() {
        return iddoctor;
    }
    public void setIddoctor(String iddoctor) {
        this.iddoctor = iddoctor;
    }

    public static Creator<ItemNewHomeoneDataHospital> getCREATOR() {
        return CREATOR;
    }
    //name, email, pass, phone, image,dateofb,  gender, address, money, point, carepay;
    public ItemNewDoctor(String name, String email, String pass, String phone, String image,
                         String dateofb, String gender, String address, String money, String point,
                         String carepay, String hospital, String spec, String cc, String iddoctor) {
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

        this.hospital = hospital;
        this.spec = spec;
        this.cc = cc;
        this.iddoctor = iddoctor;



    }


}
