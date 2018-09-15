package com.example.x.cv.previous_work;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.x.cv.R;

import java.util.ArrayList;
import java.util.List;

public class PreviousWorkActivity extends AppCompatActivity {

    private RecyclerView previousWorkListView;
    private List<PreviousWork> previousWorkList;
    private PreviousWorkAdapter previousWorkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_work);

        previousWorkListView = findViewById(R.id.previous_work_recyclerView);


        previousWorkList = new ArrayList<>();
        previousWorkList.add(new PreviousWork("facebook", "Software Engineer", "2014", "2016"));
        previousWorkList.add(new PreviousWork("Google", "Software Engineer", "2016", "2018"));

        previousWorkAdapter = new PreviousWorkAdapter();
        previousWorkAdapter.setPreviousWorkList(previousWorkList);

        previousWorkListView.setLayoutManager(new LinearLayoutManager(this));
        previousWorkListView.setHasFixedSize(true);
        previousWorkListView.setAdapter(previousWorkAdapter);
    }
}
