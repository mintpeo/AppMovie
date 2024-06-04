package com.example.myappmovielastup.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myappmovielastup.Interface.ItemClickListener;
import com.example.myappmovielastup.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappmovielastup.activity.ChiTietActivity;
import com.example.myappmovielastup.model.PhimMoi;

import java.util.List;

public class PhimMoiAdapter extends RecyclerView.Adapter<PhimMoiAdapter.MyViewHolder> {

    Context context;
    List<PhimMoi> array;

    public PhimMoiAdapter(Context context, List<PhimMoi> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp_moi, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PhimMoi phimMoi = array.get(position);
        holder.txtten.setText(phimMoi.getTen());
//        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//        holder.txtgia.setText("Giá: " +decimalFormat.format(loaiVe.getDonGia()) + "Đ");
        holder.txtgia.setText("Thời lượng: " + phimMoi.getThoiluong());
        Glide.with(context).load(phimMoi.getHinhanh()).into(holder.imghinhanh);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (!isLongClick) {
                    // click
                    Intent intent = new Intent(context, ChiTietActivity.class);
                    intent.putExtra("chitiet", phimMoi);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtgia;
        TextView txtten;
        ImageView imghinhanh;

        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtgia = itemView.findViewById(R.id.itemsp_gia);
            txtten = itemView.findViewById(R.id.itemsp_ten);
            imghinhanh = itemView.findViewById(R.id.itemsp_image);

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
