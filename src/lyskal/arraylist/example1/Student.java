package lyskal.arraylist.example1;

public class Student {
	private String _name;
	private String _birthdate;
	private int _numberGroup;
	
	public Student(final String name, 
				   final String birthdate, 
				   final int numberGroup){
		setName(name);
		setBirthdate(birthdate);
		setNumberGroup(numberGroup);
	}
	
	public String getName() {
		return _name;
	}
	
	public void setName(final String name) {
		if(name != null) {
			_name = name;
		}
	}
	
	public String getBirthdate() {
		return _birthdate;
	}
	
	public void setBirthdate(final String birthdate) {
		if(birthdate != null){
			_birthdate = birthdate;
		}
	}

	public int getNumberGroup() {
		return _numberGroup;
	}

	public void setNumberGroup(final int numberGroup) {
		if(numberGroup > 0){
			_numberGroup = numberGroup;
		}
	}

	@Override
	public String toString() {
		return "Name: " + _name + " Birthdate: " + _birthdate + " Number group: " + _numberGroup;
	}
	
	
}
