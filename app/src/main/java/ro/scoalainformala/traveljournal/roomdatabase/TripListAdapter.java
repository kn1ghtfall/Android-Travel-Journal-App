package ro.scoalainformala.traveljournal.roomdatabase;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import ro.scoalainformala.traveljournal.R;

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.TripViewHolder> {


    class TripViewHolder extends RecyclerView.ViewHolder {
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

        public TripViewHolder(@NonNull View itemView) {
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
    }

    private final LayoutInflater mInflater;
    private List<Trip> trips; // Cached copy of trips

    public TripListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_trip, parent, false);
        return new TripViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripListAdapter.TripViewHolder holder, int position) {
        if (trips != null) {
            Trip trip = trips.get(position);
            holder.thumbnail.setImageResource(trip.getThumbnail());
            holder.title.setText(trip.getTitle());
            holder.rating.setRating(trip.getRating());
            holder.destination.setText(trip.getDestinations());
            holder.regions.setText(trip.getRegions());
            holder.age_range.setText(trip.getAge_range());
            holder.nr_days.setText(trip.getNr_days());
            holder.pricePerDay.setText(trip.getPrice_per_day());
            holder.total_price.setText(trip.getTotal_price());
            holder.checkBox.setChecked(trip.isChecked());
        }
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (trips != null) {
            return trips.size();
        } else
            return 0;
    }
}
