package ex16_interface;

public class Person {


	public void  foodFeed(Pet pet,String food) {
		System.out.println(pet.getPetName()+"에게"+food+"주기");
	}

	public void walk(Walkable pet) {  //walk(Pet pet)으로 하면 낼름이도 들어감
		System.out.println(((Pet)pet).getPetName()+"와 산책");
		
	}
	
	
}	
	
	

