package br.com.alcheno.javapop.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lusca on 06/10/2017.
 */

public class Dados implements Parcelable {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("description")
    private String description;

    @SerializedName("forks")
    private int forks;

    @SerializedName("stargazers_count")
    private int stars;

    @SerializedName("owner")
    private Owner owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    protected Dados(Parcel in) {
        id = in.readLong();
        name = in.readString();
        fullName = in.readString();
        description = in.readString();
        forks = in.readInt();
        stars = in.readInt();
        owner = in.readParcelable(Owner.class.getClassLoader());
    }

    public static final Creator<Dados> CREATOR = new Creator<Dados>() {
        @Override
        public Dados createFromParcel(Parcel in) {
            return new Dados(in);
        }

        @Override
        public Dados[] newArray(int size) {
            return new Dados[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(fullName);
        parcel.writeString(description);
        parcel.writeInt(forks);
        parcel.writeInt(stars);
        parcel.writeParcelable(owner, i);
    }
}
