package com.example.app;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jacob on 4/12/14.
 */
public class Playlist {
    private String name;
    private String owner;
    //public Queue<Track> tracks;

    private Playlist(){};

    Playlist(String aName, String anOwner){
        name = aName;
        owner = anOwner;
        //tracks = new LinkedList<Track>();
    }

    public String getName() {return name;}
    public String getOwner() {return owner;}
}
