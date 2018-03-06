package com.kotlincoders.ravi.logicpractices;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kotlincoders.ravi.logicpractices.databinding.ActivityRecyclerViewBinding;

import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ActivityRecyclerViewBinding activityRecyclerViewBinding;
    private List<GetSetClass> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRecyclerViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);

        activityRecyclerViewBinding.setLogicData(new GetSetClass(RecyclerViewActivity.this));
        activityRecyclerViewBinding.setActivity(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        items = Arrays.asList(
                new GetSetClass("Palindrome", 0, "http://lorempixel.com/400/400/"),
                new GetSetClass("FabbinociSeries", 0, "http://lorempixel.com/500/400/"),
                new GetSetClass("PrimeNumber", 0, "http://lorempixel.com/300/500/"),
                new GetSetClass("Factorials", 0, "http://lorempixel.com/600/400/"),
                new GetSetClass("Armstrong", 0, "http://lorempixel.com/700/500/"),
                new GetSetClass("PrintStars", 0, "http://lorempixel.com/400/500/")
         );

        // define an adapter
        mAdapter = new ReceyclerViewAdapter(items);
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever

                        GetSetClass getSetClass = items.get(position);
                        startActivity(new Intent(RecyclerViewActivity.this, MainActivity.class)
                        .putExtra("Type",getSetClass.getType()));

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String url) {

        Glide.with(view.getContext()).load(url).into(view);

    }
}
