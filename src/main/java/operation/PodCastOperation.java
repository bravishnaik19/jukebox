package operation;

import entity.PodCast;

import java.sql.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PodCastOperation {

    public List<PodCast> findPodCastBYArtistName(List<PodCast> p, String name)throws NullPointerException
    {
//        if(p.isEmpty() || name.isEmpty())
//        {
//            NullPointerException n=new NullPointerException();
//            throw n;
//
//        }
        List<PodCast>res=p.stream().filter(m->m.getArtist().equals(name)).collect(Collectors.toList());
//        Consumer<PodCast> c=(cust)-> System.out.println(cust);
//        res.forEach(c);
        return res;
    }


    public List<PodCast> findPodCastBYDate(List<PodCast> p, Date dt)throws NullPointerException
    {
        System.out.println(dt);

        if(p.isEmpty() || dt==null)
        {
            NullPointerException n=new NullPointerException();
            throw n;

        }
        List<PodCast>res=p.stream().filter(m->m.getProdcastDate().equals(dt)).collect(Collectors.toList());
        Consumer<PodCast> c=(cust)-> System.out.println(cust);
        res.forEach(c);

        return res;
    }
}
