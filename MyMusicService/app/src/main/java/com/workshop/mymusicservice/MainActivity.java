package com.workshop.mymusicservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener

{

    private final ArrayList<com.workshop.mymusicservice.Song> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSongs();
        initSongList();
//        initStopRequest();
//        initService();
    }

    protected void initSongs()
    {
        songs.add(new com.workshop.mymusicservice.Song("Ukulele",
                "Happy and light music featuring ukulele.",
                "ukulele"));

        songs.add(new com.workshop.mymusicservice.Song("Creative Minds",
                "Inspiring music featuring guitars.",
                "creative_minds"));

        songs.add(new com.workshop.mymusicservice.Song("Memories",
                "Music composition featuring piano and drums.",
                "memories"));

        songs.add(new com.workshop.mymusicservice.Song("Acoustic Breeze",
                "Acoustic music with a soft and mellow mood.",
                "acoustic_breeze"));

        songs.add(new com.workshop.mymusicservice.Song("Buddy",
                "Music with a playful and happy mood.",
                "buddy"));

        songs.add(new com.workshop.mymusicservice.Song("Sunny",
                "Gentle acoustic music featuring guitars.",
                "sunny"));

        songs.add(new com.workshop.mymusicservice.Song("Once Again",
                "Nice cinematic music track featuring piano and strings.",
                "once_again"));

        songs.add(new com.workshop.mymusicservice.Song("Tenderness",
                "Gentle music featuring guitar and piano.",
                "tenderness"));
    }

    protected void initSongList()
    {
        ListView listView = findViewById(R.id.listView);
        if (listView != null) {
            listView.setAdapter(new MyAdapter(this, songs));
            listView.setOnItemClickListener(this);
        }
    }

//    protected void initStopRequest() {
//        Button stopBtn = findViewById(R.id.stopBtn);
//        if (stopBtn != null) {
//            stopBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(MainActivity.this, com.workshop.mymusicservice.MyMusicService.class);
//                    intent.setAction("stop");
//                    startService(intent);
//                }
//            });
//        }
//    }

//    protected void initService()
//    {
//        ArrayList<String> songFnames = new ArrayList<>();
//
//        for (com.workshop.mymusicservice.Song song: songs) {
//            songFnames.add(song.getFname());
//        }
//
//        Intent intent = new Intent(this, com.workshop.mymusicservice.MyMusicService.class);
//        intent.setAction("init_songs");
//        intent.putExtra("song_fnames", songFnames);
//        startService(intent);
//    }
    @Override
    public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
        com.workshop.mymusicservice.Song song = songs.get(pos);

        Intent intent = new Intent(this, com.workshop.mymusicservice.MyMusicService.class);
        intent.setAction("play");
        intent.putExtra("song_idx", pos);
        startService(intent);
    }
}