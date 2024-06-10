package com.example.myappmovielastup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myappmovielastup.Interface.ItemCTClickListener;
import com.example.myappmovielastup.R;
import com.example.myappmovielastup.model.EventBus.TongGiaPhimEvent;
import com.example.myappmovielastup.model.GioHang;

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;
import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.MyViewHolder> {

    Context context;
    List<GioHang> gioHangList;

    public GioHangAdapter(Context context, List<GioHang> gioHangList) {
        this.context = context;
        this.gioHangList = gioHangList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GioHang gioHang = gioHangList.get(position);
        holder.item_giohang_tenphim.setText(gioHang.getTenphim());
        holder.item_giohang_soluong.setText(gioHang.getSoluong() + " ");
        Glide.with(context).load(gioHang.getHinhphim()).into(holder.item_giohang_image);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.item_giohang_gia.setText(decimalFormat.format(gioHang.getGia()) + " Đ");
        Long gia = gioHang.getSoluong() * gioHang.getGia();
        holder.item_giohang_tonggiaphim.setText(decimalFormat.format(gia));

        holder.setItemCTClickListener(new ItemCTClickListener() {
            @Override
            public void onImageClick(View view, int pos, int giatri) {
                if (giatri == 1) {
                    if (gioHangList.get(pos).getSoluong() > 1) {
                        int soluongmoi = gioHangList.get(pos).getSoluong() - 1;
                        gioHangList.get(pos).setSoluong(soluongmoi);
                    }
                } else if (giatri == 2) {
                    if (gioHangList.get(pos).getSoluong() < 11) {
                        int soluongmoi = gioHangList.get(pos).getSoluong() + 1;
                        gioHangList.get(pos).setSoluong(soluongmoi);
                    }
                }
                holder.item_giohang_soluong.setText(gioHangList.get(pos).getSoluong() + " ");
                Long gia = gioHangList.get(pos).getSoluong() * gioHangList.get(pos).getGia();
                holder.item_giohang_tonggiaphim.setText(decimalFormat.format(gia));

                EventBus.getDefault().postSticky(new TongGiaPhimEvent());
            }
        });
    }

    @Override
    public int getItemCount() {
        return gioHangList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView item_giohang_image, item_giohang_tru, item_giohang_cong;
        TextView item_giohang_tenphim, item_giohang_gia, item_giohang_soluong, item_giohang_tonggiaphim;
        ItemCTClickListener itemCTClickListener;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            item_giohang_image = itemView.findViewById(R.id.item_giohang_image);
            item_giohang_tenphim = itemView.findViewById(R.id.item_giohang_tenphim);
            item_giohang_gia = itemView.findViewById(R.id.item_giohang_gia);
            item_giohang_soluong = itemView.findViewById(R.id.item_giohang_soluong);
            item_giohang_tonggiaphim = itemView.findViewById(R.id.item_giohang_tonggiaphim);
            item_giohang_tru = itemView.findViewById(R.id.item_giohang_tru);
            item_giohang_cong = itemView.findViewById(R.id.item_giohang_cong);

            // event click CT
            item_giohang_tru.setOnClickListener(this);
            item_giohang_cong.setOnClickListener(this);
        }

        public void setItemCTClickListener(ItemCTClickListener itemCTClickListener) {
            this.itemCTClickListener = itemCTClickListener;
        }

        @Override
        public void onClick(View v) {
            if (v == item_giohang_tru) {
                itemCTClickListener.onImageClick(v, getAdapterPosition(), 1);
            } else if (v == item_giohang_cong) {
                itemCTClickListener.onImageClick(v, getAdapterPosition(), 2);
            }
        }
    }
}
