package lyskal.map.hashmap.students;

public abstract class Person {
	@Override
	public String toString() {
		return " " + _lastName + " " + _firstName + " " + _middleName + "\t" + _birthday;
	}

	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _birthday;

	public Person(final String lastName,
				  final String firstName,
				  final String middleName, 
				  final String birthday) {
		if(Validator.isValidName(firstName) &&
		   Validator.isValidName(lastName) &&
		   Validator.isValidName(middleName) &&
		   Validator.isValidDate(birthday)) {
			_firstName = firstName;
			_lastName = lastName;
			_middleName = middleName;
			_birthday = birthday;
		} else {
			throw new IllegalArgumentException("Не валидные данные!");
		}
	}

	public String getFirstName() {
		return _firstName;
	}
	
	public String getLastName() {
		return _lastName;
	}
	
	public String getMiddleName() {
		return _middleName;
	}
	
	public String getBirthday() {
		return _birthday;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_birthday == null) ? 0 : _birthday.hashCode());
		result = prime * result + ((_firstName == null) ? 0 : _firstName.hashCode());
		result = prime * result + ((_lastName == null) ? 0 : _lastName.hashCode());
		result = prime * result + ((_middleName == null) ? 0 : _middleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (_birthday == null) {
			if (other._birthday != null)
				return false;
		} else if (!_birthday.equals(other._birthday))
			return false;
		if (_firstName == null) {
			if (other._firstName != null)
				return false;
		} else if (!_firstName.equals(other._firstName))
			return false;
		if (_lastName == null) {
			if (other._lastName != null)
				return false;
		} else if (!_lastName.equals(other._lastName))
			return false;
		if (_middleName == null) {
			if (other._middleName != null)
				return false;
		} else if (!_middleName.equals(other._middleName))
			return false;
		return true;
	}
}