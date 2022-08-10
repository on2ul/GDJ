package quiz_song;

public class Singer {
	
	private String name;
	private Song[] songs;
	private int idx;
	
	//가수의 생성자
	public Singer(String name, int cnt) { //int는 노래 개수
		
		this.name = name;
		songs =new Song[cnt]; //노래를 2곡 가진다
		
		
	}
	
	public void addSong(Song song) {  //addSong에 song 전달
		if(idx==songs.length) { //노래가 꽉 차있으면 return으로 막음
			return;
		}
		songs[idx++]=song;
	}

	
	public void info() {
		System.out.println("가수이름"+name);
		System.out.println("대표곡");
		for(int i=0; i<idx; i++) {
			System.out.println(songs[i]);
		}
	}
	
	
	

}
