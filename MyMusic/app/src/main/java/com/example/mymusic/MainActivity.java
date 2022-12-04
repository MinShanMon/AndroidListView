package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Song> songs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSongs();
        initSongList();
    }

    protected void initSongs(){
        songs.add(new Song("Ukulele",
                "Happy and light music featuring ukulele.",
                "ukulele"));

        songs.add(new Song("Creative Minds",
                "Inspiring music featuring guitars.",
                "creative_minds"));

        songs.add(new Song("Memories",
                "Music composition featuring piano and drums.",
                "memories"));

        songs.add(new Song("Acoustic Breeze",
                "Acoustic music with a soft and mellow mood.",
                "acoustic_breeze"));

        songs.add(new Song("Buddy",
                "Music with a playful and happy mood.",
                "buddy"));

        songs.add(new Song("Sunny",
                "Gentle acoustic music featuring guitars.",
                "sunny"));

        songs.add(new Song("Once Again",
                "Nice cinematic music track featuring piano and strings.",
                "once_again"));

        songs.add(new Song("Tenderness",
                "Gentle music featuring guitar and piano.",
                "tenderness"));
    }

    protected void initSongList()
    {
        ListView listView = findViewById(R.id.listView);
        if (listView != null) {
            listView.setAdapter(new MyAdapter(this, songs));
//            listView.setOnItemClickListener(this);
        }
    }
//    @Override
//    public void onItemClick(AdapterView<?> av, View v, int pos, long id){
//
//    }

    
}