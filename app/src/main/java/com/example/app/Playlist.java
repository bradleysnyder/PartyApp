package com.example.app;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jacob on 4/12/14.
 */
public class Playlist {
    private String name;
    private String owner;
    public Queue<Tracks> tracks;

    public Playlist(String aName, String anOwner){
        name = aName;
        owner = anOwner;
        tracks = new LinkedList<Tracks>();
    }

    public String getName() {return name;}
    public String getOwner() {return owner;}
}
