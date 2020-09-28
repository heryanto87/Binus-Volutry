package com.example.id.ac.binus.volutry.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.activity.HistoryAdapter;
import com.example.id.ac.binus.volutry.activity.HistoryDetailActivity;
import com.example.id.ac.binus.volutry.activity.PagePenerimaanActivity;
import com.example.id.ac.binus.volutry.model.History;
import com.example.id.ac.binus.volutry.repository.HistoryRepository;
import com.example.id.ac.binus.volutry.sharedPreferences.SharedPref;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private HistoryAdapter Adapter;
    private List<History> HistoryList;
    private ImageView ImageViewNotifPenerimaan;
    private RecyclerView RecyclerView;
    private int[] HistoryImages = new int[]{
            R.drawable.iv_u201,
            R.drawable.iv_u203,
            R.drawable.iv_u207,
            R.drawable.iv_u208,
            R.drawable.iv_u213,
            R.drawable.iv_u214,
            R.drawable.iv_u216,
            R.drawable.iv_u219
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_history, container, false);


        RecyclerView = View.findViewById(R.id.rv_history);
        ImageViewNotifPenerimaan = View.findViewById(R.id.iv_notif_penerimaan);

        ImageViewNotifPenerimaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PagePenerimaanActivity.class);
                intent.putExtra("history", history);
                startActivity(intent);
            }
        });

        setHistoryData();
        setAdapter();

        return View;
    }
    History history = new History();
    public void setHistoryData(){
        HistoryList = new ArrayList<>();
        SharedPref SharedPref = new SharedPref(getContext());
        String id = SharedPref.load().getVoluntirId();
        HistoryRepository HistoryRepository = new HistoryRepository(getContext());

        history = HistoryRepository.getActivity(id);

        history.setImages(HistoryImages[history.getImages()-1]);

        HistoryList.add(history);
    }

    public void setAdapter(){
        Adapter =new HistoryAdapter(new HistoryAdapter.OnItemClick() {
            @Override
            public void OnClick(History history) {
                //ini buat masuk ke data detail

                Intent intent = new Intent(getActivity(), HistoryDetailActivity.class);
                intent.putExtra("history", history);
                startActivity(intent);
            }
        });
        Adapter.updateData(HistoryList);
        RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.setAdapter(Adapter);
    }

}
