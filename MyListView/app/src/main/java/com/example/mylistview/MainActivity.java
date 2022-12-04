package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    String emoj[]={"Afraid", "Full", "Hug", "Laugh", "No_way", "Peep", "Snore", "Stop", "Tired", "What"};
//    int imgPath[] = {R.drawable.afraid, R.drawable.full, R.drawable.hug, R.drawable.laugh, R.drawable.no_way, R.drawable.peep, R.drawable.snore,
//    R.drawable.stop, R.drawable.tired, R.drawable.what};

    String[] emoj={"hug", "laugh", "peep", "snore", "stop",
            "tired", "full", "what", "afraid", "no_way"};
    String[] imgPath = {"Hug, please!", "So funny!", "You there?", "I'm out...", "Stop It!",
            "I'm beat...", "So Full!", "What?!", "Leave me alone...", "No Way!"};
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ForCustomBaseAdapter
//        listView = (ListView) findViewById(R.id.customListView);
//        CustomBaseAdapter customeBaseAdapter = new CustomBaseAdapter(getApplicationContext(), emoj, imgPath);
//        listView.setAdapter(customeBaseAdapter);


        //demo
        MyCustomAdapter adapter = new MyCustomAdapter(this, emoj, imgPath);
        ListView listView = findViewById(R.id.customListView);
        if(listView != null){
            listView.setAdapter(adapter);
           listView.setOnItemClickListener(this);
        }
    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        TextView textView = view.findViewById(R.id.textView);
//        String str = textView.getText().toString();
//    }
}