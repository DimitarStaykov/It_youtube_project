package youtube.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class VideoDao implements IVideoDao {
	
	private static VideoDao instance;
	private Connection connection;
	
	public static VideoDao getInstance() {
		if(instance == null) {
			instance = new VideoDao();
		}
		return instance;
	}

	private VideoDao(){
		connection = DBManager.getInstance().getConnection();
	}

	@Override
	public void addVideo(Video v) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = connection.prepareStatement(""
				+ "INSERT INTO Videos(source,name,user VALUES (?,?,?)");
			s.setString(1, v.getLocation());
			s.setString(2, v.getTitle());
			s.setObject(3, v.getPostedBy());
	}

	@Override
	public Video getById(int id) throws SQLException {
		PreparedStatement s = connection.prepareStatement("SELECT * FROM Videos WHERE id=?");
		s.setString(1, ""+id);
		ResultSet result = s.executeQuery();
		Video v = new Video(); //insert from result w/e 
		// ^!!!!!!!!!!!!!!!! 
	}

	@Override
	public void editVideoName(String str, int id) throws SQLException {
		PreparedStatement s = connection.prepareStatement("Update Videos SET name=? WHERE id=?");
		s.setString(1, str);
		s.setString(2, ""+id);
		s.executeUpdate();
	}

	@Override
	public void likeVideo(int id) throws SQLException {
		PreparedStatement s = connection.prepareStatement("Update Videos SET likes=likes+1 WHERE id=?");
		s.setString(1, ""+id);
		s.executeUpdate();
		
	}

	@Override
	public void dislikeVideo(int id) throws SQLException {
		PreparedStatement s = connection.prepareStatement("Update Videos SET likes=likes-1 WHERE id=?");
		s.setString(1, ""+id);
		s.executeUpdate();
		
	}

	@Override
	public void deleteVideo(int id) throws SQLException {
		PreparedStatement s = connection.prepareStatement("DELETE FROM Videos WHERE id=?");
		s.setString(1, ""+id);
		s.executeUpdate();
	}

	@Override
	public Collection<Video> getAllVideos() throws SQLException {
		PreparedStatement s = connection.prepareStatement("SELECT * FROM Videos");
		ArrayList<Video> videos= new ArrayList<Video>();
		ResultSet result = s.executeQuery();
		
	}

	@Override
	public Collection<Video> getMostRecentVideos() throws SQLException {
		PreparedStatement s = connection.prepareStatement("SELECT * FROM Videos ORDER BY date");
		ArrayList<Video> videos= new ArrayList<Video>();
		ResultSet result = s.executeQuery();
	}

	@Override
	public Collection<Video> getMostLikedVideos() throws SQLException {
		PreparedStatement s = connection.prepareStatement("SELECT * FROM Videos ORDER BY likes");
		ArrayList<Video> videos= new ArrayList<Video>();
		ResultSet result = s.executeQuery();
	}
	

	
}
