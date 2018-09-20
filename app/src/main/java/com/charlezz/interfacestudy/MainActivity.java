package com.charlezz.interfacestudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyItemClickListner{

    RecyclerView recyclerView;
    MyAdapter adapter = new MyAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(this);


    }

    @Override
    public void onClickMeClick(int position) {
        Toast.makeText(MainActivity.this, String.format("ClickMe:%d", position),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(MainActivity.this, String.format("ItemClick:%d", position),Toast.LENGTH_SHORT).show();
    }
}

