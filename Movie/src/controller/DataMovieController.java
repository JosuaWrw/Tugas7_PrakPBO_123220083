package controller;

import java.util.List;
import DAODataMovie.DataMovieDAO;
import DAOImplement.DataMovieImplement;
import model.*;
import view.MainView;

public class DataMovieController {
    MainView frame;
    DataMovieImplement impldataMovie;
    List<DataMovie> dm;
    
    public DataMovieController(MainView frame){
        this.frame = frame;
        impldataMovie = new DataMovieDAO();
        dm = impldataMovie.getAll();
    }
    public void isitabel(){
        dm = impldataMovie.getAll();
        ModelTabelDataMovie mt = new ModelTabelDataMovie(dm);
        frame.getTabelDataMovie().setModel(mt);
    }
    
    public void insert(){
        DataMovie dm = new DataMovie();
        dm.setJudul(frame.getjTjudul().getText());
        double alur = Double.parseDouble(frame.getjTalur().getText());
        dm.setAlur(alur);
        double penokohan = Double.parseDouble(frame.getjTpenokohan().getText());
        dm.setPenokohan(penokohan);
        double akting = Double.parseDouble(frame.getjTakting().getText());
        dm.setAkting(akting);
        double nilai = ((akting + penokohan + alur) / 3);
        dm.setNilai(nilai);
        impldataMovie.insert(dm);
    }
    
    public void update(){
        DataMovie dm = new DataMovie();
        dm.setJudul(frame.getjTjudul().getText());
        Double alur = Double.parseDouble(frame.getjTalur().getText());
        dm.setAlur(alur);
        Double penokohan = Double.parseDouble(frame.getjTpenokohan().getText());
        dm.setPenokohan(penokohan);
        Double akting = Double.parseDouble(frame.getjTakting().getText());
        dm.setAkting(akting);
        Double nilai = (alur + penokohan + akting)/3;
        dm.setNilai(nilai);
        impldataMovie.update(dm);
    }
    
    public void delete(){
        String judul = frame.getjTjudul().getText();
        impldataMovie.delete(judul);
    }
    
    public void clear(){
        impldataMovie.clear();
    } 
}
