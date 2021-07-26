package ro.scoalainformala.traveljournal.EditTrip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;

import ro.scoalainformala.traveljournal.R;

public class NewTripActivity extends AppCompatActivity {


    private EditText mEditIDView;
    private EditText mEditTitleView;
    private EditText mEditDescriptionView;
    private EditText mEditRegionView;
    private EditText mEditAgeRangeView;
    private Slider mSliderTotalPriceView;
    private EditText mEditNrDaysView;
    private RatingBar mRatingBarScoreView;



    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        mEditIDView = findViewById(R.id.add_trip_id);
        mEditTitleView = findViewById(R.id.add_trip_name_value);
        mEditDescriptionView = findViewById(R.id.add_trip_destination_value);
        mEditRegionView = findViewById(R.id.add_trip_regions);
        mEditAgeRangeView = findViewById(R.id.add_trip_age_interval);
        mSliderTotalPriceView = findViewById(R.id.add_trip_slider);
        mEditNrDaysView = findViewById(R.id.add_trip_nr_days);
        mRatingBarScoreView = findViewById(R.id.add_trip_rating);

        final Button button = findViewById(R.id.new_trip_save_button);

        button.setOnClickListener(v->{
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(mEditIDView.getText()) ){
                setResult(RESULT_CANCELED, replyIntent);
            }
            else{
                String ID = mEditIDView.getText().toString();
                String title = mEditTitleView.getText().toString();
                String region = mEditRegionView.getText().toString();
                String description = mEditDescriptionView.getText().toString();
                String ageInterval =  mEditAgeRangeView.getText().toString();
                String total_price = String.valueOf((int)mSliderTotalPriceView.getValue());
                String nr_days = mEditNrDaysView.getText().toString();
                String rating = String.valueOf(mRatingBarScoreView.getRating());

                replyIntent.putExtra("ID", ID);
                replyIntent.putExtra("TITLE", title);
                replyIntent.putExtra("REGION", region);
                replyIntent.putExtra("DESCRIPTION", description);
                replyIntent.putExtra("AGE_INTERVAL", ageInterval);
                replyIntent.putExtra("TOTAL_PRICE", total_price);
                replyIntent.putExtra("NR_DAYS", nr_days);
                replyIntent.putExtra("RATING", rating);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });

    }



}
