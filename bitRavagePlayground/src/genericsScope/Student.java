package genericsScope;

public class Student extends Person implements Comparable<Student>{
	public String school;
	
	@Override
	public int compareTo(Student s) {
		return this.school.compareTo(s.school);
	}
}

// will Freshman match <T extends Comparable<? super T>>
// will Freshman match <T extends Comparable<T>>
// If it matches, what benifits?