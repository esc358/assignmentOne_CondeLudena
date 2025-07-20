/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 20, 2025
 * 3:20pm
 * */
package ca.georgiancollege.assignmentone_condeludena;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class SearchViewMovieModel extends ViewModel {
    public SearchViewMovieModel() {
    }

    public void MovieSearch(String name){

        String url = "https://www.omdbapi.com/?apikey=";
        String apiKey = "e5317c7e";
        String searchMovie = "&s=";
        String searchID = "&i=";
        String movieType = "&type=movie";

        //validate if name has characters
        if (name.isEmpty())
        {
            String empty = "Search a movie name. Cannot be empty.";
        }else{
            String urlSearchMovies = url + apiKey + searchMovie + name + movieType;
            ApiClient.get(urlSearchMovies, new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String responseData = response.body().string();
                    //Parse info into a JSON object
                    JSONObject jsonSearchArray = null;
                    try{
                        //instantiate the JSONObject and pass the string response data
                        jsonSearchArray = new JSONObject(responseData);
                        //since Search is a JSONArray get the string
                        JSONArray moviesJSONArray = jsonSearchArray.getJSONArray("Search");
                        //loop through the array
                        for (int i = 0; i < moviesJSONArray.length(); i++) {
                            //create a JSON object and get location of i
                            JSONObject movie = moviesJSONArray.getJSONObject(i);
                            //Movie Title, Studio, Rating, and the Year
                            String title  = movie.optString("Title");
                            String year = movie.optString("Year");
                            String imdbID = movie.optString("imdbID");

                            String urlMovieTitle = url + apiKey + searchID+ imdbID + movieType;
                            Log.i("tag", urlMovieTitle);
                            ApiClient.get(urlMovieTitle, new Callback() {
                                @Override
                                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                                }
                                @Override
                                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                                    String responseData = response.body().string();

                                    JSONObject jsonMovie = null;
                                    try {
                                        jsonMovie = new JSONObject(responseData);
                                        String  studio = jsonMovie.getString("Production");
                                        String ratingValue = "No rating available";
                                        JSONArray ratingsJSONArray = jsonMovie.optJSONArray("Ratings");

                                        if (ratingsJSONArray != null && ratingsJSONArray.length() > 0) {
                                            JSONObject ratingObj = ratingsJSONArray.optJSONObject(0);
                                            if (ratingObj != null) {
                                                // optString with default guards against missing "Value"
                                                ratingValue = ratingObj.optString("Value", "No rating available");
                                            }
                                        }
                                        Log.i("tag", ratingValue);

                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }

                                }
                            });
                        }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            });
        }
    }
}
