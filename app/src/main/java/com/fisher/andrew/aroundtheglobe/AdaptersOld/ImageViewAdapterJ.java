package com.fisher.andrew.aroundtheglobe.AdaptersOld;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ImageViewAdapterJ extends RecyclerView.Adapter<ImageViewAdapterJ.ViewHolder>
{
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;//eventually the usual count as it could be less than 10
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View view){
            super(view);



        }

    }
}
