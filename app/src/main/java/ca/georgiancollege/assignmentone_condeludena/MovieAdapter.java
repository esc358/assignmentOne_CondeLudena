package ca.georgiancollege.assignmentone_condeludena;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ca.georgiancollege.assignmentone_condeludena.databinding.RowDataBinding;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieVH> {
    private final List<MovieModel> items = new ArrayList<>();

    // 1) Use the generated RowMovieBinding in your ViewHolder
    static class MovieVH extends RecyclerView.ViewHolder {
        private final RowDataBinding binding;

        public MovieVH(RowDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieModel m) {
            binding.movieTextName.setText(m.getTitle());
            binding.yearTextName.setText(m.getYear());
            binding.studioTextName.setText(m.getStudio());
            binding.ratingTextName.setText(m.getRatingValue());
        }
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 2) Inflate via RowMovieBinding rather than manual inflate
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RowDataBinding binding = RowDataBinding.inflate(inflater, parent, false);
        return new MovieVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // helper to add a movie and refresh
    public void addItem(MovieModel movie) {
        items.add(movie);
        notifyItemInserted(items.size() - 1);
    }

    // or helper to replace entire list
    public void setItems(List<MovieModel> list) {
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }
}


