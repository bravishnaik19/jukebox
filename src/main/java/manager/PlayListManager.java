package manager;

import audioInput.AudioOperation;
import dao.AudioDao;
import dao.PlayListDao;
import dao.UserDao;
import entity.Audio;
import entity.Playlist;
import entity.Song;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayListManager {
    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring the background color
    public static final String ANSI_RED_BACKGROUND
            = "\u001B[41m";
   static Scanner sc=new Scanner(System.in);

    public static void createPlayLsit() throws SQLException, ClassNotFoundException {
        System.out.println("Enter username");
        String username=sc.next();
        System.out.println("Enter Password");
        String pass=sc.next();
        List<User> list=UserDao.userLogin(username,pass);

//        System.out.println(id);

        if(!list.isEmpty())
        {
            System.out.println("1: Add Song in playlist");
            System.out.println("2. delete song from playlist");
            System.out.println(" 3 play songs");
            int playlist1=sc.nextInt();
            User user = (User)list.get(0);
            int id=user.getUsearid();
            List<Audio> a1= AudioDao.getAllAudioData();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.format("%10s,%20s,%10s,%10s","Audio id","Action","Song id","PodCast id");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            for(Audio s:a1)
            {

                System.out.format("%10s,%20s,%10s,%10s",s.getAudioid(),s.getAction(),s.getSongid(),s.getPodcastid());
                System.out.println();

            }
            switch(playlist1) {

                case 1:

                    int value = switchOptionsForCreateAudio();
                    int audioid = 0;
                    List<Playlist> playlist = new ArrayList<>();
                    do {
                        if (value == 1) {
                            audioid = AudioManager.getAudioid();
//                List<Song> play=PlayListDao.showAllSongsFromPlayList(id);
                            playlist = PlayListDao.getPlaylistData(id, audioid);
                            if (playlist.isEmpty()) {
                                PlayListDao.createPlayListwithSongId(audioid, id);
                                playListOption(1);
                            } else {
                                System.out.println(ANSI_RED_BACKGROUND
                                        + "Song is alrady present"
                                        + ANSI_RESET);
//                            playListOption(1);
//                    PlayListManager.playListOptionBysongandPodcast(1);
                            }
                        }
                    } while (!playlist.isEmpty());
                    if (value == 2) {
                        audioid = AudioManager.getAudioByPodcast();
                        PlayListDao.createPlayListwithSongId(audioid, id);
                        playListOption(1);

                    }

                    break;
                case 2:
                    List<Song> songlist = PlayListDao.showAllSongsFromPlayList(id);
//                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
//                    System.out.format("%5s,%20s,%20s,%20s,%20s,%35s","songId","Title","Album","Genre","Artist","url");
//                    System.out.println();
//                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
//                    for(Song s:songlist)
//                    {
//
//                        System.out.format("%5s,%20s,%20s,%20s,%20s,%35s",s.getSongid(),s.getSongname(),s.getAlbumname(),s.getGenrse(),s.getArtist(),s.getUrl());
//                        System.out.println();
//
//                    }
                    do {
                        if (!songlist.isEmpty()) {
                            audioid = AudioManager.getAudioid();
                            PlayListDao.deleteSonglist(id, audioid);
                            playListOption(1);
                        } else {
                            System.out.println(ANSI_RED_BACKGROUND
                                    + "No Song is present to delete"
                                    + ANSI_RESET);
                        }
                    }while(songlist.isEmpty());

                case 3:
                    AudioOperation.playsong(username,pass);
            }


        }
        else
        {
            System.out.println(ANSI_RED_BACKGROUND
                    + "Incorrect Username and password"
                    + ANSI_RESET);
            playListOption(1);

        }

    }
    public static void signupUser() throws SQLException, ClassNotFoundException {
        System.out.println("Enter user name");
        String username=sc.next();
        boolean b=UserDao.checkUsername(username);
        if(b)
        {
            System.out.println(ANSI_RED_BACKGROUND
                    + "Username is alrady Present try another"
                    + ANSI_RESET);
            playListOption(2);
        }
        else
        {
            System.out.println("Enter Password");
            String password=sc.next();
            UserDao.createSignup(username,password);
            playListOption(1);

        }


    }
    public static void switchOptions() throws SQLException, ClassNotFoundException {
        System.out.println("1.login");
        System.out.println("2. signup");
        int option= sc.nextInt();
        playListOption(option);
    }

    public static void playListOption(int a) throws SQLException, ClassNotFoundException {
        int option=a;

        switch(option)
        {
            case 1:
//                System.out.println("playListOption");
                createPlayLsit();
                break;
            case 2:
                signupUser();
                break;

            default:
                switchOptions();

        }
    }

    public static int switchOptionsForCreateAudio() throws SQLException, ClassNotFoundException {
        System.out.println("1.Search by song id");
        System.out.println("2. Search by podcastid");
        int option= sc.nextInt();
//        playListOptionBysongandPodcast(option);
        return option;
    }


    public static void playListOptionBysongandPodcast(int a) throws SQLException, ClassNotFoundException {
        int option=a;

        switch(option)
        {
            case 1:
                AudioManager.getAudioid();

                break;
            case 2:
                AudioManager.getAudioByPodcast();
        }
    }


}
