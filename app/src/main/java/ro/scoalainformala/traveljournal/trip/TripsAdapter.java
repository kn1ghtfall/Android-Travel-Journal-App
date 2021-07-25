package ro.scoalainformala.traveljournal.trip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.scoalainformala.traveljournal.R;

public class TripsAdapter extends RecyclerView.Adapter<TripViewHolder> {
    private final List<Trip> trips;
    private TripSelectedListener tripSelectedListener = null ;


    public TripsAdapter(List<Trip> trips){
        this.trips = trips;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_trip, parent, false);

        TripViewHolder viewHolder = new TripViewHolder(itemView);

//        itemView.setOnClickListener( v->{
//            if(tripSelectedListener != null ){
//                tripSelectedListener.onTripSelected(trips.get(viewHolder.getAdapterPosition()));
//            }
//        });

        return viewHolder;

    }

//    public void setTripSelectedListener(TripSelectedListener tripSelectedListener) {
//        this.tripSelectedListener = tripSelectedListener;
//    }

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
