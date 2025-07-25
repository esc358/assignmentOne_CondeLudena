/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 20, 2025
 * 2:36pm
 * */
package ca.georgiancollege.assignmentone_condeludena;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

//class to handle Api requests
public class ApiClient {

    private static final OkHttpClient movieClient = new OkHttpClient();

    //method to call api request
    public static void get(String urlMovie, Callback callback){
        Request request = new Request.Builder().url(urlMovie).build();
        movieClient.newCall(request).enqueue(callback);
    }
}
