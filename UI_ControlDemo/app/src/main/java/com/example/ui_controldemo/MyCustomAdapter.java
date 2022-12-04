package com.example.ui_controldemo;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MyCustomAdapter extends ArrayAdapter {
    private final Context context;
    protected String[] toons, captions;
    public MyCustomAdapter(Context context, String[] toons, String[] captions){
        super(context,R.layout.row);

        this.context = context;
        this.toons = toons;
        this.captions = captions;

        addAll(new Object[toons.length]);
    }
    public View getView(int pos, View view, @NonNull ViewGroup parent){
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, parent, false);
        }
        ImageView imageView = view.findViewById(R.id.imageView);
        int id = context.getResources().getIdentifier(toons[pos], "drawable", context.getPackageName());
        imageView.setImageResource(id);

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(captions[pos]);
        return view;
    }

}
