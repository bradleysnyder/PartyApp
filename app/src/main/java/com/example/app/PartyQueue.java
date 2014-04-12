package com.example.app;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;

import com.rdio.android.api.Rdio;

import java.util.LinkedList;
import java.util.Queue;

public class PartyQueue extends ActionBarActivity {

    private static final String TAG = "PartyDJ";

    private MediaPlayer player;

    private Queue<Track> trackQueue;

    private static Rdio rdio;

    private static final String appKey = "45zphqtyn4xb6zcusenp94q7";
    private static final String appSecret = "WxvBq8GQHS";

    private static String accessToken = null;
    private static String accessTokenSecret = null;

    private static final String PREF_ACCESSTOKEN = "prefs.accesstoken";
    private static final String PREF_ACCESSTOKENSECRET = "prefs.accesstokensecret";

    private static String collectionKey = null;

    private ImageView albumArt;
    private ImageView playPause;

    private class Track {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_queue);

        trackQueue = new LinkedList<Track>();

       /* if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();

        }
        */
        //if no instance of rdio exists like when the app is first opened
        //but there shouldn't be
        //seems like this check should be done in onResume() or onStart()
        //if (rdio == NULL){
        //}
        SharedPreferences user = getPreferences(MODE_PRIVATE);
        accessToken = user.getString(PREF_ACCESSTOKEN, null);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.party_queue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_party_queue, container, false);
            return rootView;
        }
    }

}
