package com.workshop.listview;

import android.app.Activity;
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

    protected String[] fnames, captions;

    public MyCustomAdapter(Context context, int resId) {
        super(context, resId);
        this.context = context;
    }

    public void setData(String[] fnames, String[] captions) {
        this.fnames = fnames;
        this.captions = captions;

        for (int i=0; i<fnames.length; i++) {
            add(null);
        }
    }

    @androidx.annotation.NonNull
    public View getView(int pos, View view, @NonNull ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);

            // if we are not responsible for adding the view to the parent,
            // then attachToRoot should be 'false' (which is in our case)
            view = inflater.inflate(R.layout.row, parent, false);
        }

        // set the image for ImageView
        ImageView imageView = view.findViewById(R.id.imageView);
        int id = context.getResources().getIdentifier(fnames[pos],
                "drawable", context.getPackageName());
        imageView.setImageResource(id);

        // set the text for TextView
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(captions[pos]);

        return view;
    }
}
