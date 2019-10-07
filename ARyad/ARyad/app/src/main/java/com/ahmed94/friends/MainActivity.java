package com.ahmed94.friends;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ahmed94.friends.Adapters.CategoryAdapter;
import com.ahmed94.friends.Object.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView categoryRecycler;
    private List<CategoryItem> categoryItemList;
    private CategoryAdapter categoryAdapter;

    private TextView learnToday;


    private SharedPreferences sharedPreferences;
    int appOpened = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting up the activity for full screen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        appOpened = sharedPreferences.getInt("appOpened", 0);
        appOpened++;
        editor.putInt("appOpened", appOpened);
        editor.apply();

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/jokerman_regular.ttf");
        learnToday = (TextView) findViewById(R.id.choose_landing);
        learnToday.setTypeface(typeface);

        categoryItemList = new ArrayList<>();
        initList();
        categoryAdapter = new CategoryAdapter(this, categoryItemList);

        categoryRecycler = (RecyclerView) findViewById(R.id.recycler_landing);
        RecyclerView.LayoutManager catLayMan = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler.setLayoutManager(catLayMan);
        categoryRecycler.setItemAnimator(new DefaultItemAnimator());
        categoryRecycler.setAdapter(categoryAdapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(categoryRecycler);


    }

    private void initList() {

        categoryItemList.add(new CategoryItem(getResources().getString(R.string.alphabets), R.drawable.aralphabets));
        categoryItemList.add(new CategoryItem(getResources().getString(R.string.animals), R.drawable.animals));
        categoryItemList.add(new CategoryItem(getResources().getString(R.string.birds), R.drawable.bird));




    }


}
