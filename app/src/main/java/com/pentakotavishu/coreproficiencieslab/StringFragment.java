package com.pentakotavishu.coreproficiencieslab;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class StringFragment extends Fragment {

    private static StringFragment instance;
    private TextView winterVote, springVote, summerVote, fallVote;
    private int count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_item, parent, false);

        winterVote = v.findViewById(R.id.winter_votes);
        springVote = v.findViewById(R.id.spring_votes);
        summerVote = v.findViewById(R.id.summer_votes);
        fallVote = v.findViewById(R.id.fall_votes);
        count = 0;

        instance = this;

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    }

    public static StringFragment getInstance() {
        return instance;
    }


    public void updateVotes(String[] season){

        winterVote.setText(season[0]);
        springVote.setText(season[1]);
        summerVote.setText(season[2]);
        fallVote.setText(season[3]);
        }


}