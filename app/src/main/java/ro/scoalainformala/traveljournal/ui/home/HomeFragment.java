package ro.scoalainformala.traveljournal.ui.home;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.scoalainformala.traveljournal.roomdatabase.Trip;
import ro.scoalainformala.traveljournal.roomdatabase.TripListAdapter;
import ro.scoalainformala.traveljournal.roomdatabase.TripViewModel;
//import ro.scoalainformala.traveljournal.trip.TripsAdapter;
//import ro.scoalainformala.traveljournal.trip.TripsDataSource;
import ro.scoalainformala.traveljournal.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TripViewModel mTripViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        RecyclerView recyclerView = binding.recycler;
//        recyclerView.setLayoutManager(linearLayoutManager);
//        TripsDataSource dataSource = new TripsDataSource();
//        TripsAdapter adapter =new TripsAdapter(dataSource.getTrips());
//
//        recyclerView.setAdapter(adapter);


        RecyclerView recyclerView = binding.recycler;
        final TripListAdapter adapter = new TripListAdapter(this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mTripViewModel = new ViewModelProvider(this).get(TripViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.

        mTripViewModel.getAllTrips().observe(getViewLifecycleOwner(), new Observer<List<Trip>>() {
            @Override
            public void onChanged(@Nullable final List<Trip> trips) {
                // Update the cached copy of the words in the adapter.
                adapter.setTrips(trips);
            }
        });


//        adapter.setTripSelectedListener(trip -> {
//            // pasare chestii
//        });

        return  root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}