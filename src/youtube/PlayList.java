package youtube;

public class PlayList {
  
  private String name;
  private int numberOfVideos;
  private User user;
  private ArrayList<Video> videos;
  private boolean private; //if not private -> public
  private Date date;
  
  // structurata moje da trqbwa da se promeni
  // trqbwa da mojem kato zadadem da se mahne opredeleno video
  // da maha towa koeto iskame, a ne wsi4ki powtarq6ti se
  // smisal ako ima6 2 edni i sa6ti koeto e wazmojno, da moje6 da mahne6 samo 1
  
  PlayList(String name,User user, boolean status){
      this.name = name;
      this.numberOfVideos = 0;
      this.user = user;
      this.videos = new Arraylist<Video>();
      this.private = status;
      this.date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date);
  }
  
  private void changeName(String newName){
    this.name = newName;
  }
 
  
  private void addVideo(Video video){
    videos.add(video);
    numberOfVideos++;
  }
  
  private void removeVideo(Video video){
    // To DO
    // think of a way to remove a video that can be found more than once
    // and remove a specific one 
    // easy if we assume we always know the position of the video in the ArrayList
  }
  
  private void setToPublic(){
    this.private = false;
  }
  
  private void setToPrivate(){
    this.private = true;
  }
  

}
