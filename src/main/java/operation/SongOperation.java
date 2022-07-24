package operation;

import entity.Song;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SongOperation {


    public void displayAllSongs(List<Song> e) throws NullPointerException
    {

        if(e.isEmpty())
        {
            NullPointerException n=new NullPointerException();
            throw n;
        }
        Consumer<Song> c=(cust)-> System.out.println(cust);
        e.forEach(c);
    }

    public List<Song> SearchSongNameByGenre(List<Song> e,String genre) throws NullPointerException
    {

        if(e.isEmpty() || genre.isEmpty())
        {
            NullPointerException n=new NullPointerException();
            throw n;
        }
        List<Song>res=e.stream().filter(m->m.getGenrse().contains(genre)).collect(Collectors.toList());

        return res;
    }

    public List<Song> SearchSongNameByArtistName(List<Song> e, String genre)throws NullPointerException
    {
        if(e.isEmpty() || genre.isEmpty())
        {
            NullPointerException n=new NullPointerException();
            throw n;
        }
        List<Song>res=e.stream().filter(m->m.getArtist().contains(genre)).collect(Collectors.toList());
        return res;
    }

    public List<Song> SearchSongNameByAlbumName(List<Song> e, String genre) throws NullPointerException
    {
        if(e.isEmpty() || genre.isEmpty())
        {
            NullPointerException n=new NullPointerException();
            throw n;
        }
        List<Song>res=e.stream().filter(m->m.getAlbumname().contains(genre)).collect(Collectors.toList());
        return res;
    }

    public List<Song> SortingByGenre(List<Song> e,String name)throws NullPointerException
    {
        if(e.isEmpty() || name.isEmpty())
        {
            NullPointerException n=new NullPointerException();
            throw n;
        }
        SongOperation s= new SongOperation();
        List<Song> l1=s.SearchSongNameByGenre(e,name);
        List<Song> l2=l1.stream().sorted((o1,o2)->o1.getSongname().compareTo(o2.getSongname())).collect(Collectors.toList());

        return l2;
    }

    public List<Song> SortingByArtistName(List<Song>e,String name)throws NullPointerException
    {
        if(e.isEmpty() || name.isEmpty())
        {
            NullPointerException n=new NullPointerException();
            throw n;
        }

            SongOperation s= new SongOperation();
            List<Song> l1=s.SearchSongNameByArtistName(e,name);
            List<Song> l2=l1.stream().sorted((o1,o2)->o1.getSongname().compareTo(o2.getSongname())).collect(Collectors.toList());

            Consumer<Song> c=(cust)-> System.out.println(cust);
            l2.forEach(c);
            return l2;
    }

    public List<Song>SortingByAlbumName(List<Song>e,String name) throws NullPointerException
    {
        if(e.isEmpty() || name.isEmpty())
        {
            NullPointerException n=new NullPointerException();
            throw n;
        }
        SongOperation s= new SongOperation();
        List<Song> l1=s.SearchSongNameByAlbumName(e,name);
        List<Song> l2=l1.stream().sorted((o1,o2)->o1.getSongname().compareTo(o2.getSongname())).collect(Collectors.toList());

        Consumer<Song> c=(cust)-> System.out.println(cust);
        l2.forEach(c);
        return l2;
    }

}
