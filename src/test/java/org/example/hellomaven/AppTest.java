package org.example.hellomaven;

import entity.PodCast;
import entity.Song;
import entity.User;
import operation.PodCastOperation;
import operation.SongOperation;
import operation.UserValidation;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    Song a1,a2,a3,a4,a5,a6,a7;
    ArrayList<Song> songlist=new ArrayList<>();
    ArrayList<User> user=new ArrayList<>();
//    SongOperation songoperation=new SongOperation();
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }




    @BeforeEach
    public void setUp() {

//        list=new ArrayList<>();
         a1=new Song(1,"bluebird.mp3","Naruto","sad","kingo","http://song.mp3.com",LocalTime.of(0,3,0));
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
//        songoperation.addSong(a1);
//        songoperation.addSong(a2);
//        songoperation.addSong(a3);
//        songoperation.addSong(a4);
//        songoperation.addSong(a5);
//        songoperation.addSong(a6);
//        songoperation.addSong(a7);



    }



        @Test
    public void songOperation() throws NullPointerException
    {
//        Consumer<Song> c=(cust)-> System.out.println(cust);
//        list.forEach(c);


        SongOperation s= new SongOperation();
//        s.displayAllSongs(list);
        List<Song> res= new ArrayList<>();
        res.add(a1);
        res.add(a4);
        res.add(a5);
        List<Song>geners=new ArrayList<>();
        geners=s.SearchSongNameByGenre(songlist,"sad");

//        assertEquals(res.size(),geners.size());

//        s.SearchSongNameByGenre(list,"sad");
//        s.SearchSongNameByGenre(list,"bad");
//        s.SortingBgGenre(list,"sad");
//        s.SortingByArtistName(list,"king");
//        s.SortingByAlbumName(list,"luffy");


    }



    @Test
    public void validation() throws NullPointerException
    {
        ArrayList<User> list=new ArrayList<>();
        User u1=new User(1,"king","king@123");
        User u2=new User(2,"Raj","raj@123");
        list.add(u1);
        list.add(u2);
        UserValidation u = new UserValidation();
//        u.userValidation(list,1,"king@123");
//        u.userValidation(list,1,"king@123");
    }

//    @Test
//    public void podCastOperation()throws NullPointerException
//    {
//        ArrayList<PodCast> list=new ArrayList<>();
//        PodCast p1=new PodCast(1,"Avanger","jony dep",Date.valueOf("2022-04-30"));
//        PodCast p2=new PodCast(2,"king","rdj",Date.valueOf("2022-02-22"));
//        PodCast p3=new PodCast(3,"king","rdj",Date.valueOf("2022-02-22"));
//
//        list.add(p1);
//        list.add(p2);
//        list.add(p3);
//
//        PodCastOperation pd=new PodCastOperation();
////        pd.findPodCastBYName(list,"");
//
//        pd.findPodCastBYDate(list,Date.valueOf("2022-02-22"));
//
//
//    }



}
