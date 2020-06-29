package com.example.nietzschepedia;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.displayRandomQuote();
    }

    public void displayRandomQuote() {
        String text = "";

        try {
            InputStream is = getAssets().open("myquotes.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
            String[] parts = text.split("\n");

            Random rand = new Random();
            int random_quote_index = rand.nextInt(parts.length);

            Toast.makeText(MainActivity.this, parts[random_quote_index], Toast.LENGTH_LONG).show();
        } catch (IOException ie) {
            Toast.makeText(MainActivity.this, "An error occurred!", Toast.LENGTH_LONG).show();
        }
    }
}

