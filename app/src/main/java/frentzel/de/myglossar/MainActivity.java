package frentzel.de.myglossar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<Entry> entries = new ArrayList<Entry>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EntryDAO dao = new EntryDAOText(MainActivity.this);

        try {
            entries = dao.getEntryList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<Entry> entryListAdapter = new ArrayAdapter<Entry>(
                this,
                R.layout.entrylist_layout,
                R.id.textViewEntry,
                entries
        );
        ListView listViewEntry = findViewById(R.id.listViewEntry);
        listViewEntry.setAdapter(entryListAdapter);
        Toast.makeText(getApplication(),entries.get(0).getContent(), Toast.LENGTH_LONG).show();
        listViewEntry.setOnItemClickListener((p,v,i,l)->showDetails(p,i));
    }

    private void showDetails(AdapterView<?> p, int i) {
        Intent intent = new Intent(this,DetailsActivity.class);
        intent.putExtra("content",entries.get(i).getContent());
        intent.putExtra("header",entries.get(i).getHeader());
        startActivity(intent);
    }
}
