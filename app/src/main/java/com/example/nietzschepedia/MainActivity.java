package com.example.nietzschepedia;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            InputStream is = getAssets().open("myquotes.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer);
            this.quotes = text.split("\n");

        } catch (IOException ie) {
            Toast.makeText(MainActivity.this, "An error occurred in reading the quotes from the file!", Toast.LENGTH_LONG).show();
        }

        displayRandomQuote();
    }

    public void displayRandomQuote() {
        Random rand = new Random();
        int random_quote_index = rand.nextInt(this.quotes.length);

        Toast.makeText(MainActivity.this, this.quotes[random_quote_index], Toast.LENGTH_LONG).show();
    }
}

