package sample.multimodule.domain.entity;

public class Account {

	private Long id;

	private String number;

	private String type;

	private String creditCardNumber;

	/**
	 * Create an empty account.
	 */
	public Account() {

	}

	/**
	 * Create a new account.
	 * 
	 * @param number
	 *            the account number
	 * @param id
	 *            the account id
	 */
	public Account(Long id, String number) {
		this.number = number;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", number=" + number + ", type=" + type + ", creditCardNumber=" + creditCardNumber
				+ "]";
	}
	

}
