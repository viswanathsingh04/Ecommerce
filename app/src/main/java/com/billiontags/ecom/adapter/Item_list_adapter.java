package com.billiontags.ecom.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.billiontags.ecom.R;
import com.billiontags.ecom.activity.ItemDetail;
import com.billiontags.ecom.model.Data;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by VPS on 02-02-2018.
 */

public class Item_list_adapter extends RecyclerView.Adapter<Item_list_adapter.ViewHolder> {
    List<Data> data;
    Context context;

    public Item_list_adapter(Context context, List<Data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int i) {
        final Data d = data.get(i);
        holder.item_name.setText(d.getItem_name());
        holder.cross_price.setText(Integer.toString(d.getCrossed_price()));
        holder.price.setText(Integer.toString(d.getPrice()));
        //Picasso.with(context).load(d.getItem_img()).into(holder.item_img);

        Picasso.with(context)
                .load(d.getItem_img())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(holder.item_img, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Picasso.with(context)
                                .load(d.getItem_img())
                                .error(R.drawable.bg_poly)
                                .into(holder.item_img, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Log.v("Picasso", "Could not fetch image");
                                    }
                                });
                    }
                });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView item_img;
        TextView item_name, cross_price, price;
        LinearLayout l_layout;

        public ViewHolder(View view) {
            super(view);
            item_img = (ImageView) view.findViewById(R.id.item_img);
            item_name = (TextView) view.findViewById(R.id.item_name);
            cross_price = (TextView) view.findViewById(R.id.cross_price);
            price = (TextView) view.findViewById(R.id.price);
            l_layout = (LinearLayout) view.findViewById(R.id.l_layout);
            l_layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId()==R.id.l_layout){
                Intent intent = new Intent(context, ItemDetail.class);
                context.startActivity(intent);
            }
        }
    }
}
