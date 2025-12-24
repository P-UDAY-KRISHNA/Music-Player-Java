package com.gprec.musicplayer.service;
import java.util.*;

import com.gprec.musicplayer.model.Song;

public class MusicPlayerService {
    private HashMap<String, Song> songLibrary = new HashMap<>();
    private ArrayList<Song> playlist = new ArrayList<>();

    public void addSong(Song song) {
        songLibrary.put(song.getId(), song);
        System.out.println("Song added successfully.");
    }

    public void updateSong(String id, String title, String artist) {
        if (songLibrary.containsKey(id)) {
            Song s = songLibrary.get(id);
            s.setTitle(title);
            s.setArtist(artist);
            System.out.println("Song updated.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void deleteSong(String id) {
        if (songLibrary.remove(id) != null) {
            System.out.println("Song deleted.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void viewSongs() {
        if (songLibrary.isEmpty()) {
            System.out.println("No songs available.");
            return;
        }
        for (Song s : songLibrary.values()) {
            System.out.println(s);
        }
    }

    public void searchSong(String title) {
        boolean found = false;
        for (Song s : songLibrary.values()) {
            if (s.getTitle().equalsIgnoreCase(title)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("Song not found.");
    }

    public void addToPlaylist(String id) {
        Song s = songLibrary.get(id);
        if (s != null) {
            playlist.add(s);
            System.out.println("Song added to playlist.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void playPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        for (Song s : playlist) {
            System.out.println("Playing: " + s.getTitle());
        }
    }
}
