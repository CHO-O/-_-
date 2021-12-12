package com.course.term_project;

import android.content.Context;
import android.content.Intent;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.course.Term_Project.R;

import java.util.ArrayList;

public class MyAdapter extends
        RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myPicture;
        TextView myText;

        MyViewHolder(View view){
            super(view);
            myPicture = view.findViewById(R.id.imageView);
            myText = view.findViewById(R.id.textView);
        }
    }

    private ArrayList<Item> myItemList;
    MyAdapter(ArrayList<Item> items){
        this.myItemList = items;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.myPicture.setImageResource(myItemList.get(position).getImageID());

        myViewHolder.myText.setText(myItemList.get(position).getItemName());

        myViewHolder.myPicture.setTag(position);

        myViewHolder.myPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                context.startActivity(intent);
            }
        });

        myViewHolder.myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myItemList.size();
    }
}
