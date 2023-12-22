package com.example.baza.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Smartphone implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "model")
    private String model;

    @NonNull
    @ColumnInfo(name = "producer")
    private String producer;

    @NonNull
    @ColumnInfo(name = "version")
    private String version;

    @NonNull
    @ColumnInfo(name = "website_address")
    private String websiteAddress;

    public Smartphone() {
    }

    protected Smartphone(Parcel in){
        id = in.readInt();
        model = in.readString();
        producer = in.readString();
        version = in.readString();
        websiteAddress = in.readString();
    }

    public static final Creator<Smartphone> CREATOR = new Creator<Smartphone>() {
        @Override
        public Smartphone createFromParcel(Parcel in) {
            return new Smartphone(in);
        }

        @Override
        public Smartphone[] newArray(int size) {
            return new Smartphone[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(model);
        parcel.writeString(producer);
        parcel.writeString(version);
        parcel.writeString(websiteAddress);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProducer(@NonNull String producer) {
        this.producer = producer;
    }

    public void setVersion(@NonNull String version) {
        this.version = version;
    }

    public void setWebsiteAddress(@NonNull String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }


    public String getModel() {
        return model;
    }

    @NonNull
    public String getProducer() {
        return producer;
    }

    @NonNull
    public String getVersion() {
        return version;
    }

    @NonNull
    public String getWebsiteAddress() {
        return websiteAddress;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
