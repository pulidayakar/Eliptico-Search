package com.test.eliptico;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.test.eliptico.databinding.CityLayoutBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MyCityListAdapter extends RecyclerView.Adapter<MyCityListAdapter.CityViewHolder> {
    private List<FeaturedList> list;
    private Context context;
    public MyCityListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyCityListAdapter.CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CityLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.city_layout, parent, false);
        return new CityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCityListAdapter.CityViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    public void setList(List<FeaturedList> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class CityViewHolder extends RecyclerView.ViewHolder{
        CityLayoutBinding binding;
        public CityViewHolder(@NonNull CityLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(FeaturedList featuredList) {
            if (featuredList != null) {
                String placesType = Arrays.toString(featuredList.getPlace_type());
                String placesCenter = Arrays.toString(featuredList.getCenter());
                placesType = placesType.replaceAll("\\[", "").replaceAll("]","");
                placesCenter = placesCenter.replaceAll("\\[", "").replaceAll("]","");
                binding.tvName.setText(context.getString(R.string.place_name, featuredList.getPlace_name()));
                binding.tvType.setText(context.getResources().getString(R.string.place_type, placesType));
                binding.tvCenter.setText(context.getResources().getString(R.string.place_center, placesCenter));
            }
        }
    }
}
