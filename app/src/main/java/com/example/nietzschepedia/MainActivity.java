package com.example.nietzschepedia;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] quotes;
    TextView quoteTextView;
    int currentQuoteIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.quoteTextView = findViewById(R.id.quoteTextView);

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
        this.currentQuoteIndex = random_quote_index;
        String quote_with_quotation_marks = "\"" + this.quotes[random_quote_index] + "\"";
        quoteTextView.setText(quote_with_quotation_marks);
    }


    public void nextQuote(View view) {
        currentQuoteIndex++;
        if (currentQuoteIndex >= quotes.length) {
            currentQuoteIndex = 0;
        }

        String quote_with_quotation_marks = "\"" + this.quotes[this.currentQuoteIndex] + "\"";
        quoteTextView.setText(quote_with_quotation_marks);
    }


    public void previousQuote(View view) {
        currentQuoteIndex--;
        if (currentQuoteIndex < 0) {
            currentQuoteIndex = quotes.length - 1;
        }

        String quote_with_quotation_marks = "\"" + this.quotes[this.currentQuoteIndex] + "\"";
        quoteTextView.setText(quote_with_quotation_marks);
    }
}

