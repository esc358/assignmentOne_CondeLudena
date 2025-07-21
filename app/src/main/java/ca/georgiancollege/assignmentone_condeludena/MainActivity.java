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

    //declare binding
    ActivityMainBinding binding;
    //declare viewmodel
    SearchViewMovieModel viewSearchMovieModel;
    //declare MovieAdapter
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding and use it on create
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //instantiate a ViewModelProvide to this class with SearchviewModel.class assign to varible
        viewSearchMovieModel = new ViewModelProvider(this).get(SearchViewMovieModel.class);

        // 1) Setup RecyclerView & Adapter
        adapter = new MovieAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        viewSearchMovieModel.getMoviesData().observe(this, movie -> {
            adapter.addItem(movie);
        });

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieName = binding.editMovieText.getText().toString().trim();
                viewSearchMovieModel.MovieSearch(movieName);
            }
        });
    }
}