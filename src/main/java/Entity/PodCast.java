package entity;


import java.sql.Date;

public class PodCast {
    int podid;
    String prodcastname;
    String artist;
    Date ProdcastDate;
    String url;

    public PodCast(int podid, String prodcastname, String artist, Date prodcastDate,String url) {
        this.podid=podid;
        this.prodcastname = prodcastname;
        this.artist = artist;
        ProdcastDate = prodcastDate;
        this.url=url;
    }

    public String getProdcastname() {
        return prodcastname;
    }

    public void setProdcastname(String prodcastname) {
        this.prodcastname = prodcastname;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getProdcastDate() {
        return ProdcastDate;
    }

    public void setProdcastDate(Date prodcastDate) {
        ProdcastDate = prodcastDate;
    }

    public int getPodid() {
        return podid;
    }

    public void setPodid(int podid) {
        this.podid = podid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PodCast{" +
                "podid=" + podid +
                ", prodcastname='" + prodcastname + '\'' +
                ", artist='" + artist + '\'' +
                ", ProdcastDate=" + ProdcastDate +
                '}';
    }
}
