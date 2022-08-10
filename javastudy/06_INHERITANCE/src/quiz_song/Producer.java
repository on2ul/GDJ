package quiz_song;

public class Producer {
	
	private String name;

	//프로듀서의 생성자
	/* public Producer(String name) {
		super();
		this.name = name;
	}
	*/
	public void produce(Singer singer,Song song) {
		singer.addSong(song); //가수한테 노래를 준다
		
		
	}

}
