package ca.georgiancollege.assignmentone_condeludena;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import ca.georgiancollege.assignmentone_condeludena.databinding.ActivityMovieDetailBinding;

public class MovieDetail extends AppCompatActivity {
    private ActivityMovieDetailBinding activityMovieDetailBinding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMovieDetailBinding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(activityMovieDetailBinding.getRoot());


        // Read the extras
        String poster = getIntent().getStringExtra("extra_poster");
        String title = getIntent().getStringExtra("extra_title");
        String studio = getIntent().getStringExtra("extra_studio");
        String rating = getIntent().getStringExtra("extra_rating");
        String year = getIntent().getStringExtra("extra_year");
        String runTime = getIntent().getStringExtra("extra_runTime");
        String director = getIntent().getStringExtra("extra_director");
        String actor = getIntent().getStringExtra("extra_actors");
        String plot = getIntent().getStringExtra("extra_plot");


        // Populate
        activityMovieDetailBinding.detailTitle.setText("Title: " + title);
        activityMovieDetailBinding.detailStudio.setText("Studio: " + studio);
        activityMovieDetailBinding.detailRating.setText("Rating: " + rating);
        activityMovieDetailBinding.detailYear.setText("Year: " + year);
        activityMovieDetailBinding.detailRunTime.setText("Runtime: " + runTime);
        activityMovieDetailBinding.detailDirector.setText("Director: " + director);
        activityMovieDetailBinding.detailActors.setText("Actors: " + actor);
        activityMovieDetailBinding.detailPlot.setText("Plot: " + plot);


        // Back
        activityMovieDetailBinding.backButton.setOnClickListener(v -> finish());
    }
}

