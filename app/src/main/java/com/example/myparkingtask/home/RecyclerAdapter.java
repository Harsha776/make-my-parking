package com.example.myparkingtask.home;


import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.myparkingtask.R;
import com.example.myparkingtask.databinding.BookListBinding;
import com.example.myparkingtask.model.Items;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<Items> items;
    private Context mContext;

    RecyclerAdapter(ArrayList<Items> myPojos){
        this.items=myPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        BookListBinding bookListBinding=BookListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecyclerAdapter.MyViewHolder(bookListBinding);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.bookList.tvBookTitle.setText(items.get(position).getVolumeInfo().getTitle());
        holder.bookList.tvBookSubTitle.setVisibility(items.get(position).getVolumeInfo().getSubtitle()!=null?View.VISIBLE:View.GONE);
        holder.bookList.tvBookSubTitle.setText(items.get(position).getVolumeInfo().getSubtitle()!=null?items.get(position).getVolumeInfo().getSubtitle():"");
        if(items.get(position).getVolumeInfo().getImageLinks()!=null) {
            Glide.with(mContext).load(items.get(position).getVolumeInfo().getImageLinks().getSmallThumbnail()).placeholder(mContext.getDrawable(R.drawable.image_place_holder))
                    .error(mContext.getDrawable(R.drawable.image_place_holder)).into(holder.bookList.sdvBookPoster);
        }
        if(items.get(position).getSaleInfo()!=null && items.get(position).getSaleInfo().getListPrice()!=null){
            holder.bookList.btnBookPrice.setText(items.get(position).getSaleInfo().getListPrice().getAmount());
        }else {
            holder.bookList.btnBookPrice.setText(items.get(position).getSaleInfo()!=null ?items.get(position).getSaleInfo().getSaleability():"");
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        BookListBinding bookList;
        public MyViewHolder( BookListBinding bookListBinding) {
            super(bookListBinding.getRoot());
            this.bookList=bookListBinding;
        }
    }

}
