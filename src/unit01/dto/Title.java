package unit01.dto;

import java.util.List;

public class Title {
	private int no;
	private String name;

	public Title() {}

	public Title(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public Title(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.no == ((Title)obj).no;
	}

	@Override
	public String toString() {
		return String.format("Title [%s, %s]", no, name);
	}

}
