package org.example.hellomaven;

import entity.PodCast;
import operation.PodCastOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class PodcastTest {
    PodCastOperation uv=new PodCastOperation();
    ArrayList<PodCast> list=new ArrayList<>();
    PodCast p1,p2,p3;
    @BeforeEach
    public void setup()
    {

         p1=new PodCast(1,"Avanger","jony dep", Date.valueOf("2022-04-30"),"haatp?//ahahhaja");
         p2=new PodCast(2,"king","rdj",Date.valueOf("2022-02-22"),"haatp?//ahahhaja");
         p3=new PodCast(3,"king","rdj",Date.valueOf("2022-02-22"),"haatp?//ahahhaja");

         list.add(p1);
         list.add(p2);
         list.add(p3);

    }

    @Test
    public void podCast()
    {
        List<PodCast> p=new ArrayList<>();

        p.add(p2);
        p.add(p3);

        List<PodCast> ps=new ArrayList<>();

        assertEquals(p,uv.findPodCastBYArtistName(list,"rdj"));
        assertEquals(ps,uv.findPodCastBYArtistName(list,"rdjaaa"));

        List<PodCast> date=new ArrayList<>();
        date.add(p1);
        assertEquals(date,uv.findPodCastBYDate(list,Date.valueOf("2022-04-30")));

    }
}
