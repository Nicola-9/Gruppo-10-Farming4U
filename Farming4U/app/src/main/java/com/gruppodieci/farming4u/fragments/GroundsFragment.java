package com.gruppodieci.farming4u.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.gruppodieci.farming4u.BottomNavigationMenu;
import com.gruppodieci.farming4u.R;
import com.gruppodieci.farming4u.activity.BasicActivity;

import static com.gruppodieci.farming4u.BottomNavigationMenu.replaceFragment;

public class GroundsFragment extends Fragment {

    private View grounds;
    private TabLayout tabLayout;
    TabLayout.Tab semina;
    static Fragment activeFragment;
    static String activeTab = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        this.grounds = inflater.inflate(R.layout.fragment_grounds, container, false);

        this.tabLayout = this.grounds.findViewById(R.id.tabGrounds);

        this.tabLayout.setElevation(10);

        semina = tabLayout.newTab().setText("Semina e coltivazione");

        tabLayout.addTab(tabLayout.newTab().setText("Cura delle piante"));
        tabLayout.addTab(tabLayout.newTab().setText("Trattamento del terreno"));
        tabLayout.addTab(semina);

        tabLayout.setBackgroundColor(Color.parseColor("#71A3BB"));
        tabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#FFFFFF"));

        if (activeTab != null && activeTab.equals("semina")){
            MaterialToolbar toolbar = BasicActivity.getToolbar();
            toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BasicActivity.getBasicActivity().onBackPressed();
                }
            });

            semina.select();

            Fragment semina = new SeminaFragment();
            BottomNavigationMenu.setActiveFragment(semina);

            replaceFragment(R.id.mapContent, semina);
        } else {
            replaceFragment(R.id.mapContent, new CuraPianteFragment());
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment fragment;

                switch (tab.getText().toString()) {
                    case "Cura delle piante":

                        fragment = new CuraPianteFragment();

                        replaceFragment(R.id.mapContent,fragment);

                        break;

                    case "Trattamento del terreno":

                        break;

                    case "Semina e coltivazione":

                        fragment = new SeminaFragment();
                        replaceFragment(R.id.mapContent,fragment);

                        break;

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return this.grounds;

    }

    public static void setTab(String tab){
        activeTab = tab;
    }
}
