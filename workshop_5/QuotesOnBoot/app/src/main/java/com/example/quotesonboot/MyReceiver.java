package com.example.quotesonboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Random;

public class MyReceiver extends BroadcastReceiver {

    protected final String[] quotes = {
            "Life is the sum of our choices.",
            "What hurts more - the pain of hard work or the pain of regret?",
            "Let your life be shaped by decisions you made, not by the ones you didn't.",
            "Knowledge is knowing what to say. Wisdom is knowing when to say it.",
            "Critique to sharpen; not to put down.",
            "Our greatest fear should not be of failure, but of succeeding at things that don't really matter.",
            "Creativity comes from constraint.",
            "Change begins, when you start trying."
    };

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            Random rand = new Random();
            Toast.makeText(context, quotes[rand.nextInt(quotes.length)],
                    Toast.LENGTH_LONG).show();
        }
    }
}