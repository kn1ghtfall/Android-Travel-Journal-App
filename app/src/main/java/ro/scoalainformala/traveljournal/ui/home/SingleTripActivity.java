package ro.scoalainformala.traveljournal.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ro.scoalainformala.traveljournal.R;

public class SingleTripActivity extends AppCompatActivity {

    private static final String TAG = "SingleTripActivity";
    
    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_trip);
        Log.d(TAG, "onCreate: started.");


        getIncomingIntent();


    }


    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if( getIntent().hasExtra("TITLE") && getIntent().hasExtra("IMAGE_RESOURCE")){


            Log.d(TAG, "getIncomingIntent: found intent extras");
            String title = getIntent().getStringExtra("TITLE");
            int image_url = getIntent().getIntExtra("IMAGE_RESOURCE", 0);


            setWidgets(title, image_url);
        }
    }

    private void setWidgets(String title, int image_resource){
        Log.d(TAG, "setImage: setting data from intent to widgets.");

        TextView mTextTileView = findViewById(R.id.single_trip_title);
        ImageView mImageThumbnailView = findViewById(R.id.single_trip_image);
        mTextTileView.setText(title);
        mImageThumbnailView.setImageResource(image_resource);
    }

}
