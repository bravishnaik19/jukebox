package audioInput;
import dao.PlayListDao;
import dao.UserDao;
import entity.Song;
import entity.User;
import manager.SongManager;
import switchOption.Options;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioOperation {

    static UserDao ud=new UserDao();
    static Song current_song=null;
    static List<Song> songlist=null;
    long position;

    static AudioOperation audioplayer=new AudioOperation();

    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring the background color
    public static final String ANSI_RED_BACKGROUND
            = "\u001B[41m";
    // to store current position
    Long currentFrame;
     static Clip clip;
    // current status of clip
    String status;

    static AudioInputStream audioInputStream;
    static String filePath;

    public static void playsong(String pusername,String pass1)
    {
        try
        {
            Scanner sc1 = new Scanner(System.in);
//            System.out.println("Enter username");
//            String username=sc1.next();
            String username=pusername;
//            System.out.println("Enter Password");
//            String pass=sc1.next();
            String pass=pass1;
            List<User> list=UserDao.userLogin(username,pass);
            if(!list.isEmpty()) {
                User user = (User)list.get(0);
                int userid=user.getUsearid();
                songlist=PlayListDao.showAllSongsFromPlayList(userid);

                System.out.println("Enter song id");

                int id = sc1.nextInt();
                current_song = SongManager.searchSongBySongUrl(id);
                System.out.println(ANSI_RED_BACKGROUND
                        + current_song.getSongname()
                        + ANSI_RESET);
                filePath = current_song.getUrl();
                initAudio();


                audioplayer.play();
                Scanner sc = new Scanner(System.in);

                while (true) {
//                    System.out.println();
                    int c = SongOption.Selectoption();
//
                    if (c == 2)
//                        sc.close();
                        break;

                }
                audioplayer.stop();
            }
            else
            {
                System.out.println(ANSI_RED_BACKGROUND
                        + "Invalid user name password"
                        + ANSI_RESET);
                Options.operation(6);
            }
        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    // Work as the user enters his choice

        // Method to play the audio
    public void play() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.start();

//        Position();
//        System.out.println(currentFrame);
        status = "play";
    }

    public  static void Position() throws InterruptedException {
        for(long i=clip.getMicrosecondLength();i>0;i--)
        {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public  void pause()
    {
        position=clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }
    public  void resume()
    {
        clip.setFramePosition((int) position);
        clip.start();
    }

    public static void nextSong() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        int index = 0;
        for(int i = 0; i < songlist.size(); i++){
            Song song = songlist.get(i);
            if(song.getSongid()== current_song.getSongid()){
                index = i;
            }
        }
        System.out.println("size : "+songlist.size() + "\t index : " + index);
        if(index<(songlist.size()-1)){
//            System.out.println(index);
//            System.out.println(current_song.getSongid());
//            System.out.println(current_song.getSongname());
            audioplayer.stop();

            filePath = songlist.get(index+1).getUrl();
            current_song=songlist.get(index+1);
            System.out.println(ANSI_RED_BACKGROUND
                    + current_song.getSongname()
                    + ANSI_RESET);

            initAudio();
            audioplayer.play();

        } else {
            System.out.println(ANSI_RED_BACKGROUND
                    + "You are Last song"
                    + ANSI_RESET);
        }

    }

    public static void previous() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        int index = 0;
            for (int i = 0; i < songlist.size(); i++) {
                Song song = songlist.get(i);
                if (song.getSongid() == current_song.getSongid()) {
                    index = i;
                }
            }
            if(index>0)
            {
                audioplayer.stop();

                filePath = songlist.get(index - 1).getUrl();
                current_song=songlist.get(index-1);
                System.out.println(ANSI_RED_BACKGROUND
                        + current_song.getSongname()
                        + ANSI_RESET);
                initAudio();
                audioplayer.play();
            }
            else
            {
                System.out.println(ANSI_RED_BACKGROUND
                        + "You are at first song"
                        + ANSI_RESET);
            }

    }

    public static void shuffle() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        int min = 0;
        System.out.println(songlist.size()-1);
        int max = songlist.size()-1;
//        System.out.println();
        //create instance of Random classz
        Random randomNum = new Random();
        int a = min + randomNum.nextInt(max);

        System.out.println(a);

        audioplayer.stop();
        filePath = songlist.get(a).getUrl();
        initAudio();
        audioplayer.play();
    }

    public static void loopSong() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        for(Song song : songlist) {
            audioplayer.stop();
            filePath = song.getUrl();
            initAudio();
            audioplayer.play();
            System.out.println("song : " + song.getSongname() + "d : " + clip.getFrameLength());
            while(true){
                if(clip.getMicrosecondLength() == 0){
                    break;
                }
            }
        }
    }

    public static void initAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
