package DAOImplement;
import java.util.List;
import model.*;

public interface DataMovieImplement {
    public void insert (DataMovie m);
    public void update (DataMovie m);
    public void delete (String judul);
    public void clear();
    public List<DataMovie> getAll();
}
