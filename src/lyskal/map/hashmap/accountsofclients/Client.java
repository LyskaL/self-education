package lyskal.map.hashmap.accountsofclients;

import lyskal.map.hashmap.students.Person;

public class Client extends Person {
	private int _loanAmount;
	
	public static int MINIMUM_AMOUNT_OF_CREDIT = 1000;

	public Client(final String lastName, final String firstName, 
						 final String middleName, final String birthday,
						 final int loanAmount) {
		super(lastName, firstName, middleName, birthday);
		if (loanAmount > 0) {
			_loanAmount = loanAmount;
		} else {
			_loanAmount = MINIMUM_AMOUNT_OF_CREDIT;
		}
	}

	public int getLoanAmount() {
		return _loanAmount;
	}

	public void setLoanAmount(final int loanAmount) {
		_loanAmount = loanAmount;
	}
}
