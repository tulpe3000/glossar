package frentzel.de.myglossar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends Activity {
    private TextView textViewHeader;
    private TextView textViewContent;
    private String details;
    private String header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textViewHeader = findViewById (R.id.textView);
        textViewContent = findViewById (R.id.textView2);
        Intent intent = getIntent();
        if (intent.hasExtra("content"))
            details = intent.getStringExtra("content");
        if (intent.hasExtra("header"))
            header = intent.getStringExtra("header");
        textViewContent.setText(details);
        textViewHeader.setText(header);
    }
}
