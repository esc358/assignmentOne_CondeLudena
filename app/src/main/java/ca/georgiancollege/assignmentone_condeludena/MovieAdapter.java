/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 22, 2025
 * 2:36pm
 * */
package ca.georgiancollege.assignmentone_condeludena;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import ca.georgiancollege.assignmentone_condeludena.databinding.MovieItemBinding;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    //instantiate a list array of MovieModel class
    private final List<MovieModel> movieItems = new ArrayList<>();

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 2) Inflate via RowMovieBinding rather than manual inflate
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MovieItemBinding movieItemBinding = MovieItemBinding.inflate(inflater, parent, false);
        return new MovieViewHolder(movieItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movieItems.get(position));
    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }

    //this method clear the list of movie items, add all movie items to a list,
    //and use a notifyDataChanged() that notifies observer data changed
    @SuppressLint("NotifyDataSetChanged")
    public void setMovieItems(List<MovieModel> movieList) {
        movieItems.clear();
        movieItems.addAll(movieList);
        notifyDataSetChanged();
    }

}


