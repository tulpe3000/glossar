package frentzel.de.myglossar;

public class Entry {
    private String header;
    private String content;

    public Entry(){
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return header;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

}
