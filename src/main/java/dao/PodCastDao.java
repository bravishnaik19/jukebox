package dao;

import entity.PodCast;
import connection.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodCastDao {
        public static  List<PodCast> podCastDatata() throws SQLException, ClassNotFoundException {
        Connection con= Connector.getConnection();

        List<PodCast> pod=new ArrayList<>();
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery("Select * from prodcast");
        while(rs.next())
        {
            int poid=rs.getInt(1);
            String name=rs.getString(2);
            String artistnm=rs.getString(3);
            String relesedt=rs.getString(4);
            String url=rs.getString(5);

            PodCast po= new PodCast(poid,name,artistnm, Date.valueOf(relesedt),url);

            pod.add(po);
        }
        return pod;
    }
}
