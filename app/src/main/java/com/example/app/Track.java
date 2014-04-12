package com.example.app;

/**
 * Created by Jacob on 4/12/14.
 */
public class Track {
    public String key;
    public String trackName;
    public String artistName;
    public String albumName;
    public String albumArt;

    public Track(String k, String name, String artist, String album, String uri) {
        key = k;
        trackName = name;
        artistName = artist;
        albumName = album;
        albumArt = uri;
    }
}
