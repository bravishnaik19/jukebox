package dao;

import entity.Song;
import connection.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SongDao {

    public static List<Song> accesAllData() throws SQLException, ClassNotFoundException {
        Connection con = Connector.getConnection();
        List<Song>res= new ArrayList<>();
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery("Select * from song");

        while(rs.next())
        {
            int songid=rs.getInt(1);
            String name=rs.getString(2);
            String albumname=rs.getString(3);
            String Genres=rs.getString(4);
            String artist=rs.getString(5);
            String url=rs.getString(6);
            String duration=rs.getString(7);

            Song s1=new Song(songid,name,albumname,Genres,artist,url,LocalTime.parse(duration));
            res.add(s1);

        }


        return res;
    }


}
