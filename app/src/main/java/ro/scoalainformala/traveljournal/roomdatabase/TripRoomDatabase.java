package ro.scoalainformala.traveljournal.roomdatabase;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ro.scoalainformala.traveljournal.R;


@Database(entities = {Trip.class} , version =   1, exportSchema = false)
public abstract class TripRoomDatabase extends RoomDatabase {


    public abstract TripDao tripDao();


    private static volatile TripRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static  TripRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (TripRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TripRoomDatabase.class, "trip_databse")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     *
     * If you want to populate the database only when the database is created for the 1st time,
     * override RoomDatabase.Callback()#onCreate
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TripDao dao = INSTANCE.tripDao();
                dao.deleteAll();

                Trip project = new Trip(100,R.drawable.italy_trip_2_rome_venice, "Rome to Venice Adventure Tour"
                        , 4.3F, "Rome, Florence, Cinque Terre, Venice", "Italy", "18 to 99", "10 days", "1519", false);
                dao.insert(project);
                project = new Trip(200,R.drawable.italy_trip_2_rome_venice, "Rome to Venice Adventure Tour"
                        , 4.3F, "Rome, Florence, Cinque Terre, Venice", "Italy", "18 to 99", "10 days", "1519", false);
                dao.insert(project);
            });
        }
    };



}
