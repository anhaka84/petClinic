package DB.core;

import java.util.Arrays;
import java.util.List;

public class DemoDB {

    public static void main(String[] args) {

        DB<Student> db = new DB<>();

        /**
         * method getOne(query, condition, classObject) must use
         * setResultSetValue(classObject, resultSet) to set the return data
         */
        System.out.println("---------<getOne()>---------\n");
        System.out.println("-----<Example>-----\n");

        String getOne_sql = "SELECT * FROM student WHERE rollNumber = ?";

        List getOne_condition = Arrays.asList(1); // nhap vao rollNumber va nhung dieu kien khac 

        System.out.println(db.getOne(getOne_sql, getOne_condition, new Student()));

        System.out.println("\n-----<End Example>-----\n");

        /**
         * method getAll(query, classObject) must use
         * setResultSetValue(classObject, resultSet) to set the return data
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

        String add_sql = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?)";

        //way 1
        /**
         * method add(query, classObject) must use
         * setPreparedStatementValue(classObject, PreparedStatement) to set data
         */
        System.out.println("-----<Way 1>-----\n");

        Student new_std;
        new_std = new Student(9, "name9", 0, "11-11-2011", "name8@name8.com", "1234567890", "abcxyz");

        System.out.println("add success ? " + db.add(add_sql, new_std));

        //way 2
        /**
         * method add(query, classObject) must use
         * setPreparedStatementValue(classObject, PreparedStatement) to set data
         */
        System.out.println("\n-----<Way 2>-----\n");

        List add_condition;

        //way 1 (offer)
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

        System.out.println("add success ? " + db.add(add_sql, add_condition, new_std));

        //way 2
        System.out.println("\n-----<Way 2.2>-----\n");

        add_condition = new Student().setPreparedStatementValue(new_std);

        System.out.println("add success ? " + db.add(add_sql, add_condition, new_std));

        System.out.println("\n-----<End Example>-----\n");

        /**
         * method update()
         */
        //@@update(query, condition, classObject) is equal to add(query, condition, classObject)@@
        System.out.println("----------<update()>----------\n");
        System.out.println("-----<Example>-----\n");

        String update_sql = "UPDATE student"
                + " SET name = ?"
                + ",gender = ?"
                + ",dob = ?"
                + ",email = ?"
                + ",mobile = ?"
                + ",address = ?"
                + ",status = ?"
                + " WHERE rollNumber = ?";

        Student update_std
                = new Student(1, "NAME01", 0, "22-22-2222", "NAME001@gmail.com", "0123456789", "ABXZYC");

        List update_condition = Arrays.asList(
                update_std.getName(),
                update_std.getGender(),
                update_std.getDob(),
                update_std.getEmail(),
                update_std.getMobile(),
                update_std.getAddress(),
                "0",
                update_std.getRollNumber()
        );

        System.out.println("update success ? " + db.update(update_sql, update_condition, update_std));

        System.out.println("update success ? " + db.add(update_sql, update_condition, update_std));

        System.out.println("\n-----<End Example>-----\n");

        /**
         * method delete()
         */
        System.out.println("----------<delete()>----------\n");
        System.out.println("-----<Example>-----\n");

        String delete_sql = "DELETE FROM student WHERE rollNumber = ?";

        List delete_condition = Arrays.asList(9);

        System.out.println("delete success ? " + db.delete(delete_sql, delete_condition, new Student()));

        System.out.println("\n-----<End Example>-----\n");
    }
}
