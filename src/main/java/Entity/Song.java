package entity;


import java.sql.Time;
import java.time.LocalTime;

public class Song {
    int songid;
    String Songname;
    String albumname;
    String genrse;
    String artist;
    String url;
    LocalTime songduration;

    public Song(int songid,String songname, String albumname, String genrse, String artist, String url,LocalTime songduration) {
        this.songid=songid;
        this.Songname = songname;
        this.albumname = albumname;
        this.genrse = genrse;
        this.artist = artist;
        this.url = url;
        this.songduration = songduration;
    }

    public String getSongname() {
        return Songname;
    }

    public void setSongname(String songname) {
        Songname = songname;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getGenrse() {
        return genrse;
    }

    public void setGenrse(String genrse) {
        this.genrse = genrse;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalTime getSongduration() {
        return songduration;
    }

    public void setSongduration(LocalTime songduration) {
        this.songduration = songduration;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    @Override
    public String toString() {
        return
                "songid:  " + songid +
                "  Songname: " + Songname +
                "  albumname:  " + albumname +
                "  genrse:  " + genrse+
                "  artist:  " + artist +
                "  url:  " + url+
                "  songduration:  " + songduration
                ;
    }
}
