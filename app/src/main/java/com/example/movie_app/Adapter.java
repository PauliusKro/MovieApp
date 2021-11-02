package com.example.movie_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<Movie> data;

    // create constructor to intialize context and data sent from SearchActivity

    public Adapter(Context context, List<Movie>data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_movie, parent, false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        Movie current = data.get(position);
        myHolder.textName.setText("Name: "+ current.getName());
        myHolder.textReleaseDate.setText("Relase date: " + current.getReleaseDate());

    }

    // return total item form list
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textName;
        TextView textReleaseDate;

        // create constructor to get widget reference
        public MyHolder(View itemView) {

            super(itemView);
            TextView textName = (TextView) itemView.findViewById(R.id.textName);
            TextView textReleaseDate = (TextView) itemView.findViewById(R.id.textReleaseDate);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();
        }
    }
}
