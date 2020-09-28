package com.example.id.ac.binus.volutry.activity;

import androidx.recyclerview.widget.DiffUtil;

import com.example.id.ac.binus.volutry.model.Event;

import java.util.List;

public class EventDiffUtil extends DiffUtil.Callback {

    private List<Event> OldList;
    private List<Event> NewList;

    public EventDiffUtil(List<Event> OldList, List<Event> NewList){
        this.OldList = OldList;
        this.NewList = NewList;
    }

    @Override
    public int getOldListSize() {
        return OldList.size();
    }

    @Override
    public int getNewListSize() {
        return NewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        String OldId = OldList.get(oldItemPosition).getEventID();
        String NewId = NewList.get(newItemPosition).getEventID();

        return OldId.equals(NewId);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        String OldId = OldList.get(oldItemPosition).getEventID();
        String NewId = NewList.get(newItemPosition).getEventID();

        return OldId.equals(NewId);
    }
}

