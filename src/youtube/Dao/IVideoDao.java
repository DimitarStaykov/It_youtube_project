package Dao;

import java.util.Collection;

import model.Video;

public interface IVideoDao {

	void addVideo(Video v) throws Exception;
	Video getById (int id) throws Exception;
	void editVideoName(String s,int id) throws Exception;
	void likeVideo (int id) throws Exception;
	void dislikeVideo ( int id) throws Exception;
	void deleteVideo (int id) throws Exception;
	Collection<Video> getAllVideos() throws Exception;	
	Collection<Video> getMostRecentVideos() throws Exception;
	Collection<Video> getMostLikedVideos() throws Exception;
}
