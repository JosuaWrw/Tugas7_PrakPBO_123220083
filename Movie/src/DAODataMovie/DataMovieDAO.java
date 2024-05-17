package DAODataMovie;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.DataMovieImplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataMovieDAO implements DataMovieImplement {
    Connection connection;
    
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?)";
    final String update = "UPDATE movie SET judul=?, alur=?, penokohan=?, akting=?, nilai=? WHERE movie.judul=? ";
    final String delete = "DELETE FROM movie WHERE judul=?";
    final String clear = "TRUNCATE TABLE movie";
    
    public DataMovieDAO (){
        connection = connector.connection();
    }

    @Override
    public void insert(DataMovie m) {
         PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getNilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                m.setJudul(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataMovie m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getNilai());
            statement.setString(6, m.getJudul());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void clear(){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(clear);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataMovie> getAll() {
        List<DataMovie> dm = null;
        try{
            dm = new ArrayList<DataMovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataMovie movie = new DataMovie();
                movie.setJudul(rs.getString("Judul"));
                movie.setAlur(rs.getDouble("Alur"));
                movie.setPenokohan(rs.getDouble("Penokohan"));
                movie.setAkting(rs.getDouble("Akting"));
                movie.setNilai(rs.getDouble("Nilai"));
                dm.add(movie);
            }
        } catch(SQLException ex){
            Logger.getLogger(DataMovieDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dm;
    }
}
