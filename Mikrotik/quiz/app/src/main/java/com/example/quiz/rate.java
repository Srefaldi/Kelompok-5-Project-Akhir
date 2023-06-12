package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class rate extends AppCompatActivity {

    Button Button;
    RatingBar RatingBar;

    float myRating= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Button=findViewById(R.id.button);
        RatingBar=findViewById(R.id.RatingBar);


        RatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message=null;

                myRating = ratingBar.getRating();

                switch(rating) {
                    case 1:
                        message = "Saya Kecewa!";
                        break;
                    case 2:
                        message = "Saya Sedih!";
                        break;
                    case 3:
                        message = "Biasa saja";
                        break;
                    case 4:
                        message = "Materi Bagus";
                        break;
                    case 5:
                        message = "Saya sangat puas dengan materinya";
                        break;
                }
                Toast.makeText(  rate.this, message,Toast.LENGTH_SHORT).show();
            }
        });
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(rate.this, "Your rating is" + myRating, Toast.LENGTH_SHORT).show();
            }
        } );
    }
}