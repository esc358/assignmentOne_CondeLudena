package ca.georgiancollege.assignmentone_condeludena;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;


import ca.georgiancollege.assignmentone_condeludena.databinding.MovieItemBinding;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private final MovieItemBinding binding;

    public MovieViewHolder(MovieItemBinding binding) {
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
            intent.putExtra("extra_actors", movieModel.getActors());
            intent.putExtra("extra_plot", movieModel.getPlot());

            context.startActivity(intent);
        });
    }
}
