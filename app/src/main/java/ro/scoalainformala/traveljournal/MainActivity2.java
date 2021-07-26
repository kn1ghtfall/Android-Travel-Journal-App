package ro.scoalainformala.traveljournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import ro.scoalainformala.traveljournal.EditTrip.NewTripActivity;
import ro.scoalainformala.traveljournal.EditTrip.RemoveTripActivity;
import ro.scoalainformala.traveljournal.databinding.ActivityMain2Binding;
import ro.scoalainformala.traveljournal.roomdatabase.Trip;
import ro.scoalainformala.traveljournal.roomdatabase.TripViewModel;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public static final int NEW_TRIP_ACTIVITY_REQUEST_CODE = 1;
    public static final int REMOVE_TRIP_ACTIVITY_REQUEST_CODE = 2;


    // binding - replaces 'findViewById()'
    // ActivityMainBinging -> class generated when using binding, it contains the id-s from activity_main.xml
    private ActivityMain2Binding binding;
    private TripViewModel mTripViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarMain.toolbar);


        //
        // Navigation Bar implementation
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_about_us)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Setarea intent-urilor pentru Share si Contact
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                Log.d("CEVA", "a fost selectat un item");
                //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
                if (id == R.id.nav_home) {
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                }
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Log.d("CEVA", "home item selected");
                        break;
                    case R.id.nav_contact:
                        Log.d("CEVA", "contact item selected");
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String[] emails = new String[1];
                        emails[0] = "emailaddress@emailadress.com";
                        intent.putExtra(Intent.EXTRA_EMAIL, emails);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
                        startActivity(Intent.createChooser(intent, "Send Email"));
                        break;
                    case R.id.nav_share:
                        Log.d("CEVA", "Buttonul de share a fost apasat");
                        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                        sendIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.googlequicksearchbox"));


                        Intent shareIntent = Intent.createChooser(sendIntent, null);
                        startActivity(shareIntent);
                        break;
                    case R.id.action_settings:
                        Log.d("CEVA", "settings a fost selectat");
                        break;
                    case R.id.drawer_layout:
                        Log.d("CEVA", "buttonul de drawer a fost selectat");
                        break;
                    case R.id.nav_view:
                        Log.d("CEVA", "buttonul de navigation drawer a fost selectat");
                        break;
                    case R.menu.activity_main_drawer:
                        Log.d("CEVA", "activity main drawer a fost selectat");
                        break;
                    default:
                        Log.d("CEVA", "a fost selectat altceva");
                        break;
                }
                //This is for maintaining the behavior of the Navigation view
                NavigationUI.onNavDestinationSelected(menuItem, navController);
                //This is for closing the drawer after acting on it
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        mTripViewModel = new ViewModelProvider(this).get(TripViewModel.class);

        //        add new trip button
        binding.appBarMain.addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Add new trip", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity2.this, NewTripActivity.class);
                startActivityForResult(intent, NEW_TRIP_ACTIVITY_REQUEST_CODE);
            }
        });


        binding.appBarMain.removeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, RemoveTripActivity.class);
                startActivityForResult(intent, REMOVE_TRIP_ACTIVITY_REQUEST_CODE);
                mTripViewModel.deleteById(100);
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == NEW_TRIP_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK ) {

            int ID = Integer.parseInt(data.getStringExtra("ID"));
            String title = data.getStringExtra("TITLE");
            String region = data.getStringExtra("REGION");
            String description = data.getStringExtra("DESCRIPTION");
            String ageInterval = data.getStringExtra("AGE_INTERVAL");
            String total_price = data.getStringExtra("TOTAL_PRICE");
            String nr_days = data.getStringExtra("NR_DAYS") + " days";
            float rating = Float.parseFloat(data.getStringExtra("RATING"));

            mTripViewModel = new ViewModelProvider(this).get(TripViewModel.class);


            Trip trip = new Trip(ID , R.drawable.vietnam_trip_1_vietnam_experience,title, rating, description, region, ageInterval, nr_days, total_price, false );
            mTripViewModel.insert(trip);
        }
        else if( requestCode == REMOVE_TRIP_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            int ID = Integer.parseInt(data.getStringExtra("ID"));
            mTripViewModel.deleteById(ID);
        }
        else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}