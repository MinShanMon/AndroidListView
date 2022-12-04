package com.example.ui_controldemo;

import androidx.appcompat.app.AppCompatActivity;

//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.content.Intent;
//import androidx.appcompat.app.AlertDialog;
//import android.content.DialogInterface;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String[] toons = {
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

        MyCustomAdapter adapter = new MyCustomAdapter(this, toons, captions);
        ListView listView = findViewById(R.id.listView);
        if (listView != null) {
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
// View v is the selected row
        TextView textView = v.findViewById(R.id.textView);
        String str = textView.getText().toString();
    }
}


//        Button btn1 = findViewById(R.id.btn1);
//        btn1.setOnClickListener(this);
//
//        Button btn2 = findViewById(R.id.btn2);
//        btn2.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v){
//        int id = v.getId();
//        Uri uri;
//        Intent intent = null;
//        if(id== R.id.btn1){
//            uri = Uri.parse("https://www.nus.edu.sg");
//            intent = new Intent(Intent.ACTION_VIEW, uri);
//        }
//
//        else if(id == R.id.btn2){
//            String title = getString(R.string.save);
//            String msg = getString(R.string.confirm_save);
//
//            AlertDialog.Builder dlg=new AlertDialog.Builder(this).setTitle(title)
//                    .setTitle(title)
//                    .setMessage(msg)
//                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which){
//                            //your action here
//                        }
//                    }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener(){
//                        @Override
//                        public void onClick(DialogInterface dialog, int which){
//                            //your action here
//                        }
//                    }).setIcon(android.R.drawable.ic_dialog_alert);
//            dlg.show();
//        }
//
//        if(intent != null){
//            if(intent.resolveActivity(getPackageManager())!=null){
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        }
//    }


}