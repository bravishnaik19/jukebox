package switchOption;

import audioInput.AudioOperation;
import entity.PodCast;
import manager.PlayListManager;
import manager.PodcastManager;
import manager.SongManager;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Options {

    public static void switchOptions() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        int option=0;
        System.out.println("Select Option");
        System.out.println("1 Show all the songs");
        System.out.println("2 Search Song by Song name");
        System.out.println("3 Search Song by Song artist name");
        System.out.println("4 Search Song by genres");
        System.out.println("5 Create playlist");
        System.out.println("6 Show all podcast");
//        System.out.println("6 play song");
        System.out.println("7 Exit");
        Scanner sc=new Scanner(System.in);
        option=sc.nextInt();
        operation(option);

    }

    public static void operation(int a) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        SongManager songma=new SongManager();
//        b.Options();
        int option=a;
//        System.out.println(option);
        switch (option)
        {
            case 1:
                songma.showAllSongs();
                break;
            case 2:
                songma.searchSongBySongName();
                break;
                case 3:
                    songma.searchSongByArtistName();
                    break;
            case 4:
                SongManager.searchSongBygeners();
                break;
            case 5:
                PlayListManager.switchOptions();
                break;
            case 6:
                PodcastManager.displaydata();
                break;

            case 7:
                System.exit(0);

        }
    }
}
