package ca.georgiancollege.assignmentone_condeludena;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ca.georgiancollege.assignmentone_condeludena.databinding.RowDataBinding;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final List<MovieModel> items = new ArrayList<>();

    // 1) Use the generated RowMovieBinding in your ViewHolder
    static class MovieViewHolder extends RecyclerView.ViewHolder {
        private final RowDataBinding binding;

        public MovieViewHolder(RowDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieModel movieModel) {
            binding.movieTextName.setText(movieModel.getTitle());
            binding.yearTextName.setText(movieModel.getYear());
            binding.studioTextName.setText(movieModel.getStudio());
            binding.ratingTextName.setText(movieModel.getRatingValue());
            binding.actionButton.setTag(movieModel);

            binding.actionButton.setOnClickListener(v -> {
                Context context = v.getContext();
                Intent intent = new Intent(context, MovieDetail.class);
                // pass fields individually
                intent.putExtra("extra_poster", movieModel.getPoster());
                intent.putExtra("extra_title", movieModel.getTitle());
                intent.putExtra("extra_studio", movieModel.getStudio());
                intent.putExtra("extra_rating", movieModel.getRatingValue());
                intent.putExtra("extra_year", movieModel.getYear());
                intent.putExtra("extra_runTime", movieModel.getRunTime());
                intent.putExtra("extra_director", movieModel.getDirector());
                intent.putExtra("exttra_actors", movieModel.getActors());
                intent.putExtra("extra_plot", movieModel.getPlot());

                context.startActivity(intent);
            });
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 2) Inflate via RowMovieBinding rather than manual inflate
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RowDataBinding binding = RowDataBinding.inflate(inflater, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setItems(List<MovieModel> movieList) {
        items.clear();
        items.addAll(movieList);
        notifyDataSetChanged();
    }

    public void clear() {
        int oldSize = items.size();
        items.clear();
        notifyItemRangeRemoved(0, oldSize);
    }
}


