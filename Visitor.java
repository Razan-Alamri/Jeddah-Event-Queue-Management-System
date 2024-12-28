// Visitor.java

/*
** Name: Razan Arif Alamri
** 9-12-2022
*/
package finallab2022_1;

public class Visitor {

	private String firstName;
	private String lastName;
	private String showName;
	private int TN;
	private Visitor next;

	/* Constructor */
	public Visitor() {
		next = null;
	}

	public Visitor(String fname, String lname, String showNum, int ticketNum, Visitor next) {
		this.firstName = fname;
		this.lastName = lname;
		this.showName = showNum;
		this.TN = ticketNum;
		this.next = next;
	}

	/* Getter methods */

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getShowName() {
		return showName;
	}

	public int getTN() {
		return TN;
	}

	public Visitor getNext() {
		return next;
	}

	/* Setter methods */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public void setTN(int TN) {
		this.TN = TN;
	}

	public void setNext(Visitor next) {
		this.next = next;
	}

}// end Visitor
