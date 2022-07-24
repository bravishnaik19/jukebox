package dao;

import connection.Connector;
import entity.Playlist;
import entity.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PlayListDao {

    public static void createPlayListwithSongId(int audioid,int userid) throws SQLException, ClassNotFoundException {
        Connection con= Connector.getConnection();
        String query="insert into playlist(audioid,userid) values(?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,audioid);
        ps.setInt(2,userid);
        int count=ps.executeUpdate();
        System.out.println(count+" records affected");
    }

    public static List<Song> showAllSongsFromPlayList(int userid) throws SQLException, ClassNotFoundException {
        Connection con=Connector.getConnection();
        List<Song> result=new ArrayList<>();
        String query="select song.songid,song.songname,song.albumname,song.genres,song.artist,song.url,song.songdur from song inner join audio inner join playlist on song.songid=audio.songid and audio.audioid=playlist.audioid where userid=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,userid);
        ResultSet rs=ps.executeQuery();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%5s,%20s,%20s,%20s,%20s,%35s","songId","Title","Album","Genre","Artist","url");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        while(rs.next())
        {
            int songid=rs.getInt(1);
            String songname=rs.getString(2);
            String albumname=rs.getString(3);
            String genres=rs.getString(4);
            String artistname=rs.getString(5);
            String songurl=rs.getString(6);
            String songduration=rs.getString(7);

            Song s=new Song(songid,songname,albumname,genres,artistname,songurl, LocalTime.parse(songduration));

            result.add(s);



                System.out.format("%5s,%20s,%20s,%20s,%20s,%35s",songid,songname,albumname,genres,artistname,songurl);
                System.out.println();


//            System.out.println(songid+"  "+songname+"  "+albumname+"  "+genres+"  "+artistname+"  "+songurl+"  "+songduration);
        }
        return result;
    }

    public static void deleteSonglist(int userid,int audioid) throws SQLException, ClassNotFoundException {
        Connection con=Connector.getConnection();
        String query="delete from playlist where userid=? and audioid=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,userid);
        ps.setInt(2,audioid);
        int count=ps.executeUpdate();
        System.out.println(count+" records affected");

    }

    public static List<Playlist> getPlaylistData(int puserid,int audioid) throws SQLException, ClassNotFoundException {
        Connection con=Connector.getConnection();
        List<Playlist> res=new ArrayList<>();
        String query="select * from playlist where userid=? and audioid=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,puserid);
        ps.setInt(2,audioid);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            int playlistid=rs.getInt(1);
            int laudioid=rs.getInt(2);
            int userid=rs.getInt(3);

            Playlist pl=new Playlist(playlistid,laudioid,userid);
            res.add(pl);

        }
        return res;
    }
}
