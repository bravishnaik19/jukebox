package manager;

import dao.SongDao;
import entity.Song;
import switchOption.Options;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.io.*;

public class SongManager {

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring the background color
    public static final String ANSI_RED_BACKGROUND
            = "\u001B[41m";
    public  SongManager() throws SQLException, ClassNotFoundException {
    }

    static List<Song> songs;

    static {
        try {
            songs = SongDao.accesAllData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Scanner sc = new Scanner(System.in);

    public void showAllSongs() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {

//        Consumer<Song> c = (cust) -> System.out.println(cust);
//        songs.forEach(c);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%5s,%20s,%20s,%20s,%20s,%35s","songId","Title","Album","Genre","Artist","url");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(Song s:songs)
        {

            System.out.format("%5s,%20s,%20s,%20s,%20s,%35s",s.getSongid(),s.getSongname(),s.getAlbumname(),s.getGenrse(),s.getArtist(),s.getUrl());
            System.out.println();

        }
        Options.switchOptions();
    }

    public static void searchSongBySongName() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("Enter Song name to Search");
        String songname = sc.next();
        List<Song> songresult = songs.stream().filter(f -> f.getSongname().equals(songname)).collect(Collectors.toList());
        if (songresult.isEmpty())
        {
            System.out.println(ANSI_RED_BACKGROUND
                    + "Song name you entered is incorrect"
                    + ANSI_RESET);
//            UserException c1 = new UserException("Wrong Song name");
            Options.operation(2);
//            throw c1;

        }
        else
        {
            Consumer<Song> c = (cust) -> System.out.println(cust);
            songresult.forEach(c);
            Options.switchOptions();

        }

    }

    public static void searchSongByArtistName() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("Enter Artist name to Search");
        String artistname = sc.next();
        List<Song> songresult = songs.stream().filter(f -> f.getArtist().equals(artistname)).collect(Collectors.toList());
        if (songresult.isEmpty()) {
            System.out.println(ANSI_RED_BACKGROUND
                    + "Artist name you entered is incorrect"
                    + ANSI_RESET);
            Options.operation(3);
//            UserException c1 = new UserException("Wrong input");
//            throw c1;
        }
        else
        {
            Consumer<Song> c = (cust) -> System.out.println(cust);
            songresult.forEach(c);
            Options.switchOptions();
        }

    }

    public static void searchSongBygeners() throws UnsupportedAudioFileException, SQLException, LineUnavailableException, IOException, ClassNotFoundException {
        System.out.println("Enter geners name to Search");
        String genersname = sc.next();
        List<Song> songresult = songs.stream().filter(f -> f.getGenrse().equals(genersname)).collect(Collectors.toList());
        if (songresult.isEmpty()) {
            System.out.println(ANSI_RED_BACKGROUND
                    + "Artist name you entered is incorrect"
                    + ANSI_RESET);
            Options.operation(4);
//            UserException c1 = new UserException("Wrong input");
//            throw c1;
        }
        else
        {
            Consumer<Song> c = (cust) -> System.out.println(cust);
            songresult.forEach(c);
            Options.switchOptions();
        }

    }

    public static Song searchSongBySongUrl(int id) throws UnsupportedAudioFileException, SQLException, LineUnavailableException, IOException, ClassNotFoundException {
        String curl=null;
         List<Song>res=songs.stream().filter(c->c.getSongid()==id).collect(Collectors.toList());

         if(res.isEmpty()) {
             System.out.println(ANSI_RED_BACKGROUND
                     + "Song id you entered is incorrect"
                     + ANSI_RESET);
             Options.operation(6);
             return null;
         }
         else {
             return res.get(0);
         }
    }

}
