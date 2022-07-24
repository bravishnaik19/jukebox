package dao;

import connection.Connector;
import entity.Audio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AudioDao {

    public static List<Audio> getAllAudioData() throws SQLException, ClassNotFoundException {
        Connection con=Connector.getConnection();
        List<Audio> audio=new ArrayList<>();
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery("select * from audio");
        while (rs.next())
        {
            int audioid=rs.getInt(1);
            String action=rs.getString(2);
            int songid=rs.getInt(3);
            int podcastid=rs.getInt(4);
            Audio au=new Audio(audioid,action,songid,podcastid);
            audio.add(au);
        }
        return audio;
    }

    public static int returnIdBySongId(int id) throws SQLException, ClassNotFoundException {
        Connection con=Connector.getConnection();
        int laudioid=0;
        String query="select audioid from audio where songid=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while (rs.next())
        {
            int gaudioid=rs.getInt(1);
            laudioid=gaudioid;
        }
        return laudioid;
    }

    public static int returnIdByPodCast(int id) throws SQLException, ClassNotFoundException {
        Connection con=Connector.getConnection();
        int laudioid=0;
        String query="select audioid from audio where prodcastid=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while (rs.next())
        {
            int gaudioid=rs.getInt(1);
            laudioid=gaudioid;
        }
        return laudioid;
    }


}
