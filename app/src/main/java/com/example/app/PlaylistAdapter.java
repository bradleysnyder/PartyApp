package com.example.app;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;

/**
 * Created by Jacob on 4/12/14.
 */
public class PlaylistAdapter extends FirebaseListAdapter<Playlist>{
    private String playlistName;

    public PlaylistAdapter(Query ref, Activity activity, int layout, String username) {
        super(ref, Playlist.class, layout, activity);
        this.playlistName = username;
    }

    @Override
    protected void populateView(View view, Playlist playlist) {
        // Map a Chat object to an entry in our listview
        String owner = playlist.getOwner();
        String name = playlist.getName();
        TextView artistText = (TextView)view.findViewById(R.id.name);
        artistText.setText(name + "by ");
        // If the message was sent by this user, color it differently
        ((TextView)view.findViewById(R.id.owner)).setText(owner);
    }
}
