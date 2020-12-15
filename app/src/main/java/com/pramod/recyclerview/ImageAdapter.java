package com.pramod.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{
    private ArrayList<CarsModel>  carsModels;
    private Context context;

    public ImageAdapter(ArrayList<CarsModel> carsModels, Context context) {
        this.carsModels = carsModels;
        this.context = context;
    }






    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_list_item,parent,false);

        return  new ImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        holder.car_name.setText(carsModels.get(position).getName());
        holder.car_desc.setText(carsModels.get(position).getDesc());

        Picasso.get().load(carsModels.get(position).getImage()).into(holder.car_image);



    }

    @Override
    public int getItemCount() {
        return carsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView car_image;
        private TextView car_name,car_desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            car_image=(ImageView)itemView.findViewById(R.id.car_image);
            car_name=(TextView) itemView.findViewById(R.id.car_name);
            car_desc=(TextView)itemView.findViewById(R.id.car_desc);
    }
}
}
