package model;

public class DataMovie {
    private String judul;
    private double alur;
    private double penokohan;
    private double akting;
    private double nilai;
    
    public String getJudul (){
        return judul;
    }
    
    public void setJudul (String judul){
        this.judul = judul;
    }
    
    public double getAlur (){
        return alur;
    }
    
    public void setAlur (double alur){
        this.alur = alur;
    }
    
    public double getPenokohan (){
        return penokohan;
    }
    
    public void setPenokohan (double penokohan){
        this.penokohan = penokohan;
    }
    
    public double getAkting (){
        return akting;
    }
    
    public void setAkting (double akting){
        this.akting = akting;
    }
    
    public double getNilai (){
        return nilai;
    }
    
    public void setNilai (double nilai){
        this.nilai = nilai;
    }
}
