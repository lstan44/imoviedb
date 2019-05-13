package com.stanleylalanne.imoviedb;
import android.os.AsyncTask;
import android.widget.Toast;
import org.asynchttpclient.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Model extends AsyncTask<String, Void, HttpURLConnection> {

    public String title;
    public String date;
    public String img;
    public Integer ratings;
    public ArrayList<String> cast = new ArrayList<String>();
    public String description;

    public String fetchMovie(){
        try {
            String json = "";
            String link = "https://api.themoviedb.org/3/discover/movie?api_key=59b765a2971a174ce1ea7467004d3bf0&language=en-US&sort_by=vote_count.desc&include_adult=false&include_video=false&page=1&primary_release_date.lte=2020";
            URL myUrl = new URL(link);
            HttpURLConnection con = (HttpURLConnection) myUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            json += con.getResponseCode();
            return json;

        }
        catch (Exception e){
            return e.toString();
        }
    }
}

