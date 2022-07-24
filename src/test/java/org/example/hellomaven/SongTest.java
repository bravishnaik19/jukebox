package org.example.hellomaven;


import entity.Song;
import operation.SongOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class SongTest {
    SongOperation s= new SongOperation();
    Song a1,a2,a3,a4,a5,a6,a7;
    ArrayList<Song> songlist=new ArrayList<>();

    @BeforeEach
    public void setup()
    {
        s= new SongOperation();
        a1=new Song(1,"bluebird.mp3","Naruto","sad","kingo","http://song.mp3.com", LocalTime.of(0,3,0));
        a2=new Song(2,"mysong.mp3","ross","happy","ibe","http://song.mp3.com",LocalTime.of(0,2,0));
        a3=new Song(3,"frinds.mp3","Rechal","emotional","rock","https//song.mp3",LocalTime.of(0,3,0));
        a4=new Song(4,"jazzs.mp3","hunterx","sad","kingroco","http://song.mp3.com",LocalTime.of(0,4,0));
        a5=new Song(5,"clever.mp3","luffy","sad","kingkong","http://song.mp3.com",LocalTime.of(0,2,0));
        a6=new Song(6,"ace.mp3","luffy","kpop","Rojar","http://song.mp3.com",LocalTime.of(0,3,0));
        a7=new Song(7,"aajanachle.mp3","haikyuu","rockband","kingkong","http://song.mp3.com",LocalTime.of(0,3,0));
        songlist.add(a1);
        songlist.add(a2);
        songlist.add(a3);
        songlist.add(a4);
        songlist.add(a5);
        songlist.add(a6);
    }

    @Test
    public void returnSongOperation()
    {
        List<Song> res= new ArrayList<>();
        res.add(a1);
        res.add(a4);
        res.add(a5);

        List<Song> list=s.SearchSongNameByGenre(songlist,"sad");
        assertEquals(res.size(),list.size());

        List<Song> resultartist=new ArrayList<>();
        resultartist.add(a3);

        List<Song> artistname=s.SearchSongNameByArtistName(songlist,"rock");
        assertEquals(resultartist,artistname);

        List<Song> ResAlbum=new ArrayList<>();
        ResAlbum.add(a1);
        List<Song> Album=s.SearchSongNameByAlbumName(songlist,"Naruto");
        assertEquals(ResAlbum,Album);

        List<Song> resgeners=new ArrayList<>();
        resgeners.add(a1);
        resgeners.add(a5);
        resgeners.add(a4);
        List<Song> generssort=s.SortingByGenre(songlist,"sad");
        assertEquals(resgeners,generssort);

        List<Song> result=new ArrayList<>();
        result.add(a1);
        result.add(a5);
        result.add(a4);

        List<Song> artistnameres=s.SortingByArtistName(songlist,"king");
        assertEquals(result,artistnameres);


        List<Song> sortbyalbum=new ArrayList<>();
        sortbyalbum.add(a6);
        sortbyalbum.add(a5);

        assertEquals(sortbyalbum, s.SortingByAlbumName(songlist,"luffy"));

    }
}
