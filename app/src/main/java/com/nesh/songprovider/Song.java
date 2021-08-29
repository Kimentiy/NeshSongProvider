package com.nesh.songprovider;

public class Song {
    private final String title;
    private final String downloadUrl;

    public Song(String title, String downloadUrl) {
        this.title = title;
        this.downloadUrl = downloadUrl;
    }


    public String getTitle() {
        return title;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
}
