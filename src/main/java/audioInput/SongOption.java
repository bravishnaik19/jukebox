package audioInput;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class SongOption {

    static Scanner sc= new Scanner(System.in);
    public static int Selectoption() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        System.out.println("Select option");
        System.out.println("1. pause");
        System.out.println("2. Exit");
        System.out.println("3 next song");
        System.out.println("4 Previous song");
        System.out.println("5 shuffle");
        System.out.println("6. Resume");
        System.out.println(" 7.loop");
//        System.out.println("4. stop");
        int num=sc.nextInt();
        songOptions(num);
        return num;

    }

    public static void songOptions(int action) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        int option = action;
        AudioOperation a=new AudioOperation();

        switch (option) {
            case 1:
                a.pause();
                break;
            case 3:
                AudioOperation.nextSong();
                break;
            case 4:
                AudioOperation.previous();
                break;
            case 5:
                AudioOperation.shuffle();
                break;
            case 6:
                a.resume();
            case 7:
                AudioOperation.loopSong();
            default:
        }
    }
}



