package manager;

import dao.AudioDao;

import java.sql.SQLException;
import java.util.Scanner;

public class AudioManager {

    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring the background color
    public static final String ANSI_RED_BACKGROUND
            = "\u001B[41m";
    static Scanner sc=new Scanner(System.in);

    public static int getAudioid() throws SQLException, ClassNotFoundException {
//        int value=PlayListManager.switchOptionsForCreateAudio();
        int audioid=0;
//        if(value==1)
//        {

            System.out.println("Enter Song id");
            int songid=sc.nextInt();
            audioid= AudioDao.returnIdBySongId(songid);
            if(audioid==0)
            {
                System.out.println(ANSI_RED_BACKGROUND
                        + "Song id you entered is incorrect"
                        + ANSI_RESET);
                PlayListManager.playListOptionBysongandPodcast(1);
            }

        return audioid;
    }

    public static int getAudioByPodcast() throws SQLException, ClassNotFoundException {
//        int value=PlayListManager.switchOptionsForCreateAudio();
        int podcastid=0;
//        if(value==2)
//        {

            System.out.println("Enter podcast id");
            int podid=sc.nextInt();
            podcastid= AudioDao.returnIdByPodCast(podid);
            if(podcastid==0)
            {
                System.out.println(ANSI_RED_BACKGROUND
                        + "Podcast id you entered is incorrect"
                        + ANSI_RESET);
                PlayListManager.playListOption(2);
            }
//        }
        return podcastid;
    }
}
