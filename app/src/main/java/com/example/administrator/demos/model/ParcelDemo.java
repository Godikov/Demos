package com.example.administrator.demos.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/8/13.
 */

public class ParcelDemo implements Parcelable {

    private String name;
    private int age;
    private boolean bool;
    private ParcelInnerDemo innerDemo;

    public ParcelDemo(){

    }

    protected ParcelDemo(Parcel in) {
        name = in.readString();
        age = in.readInt();
        bool = in.readByte() != 0;
        innerDemo = in.readParcelable(ParcelInnerDemo.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeByte((byte) (bool ? 1 : 0));
        dest.writeParcelable(innerDemo, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ParcelDemo> CREATOR = new Creator<ParcelDemo>() {
        @Override
        public ParcelDemo createFromParcel(Parcel in) {
            return new ParcelDemo(in);
        }

        @Override
        public ParcelDemo[] newArray(int size) {
            return new ParcelDemo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public ParcelInnerDemo getInnerDemo() {
        return innerDemo;
    }

    public void setInnerDemo(ParcelInnerDemo innerDemo) {
        this.innerDemo = innerDemo;
    }

}
