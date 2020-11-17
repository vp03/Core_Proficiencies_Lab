package com.pentakotavishu.coreproficiencieslab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    private CheckBox winter;
    private CheckBox spring;
    private CheckBox summer;
    private CheckBox fall;

    int CB_count;
    String season;

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
    }

    public void onCheckboxClicked(View view) {


    }

    public void submit_vote(View view) {

        CB_count=0;
        season = "";
        if (winter.isChecked()) {
            CB_count=CB_count+1;
            season = "winter";
        }
        if (spring.isChecked()) {
            CB_count=CB_count+1;
            season = "spring";
        }
        if (summer.isChecked()) {
            CB_count=CB_count+1;
            season = "summer";
        }
        if (fall.isChecked()) {
            CB_count=CB_count+1;
            season = "fall";
        }

        if (CB_count == 1) {

            //do your magic
            StringFragment.getInstance().updateVotes(season);

        } else {
            Toast.makeText(getApplicationContext(), "you can select only 1 checkbox", Toast.LENGTH_SHORT).show();
        }
    }
}