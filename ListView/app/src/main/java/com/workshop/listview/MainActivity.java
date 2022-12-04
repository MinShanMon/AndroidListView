package com.workshop.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private final String[] fnames = {
            "hug", "laugh", "peep", "snore", "stop",
            "tired", "full", "what", "afraid", "no_way"
    };
    private final String[] captions = {
            "Hug, please!", "So funny!", "You there?", "I'm out...", "Stop It!",
            "I'm beat...", "So Full!", "What?!", "Leave me alone...", "No Way!"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCustomAdapter adapter = new MyCustomAdapter(this, 0);
        adapter.setData(fnames, captions);

        ListView listView = findViewById(R.id.listView);
        if (listView != null) {
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> av,
                            View v, int pos, long id) {

        TextView textView = v.findViewById(R.id.textView);
        String caption = textView.getText().toString();

        Toast toast = Toast.makeText(this, caption, Toast.LENGTH_SHORT);
        toast.show();
    }
}