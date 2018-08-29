package id.liqu.laundry.liquid.ui;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

public class Order implements Serializable {
    String dateP,timeP, location, notes,dateD, timeD, status;
    Double latitude, longitude;
    int harga,berat;

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("dateP",dateP);
        result.put("timeP", timeP);
        result.put("location", location);
        result.put("latitude", latitude);
        result.put("longitude", longitude);
        result.put("notes", notes);
        result.put("dateD", dateD);
        result.put("timeD", timeD);
        result.put("harga", harga);
        result.put("berat", berat);
        result.put("status", status);

        return result;
    }

    public Order(String dateP, String timeP, String location, String notes, String dateD, String timeD, Double latitude, Double longitude) {
        this.dateP = dateP;
        this.timeP = timeP;
        this.location = location;
        this.notes = notes;
        this.dateD = dateD;
        this.timeD = timeD;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Order(String dateP, String timeP, String location, String notes, String dateD, String timeD, Double latitude, Double longitude, int harga, int berat) {
        this.dateP = dateP;
        this.timeP = timeP;
        this.location = location;
        this.notes = notes;
        this.dateD = dateD;
        this.timeD = timeD;
        this.latitude = latitude;
        this.longitude = longitude;
        this.harga = harga;
        this.berat = berat;
    }

    public Order(String dateP, String timeP, String location, String notes, String dateD, String timeD, String status, Double latitude, Double longitude, int harga, int berat) {
        this.dateP = dateP;
        this.timeP = timeP;
        this.location = location;
        this.notes = notes;
        this.dateD = dateD;
        this.timeD = timeD;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.harga = harga;
        this.berat = berat;
    }

    public Order() {
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDateP() {
        return dateP;
    }

    public void setDateP(String dateP) {
        this.dateP = dateP;
    }

    public String getTimeP() {
        return timeP;
    }

    public void setTimeP(String timeP) {
        this.timeP = timeP;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDateD() {
        return dateD;
    }

    public void setDateD(String dateD) {
        this.dateD = dateD;
    }

    public String getTimeD() {
        return timeD;
    }

    public void setTimeD(String timeD) {
        this.timeD = timeD;
    }



    @Override
    public String toString() {
        return "Order{" +
                "dateP='" + dateP + '\'' +
                ", timeP='" + timeP + '\'' +
                ", location='" + location + '\'' +
                ", notes='" + notes + '\'' +
                ", dateD='" + dateD + '\'' +
                ", timeD='" + timeD + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
