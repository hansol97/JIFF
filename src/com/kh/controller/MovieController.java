package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.MovieService;
import com.kh.model.vo.Movie;
import com.kh.view.MainView;

public class MovieController {
    
    public void selectAll() {
        
         ArrayList<Movie> list = new MovieService().selectAll();
         
         if(list.isEmpty()) {
             new MainView().displayNodata("현재 상영중인 영화가 없습니다");
         }else {
             new MainView().displayOne(list);
         }
    }
    
    public void selectByTitle(String keyword) {
        
         ArrayList<Movie> list = new MovieService().selectByTitle(keyword);
        
        
        if(list.isEmpty()) {
             new MainView().displayNodata("검색한 영화가 없습니다.");
         }else {
             new MainView().displayOne(list);
         }
        
    }
    
    public void selectByGenre(String genre) {
        
        ArrayList<Movie> list = new MovieService().selectByGenre(genre);
        
        if(list.isEmpty()) {
            new MainView().displayNodata("검색한 장르 영화가 없습니다");
        }else {
            new MainView().displayOne(list);
        }
    }

}
