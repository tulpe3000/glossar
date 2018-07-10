package frentzel.de.myglossar;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EntryDAOText implements EntryDAO {

    private InputStream input;
    private Context res;
    public EntryDAOText(Context res){
        this.res = res;
        this.input = res.getResources().openRawResource(R.raw.glossary);
    }

    @Override
    public ArrayList<Entry> getEntryList() throws IOException {
        ArrayList<Entry> entries;

            String entryHeader;
            String entryContent;
            entries = new ArrayList<Entry>();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            while ((entryHeader = br.readLine())!=null) {
                Entry entry = new Entry();
                entry.setHeader(entryHeader);
                entryContent = getContent(entryHeader);
                entry.setContent(entryContent);
                entries.add(entry);
            }

        return entries;
    }

    private String getContent(String entryHeader) {
        String entryContent = "";
        String str="";
        input = getInput(entryHeader);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            while ((str = br.readLine()) != null) {
               entryContent += str+"\n";
            }
        }
        catch (Exception e){
            entryContent = "xxx";
        }
        return entryContent;
    }

    private InputStream getInput(String entryHeader) {
        String str = entryHeader.toLowerCase().trim();
        switch (str){
            case "activity" : return res.getResources().openRawResource(R.raw.activity);

            case "intent" : return res.getResources().openRawResource(R.raw.intent);

            case "theme" : return res.getResources().openRawResource(R.raw.theme);

            case "view" : return res.getResources().openRawResource(R.raw.view);

        }
        return res.getResources().openRawResource(R.raw.view);
    }
}
