package quiz_song;

public class Song {
	
	private String title;
	private double playIime;
	
	public Song(String title, double playIime) {
		super();
		this.title = title;
		this.playIime = playIime;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", playIime=" + playIime + "]";
	}
	
	
	

}
