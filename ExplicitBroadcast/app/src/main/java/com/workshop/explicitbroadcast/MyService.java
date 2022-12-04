package com.workshop.explicitbroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class MyService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();

        if (action != null)
        {
            if (action.equals("download_image"))
            {
                String url = intent.getStringExtra("url");

                String fname = UUID.randomUUID().toString() +
                        url.lastIndexOf(".") + 1;   // get extension

                File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                File file = new File(dir, fname);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();

                        if (downloadImage(url, file))
                        {
                            intent.setAction("download_completed");   // action-code for successful download
                            intent.putExtra("path", file.getAbsolutePath());      // path to the downloaded image
                        }
                        else
                        {
                            intent.setAction("download_failed");    // action-code for unsuccessful download
                        }

                        sendBroadcast(intent);
                    }
                }).start();
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    protected boolean downloadImage(String imgURL, File file) {
        try {
            URL url = new URL(imgURL);
            URLConnection conn = url.openConnection();

            InputStream in = conn.getInputStream();
            FileOutputStream out = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int bytesRead = -1;
            while ((bytesRead = in.read(buf)) != -1) {
                out.write(buf, 0, bytesRead);
            }

            out.close();
            in.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}