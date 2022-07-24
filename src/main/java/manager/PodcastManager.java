package manager;

import dao.PodCastDao;
import entity.PodCast;
import entity.Song;
import switchOption.Options;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PodcastManager
{
    static List<PodCast> pod;

    static {
        try {
            pod = PodCastDao.podCastDatata();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PodcastManager() throws SQLException, ClassNotFoundException {
    }

    public static void displaydata() throws UnsupportedAudioFileException, SQLException, LineUnavailableException, IOException, ClassNotFoundException {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%5s,%20s,%20s,%20s,%35s","poid","Title","Artist","ProdcastDate","url");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(PodCast s:pod)
        {

            System.out.format("%5s,%20s,%20s,%20s,%35s",s.getPodid(),s.getProdcastname(),s.getArtist(),s.getProdcastDate(),s.getUrl());
            System.out.println();

        }
        Options.switchOptions();
    }
}
