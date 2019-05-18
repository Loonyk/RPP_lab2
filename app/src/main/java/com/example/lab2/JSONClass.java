package com.example.lab2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONClass implements Parcelable {

    @SerializedName("graphic")
    @Expose
    private String graphic;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("helptext")
    @Expose
    private String helptext;


    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }

    @Override
    public String toString() {
        return "JSONClass{" +
                "graphic='" + graphic + '\'' +
                ", name='" + name + '\'' +
                ", helptext='" + helptext + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(graphic);
        dest.writeString(name);
        dest.writeString(helptext);
    }

    private JSONClass(Parcel in) {
        graphic = in.readString();
        name = in.readString();
        helptext = in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public JSONClass createFromParcel(Parcel in) {
            return new JSONClass(in);
        }

        public JSONClass[] newArray(int size) {
            return new JSONClass[size];
        }
    };

}