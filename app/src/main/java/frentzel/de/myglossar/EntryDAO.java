package frentzel.de.myglossar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

interface EntryDAO {
    public ArrayList<Entry> getEntryList() throws IOException;
}
