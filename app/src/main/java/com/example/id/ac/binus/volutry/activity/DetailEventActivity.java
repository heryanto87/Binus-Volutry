package com.example.id.ac.binus.volutry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.repository.DetailPenerimaanRepository;
import com.example.id.ac.binus.volutry.repository.PenerimaanRepository;
import com.example.id.ac.binus.volutry.model.DetailFormPenerimaan;
import com.example.id.ac.binus.volutry.model.Event;
import com.example.id.ac.binus.volutry.model.FormPenerimaan;
import com.example.id.ac.binus.volutry.sharedPreferences.SharedPref;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetailEventActivity extends AppCompatActivity {

    /*
    Edited by: Eric Pangiawan
    Date: 09 Feb 2020 11:18 AM
    Purpose: Connect to Databse
     */

    Button ButtonBack, ButtonApply;
    ImageView ImageViewEvent;
    TextView TextViewEventName, TextViewDate
            ,TextViewEventCondition, TextViewEventActivities
            ,TextViewEventLocation, TextViewEventDivision, TextViewEventType, TextViewEventDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final Event event =(Event) getIntent().getSerializableExtra("event");
        //buat isi deskripsi nantinya
        ButtonBack = findViewById(R.id.btn_back_detail);
        ButtonApply = findViewById(R.id.btn_apply);

        //init
        ImageViewEvent = findViewById(R.id.iv_detail);
        TextViewEventName = findViewById(R.id.tv_event_name);
        TextViewDate = findViewById(R.id.tv_date);
        TextViewEventCondition = findViewById(R.id.tv_condition);
        TextViewEventType = findViewById(R.id.tv_event_type);
        TextViewEventDescription = findViewById(R.id.tv_event_description);
        TextViewEventLocation = findViewById(R.id.tv_location);
        TextViewEventActivities = findViewById(R.id.tv_activities);
        TextViewEventDivision = findViewById(R.id.tv_division);
        //setData
        ImageViewEvent.setImageResource(event.getImages());
        TextViewEventName.setText(event.getEventName());
        TextViewDate.setText(event.getEventDate());
        TextViewEventCondition.setText(event.getEventCondition());
        TextViewEventType.setText(event.getEventType());
        TextViewEventDescription.setText(event.getEventDescription());
        TextViewEventLocation.setText(event.getEventLocation());
        TextViewEventActivities.setText(event.getEventActivity());
        TextViewEventDivision.setText(event.getEventDivision());
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buat back, harusnya ke fragment
                Intent intent = new Intent(DetailEventActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        ButtonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insert data disini
                //Header
                PenerimaanRepository PenerimaanRepository = new PenerimaanRepository(DetailEventActivity.this);
                SharedPref SharedPref = new SharedPref(DetailEventActivity.this);
                String idVoluntir = SharedPref.load().getVoluntirId();
                boolean isRegistered = PenerimaanRepository.haveRegistered(idVoluntir);
                System.out.println(idVoluntir);
                if(isRegistered){
                    Calendar rightNow = Calendar.getInstance();
                    String tf = new SimpleDateFormat("yyyy-MM-dd").format(rightNow.getTime());
                    String id = PenerimaanRepository.getIndex();
                    FormPenerimaan FormPenerimaan = new FormPenerimaan();
                    FormPenerimaan.setDescriptionPenerimaan("Halo, selamat anda keterima menjadi salah satu committe kami, peserta akan dihirapkan untuk datang pukul 17.00 pada alamat dan waktu yang tertera dibawah.");
                    FormPenerimaan.setStatusPenerimaan("Succeed");
                    FormPenerimaan.setTanggalPenerimaan(tf);
                    FormPenerimaan.setIdFormKegiatan(id);
                    FormPenerimaan.setIdVoluntir(idVoluntir);

                    boolean check = PenerimaanRepository.insert(FormPenerimaan);
                    DetailPenerimaanRepository DetailPenerimaanRepository = new DetailPenerimaanRepository(DetailEventActivity.this);

                    DetailFormPenerimaan DetailFormPenerimaan = new DetailFormPenerimaan();
                    DetailFormPenerimaan.setGaji(500000);
                    DetailFormPenerimaan.setIdKegiatan(event.getEventID());
                    DetailFormPenerimaan.setIdFormKegiatan(id);

                    DetailPenerimaanRepository.insert(DetailFormPenerimaan);
                    Toast.makeText(DetailEventActivity.this, "Event Applied", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DetailEventActivity.this, "You already registered an event!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
