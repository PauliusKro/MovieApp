package com.example.movie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SearchActivity extends AppCompatActivity {
    public static final String API_MOVIE = "https://api.themoviedb.org/3/movie/550?api_key=9fc459388e1a035ff8f7d3ec7df9c950"; // tavo API

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        AsyncFetch asyncFetch = new AsyncFetch();
        asyncFetch.execute();

    }

    private class AsyncFetch extends AsyncTask<String, String, JSONObject> {
        ProgressDialog pdLoading = new ProgressDialog(SearchActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be runing on UI thread
            pdLoading.setMessage(getResources().getString(R.string.search_loading_data));
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            try {
                JSONObject jsonObject = JSON.readJsonFromUrl(API_MOVIE);
                //System.err.println(jsonObject.toString());
                return jsonObject;
            } catch (JSONException | IOException e1) {
                Toast.makeText(
                        SearchActivity.this,
                        getResources().getText(R.string.search_error_reading_data) + e1.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            pdLoading.dismiss();

            Toast.makeText(SearchActivity.this, json.toString(), Toast.LENGTH_LONG).show();
        }//onPostExecute

    }//AsyncFetch

} // SearchActivity
