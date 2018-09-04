package com.example.administrator.demos.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/8/13.
 */

public class ParcelInnerDemo implements Parcelable {

    private String id;
    private int index;

    public ParcelInnerDemo(){

    }

    protected ParcelInnerDemo(Parcel in) {
        id = in.readString();
        index = in.readInt();
    }

    public static final Creator<ParcelInnerDemo> CREATOR = new Creator<ParcelInnerDemo>() {
        @Override
        public ParcelInnerDemo createFromParcel(Parcel in) {
            return new ParcelInnerDemo(in);
        }

        @Override
        public ParcelInnerDemo[] newArray(int size) {
            return new ParcelInnerDemo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(index);
    }
}
