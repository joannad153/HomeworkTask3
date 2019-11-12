package com.example.homeworktask3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView weightTextView;
    private TextView temperamentTextView;
    //private TextView descriptionTextView;
    private TextView originTextView;
    private TextView lifespanTextView;
    private TextView friendlinessTextView;
    private TextView linkTextView;
    //private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String catID = intent.getStringExtra("CatID");
        //TODO: Set up database to retrieve data from
        Cat cat = FakeDatabase.getCatById(catID);

        nameTextView = findViewById(R.id.catName);
        weightTextView = findViewById(R.id.weight);
        temperamentTextView = findViewById(R.id.temperament);
        //descriptionTextView = findViewById(R.id.description);
        originTextView = findViewById(R.id.origin);
        lifespanTextView = findViewById(R.id.lifespan);
        friendlinessTextView = findViewById(R.id.friendliness);
        linkTextView = findViewById(R.id.link);
        //imageView = findViewById(R.id.catImage);

        nameTextView.setText(cat.getName());
        weightTextView.setText(cat.getWeight_imperial());
        temperamentTextView.setText(cat.getTemperament());
        originTextView.setText(cat.getOrigin());
        lifespanTextView.setText(cat.getLife_span());
        friendlinessTextView.setText(cat.getDog_friendly());
        linkTextView.setText(cat.getWikipedia_url());
    }
}
