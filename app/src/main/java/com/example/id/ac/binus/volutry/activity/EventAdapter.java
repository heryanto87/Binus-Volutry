package com.example.id.ac.binus.volutry.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private List<Event> EventList = new ArrayList<>();
    private OnItemClick listener;


    public EventAdapter(OnItemClick listener){this.listener = listener;}

    class EventViewHolder extends RecyclerView.ViewHolder{
        ImageView ImageViewEvent;
        LinearLayout LinearLayoutEventItem;
        public EventViewHolder(View view){
            super(view);
            ImageViewEvent = view.findViewById(R.id.iv_newevent);
            LinearLayoutEventItem = view.findViewById(R.id.ll_event_item);
        }

        public void bind(final Event event){
            ImageViewEvent.setImageResource(event.getImages());

            LinearLayoutEventItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(event);
                }
            });
        }

    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_newevent, parent,
                false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = EventList.get(position);
        holder.bind(event);

    }

    @Override
    public int getItemCount() {
        return EventList.size();
    }

    public Event getItem(int position){
        return EventList.get(position);
    }
    public void updateData(List<Event> NewList){
        EventDiffUtil EventDiffUtil = new EventDiffUtil(EventList, NewList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(EventDiffUtil);
        EventList.clear();
        EventList.addAll(NewList);

        result.dispatchUpdatesTo(this);
    }
    public interface OnItemClick{
        void OnClick(Event event);
    }
}
