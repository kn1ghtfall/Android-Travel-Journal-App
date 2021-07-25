package ro.scoalainformala.traveljournal.roomdatabase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TripRepository {

    private TripDao mTripDao;
    private LiveData<List<Trip>> mAllTrips;


    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    TripRepository(Application application) {
        TripRoomDatabase db = TripRoomDatabase.getDatabase(application);
        mTripDao = db.tripDao();
        mAllTrips = mTripDao.getOrderedTrips();
    }



    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Trip>> getAllTrips() {
        return mAllTrips;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Trip project) {
        TripRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTripDao.insert(project);
        });
    }

    void deleteAll(){
        TripRoomDatabase.databaseWriteExecutor.execute(() ->{
            mTripDao.deleteAll();
        });
    }


    void deleteById(int id){
        TripRoomDatabase.databaseWriteExecutor.execute(() ->{
            mTripDao.deleteById(id);
        });
    }

}
