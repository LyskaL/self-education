package lyskal.arraylist.example2;

import java.util.ArrayList;

public class Main {

	public static void main(final String[] args) {
		Teacher lyuda = new Teacher("Ludmila Vladimirovna");
		lyuda.addItems("Math");
		lyuda.addItems("Geography");
		lyuda.addItems("English");
		Teacher maria = new Teacher("Maria Ivanovna");
		maria.addItems("English");
		maria.addItems("History");
		Teacher peter = new Teacher("Peter Alekseevich");
		peter.addItems("Physical education");
		
		ArrayList<Teacher> teachers = new ArrayList<>();
		//add teachers in ArrayList
		teachers.add(peter);
		teachers.add(maria);
		teachers.add(lyuda);
		show(teachers);
		//find Teacher lyuda and delete her
		if(teachers.contains(lyuda)) {
			teachers.remove(lyuda);
		}
		show(teachers);
		//set Teacher with index 0 on Teacher lyuda
		teachers.set(0, lyuda);
		show(teachers);
		//cleach ArrayList
		teachers.clear();
		System.out.println("Remove all teachers: ");
		show(teachers);
	}
	
	public static void show(final ArrayList<Teacher> teachers) {
		if(teachers != null){
			for (Teacher teacher : teachers) {
				System.out.println(teacher.toString());
			}
			System.out.println();
		}
		
	}

}
