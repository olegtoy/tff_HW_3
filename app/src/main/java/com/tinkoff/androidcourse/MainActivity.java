package com.tinkoff.androidcourse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyItemTouchHelper myItemTouchHelper;
    private ItemTouchHelper itemTouchHelper;
    private FloatingActionButton fab;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private static final int WORKERS_Count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        List<Worker> workers = WorkerGenerator.generateWorkers(WORKERS_Count);

        myAdapter = new MyAdapter(workers);
        mRecyclerView.setAdapter(myAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myAdapter.addItem(WorkerGenerator.generateWorker());
                mRecyclerView.smoothScrollToPosition(myAdapter.getItemCount());
            }
        });

        myItemTouchHelper=new MyItemTouchHelper(myAdapter);


        itemTouchHelper = new ItemTouchHelper(myItemTouchHelper);

        mRecyclerView.addItemDecoration(new myItemDecorator(this));


        itemTouchHelper.attachToRecyclerView(mRecyclerView);


/*





       ;*/
    }
}
