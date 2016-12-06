package lyskal.set.treeset.example1;

public class Country implements Comparable<Country>{
	private String _name;
	
	public Country(final String name) {
		if (name != null){
			_name = name;
		}
	}

	public String getName() {
		return _name;
	}

	public void setName(final String name) {
		this._name = name;
	}

	@Override
	public String toString() {
		return "country: " + _name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
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
		Country other = (Country) obj;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		return true;
	}

	@Override
	public int compareTo(final Country country) {
		return _name.compareTo(country.getName());
	}
}