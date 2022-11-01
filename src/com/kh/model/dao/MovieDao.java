package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Movie;
import static com.kh.common.JIFFTemplate.*;

public class MovieDao {

    private Properties prop = new Properties();

    public MovieDao() {

        try {
            prop.loadFromXML(new FileInputStream("resources/movie-mapper.xml"));

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public ArrayList<Movie> selectAll(Connection conn) {

        ArrayList<Movie> list = new ArrayList();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("SELECTALL");

        try {
            pstmt = conn.prepareStatement(sql);

            rset = pstmt.executeQuery();
            while (rset.next()) {

                Movie m = new Movie();

                m.setMovieNo(rset.getInt("MOVIE_NO"));
                m.setTitle(rset.getString("TITLE"));
                m.setGenre(rset.getString("GENRE"));
                m.setRating(rset.getInt("RATING"));

                list.add(m);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);

        }

        return list;
    }

    public ArrayList<Movie> selectByTitle(Connection conn, String keyword) {

        ArrayList<Movie> list = new ArrayList();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("SELECTBYTITLE");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+ keyword + "%");
            
            rset = pstmt.executeQuery();

            while (rset.next()) {

                Movie m = new Movie();

                m.setMovieNo(rset.getInt("MOVIE_NO"));
                m.setTitle(rset.getString("TITLE"));
                m.setGenre(rset.getString("GENRE"));
                m.setRating(rset.getInt("RATING"));

                list.add(m);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);
        }
        return list;
        

    }
    
    public ArrayList<Movie> selectByGenre(Connection conn, String genre){
        
        ArrayList<Movie> list = new ArrayList();
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String sql= prop.getProperty("SELECTBYGENRE");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,genre);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                Movie m = new Movie();
                
                m.setMovieNo(rset.getInt("MOVIE_NO"));
                m.setTitle(rset.getString("TITLE"));
                m.setGenre(rset.getString("GENRE"));
                m.setRating(rset.getInt("RATING"));
                
                list.add(m);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(rset);
            close(pstmt);
        }
        
        return list;
    }

}
