package youtube;

import java.util.Set;

public class YouTube {

	private Set<User> users;
	private Set<Video> videos;
	private static YouTube youtube;
	
	public static YouTube getInstance() {
		if(youtube == null) {
			youtube = new YouTube();
		}
		return youtube;
	}
	
	private YouTube() {
		
	}
	
	public boolean upload(Video video) {
		if(this.videos.contains(video)) {
			System.out.println("There is existing video with the same title, rename it and try again.");
			return false;
		}
		this.videos.add(video);
		return true;
	}
	
	public void deleteVideo(Video video) {
		this.videos.remove(video);
	}
	
	public void register(String name,String password,String password2,String eMail){
		/*validate name restrictions - existingUsername and etc. 
		 *validate password
		 *compare two passwords for quality
		 * validate eMail format
		 * If everything passes create user and generate code
		 * temporary user data is stored in db , inactive users are removed once a day 
		 * set user as inactive till code is confirmed , has to be a bool that stops logins
		 * send code to e-mail
		 */
	}
	
	public void confirmEmail(String s){
		
		// if string s matches code in user
		// change boolean to make account login possible
	}
	
	public void logIn(String name, String password){
		
		// search database for input 
		// generate user page if correct
		// error page is data not found/incorrect 
	}
	

	public boolean existingEmail(String newEmail) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
