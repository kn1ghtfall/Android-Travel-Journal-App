package ro.scoalainformala.traveljournal.roomdatabase;


import androidx.annotation.DrawableRes;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

@Entity(tableName = "trip_table")
public class Trip {

    @PrimaryKey
    private Integer ID;

    @DrawableRes
    private final int thumbnail;
    private final String title;
    private final float rating;
    private final String destinations;
    private final String regions;
    private final String age_range;
    private final String nr_days;
    private final String total_price;
    private String price_per_day;
    private final boolean checked;

    public Trip(int ID, int thumbnail, String title, float rating, String destinations, String regions, String age_range, String nr_days, String total_price, boolean checked) {
        this.ID = ID;
        this.thumbnail = thumbnail;
        this.title = title;
        this.rating = rating;
        this.destinations = destinations;
        this.regions = regions;
        this.age_range = age_range;
        this.nr_days = nr_days;
        this.total_price = total_price;
        this.checked = checked;

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance(Locale.GERMANY));

        String s1 = total_price.replaceAll("[€,]","");
        s1.replaceAll(".00","");
        this.price_per_day = String.valueOf(Integer.parseInt(s1) / Integer.parseInt(nr_days.split(" ")[0]));



    }


    @Ignore
    public Trip(int thumbnail, String title, float rating, String destinations, String regions, String age_range, String nr_days, String total_price, boolean checked) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.rating = rating;
        this.destinations = destinations;
        this.regions = regions;
        this.age_range = age_range;
        this.nr_days = nr_days;
        this.total_price = total_price;
        this.checked = checked;

        this.price_per_day = String.valueOf(Integer.parseInt(total_price) / Integer.parseInt(nr_days.split(" ")[0]));
    }



    public String getPrice_per_day(){
//        NumberFormat formatter = NumberFormat.getCurrencyInstance();
//        formatter.setCurrency(Currency.getInstance(Locale.GERMANY));

//        return formatter.format(Integer.parseInt(price_per_day)).replaceAll("[,.]00","");

        return price_per_day;
    }

    public Integer getID() {
        return ID;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }

    public String getDestinations() {
        return destinations;
    }

    public String getRegions() {
        return regions;
    }

    public String getNr_days() {
        return nr_days;
    }

    public String getTotal_price() {
//        NumberFormat formatter = NumberFormat.getCurrencyInstance();
//        formatter.setCurrency(Currency.getInstance(Locale.GERMANY));
//        return formatter.format(Integer.parseInt(total_price)).replaceAll("[,.]00","");
        return total_price;
    }

    public String getAge_range() {
        return age_range;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setPrice_per_day(String price_per_day) {
        this.price_per_day = price_per_day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ro.scoalainformala.traveljournal.trip.Trip)) return false;
        ro.scoalainformala.traveljournal.trip.Trip trip = (ro.scoalainformala.traveljournal.trip.Trip) o;
        return getThumbnail() == trip.getThumbnail() &&
                Float.compare(trip.getRating(), getRating()) == 0 &&
                isChecked() == trip.isChecked() &&
                Objects.equals(getTitle(), trip.getTitle()) &&
                Objects.equals(getDestinations(), trip.getDestinations()) &&
                Objects.equals(getRegions(), trip.getRegions()) &&
                Objects.equals(getAge_range(), trip.getAge_range()) &&
                Objects.equals(getNr_days(), trip.getNr_days()) &&
                Objects.equals(getTotal_price(), trip.getTotal_price());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getThumbnail(), getTitle(), getRating(), getDestinations(), getRegions(), getAge_range(), getNr_days(), getTotal_price(), isChecked());
    }
}
