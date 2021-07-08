package ro.scoalainformala.traveljournal.ui.trip;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ro.scoalainformala.traveljournal.R;


public class TripViewHolder extends RecyclerView.ViewHolder {

    private final ImageView thumbnail;
    private final TextView title;
    private final RatingBar rating;
    private final TextView destination;
    private final TextView regions;
    private final TextView age_range;
    private final TextView nr_days;
    private final TextView total_price;
    private final CheckBox checkBox;
    private final TextView pricePerDay;

    public TripViewHolder(@NonNull View itemView){
        super(itemView);

        thumbnail = itemView.findViewById(R.id.item_trip_thumbnail);
        title = itemView.findViewById(R.id.item_trip_title);
        rating = itemView.findViewById(R.id.item_trip_rating_bar);
        destination = itemView.findViewById(R.id.item_trip_destinations_text);
        regions = itemView.findViewById(R.id.item_trip_country_region_value);
        age_range = itemView.findViewById(R.id.item_trip_age_range_value);
        nr_days = itemView.findViewById(R.id.item_trip_tour_length_value);
        pricePerDay = itemView.findViewById(R.id.item_trip_price_per_day_value);
        total_price = itemView.findViewById(R.id.item_trip_total_price_value);
        checkBox = itemView.findViewById(R.id.item_trip_checkbox);

    }

    public void bindTrip(Trip trip){
        thumbnail.setImageResource(trip.getThumbnail());
        title.setText(trip.getTitle());
        rating.setRating(trip.getRating());
        destination.setText(trip.getDestinations());
        regions.setText(trip.getRegions());
        age_range.setText(trip.getAge_range());
        nr_days.setText(trip.getNr_days());
        pricePerDay.setText(trip.getPrice_per_day());
        total_price.setText(trip.getTotal_price());
        checkBox.setChecked(trip.isChecked());

    }

}
