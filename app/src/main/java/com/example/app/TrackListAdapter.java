package com.example.app;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;

/**
 * Created by Jacob on 4/12/14.
 */
public class TrackListAdapter extends FirebaseListAdapter<Track>{
        private String trackName;

        public TrackListAdapter(Query ref, Activity activity, int layout, String username) {
            super(ref, Track.class, layout, activity);
            this.trackName = username;
        }

        @Override
        protected void populateView(View view, Track track) {
            // Map a Chat object to an entry in our listview
            String trackName = track.getTrackName();
            String artistName = track.getArtistName();
            TextView artistText = (TextView)view.findViewById(R.id.name);
            artistText.setText(trackName + " by ");
            // If the message was sent by this user, color it differently
            ((TextView)view.findViewById(R.id.owner)).setText(artistName);
        }
}