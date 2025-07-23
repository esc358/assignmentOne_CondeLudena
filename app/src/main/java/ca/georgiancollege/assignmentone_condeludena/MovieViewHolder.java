package ca.georgiancollege.assignmentone_condeludena;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;


import ca.georgiancollege.assignmentone_condeludena.databinding.MovieItemBinding;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private final MovieItemBinding movieItemBinding;

    //constructor using binding view
    public MovieViewHolder(MovieItemBinding movieItemBinding) {
        super(movieItemBinding.getRoot());
        this.movieItemBinding = movieItemBinding;
    }

    //void method takes MovieModel object as parameter
    public void movieData(MovieModel movieModel) {
        //set in view the following fields
        movieItemBinding.movieTextName.setText(movieModel.getTitle());
        movieItemBinding.yearTextName.setText(movieModel.getYear());
        movieItemBinding.studioTextName.setText(movieModel.getStudio());
        movieItemBinding.ratingTextName.setText(movieModel.getRatingValue());
        movieItemBinding.actionButton.setTag(movieModel);

        //button action
        movieItemBinding.actionButton.setOnClickListener(v -> {
            //instantiate a context
            Context context = v.getContext();
            //instantiate an intent
            Intent intent = new Intent(context, MovieDetail.class);
            // pass fields individually in the intent
            intent.putExtra("extra_poster", movieModel.getPoster());
            intent.putExtra("extra_title", movieModel.getTitle());
            intent.putExtra("extra_studio", movieModel.getStudio());
            intent.putExtra("extra_rating", movieModel.getRatingValue());
            intent.putExtra("extra_year", movieModel.getYear());
            intent.putExtra("extra_runTime", movieModel.getRunTime());
            intent.putExtra("extra_director", movieModel.getDirector());
            intent.putExtra("extra_actors", movieModel.getActors());
            intent.putExtra("extra_plot", movieModel.getPlot());

            //passed intent into activity
            context.startActivity(intent);
        });
    }
}
