import exception.UserException;
import switchOption.Options;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UserException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Options.switchOptions();
    }

}
