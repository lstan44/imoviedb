package com.stanleylalanne.imoviedb;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Model {

    public String title;
    public String date;
    public String img;
    public Integer ratings;
    public ArrayList<String> cast = new ArrayList<String>();
    public String description;

    public String fetchMovie() {
        try {
            URL myUrl = new URL("https://api.themoviedb.org/3/discover/movie?api_key=59b765a2971a174ce1ea7467004d3bf0&language=en-US&sort_by=vote_count.desc&include_adult=false&include_video=false&page=1&primary_release_date.lte=2020");
            HttpURLConnection con = (HttpURLConnection) myUrl.openConnection();
            con.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            return content.toString();
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}

