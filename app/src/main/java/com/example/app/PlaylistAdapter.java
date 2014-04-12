package com.example.app;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;

/**
 * Created by Jacob on 4/12/14.
 */
public class PlaylistAdapter extends FirebaseListAdapter<Track>{
    private String playlistName;

    public PlayListAdapter(Query ref, Activity activity, int layout, String username) {
        super(ref, Track.class, layout, activity);
        this.playlistName = username;
    }

    @Override
    protected void populateView(View view, Track track) {
        // Map a Chat object to an entry in our listview
        String owner = Playlist.getOwner();
        String name = Track.getTrackName();
        TextView artistText = (TextView)view.findViewById(R.id.artist);
        artistText.setText(name + "by ");
        // If the message was sent by this user, color it differently
        ((TextView)view.findViewById(R.id.)).setText(chat.getMessage());
    }
}
