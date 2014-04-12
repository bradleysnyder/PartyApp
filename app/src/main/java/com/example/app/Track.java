package com.example.app;

/**
 * Created by Jacob on 4/12/14.
 */
public class Track {
    private String key;
    private String trackName;
    private String artistName;
    private String albumName;
    private String albumArt;

    public Track(String k, String name, String artist, String album, String uri) {
        key = k;
        trackName = name;
        artistName = artist;
        albumName = album;
        albumArt = uri;
    }

    public String getTrackName() {return trackName;}
    public String getArtistName() {return artistName;}
    public String getAlbumName() {return albumName;}
    public String getKey() {return key;}
    public String getAlbumArt() {return albumArt;}

}
