package entity;

public class Playlist {
    int playlistid;
    int userid;
    int audioid;

    public Playlist(int playlistid, int userid, int audioid) {
        this.playlistid = playlistid;
        this.userid = userid;
        this.audioid = audioid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getAudioid() {
        return audioid;
    }

    public void setAudioid(int audioid) {
        this.audioid = audioid;
    }
}
