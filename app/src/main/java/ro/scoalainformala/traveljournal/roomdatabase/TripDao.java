package ro.scoalainformala.traveljournal.roomdatabase;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TripDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Trip trip);

    @Query("DELETE FROM trip_table")
    void deleteAll();

    @Query("SELECT * from trip_table ORDER BY ID ASC")
    LiveData<List<Trip>> getOrderedTrips();

    @Query("DELETE FROM trip_table WHERE ID = :id")
    void deleteById(int id);

    @Update(onConflict = OnConflictStrategy.IGNORE, entity = Trip.class)
    public void updateTrip(Trip trip);

}
