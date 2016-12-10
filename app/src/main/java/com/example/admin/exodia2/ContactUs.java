package com.example.admin.exodia2;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment {


    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contact_us = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ((MainActivity) getActivity())
                .setActionBarTitle("Contact Us");
        ImageView ivcall = (ImageView)contact_us.findViewById(R.id.iv_call_image_kislaya);
        ivcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015413")));
            }
        });
        ImageView call1 = (ImageView)contact_us.findViewById(R.id.iv_call_image_aditya);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015395")));
            }
        });
        ImageView call2 = (ImageView)contact_us.findViewById(R.id.iv_call_image_abhishek);
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015394")));
            }
        });
        ImageView call3 = (ImageView)contact_us.findViewById(R.id.iv_call_image_atul);
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015414")));
            }
        });
        ImageView call4 = (ImageView)contact_us.findViewById(R.id.iv_call_image_mukesh);
        call4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918350939554")));
            }
        });
        ImageView call5 = (ImageView)contact_us.findViewById(R.id.iv_call_image_anuksha);
        call5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918629015407")));
            }
        });
        ImageView call6 = (ImageView)contact_us.findViewById(R.id.iv_call_image_rahul);
        call6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918989587883")));
            }
        });
        ImageView call7 = (ImageView)contact_us.findViewById(R.id.iv_call_image_pulkit);
        call7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919882650863")));
            }
        });
        return contact_us;
    }
    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    Fragment fragment = new Home();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame,fragment);
                    ft.commit();
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
