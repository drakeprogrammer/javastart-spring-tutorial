package pl.drakeprogrammer.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Participant {
	private String firstName;
	private String lastName;

	public Participant(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Participant)) {
			return false;
		}
		Participant that = (Participant) o;
		return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFirstName(), getLastName());
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Participant.class.getSimpleName() + "[", "]").add("firstName='" + firstName + "'")
				.add("lastName='" + lastName + "'").toString();
	}
}
