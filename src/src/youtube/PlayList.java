package youtube;

public class PlayList {
  
  String name;
  int numberOfVideos;
  User user;
  ArrayList<Video> videos;
  
  // structurata moje da trqbwa da se promeni
  // trqbwa da mojem kato zadadem da se mahne opredeleno video
  // da maha towa koeto iskame, a ne wsi4ki powtarq6ti se
  // smisal ako ima6 2 edni i sa6ti koeto e wazmojno, da moje6 da mahne6 samo 1
  
  PlayList(String name,User user){
      this.name = name;
      this.numberOfVideos = 0;
      this.user = user;
      this.videos = new Arraylist<Video>();
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

}
