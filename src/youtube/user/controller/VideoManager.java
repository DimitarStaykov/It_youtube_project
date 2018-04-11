package youtube.user.controller;

public class VideoManager {

	private static VideoManager instance;

	public static synchronized VideoManager getInstance() {
		if(instance == null) {
			instance = new VideoManager();
		}
		return instance;
	}
	
	private VideoManager() {
		
	}

	
	
	
}