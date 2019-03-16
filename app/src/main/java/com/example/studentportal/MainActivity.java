package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
    List<Portal> mPortals;
    private RecyclerView mRecyclerView;
    private PortalAdapter mPortalAdapter;
    private GestureDetector mGestureDetector;

    public static final String ADD_PORTAL = "NewPortal";
    public static final int NewPortalCode = 4321;
    public static final String VIEW_PORTAL = "ViewPortal";
    public static final int ViewPortalCode = 3421;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPortals = new ArrayList<>();
        mRecyclerView = findViewById(R.id.portalRecyclerView);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(false);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPortalActivity.class);
                startActivityForResult(intent, NewPortalCode);
            }
        });
        mRecyclerView.addOnItemTouchListener(this);
        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
        //mRecyclerView.addOnItemTouchListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void updateUI() {
        if (mPortalAdapter == null) {
            mPortalAdapter = new PortalAdapter(mPortals);
            mRecyclerView.setAdapter(mPortalAdapter);
        } else {
            mPortalAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NewPortalCode){
            if(resultCode == RESULT_OK){
                Portal portal = data.getParcelableExtra(MainActivity.ADD_PORTAL);
                mPortals.add(portal);
                updateUI();
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        if(child != null) {
            int position = recyclerView.getChildAdapterPosition(child);

            if (mGestureDetector.onTouchEvent(motionEvent)) {
                Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
                intent.putExtra(VIEW_PORTAL, mPortals.get(position));
                startActivityForResult(intent, ViewPortalCode);
            }
        }

        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
