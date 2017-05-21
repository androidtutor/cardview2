package com.example.cardview2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private List<SampleItem> mSampleItems;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadSampleItems();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(mSampleItems);
        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SampleItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
        mRecyclerView.setAdapter(adapter);
    }


    private void loadSampleItems() {
        mSampleItems = new ArrayList<SampleItem>();
        mSampleItems.add(new SampleItem("Sample1", getResource(R.drawable.sample1)));
        mSampleItems.add(new SampleItem("Sample2", getResource(R.drawable.sample2)));
        mSampleItems.add(new SampleItem("Sample3", getResource(R.drawable.sample3)));
        mSampleItems.add(new SampleItem("Sample4", getResource(R.drawable.sample4)));
        mSampleItems.add(new SampleItem("Sample5", getResource(R.drawable.sample5)));
        mSampleItems.add(new SampleItem("Sample6", getResource(R.drawable.sample6)));
        mSampleItems.add(new SampleItem("Sample7", getResource(R.drawable.sample7)));
        mSampleItems.add(new SampleItem("Sample7", getResource(R.drawable.sample8)));
        mSampleItems.add(new SampleItem("Sample7", getResource(R.drawable.sample9)));
        mSampleItems.add(new SampleItem("Sample7", getResource(R.drawable.sample10)));
    }

    private Drawable getResource(int resourceId) {
        Drawable dr = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dr = getDrawable(resourceId);
        } else {
            dr = getResources().getDrawable(resourceId);
        }
        return dr;
    }

}
