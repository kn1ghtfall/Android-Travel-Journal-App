package ro.scoalainformala.traveljournal.EditTrip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ro.scoalainformala.traveljournal.R;

public class RemoveTripActivity extends AppCompatActivity{


    private EditText mEditIDView ;
    private Button mButtonDelete;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_trip);

        mEditIDView = findViewById(R.id.remove_trip_id);
        mButtonDelete = findViewById(R.id.remove_trip_button);


        mButtonDelete.setOnClickListener(v->{
            Intent replyIntent = new Intent();

            if(TextUtils.isEmpty(mEditIDView.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            }
            else{
                String ID = mEditIDView.getText().toString();

                replyIntent.putExtra("ID", ID);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });


    }
}
