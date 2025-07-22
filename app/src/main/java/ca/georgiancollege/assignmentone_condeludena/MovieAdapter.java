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

        public void bind(MovieModel m) {
            binding.movieTextName.setText(m.getTitle());
            binding.yearTextName.setText(m.getYear());
            binding.studioTextName.setText(m.getStudio());
            binding.ratingTextName.setText(m.getRatingValue());
            binding.actionButton.setTag(m);

            binding.actionButton.setOnClickListener(v -> {
                Context ctx = v.getContext();
                Intent i = new Intent(ctx, MovieDetail.class);
                // pass fields individually
                i.putExtra("extra_title",  m.getTitle());
                i.putExtra("extra_studio", m.getStudio());
                i.putExtra("extra_rating", m.getRatingValue());
                i.putExtra("extra_year",   m.getYear());
                // if your model is Parcelable you could do:
                // i.putExtra("extra_movie", m);
                ctx.startActivity(i);
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


