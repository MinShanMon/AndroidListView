package com.workshop.explicitbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupReceiver();
        registerReceiver();

        startDownload();
    }
    protected void setupReceiver()
    {
        receiver = new MyReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();

                if (action.equals("download_completed"))
                {
                    String path = intent.getStringExtra("path");

                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    ImageView imageView = findViewById(R.id.imageView);
                    imageView.setImageBitmap(bitmap);
                }
                else if (action.equals("download_failed"))
                {
                    Toast msg = Toast.makeText(MainActivity.this,
                            "Download Failed", Toast.LENGTH_LONG);
                    msg.show();
                }
            }
        };
    }

    protected void registerReceiver()
    {
        IntentFilter filter = new IntentFilter();
        filter.addAction("download_completed");
        filter.addAction("download_failed");

        registerReceiver(receiver, filter);
    }

    protected void startDownload()
    {
        Intent intent = new Intent(this, MyService.class);
        intent.setAction("download_image");
        intent.putExtra("url", "https://p4.wallpaperbetter.com/wallpaper/291/663/679/stones-background-stones-spa-wallpaper-preview.jpg");

        // call Service to help us download image
        startService(intent);
    }
}