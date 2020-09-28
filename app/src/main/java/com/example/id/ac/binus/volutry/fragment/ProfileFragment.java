package com.example.id.ac.binus.volutry.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.activity.UpdateProfileActivity;
import com.example.id.ac.binus.volutry.model.Voluntir;
import com.example.id.ac.binus.volutry.repository.UserRepository;
import com.example.id.ac.binus.volutry.sharedPreferences.SharedPref;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;


/*  Modified by Heryanto
    Date : Sunday February 9,
    2020 Purpose : Showing personal information from saved sharedpreferences */

public class ProfileFragment extends Fragment {

    CircleImageView CircleImageViewProfile;

    TextView TextviewName;
    TextView TextviewEmail;
    TextView TextviewGender;
    TextView TextviewDOB;
    TextView TextviewPhone;
    TextView TextviewAddress;
    TextView TextviewDescription;
    TextView TextviewEducation;
    TextView TextviewWorkingexp;
    TextView TextviewSkill;

    ImageView ImageviewSupportingMaterial;

    FloatingActionButton ButtonUpdateProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_profile, container, false);

        ButtonUpdateProfile = View.findViewById(R.id.button_update_profile);

        CircleImageViewProfile = View.findViewById(R.id.civ_profile);

        TextviewName = View.findViewById(R.id.textview_name);
        TextviewEmail = View.findViewById(R.id.textview_email);
        TextviewGender = View.findViewById(R.id.textview_gender);
        TextviewDOB = View.findViewById(R.id.textview_dob);
        TextviewPhone = View.findViewById(R.id.textview_phone);
        TextviewAddress = View.findViewById(R.id.textview_address);
        TextviewDescription = View.findViewById(R.id.textview_description);
        TextviewEducation = View.findViewById(R.id.textview_education);
        TextviewWorkingexp = View.findViewById(R.id.textview_working_exp);
        TextviewSkill = View.findViewById(R.id.textview_skill);

        ImageviewSupportingMaterial = View.findViewById(R.id.imageview_supporting_material);

        SharedPref SharedPref = new SharedPref(getActivity());
        UserRepository UserRepository = new UserRepository(getActivity());
        Voluntir Voluntir = UserRepository.getVoluntir(SharedPref.load().getVoluntirId());

        TextviewName.setText(Voluntir.getVoluntirName());
        TextviewEmail.setText(Voluntir.getVoluntirEmail());
        TextviewGender.setText(Voluntir.getVoluntirGender());
        TextviewDOB.setText(Voluntir.getVoluntirDateOfBirth());
        TextviewPhone.setText(Voluntir.getVoluntirPhone());
        TextviewAddress.setText(Voluntir.getVoluntirAddress());
        TextviewDescription.setText(Voluntir.getVoluntirDescription());
        TextviewEducation.setText(Voluntir.getVoluntirEducation());
        TextviewWorkingexp.setText(Voluntir.getVoluntirWorkExp());
        TextviewSkill.setText(Voluntir.getVoluntirSkill());
        ImageviewSupportingMaterial.setImageBitmap(Voluntir.getVoluntirSuppMaterial());
        CircleImageViewProfile.setImageBitmap(Voluntir.getVoluntirImage());


        ButtonUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(getActivity(), UpdateProfileActivity.class);
                startActivity(intent);
            }
        });

        return View;
    }
}
