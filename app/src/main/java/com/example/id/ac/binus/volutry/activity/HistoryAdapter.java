package com.example.id.ac.binus.volutry.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.model.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    private List<History> HistoryList = new ArrayList<>();
    private OnItemClick Listener;
    private Context Context;

    public HistoryAdapter(OnItemClick Listener){
        this.Listener= Listener;
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder{

        ImageView ImageViewHistory;
        TextView TextViewDate, TextViewDivision;
        LinearLayout LinearLayoutHistoryItem;

        public HistoryViewHolder(View view){
            super(view);
            ImageViewHistory = view.findViewById(R.id.iv_history);
            TextViewDate = view.findViewById(R.id.tv_date);
            TextViewDivision = view.findViewById(R.id.tv_division);
            LinearLayoutHistoryItem = view.findViewById(R.id.ll_history_item);
        }

        public void bind(final History history){
            ImageViewHistory.setImageResource(history.getImages());
            TextViewDate.setText(history.getDate());
            TextViewDivision.setText(history.getDivision());

            LinearLayoutHistoryItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Listener.OnClick(history);
                }
            });
        }
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 3 parameter : layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_history_item,
                        parent,
                        false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HistoryViewHolder Holder, int Position) {
        final History history = HistoryList.get(Position);
        Holder.bind(history);

        Holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), HistoryDetailActivity.class);
                intent.putExtra("history", history);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return HistoryList.size();
    }

    public void updateData(List<History> NewList){
        HistoryDiffUtil historyDiffUtil = new HistoryDiffUtil(HistoryList, NewList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(historyDiffUtil);
        HistoryList.clear();
        HistoryList.addAll(NewList);

        result.dispatchUpdatesTo(this);
    }

    public interface OnItemClick{
        void OnClick(History history);
    }
}
