package com.example.app;

import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.media.MediaPlayer;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.GenericTypeIndicator;
import com.firebase.client.Query;
import com.rdio.android.api.Rdio;

import java.io.Console;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PartyQueue extends ListActivity {

    private static final String TAG = "PartyDJ";

    private static final String FIREBASE_URL = "https://flickering-fire-2243.firebaseio.com/";

    private Firebase firebase;

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

    private PlaylistAdapter playlistAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_queue);

        trackQueue = new LinkedList<Track>();

        firebase = new Firebase(FIREBASE_URL).child("Playlists");
        //Query partylistQ = firebase.limit(100);
        //give us the first 100 playlists in firebase
        //we handle cases where new playlists are added as well as moved
        //System.out.println(partylistQ);

        String t = firebase.getName();
        System.out.println(t);
        //still just prints out "Playlists"
        //Firebase pl = firebase.child("");
        //String tra = pl.getName();
        //Log.d(t, t);
        //Log.d(tra, tra);

        //Track t = new Track("")
        //Track t = dataSnapShot.getValue()
        //partylistQ.once('value', function(dataSnapShot));
        /*partylistQ.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot ds, String s) {
                Track tr = new Track("b", "brad", "b", "b", "b");
                //Track ud = dataSnapshot.getValue(t);
                //System.out.println("User" + ud.get("user_id") + "said" + ud.get("text"));
                //System.out.println("hi");

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                GenericTypeIndicator<Map<String, String>> t = new GenericTypeIndicator<Map<String, String>>() {};
                Map<String, String> ud = dataSnapshot.getValue(t);
                System.out.println("Message" + ud.get("message") + " from user " + ud.get("user_id") + "should no longer be displayed");

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/
        

        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        } */
        //don't have to check for null rdio I don't think
        //that should be done in onPause() or onStart()
        //check to see if user exists. If so, then get username and pass
        //SharedPreferences user = getPreferences(MODE_PRIVATE);
        //accessToken = user.getString(PREF_ACCESSTOKEN, null);
        //accessTokenSecret = user.getString(PREF_ACCESSTOKENSECRET, null);

        //create new rdio instance
        //rdio = new Rdio(appKey, appSecret, accessToken, accessTokenSecret, this, this);

        //allow user to browse playlists online and only prompt for login info if they
        //attempt to play the playlist or modify the playlist
        //only prompt login screen if you try to listen or create a playlist
        //check to make sure user exists
        if (accessToken == null || accessTokenSecret == null){}


    }

    public void onStart(){
        super.onStart();
        final ListView listView = getListView();

        playlistAdapter = new PlaylistAdapter(firebase.limit(50), this, R.layout.fragment_party_queue, "Playlist");
        listView.setAdapter(playlistAdapter);
        playlistAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(playlistAdapter.getCount() - 1);
            }
        });

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
