package ro.scoalainformala.traveljournal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ro.scoalainformala.traveljournal.ui.trip.TripsAdapter;
import ro.scoalainformala.traveljournal.ui.trip.TripsDataSource;
import ro.scoalainformala.traveljournal.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = binding.recycler;
        recyclerView.setLayoutManager(linearLayoutManager);
        TripsDataSource dataSource = new TripsDataSource();
        TripsAdapter adapter =new TripsAdapter(dataSource.getTrips());

        recyclerView.setAdapter(adapter);


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