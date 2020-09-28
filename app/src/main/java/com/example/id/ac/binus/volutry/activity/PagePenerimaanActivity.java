package com.example.id.ac.binus.volutry.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.model.Event;
import com.example.id.ac.binus.volutry.model.History;
import com.example.id.ac.binus.volutry.repository.EventRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PagePenerimaanActivity extends AppCompatActivity {

    TextView TextViewTanggal, TextViewAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_penerimaan);
        History history = (History) getIntent().getSerializableExtra("history");
        EventRepository EventRepository = new EventRepository(PagePenerimaanActivity.this);
        Event event = EventRepository.getOneEvent(history.getIdKegiatan());

        TextViewTanggal = findViewById(R.id.tv_tanggal);
        TextViewAlamat = findViewById(R.id.tv_alamat);


        TextViewTanggal.setText(event.getEventDate());
        TextViewAlamat.setText(event.getEventLocation());
    }
}
