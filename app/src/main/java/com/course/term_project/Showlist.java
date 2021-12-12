package com.course.term_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.course.Term_Project.R;

import java.util.ArrayList;

public class Showlist extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist);

        myRecyclerView = (RecyclerView)
                findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new GridLayoutManager(this, 2);
        myRecyclerView.setLayoutManager(myLayoutManager);


                ArrayList<Item> ItemInfo = new ArrayList<>();
        ItemInfo.add(new Item(R.drawable.kone1,"ROCCAT KONE PURE ULTRA"));
        ItemInfo.add(new Item(R.drawable.a6601, "앱코 A660 3325 프로페셔널 게이밍 마우스"));
        ItemInfo.add(new Item(R.drawable.g1021, "로지텍G G102 2세대 LIGHTSYNC"));
        ItemInfo.add(new Item(R.drawable.m1501, "HP M150"));
        ItemInfo.add(new Item(R.drawable.g5021, "로지텍G G502 HERO"));
        ItemInfo.add(new Item(R.drawable.a7001, "앱코 A700 하이엔드 게이밍 마우스"));
        ItemInfo.add(new Item(R.drawable.wm2001, "한성컴퓨터 WM200 RAINBOW"));
        ItemInfo.add(new Item(R.drawable.tuf1, "ASUS TUF M3"));
        ItemInfo.add(new Item(R.drawable.cm501, "COX CM50 RGB 게이밍 마우스"));
        ItemInfo.add(new Item(R.drawable.gm9001, "세컨드찬스 긱스타 GM900 3325 LED 게이밍 마우스"));

        MyAdapter myAdapter = new MyAdapter(ItemInfo);

        myRecyclerView.setAdapter(myAdapter);
    }
}