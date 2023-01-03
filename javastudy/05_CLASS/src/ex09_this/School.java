package ex09_this;

public class School {

	
	// 필드
	private Student[] students;
	private int idx;  //students 배열의 인덱스.students배열에 저장된 학생수와 같다
	
	
	
	
	// 생성자
	public School(int cnt) {
		students=new Student[cnt];
	}
	
	//메소드
	//일반적인 코드 가이드
	public void addStudent(Student student) {
		if(idx == students.length) {
			System.out.println("Full");
			return;
		}
		
		students[idx++]=student;
	}

		
	   /* 위와 같은 코드
		if(idx == students.length) {
			System.out.println("Full");
		}else {
			students[idx++]=student;
			
		}
		*/
		
	
	
	//일반포문
	
	public void printStudents() {
	/*
		for(int i=0;i<idx; i++ ) { //i<students.length; 로 쓰면 학생수가 없을때 오류 발생
			System.out.println(students[i].getName()+","+students[i].getStuNo());
			
		}
		*/
		
	

	for(Student student :students) {
		if(student !=null) {
			System.out.println(student.getName()+","+student.getStuNo());
			}
		}
	}
}


