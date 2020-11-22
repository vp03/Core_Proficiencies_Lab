package com.pentakotavishu.coreproficiencieslab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private CheckBox winter;
    private CheckBox spring;
    private CheckBox summer;
    private CheckBox fall;

    int CB_count;
    String season;

    private RequestQueue requestQueue;
    List<String> votes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winter = findViewById(R.id.checkbox_winter);
        spring = findViewById(R.id.checkbox_spring);
        summer = findViewById(R.id.checkbox_summer);
        fall = findViewById(R.id.checkbox_fall);


        CB_count = 0;
        season = "";

        requestQueue = Volley.newRequestQueue(this);

        votes = new ArrayList<String>();
    }

    public void onCheckboxClicked(View view) {


    }
    public void submit_vote(View view) {

        CB_count=0;
        season = "";
        if (winter.isChecked()) {
            CB_count=CB_count+1;
            season = "Winter";
        }
        if (spring.isChecked()) {
            CB_count=CB_count+1;
            season = "Spring";
        }
        if (summer.isChecked()) {
            CB_count=CB_count+1;
            season = "Summer";
        }
        if (fall.isChecked()) {
            CB_count=CB_count+1;
            season = "Fall";
        }

        if (CB_count == 1) {


            String url = "https://vishu-core-proficiencies-lab.sites.tjhsst.edu/" + "?season=" + season;
            Log.i("my tag", "hiiiii");
            final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                                Log.i("my tag", "byeeee");
                                Log.i("my tag", "response: " + response);

                            String help = response;
                            help = help.replace("[", "");
                            help = help.replace("]", "");
                            String helper[] = help.split(",");

                            String s = "";
                                for(int i=0; i<=3; i++){
                                    votes.add(i, helper[i]);
                                    s = s + " " + helper[i];
                                }
                            StringFragment.getInstance().updateVotes(helper);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                        }
                    }
            );
            requestQueue.add(stringRequest);

        }

        else {
            Toast.makeText(getApplicationContext(), "you can select only 1 checkbox", Toast.LENGTH_SHORT).show();
        }
    }

}