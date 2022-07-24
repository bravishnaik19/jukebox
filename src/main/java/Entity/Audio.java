package entity;

public class Audio {
    int audioid;
    String action;
    int songid;
    int podcastid;

    public Audio(int audioid, String action, int songid, int podcastid) {
        this.audioid = audioid;
        this.action = action;
        this.songid = songid;
        this.podcastid = podcastid;
    }

    public int getAudioid() {
        return audioid;
    }

    public void setAudioid(int audioid) {
        this.audioid = audioid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public int getPodcastid() {
        return podcastid;
    }

    public void setPodcastid(int podcastid) {
        this.podcastid = podcastid;
    }

    @Override
    public String toString() {
        return
                "audioid: " + audioid +
                "  action:  " + action +
                "  songid:  " + songid +
                "  podcastid  " + podcastid;
    }
}
