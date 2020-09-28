package com.example.id.ac.binus.volutry.activity;

import androidx.recyclerview.widget.DiffUtil;

import com.example.id.ac.binus.volutry.model.History;

import java.util.List;

public class HistoryDiffUtil extends DiffUtil.Callback {

    private List<History> OldList;
    private List<History> NewList;

    public HistoryDiffUtil(List<History> oldList, List<History> newList){
        this.OldList = oldList;
        this.NewList = newList;
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
    public boolean areItemsTheSame(int OldItemPosition, int NewItemPosition) {
        String OldId = OldList.get(OldItemPosition).getIdFormKegiatan();
        String NewId = NewList.get(NewItemPosition).getIdFormKegiatan();

        return OldId == NewId;
    }

    @Override
    public boolean areContentsTheSame(int OldItemPosition, int NewItemPosition) {
        String OldId = OldList.get(OldItemPosition).getIdFormKegiatan();
        String NewId = NewList.get(NewItemPosition).getIdFormKegiatan();

        return OldId == NewId;
    }
}

