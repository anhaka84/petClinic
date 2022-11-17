package DB.core;

import java.util.Arrays;
import java.util.List;

public class DemoDB {

    public static void main(String[] args) {

        DB<Student> db = new DB<>();
//
        System.out.println("\n---------<getOne()>---------\n");

        String getOne_query = "SELECT * FROM student WHERE rollNumber = ?";
        List getOne_condition = Arrays.asList(1);

        System.out.println(db.getOne(getOne_query, getOne_condition, new Student()));
//
        System.out.println("\n----------<getAll()>----------\n");

        String getAll_query = "SELECT * FROM student";
        List<Student> list_std = db.getAll(getAll_query, new Student());

        for (Student s : list_std) {
            System.out.println(s);
        }
//
        System.out.println("\n----------<add()>----------\n");

        String add_query = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?)";
        Student std;
        std = new Student(9, "name9", 0, "11-11-2011", "name8@name8.com", "1234567890", "abcxyz");
        List add_condition;
        add_condition = Arrays.asList(
                std.getRollNumber(),
                std.getName(),
                std.getGender(),
                std.getDob(),
                std.getEmail(),
                std.getMobile(),
                std.getAddress(),
                "0"
        );

        System.out.println("add success ? " + db.setSqlRow(add_query, add_condition, std));
//
        System.out.println("----------<update()>----------\n");

        String update_query = "UPDATE student"
                + " SET name = ?"
                + ",gender = ?"
                + ",dob = ?"
                + ",email = ?"
                + ",mobile = ?"
                + ",address = ?"
                + ",status = ?"
                + " WHERE rollNumber = ?";
        Student update_data
                = new Student(1, "NAME01", 0, "22-22-2222", "NAME001@gmail.com", "0123456789", "ABXZYC");
        List update_condition = Arrays.asList(
                update_data.getName(),
                update_data.getGender(),
                update_data.getDob(),
                update_data.getEmail(),
                update_data.getMobile(),
                update_data.getAddress(),
                "0",
                update_data.getRollNumber()
        );

        System.out.println("update success ? " + db.setSqlRow(update_query, update_condition, update_data));
//
        System.out.println("----------<delete()>----------\n");

        String delete_sql = "DELETE FROM student WHERE rollNumber = ?";
        List delete_condition = Arrays.asList(9);
        System.out.println("delete success ? " + db.setSqlRow(delete_sql, delete_condition, new Student()));
    }
}
