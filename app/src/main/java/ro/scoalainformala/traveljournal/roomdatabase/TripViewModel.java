package ro.scoalainformala.traveljournal.roomdatabase;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TripViewModel extends AndroidViewModel {

    private TripRepository mRepository;

    private LiveData<List<Trip>> mAllTrips;

    public TripViewModel (Application application){
        super(application);
        mRepository = new TripRepository(application);
        mAllTrips = mRepository.getAllTrips();
    }

    public LiveData<List<Trip>> getAllTrips(){
        return  mAllTrips;
    }

    public void insert(Trip project){
        mRepository.insert(project);
    }

    public void deleteAll(){
        mRepository.deleteAll();
    }


    public void deleteById(int id){
        mRepository.deleteById(id);
    }

}
