package com.kh.model.service;

import static com.kh.common.JIFFTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.MovieDao;
import com.kh.model.vo.Movie;

public class MovieService {
    
    public ArrayList<Movie> selectAll() {
        
        Connection conn = getConnection();
        
        ArrayList<Movie> list= new MovieDao().selectAll(conn); 
        
        close(conn);
        
        return list;
    }
    
    public ArrayList<Movie> selectByTitle(String keyword) {
        
        Connection conn = getConnection();
        
        ArrayList<Movie> list= new MovieDao().selectByTitle(conn, keyword); 
        
        close(conn);
        
        return list;
        
    }
    
    public ArrayList<Movie> selectByGenre(String genre) {
        
        Connection conn = getConnection();
        
        ArrayList<Movie> list = new MovieDao().selectByGenre(conn, genre);
        
        close(conn);
        
        return list;
        
    }

}
