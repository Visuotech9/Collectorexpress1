package com.example.collectorexpress.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collectorexpress.ModelDetails;
import com.example.collectorexpress.R;
import com.example.collectorexpress.UtilClass.SessionParam;
import com.example.collectorexpress.retrofit.BaseRequest;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;


//import android.support.v7.widget.PopupMenu;


public class Ad_list extends RecyclerView.Adapter<Ad_list.MyViewHolder> {
    ArrayList<ModelDetails> list;
    Context context;
    BaseRequest baseRequest;
    SessionParam sessionParam;

    public Ad_list(Context context, ArrayList<ModelDetails> list, SessionParam sessionParam) {
        this.list = list;
        this.context = context;
        this.sessionParam=sessionParam;
    }

    public Ad_list(Context context, int count) {
        this.context = context;
    }

    public void removeItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(ModelDetails followRequest, int position) {
        list.add(position, followRequest);
        notifyItemInserted(position);
    }

    public ArrayList<ModelDetails> getData() {
        return list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cards, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {

    }

    public void filterList(ArrayList<ModelDetails> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return 11;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_location,tv_accept,tv_cancel;
        LinearLayout lin_layout,lay_message;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_location = itemView.findViewById(R.id.tv_location);
            tv_accept = itemView.findViewById(R.id.tv_accept);
            tv_cancel = itemView.findViewById(R.id.tv_cancel);
            lin_layout = itemView.findViewById(R.id.lin_layout);
        }


    }




}
