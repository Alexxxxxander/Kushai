package com.example.a23_kushai;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainMenuFragment extends Fragment implements  NavigationView.OnNavigationItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainMenuFragment newInstance(String param1, String param2) {
        MainMenuFragment fragment = new MainMenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }
    DBCHelper databaseHelper;
    SQLiteDatabase db;
    Cursor cursor;
    View view;
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mRates = new ArrayList<>();
    private ArrayList<String> mCategories = new ArrayList<>();
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageButton openDrawer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        drawerLayout = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.rightNavigationView);
        openDrawer = view.findViewById(R.id.btn_openMenu);

        navigationView.setNavigationItemSelectedListener(this);
        openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(GravityCompat.END)){
                    drawerLayout.closeDrawer(GravityCompat.END);
                }
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });
        getItems();
        return view;



    }
    void getItems(){
        databaseHelper = new DBCHelper(requireContext().getApplicationContext());
        db = databaseHelper.getReadableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM " + DBCHelper.TABLE_RESTR,null);
        while (query.moveToNext()){
            mTitles.add(query.getString(1));
            mRates.add(query.getString(2));
            mCategories.add(query.getString(3));
            mImages.add(query.getInt(4));
        }
        query.close();
        db.close();
        initRecyclerView();
    }
    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewRestr = view.findViewById(R.id.rViewRestraunts);
        recyclerViewRestr.setLayoutManager(layoutManager);
        RestrauntAdapter restrauntAdapter = new RestrauntAdapter(view.getContext(), mImages, mTitles, mRates, mCategories);
        recyclerViewRestr.setAdapter(restrauntAdapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.login:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                Intent intent1 = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent1);
                break;
            default:
                break;

        }
        return false;
    }
}