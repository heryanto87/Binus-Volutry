package com.example.id.ac.binus.volutry.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.activity.DetailEventActivity;
import com.example.id.ac.binus.volutry.activity.EventAdapter;
import com.example.id.ac.binus.volutry.model.Event;
import com.example.id.ac.binus.volutry.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

/*
Edited by: Eric
Date: 09 February 2020 11.19 AM
Purpose: PutExtra to send data
 */
public class VolunteerFragment extends Fragment {
    private EventAdapter adapter;
    private List<Event> EventList;
    private RecyclerView RecyclerViewEvent;

    private boolean isInserted = false;
    private int[] EventImages = new int[]{
        R.drawable.iv_u201,
        R.drawable.iv_u203,
        R.drawable.iv_u207,
        R.drawable.iv_u208,
        R.drawable.iv_u213,
        R.drawable.iv_u214,
        R.drawable.iv_u216,
        R.drawable.iv_u219
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);
        RecyclerViewEvent = (RecyclerView) view.findViewById(R.id.rv_newevent);

        isInserted = insertAllEvent();
        setEventData();
        setEventAdapter();
        return view;
    }

    public boolean insertAllEvent(){
        EventRepository EventRepository = new EventRepository(getContext());

        if(EventRepository.checkInserted())
            return true;
//        EventRepository EventRepository = new EventRepository(getContext());
        //init
        Event event = new Event();

        //data 1
        event.setEventID("EV001");
        event.setEventName("On Off Festival");
        event.setEventDate("2019-03-12");
        event.setEventCondition("Age: 18-30 years old, Experience in social media or sound");
        event.setEventType("Social Event");
        event.setEventDescription("A festival celebrating all things viral for the born online generation !");
        event.setEventLocation("Jl. Pintu Satu Senayan, RT.1/RW.3, Gelora, Tanahabang, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 10270");
        event.setEventActivity("Arrange sosial media or sound management");
        event.setEventDivision("Consumption Commitee");
        EventRepository.insert(event);

        //data 2
        event.setEventID("EV002");
        event.setEventName("African Hunger");
        event.setEventDate("2019-02-04");
        event.setEventCondition("Age: 18-25 years old, Experience in teaching");
        event.setEventType("Social Event");
        event.setEventDescription("We are trying to assist african government providing food for their citizens");
        event.setEventLocation("Cape Town, Pretoria, Bloemfontein, South Africa");
        event.setEventActivity("Teach and delivering foods");
        event.setEventDivision("Consumption Commitee");
        EventRepository.insert(event);

        //data 3
        event.setEventID("EV003");
        event.setEventName("JiCom Fest");
        event.setEventDate("2019-08-23");
        event.setEventCondition("Age: 20-35 years old, Experience in sound management");
        event.setEventType("Comedy Event");
        event.setEventDescription("JICOMFEST 2019 will become this annual festival, the plan will be enlivened by more than 100 homeland comedians and abroad whose existence is no longer questionable.");
        event.setEventLocation("Jalan Jendral Gatot Subroto, RT.9/RW.2, Bendungan Hilir, Tanah Abang, Kota Jakarta Pusat, 10210");
        event.setEventActivity("Arrange sound management");
        event.setEventDivision("Documentation Commitee");
        EventRepository.insert(event);

        //data 4
        event.setEventID("EV004");
        event.setEventName("Love Fest");
        event.setEventDate("2020-02-21");
        event.setEventCondition("Age: 18-30 years old, Experience in social media or sound management");
        event.setEventType("Social Event");
        event.setEventDescription("We Celebrate the happines of young love !");
        event.setEventLocation("Jl. Pintu Satu Senayan, RT.1/RW.3, Gelora, Tanahabang, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 10270");
        event.setEventActivity("Arrange social media or sound management");
        event.setEventDivision("Documentation Commitee");
        EventRepository.insert(event);

        //data 5
        event.setEventID("EV005");
        event.setEventName("Australia Needs Your Help");
        event.setEventDate("2019-10-08");
        event.setEventCondition("Age: 17-30 years old, Willing to help");
        event.setEventType("Social Event");
        event.setEventDescription("Australia needs your help; our country is on fire. We are deeply hurt from the loss experienced in all states of this country as the fires remain out of control. We need your help.");
        event.setEventLocation("Gereja Maria Bunda Karmel, Jalan Kebon Jeruk, Jakarta Barat 11450");
        event.setEventActivity("Clothes donation and funds");
        event.setEventDivision("Consumption Commitee");
        EventRepository.insert(event);

        //data 6
        event.setEventID("EV006");
        event.setEventName("Indonesian Flood");
        event.setEventDate("2020-01-05");
        event.setEventCondition("Age: 20-30 years old, No allergies or heavy illness");
        event.setEventType("Social Event");
        event.setEventDescription("We are trying to assist Indonesian government providing food and medicine for their citizens");
        event.setEventLocation("Summarecon Bekasi, RT.006/RW.002, Marga Mulya, Bekasi Utara, Bekasi City, West Java 17142");
        event.setEventActivity("Provide food and medicine for flood victim");
        event.setEventDivision("Consumption Commitee");
        EventRepository.insert(event);

        //data 7
        event.setEventID("EV007");
        event.setEventName("Australia Forest Fire");
        event.setEventDate("2020-02-05");
        event.setEventCondition("Age: 20-30 years old");
        event.setEventType("Social Event");
        event.setEventDescription("Australia is facing a big threat in its ecosystem, we want you to help us provide sanctuary for wildlife !");
        event.setEventLocation("Northwest of the city, Daintree National Park");
        event.setEventActivity("Provide sanctuary for wildlife");
        event.setEventDivision("Rescue Commitee");
        EventRepository.insert(event);

        //data 8
        event.setEventID("EV008");
        event.setEventName("Jakarta Folk Festival");
        event.setEventDate("2020-05-16");
        event.setEventCondition("Age: 17-30 years old, have taste in music");
        event.setEventType("Music Event");
        event.setEventDescription("Performance by indie bands with folk musical flow!");
        event.setEventLocation("Jl. Pintu Satu Senayan, RT.1/RW.3, Gelora, Tanahabang, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 10270");
        event.setEventActivity("Sound management and medical support");
        event.setEventDivision("Supply Commitee");
        EventRepository.insert(event);

        return true;
    }

    public void setEventData(){
        EventList = new ArrayList<>();
        EventRepository EventRepository = new EventRepository(getContext());
        for(int i = 0; i < EventImages.length; i++){

            Event event;
            event = EventRepository.getOneEvent("EV00" + (i+1));
            event.setImages(EventImages[i]);

            EventList.add(event);
        }
    }

    public void setEventAdapter(){
        adapter =new EventAdapter(new EventAdapter.OnItemClick() {
            @Override
            public void OnClick(Event event) {
                //ini event buat masuk ke deskripsi event
                Intent intent = new Intent(getActivity(), DetailEventActivity.class);
                intent.putExtra("event", event);
                startActivity(intent);
            }
        });
        adapter.updateData(EventList);
        RecyclerViewEvent.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerViewEvent.setAdapter(adapter);
    }

}
