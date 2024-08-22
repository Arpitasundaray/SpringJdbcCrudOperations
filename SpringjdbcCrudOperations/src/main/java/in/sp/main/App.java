package in.sp.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.sp.beans.Student;
import in.sp.mappers.StudentRowMapper;
import in.sp.resources.SpringConfigFile;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//        //------------insert operation-------------//

		/*
		 * int std_roll = 107; String std_name = "puja"; float std_marks = 89.2f;
		 * 
		 * String insert_sql_query = "INSERT INTO student Values(?,?,?)"; int count =
		 * jdbcTemplate.update(insert_sql_query, std_roll, std_name, std_marks); if
		 * (count > 0) { System.out.println("insertion success"); } else {
		 * System.out.println("insertion failed"); }
		 */
//        //-------------update------------------//
		/*
		 * float marks = 23.9f; int roll = 101; String update_sql_query =
		 * "UPDATE student SET std_marks=? WHERE std_roll=?"; int count =
		 * jdbcTemplate.update(update_sql_query, marks, roll); // Corrected order of
		 * parameters if (count > 0) { System.out.println("Updation success"); } else {
		 * System.out.println("Updation failed"); }
		 */

		// ------------delete---------------//
		/*
		 * int roll = 101;
		 * 
		 * String delete_sql_query = "DELETE FROM student  WHERE std_roll=?"; int count
		 * = jdbcTemplate.update(delete_sql_query, roll); if (count > 0) {
		 * System.out.println("deletion success"); } else {
		 * System.out.println("deletion failed"); }
		 */
		//------------select-----------//
		String select_sql_query = "SELECT * from student";
		List<Student> std_list = jdbcTemplate.query(select_sql_query , new StudentRowMapper());
        for(Student std : std_list) {
        	
        	System.out.println("Rollno :"+std.getRollno());
        	System.out.println("Name :"+std.getName());
        	System.out.println("Marks :"+std.getMarks());
        	System.out.println("---------------------------");
        }
	}
}
