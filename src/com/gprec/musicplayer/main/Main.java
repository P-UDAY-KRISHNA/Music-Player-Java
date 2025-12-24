package com.gprec.musicplayer.main;
import java.util.Scanner;

import com.gprec.musicplayer.model.Song;
import com.gprec.musicplayer.service.MusicPlayerService;

public class Main {
    public static void main(String[] args) {
        MusicPlayerService service = new MusicPlayerService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Update 3.Delete 4.View 5.Search 6.AddToPlaylist 7.Play 8.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Artist: ");
                    String artist = sc.nextLine();
                    service.addSong(new Song(id, title, artist));
                    break;

                case 2:
                    System.out.print("ID: ");
                    id = sc.nextLine();
                    System.out.print("New Title: ");
                    title = sc.nextLine();
                    System.out.print("New Artist: ");
                    artist = sc.nextLine();
                    service.updateSong(id, title, artist);
                    break;

                case 3:
                    System.out.print("ID: ");
                    service.deleteSong(sc.nextLine());
                    break;

                case 4:
                    service.viewSongs();
                    break;

                case 5:
                    System.out.print("Title: ");
                    service.searchSong(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Song ID: ");
                    service.addToPlaylist(sc.nextLine());
                    break;

                case 7:
                    service.playPlaylist();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}
