package ca.georgiancollege.assignmentone_condeludena;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import ca.georgiancollege.assignmentone_condeludena.databinding.ActivityMovieDetailBinding;

public class MovieDetail extends AppCompatActivity {
    private ActivityMovieDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Read the extras
        String title  = getIntent().getStringExtra("extra_title");
        String studio = getIntent().getStringExtra("extra_studio");
        String rating = getIntent().getStringExtra("extra_rating");
        String year   = getIntent().getStringExtra("extra_year");

        // Populate
        binding.detailTitle .setText(title);
        binding.detailStudio.setText(studio);
        binding.detailRating.setText(rating);
        binding.detailYear  .setText(year);

        // Back
        binding.backButton.setOnClickListener(v -> finish());
    }
}

