/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 22, 2025
 * 5:02pm
 * */
package ca.georgiancollege.assignmentone_condeludena;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
import ca.georgiancollege.assignmentone_condeludena.databinding.ActivityMovieDetailBinding;

public class MovieDetail extends AppCompatActivity {
    //initialize binding
    private ActivityMovieDetailBinding activityMovieDetailBinding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding for view
        activityMovieDetailBinding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(activityMovieDetailBinding.getRoot());

        //read the extras from intent
        String posterUrl = getIntent().getStringExtra("extra_poster");
        String title = getIntent().getStringExtra("extra_title");
        String studio = getIntent().getStringExtra("extra_studio");
        String rating = getIntent().getStringExtra("extra_rating");
        String year = getIntent().getStringExtra("extra_year");
        String runTime = getIntent().getStringExtra("extra_runTime");
        String director = getIntent().getStringExtra("extra_director");
        String actor = getIntent().getStringExtra("extra_actors");
        String plot = getIntent().getStringExtra("extra_plot");

        //check if poster url is empty
        if ("N/A".equals(posterUrl)) {
            //set image from drawable folder
            activityMovieDetailBinding.detailPoster.setImageResource(R.drawable.no_poster);
        }else{
            //picasso.get.load poster ulr into binding detail poster
            Picasso.get()
                    .load(posterUrl)
                    .into(activityMovieDetailBinding.detailPoster);
        }

        //populate fields by binding
        activityMovieDetailBinding.detailTitle.setText("Title: " + title);
        activityMovieDetailBinding.detailStudio.setText("Studio: " + studio);
        activityMovieDetailBinding.detailRating.setText("Rating: " + rating);
        activityMovieDetailBinding.detailYear.setText("Year: " + year);
        activityMovieDetailBinding.detailRunTime.setText("Runtime: " + runTime);
        activityMovieDetailBinding.detailDirector.setText("Director: " + director);
        activityMovieDetailBinding.detailActors.setText("Actors: " + actor);
        activityMovieDetailBinding.detailPlot.setText("Plot: " + plot);

        //closes the current view and sends to back
        activityMovieDetailBinding.backButton.setOnClickListener(v -> finish());
    }
}

