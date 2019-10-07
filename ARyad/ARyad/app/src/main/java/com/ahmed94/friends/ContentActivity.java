package com.ahmed94.friends;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.ahmed94.friends.Adapters.ImageAdapter;
import com.ahmed94.friends.Helper.CenterZoomLayoutManager;
import com.ahmed94.friends.Object.ImageItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<ImageItem> imageItemList = new ArrayList<>();
    private ImageAdapter adapter;

    private CenterZoomLayoutManager centerZoomLayoutManager;

    private Button previous, play, next;
    private int counter = 0;

    private int type;

    private MediaPlayer mediaPlayer;
    private int[] sounds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_content);
        initializeView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initializeView() {
        counter = Integer.MAX_VALUE / 2;
        type  = Objects.requireNonNull(getIntent().getExtras()).getInt("type");
        initList();
        findViews();
        initializeRecyclerView();
    }

    private void initList() {
        imageItemList = ContentRepository.getImagesByType(type);
        sounds = ContentRepository.getSoundsByType(type);
    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        previous = (Button) findViewById(R.id.previous);
        play = (Button) findViewById(R.id.play);
        next = (Button) findViewById(R.id.next);

        previous.setOnClickListener(this);
        play.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    private void initializeRecyclerView() {
        adapter = new ImageAdapter(this, imageItemList);

        centerZoomLayoutManager = new CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(centerZoomLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(counter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        System.out.println("The RecyclerView is not scrolling");
                        play.setEnabled(true);
                        previous.setEnabled(true);
                        next.setEnabled(true);
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        System.out.println("Scrolling now");
                        play.setEnabled(false);
                        previous.setEnabled(false);
                        next.setEnabled(false);
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        System.out.println("Scroll Settling");
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous:
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                counter--;
                recyclerView.smoothScrollToPosition(counter);
                break;

            case R.id.next:
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                counter++;
                recyclerView.smoothScrollToPosition(counter);
                break;

            case R.id.play:
                counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
                int pos = counter % imageItemList.size();
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), sounds[pos]);
                mediaPlayer.start();
                break;
        }
    }
}
