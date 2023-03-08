import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Student> studentArrayList = new ArrayList<Student>();
		studentArrayList.add(new Student("John Doe", 1, 62));
		studentArrayList.add(new Student("Jane Doe", 2, 22));
		studentArrayList.add(new Student("Mike", 3, 89));
		studentArrayList.add(new Student("Me", 4, 33));
		studentArrayList.add(new Student("You", 5, 2));
		Predicate<Float> predicate = marks -> marks > 33.0f;
		Function<Student, Float> function = student -> (student.marks) * 10 / 100;
		Supplier<Date> supplier = () -> new Date();
		Consumer<Student> consumer = student ->
		{
			System.out.println("Student name: " + student.name);
			System.out.println("Roll No.:     " + student.roll);
			System.out.println("Scored Marks: " + (student.marks + student.graceMarks));
		};
		System.out.println("The passed students are:- \n");
		for(Student student: studentArrayList)
		{
			student.graceMarks = function.apply(student);
			if(predicate.test(student.marks + student.graceMarks))
			{
				consumer.accept(student);
				System.out.println("\n");
			}
		}
		System.out.println("\n\nThe failed students are:- \n");
		for(Student student: studentArrayList)
		{
			student.graceMarks = function.apply(student);
			if(predicate.negate().test(student.marks + student.graceMarks))
			{
				consumer.accept(student);
				System.out.println("\n");
			}
		}
		System.out.println("The list was produced on: " + supplier.get());
	}
}