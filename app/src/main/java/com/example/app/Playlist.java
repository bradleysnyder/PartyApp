package com.example.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Jacob on 4/12/14.
 */
public class Playlist {
    private String name;
    private String owner;
    public List<Track> Track;
   // private String Track;

    private Playlist(){};

    Playlist(String aName, String anOwner){
        name = aName;
        owner = anOwner;
        Track = new ArrayList<Track>();
        //tracks = new LinkedList<Track>();
    }

    public String getName() {return name;}
    public String getOwner(){return owner;}
    //public String getTrack(){return Track;}
}
