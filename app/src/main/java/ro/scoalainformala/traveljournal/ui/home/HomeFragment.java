package ro.scoalainformala.traveljournal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ro.scoalainformala.traveljournal.MainActivity2;
import ro.scoalainformala.traveljournal.R;
import ro.scoalainformala.traveljournal.TripsAdapter;
import ro.scoalainformala.traveljournal.TripsDataSource;
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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}