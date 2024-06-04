package com.example.myappmovielastup.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myappmovielastup.Interface.ItemClickListener;
import com.example.myappmovielastup.R;
import com.example.myappmovielastup.activity.ChiTietActivity;
import com.example.myappmovielastup.model.PhimMoi;

import java.util.List;

public class TheLoaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<PhimMoi> array;
    private static final  int VIEW_TYPE_DATA = 0;
    private static final  int VIEW_TYPE_LOADING = 1;


    public TheLoaiAdapter(Context context, List<PhimMoi> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_DATA) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theloai, parent, false);
            return new MyViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            PhimMoi phim = array.get(position);
            myViewHolder.tenphim.setText(phim.getTen());
            myViewHolder.daodien.setText(phim.getDaodien());
            myViewHolder.theloai.setText(phim.getNgonngu());
            Glide.with(context).load(phim.getHinhanh()).into(myViewHolder.hinhanh);
            myViewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int pos, boolean isLongClick) {
                    if (!isLongClick) {
                        // click
                        Intent intent = new Intent(context, ChiTietActivity.class);
                        intent.putExtra("chitiet", phim);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        } else {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressbar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return array.get(position) == null ? VIEW_TYPE_LOADING:VIEW_TYPE_DATA;
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressbar;
        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressbar = itemView.findViewById(R.id.progressbar);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tenphim, daodien, theloai;
        ImageView hinhanh;
        private ItemClickListener itemClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tenphim = itemView.findViewById(R.id.itemdp_ten);
            daodien = itemView.findViewById(R.id.itemdp_daodien);
            theloai = itemView.findViewById(R.id.itemdp_theloai);
            hinhanh = itemView.findViewById(R.id.itemdp_image);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }
    }
}
