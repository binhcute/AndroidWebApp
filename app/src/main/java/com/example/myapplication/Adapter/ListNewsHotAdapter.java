
package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.model.News;

import java.util.LinkedList;

public class ListNewsHotAdapter extends RecyclerView.Adapter<ListNewsHotAdapter.NewHotViewHolder> {

    private final LinkedList<News> mListNewsHot;
    private LayoutInflater mInflater;

    public ListNewsHotAdapter(Context context, LinkedList<News> mListNewsHot) {
        this.mInflater = LayoutInflater.from(context);
        this.mListNewsHot = mListNewsHot;
    }

    @NonNull
    @Override
    public NewHotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.layout_item_news,parent,false);
        return new NewHotViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull NewHotViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mListNewsHot.size();
    }

    public class NewHotViewHolder extends RecyclerView.ViewHolder{
        final ListNewsHotAdapter Adapter;
        public TextView txt_NewsDec;
        public TextView News_id;
        public TextView txt_News;
        public ImageView imgNews;
        public NewHotViewHolder(@NonNull View itemView, ListNewsHotAdapter adapter) {
            super(itemView);
            this.Adapter = adapter;
            this.txt_NewsDec = itemView.findViewById(R.id.txt_NewsDec);
            this.txt_News = itemView.findViewById(R.id.txt_News);
            this.News_id = itemView.findViewById(R.id.News_id);
        }
    }
}
