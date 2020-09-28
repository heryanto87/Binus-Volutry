package com.example.id.ac.binus.volutry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.fragment.HistoryFragment;
import com.example.id.ac.binus.volutry.model.Event;
import com.example.id.ac.binus.volutry.model.History;
import com.example.id.ac.binus.volutry.repository.EventRepository;

public class HistoryDetailActivity extends AppCompatActivity {

    ImageView ImageViewDetailHistory;
    Button ButtonBack;
    TextView TextViewEventName, TextViewEventType, TextViewEventDesc,
            TextViewDate, TextViewCondition, TextViewActivities,
            TextViewLocation, TextViewSalary, TextViewDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        History history =(History) getIntent().getSerializableExtra("history");
        EventRepository EventRepository = new EventRepository(HistoryDetailActivity.this);
        Event event = EventRepository.getOneEvent(history.getIdKegiatan());

        ImageViewDetailHistory = findViewById(R.id.iv_detail_history);
        ButtonBack = findViewById(R.id.btn_back);
        TextViewEventName = findViewById(R.id.tv_event_name);
        TextViewEventType = findViewById(R.id.tv_event_type);
        TextViewEventDesc = findViewById(R.id.tv_event_description);
        TextViewDate = findViewById(R.id.tv_date);
        TextViewCondition = findViewById(R.id.tv_condition);
        TextViewActivities = findViewById(R.id.tv_activities);
        TextViewLocation = findViewById(R.id.tv_location);
        TextViewSalary = findViewById(R.id.tv_salary);
        TextViewDivision = findViewById(R.id.tv_division);

        ImageViewDetailHistory.setImageResource(history.getImages());
        TextViewEventName.setText(event.getEventName());
        TextViewEventType.setText(event.getEventType());
        TextViewEventDesc.setText(event.getEventDescription());
        TextViewDate.setText(event.getEventDate());
        TextViewCondition.setText(event.getEventCondition());
        TextViewActivities.setText(event.getEventActivity());
        TextViewLocation.setText(event.getEventLocation());
        TextViewSalary.setText("Rp. " + Integer.toString(history.getGaji()));
        TextViewDivision.setText(history.getDivision());


        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryDetailActivity.this, HistoryFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
