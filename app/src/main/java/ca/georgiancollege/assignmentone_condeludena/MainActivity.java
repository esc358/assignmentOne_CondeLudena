/*
* Emilio Sebastian Conde Ludena
* 200478144
* July 19, 2025
* 7:16pm
* */
package ca.georgiancollege.assignmentone_condeludena;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import ca.georgiancollege.assignmentone_condeludena.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //declare them private for security
    private ActivityMainBinding activityMainBinding;
    private SearchViewMovieModel viewSearchMovieModel;
    private MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding and use it on create
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //instantiate a ViewModelProvide to this class with Search viewModel.class assign to variable
        viewSearchMovieModel = new ViewModelProvider(this).get(SearchViewMovieModel.class);

        //setup RecyclerView & Adapter
        movieAdapter = new MovieAdapter();
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.setAdapter(movieAdapter);

        //use live data from searchMovieData to observe list of movies how adapter changes list of movies
        viewSearchMovieModel.getMoviesData().observe(this, movies -> {
            movieAdapter.setMovieItems(movies);
        });

        //display error string in application using live data
        viewSearchMovieModel.getErrorMessage().observe(this, err -> {
            if (err != null) {
                activityMainBinding.errorText.setText(err);
                activityMainBinding.errorText.setVisibility(View.VISIBLE);
            } else {
                activityMainBinding.errorText.setVisibility(View.GONE);
            }
        });

        //lister for button
        activityMainBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text input and parse it as string
                String movieName = activityMainBinding.editMovieText.getText().toString().trim();
                //create movie object with live data
                viewSearchMovieModel.MovieSearch(movieName);
            }
        });
    }
}