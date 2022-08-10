package quiz_exam;

public class Exam {
	
	private String examName; // 시험 이름 저장
	private int kor;
	private int eng;
	private int mat;
	
	public Exam(String examName) { // "중간고사"
		this.examName=examName;
		
	}
	
	public void setScore() {
		kor=(int)(Math.random()*101);  // 점수 랜덤 처리
		eng=(int)(Math.random()*101);
		mat=(int)(Math.random()*101);
	
	}
	public void examInfo() {
		System.out.println(examName+"성적");
		System.out.println("국어 :"+kor+",영어 :"+eng+",수학 :"+mat);
		int total=kor+eng+mat;
		System.out.println("총점 :"+total+",평균 :"+(total/3.0));
	}
}



	
	
	
