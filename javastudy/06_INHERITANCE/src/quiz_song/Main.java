package quiz_song;

public class Main {

	public static void main(String[] args) {
		
		
		Singer singer = new Singer("가수",2); // 가수의 노래 2개
		
		Song song1 = new Song("노래1",3.5);
		Song song2 = new Song("노래2",4.5);
		
		Producer producer =new Producer();
		producer.produce(singer,song1);
		producer.produce(singer,song2);
		
		singer.info();

	}

}
