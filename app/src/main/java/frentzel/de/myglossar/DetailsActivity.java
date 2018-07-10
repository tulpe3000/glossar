package frentzel.de.myglossar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends Activity {
    private TextView textViewHeader;
    private TextView textViewContent;
    private TextView textView3;
    private String details;
    private String header;
    private ArrayList<Entry> entries = new ArrayList<>();
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textViewHeader = findViewById (R.id.textView);
        textViewContent = findViewById (R.id.textView2);
        textView3 = findViewById (R.id.textView3);
        Intent intent = getIntent();
        if (intent.hasExtra("content"))
            details = intent.getStringExtra("content");
        if (intent.hasExtra("header"))
            header = intent.getStringExtra("header");
        if (intent.hasExtra("entries"))
            entries = intent.getParcelableArrayListExtra("entries");
        if (intent.hasExtra("id"))
            id=intent.getIntExtra("id",0);
        textViewContent.setText(details);
        textViewHeader.setText(header);
        textView3.setText(entries.get(id).getHeader()+"\n"+entries.get(id).getContent());
    }
}
