
package com.juaracoding.mahasiswaappver2.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MahasiswaModel implements Serializable, Parcelable
{

    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    public final static Creator<MahasiswaModel> CREATOR = new Creator<MahasiswaModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MahasiswaModel createFromParcel(Parcel in) {
            return new MahasiswaModel(in);
        }

        public MahasiswaModel[] newArray(int size) {
            return (new MahasiswaModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2236258547044703011L;

    protected MahasiswaModel(Parcel in) {
        this.nik = ((String) in.readValue((String.class.getClassLoader())));
        this.nama = ((String) in.readValue((String.class.getClassLoader())));
        this.alamat = ((String) in.readValue((String.class.getClassLoader())));
        this.tanggal = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public MahasiswaModel() {
    }

    /**
     * 
     * @param nik
     * @param nama
     * @param tanggal
     * @param alamat
     */
    public MahasiswaModel(String nik, String nama, String alamat, String tanggal) {
        super();
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.tanggal = tanggal;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(nik);
        dest.writeValue(nama);
        dest.writeValue(alamat);
        dest.writeValue(tanggal);
    }

    public int describeContents() {
        return  0;
    }

}
