package com.example.android.deprecure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.deprecure.model.Mood;

import java.util.ArrayList;

/**
 * Created by juraj on 6/18/18.
 */

public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.ViewHolder> {

    private ArrayList<Mood> mMoods;
    private Context mContext;

    public MoodAdapter(ArrayList<Mood> mMoods) {
        this.mMoods = mMoods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View itemView = layoutInflater.inflate(R.layout.item_mood, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mood mood = mMoods.get(position);
        holder.mMoodName.setText(mood.getMoodName());
        holder.mMoodSmile.setImageDrawable(mContext.getDrawable(mood.getMoodDrawableId()));
    }

    @Override
    public int getItemCount() {
        return mMoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mMoodName;
        public ImageView mMoodSmile;

        public ViewHolder( View itemView ) {
            super(itemView);
            mMoodName = itemView.findViewById(R.id.mood_name);
            mMoodSmile = itemView.findViewById(R.id.mood_smile);
        }
    }


}
