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
import ca.georgiancollege.assignmentone_condeludena.databinding.ActivityMovieDetailBinding;

public class MainActivity extends AppCompatActivity {

    //declare binding
    ActivityMainBinding activityMainBinding;
    //declare viewmodel
    SearchViewMovieModel viewSearchMovieModel;
    //declare MovieAdapter
    MovieAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding and use it on create
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //instantiate a ViewModelProvide to this class with Search viewModel.class assign to variable
        viewSearchMovieModel = new ViewModelProvider(this).get(SearchViewMovieModel.class);

        // 1) Setup RecyclerView & Adapter
        adapter = new MovieAdapter();
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.setAdapter(adapter);

        viewSearchMovieModel.getMoviesData().observe(this, movie -> {
            adapter.addItem(movie);
        });

        viewSearchMovieModel.getErrorMessage().observe(this, err -> {
            if (err != null) {
                activityMainBinding.errorText.setText(err);
                activityMainBinding.errorText.setVisibility(View.VISIBLE);
            } else {
                activityMainBinding.errorText.setVisibility(View.GONE);
            }
        });

        activityMainBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieName = activityMainBinding.editMovieText.getText().toString().trim();
                adapter.clear();
                viewSearchMovieModel.MovieSearch(movieName);
            }
        });
    }
}