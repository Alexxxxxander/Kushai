package com.example.a23_kushai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class RestrauntAdapter extends RecyclerView.Adapter<RestrauntAdapter.ViewHolder> {
    public static final String TAG = "RecycleViewAdapter";
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mRates = new ArrayList<>();
    private ArrayList<String> mCategories = new ArrayList<>();
    private ArrayList<Integer> mTimeMin = new ArrayList<>();
    private ArrayList<Integer> mTimeMax = new ArrayList<>();
    private Context mContext;
    public RestrauntAdapter(Context context, ArrayList<Integer> images, ArrayList<String> titles,
                            ArrayList<String> rates, ArrayList<String> categories,
                            ArrayList<Integer> timeMin, ArrayList<Integer> timeMax){
        mImages = images;
        mTitles = titles;
        mRates = rates;
        mCategories = categories;
        mContext = context;
        mTimeMin = timeMin;
        mTimeMax = timeMax;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restraunt_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.image.setImageResource(mImages.get(position));
        holder.title.setText(mTitles.get(position));
        holder.rate.setText(mRates.get(position));
        holder.categories.setText(mCategories.get(position));
        holder.time.setText(mTimeMin.get(position) + " - " + mTimeMax.get(position) + " мин");

    }


    @Override
    public int getItemCount() {
        return mImages.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        TextView rate;
        TextView categories;
        TextView time;

        public ViewHolder(View itemView){
            super(itemView);
            image =  itemView.findViewById(R.id.imgViewRestr);
            title = itemView.findViewById(R.id.txtViewTitleRestr);
            rate = itemView.findViewById(R.id.txtViewRateRestr);
            categories = itemView.findViewById(R.id.txtViewCategories);
            time = itemView.findViewById(R.id.txtViewTime);
        }
    }
}
