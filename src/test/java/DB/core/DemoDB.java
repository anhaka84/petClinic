package DB.core;

import java.util.Arrays;
import java.util.List;

public class DemoDB {

    public static void main(String[] args) {

        DB<Student> db = new DB<>();

        /**
         * method getOne()
         */
        System.out.println("---------<getOne()>---------\n");
        System.out.println("-----<Example>-----\n");

        String getOne_sql = "SELECT * FROM student WHERE rollNumber = ?";

        List getOne_condition = Arrays.asList(1); // nhap vao rollNumber va nhung dieu kien khac 

        System.out.println(db.getOne(getOne_sql, getOne_condition, new Student()));

        System.out.println("\n-----<End Example>-----\n");

        /**
         * method getAll()
         */
        System.out.println("----------<getAll()>----------\n");
        System.out.println("-----<Example>-----\n");

        String getAll_sql = "SELECT * FROM student";

        List<Student> list_std = db.getAll(getAll_sql, new Student());

        for (Student s : list_std) {
            System.out.println(s);
        }

        System.out.println("\n-----<End Example>-----\n");

        /**
         * method add()
         */
        System.out.println("----------<add()>----------\n");
        System.out.println("-----<Example>-----\n");

        //way 1
        System.out.println("-----<Way 1>-----\n");

        String add_sql = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?)";

        Student new_std;
        new_std = new Student(9, "name9", 0, "11-11-2011", "name8@name8.com", "1234567890", "abcxyz");

        System.out.println(db.add(add_sql, new_std));

        //way 2
        System.out.println("\n-----<Way 2>-----\n");

        List add_condition;

        //way 1
        System.out.println("-----<Way 2.1>-----\n");

        add_condition = Arrays.asList(
                new_std.getRollNumber(),
                new_std.getName(),
                new_std.getGender(),
                new_std.getDob(),
                new_std.getEmail(),
                new_std.getMobile(),
                new_std.getAddress(),
                "0"
        );

        System.out.println(db.add(add_sql, add_condition, new_std));

        //way 2
        System.out.println("\n-----<Way 2.2>-----\n");

        add_condition = new Student().setPreparedStatementValue(new_std);

        System.out.println(db.add(add_sql, add_condition, new_std));

        System.out.println("\n-----<End Example>-----\n");

        /**
         * method update()
         */
        /**
         * method delete()
         */
    }
}
