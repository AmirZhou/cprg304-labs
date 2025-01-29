package exercise1;


/**
 * @author Yue (Amir) Zhou
 *  
 */
public class Student implements Comparable<Student>{
	private final String name;
	private final int age;
	
	public int getAge() {
		return age;
	};
	
	public String getName() {
		return name;
	}
	
	public Student( String name, int age ) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Student o) {
		return Integer.compare(this.age, o.getAge());
	}
	
	@Override
	public String toString() {
		return this.getName() + ':' + this.getAge();
	}
}
