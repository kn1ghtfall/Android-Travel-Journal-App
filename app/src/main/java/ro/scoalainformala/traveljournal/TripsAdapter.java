package ro.scoalainformala.traveljournal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TripsAdapter extends RecyclerView.Adapter<TripViewHolder> {
    private final List<Trip> trips;

    public TripsAdapter(List<Trip> trips){
        this.trips = trips;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_trip, parent, false);

        return new TripViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip trip =trips.get(position);
        holder.bindTrip(trip);
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }
}
