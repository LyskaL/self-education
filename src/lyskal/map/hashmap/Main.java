package lyskal.map.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(final String[] args) {
		Student lyuda = new Student("Ivanova", "Lyudmila", "Viktorovna", "20.08.1991");
		Student maria = new Student("Voronova", "Maria", "Denisovna", "13.09.1990");
		Student max = new Student("Lugov", "Max", "Petrovich", "30.03.1990");
		Student denis = new Student("Ishenko", "Denis", "Vaximovich", "11.12.1992");
		List<Student> groupBU32 = new ArrayList<Student>();
		groupBU32.add(max);
		groupBU32.add(denis);
		List<Student> groupBU20 = new ArrayList<Student>();
		groupBU20.add(lyuda);
		groupBU20.add(maria);
		
		Map<String, List<Student>> groups = new HashMap<String, List<Student>>();
		groups.put("BU-32", groupBU32);
		groups.put("BU-20", groupBU20);
		
		for (Map.Entry<String, List<Student>> group: groups.entrySet()) {
			System.out.println("Group: " + group.getKey());
			for (Student student : group.getValue()) {
				System.out.println(student.toString());
			}
			System.out.println();
		}
		
	}

}