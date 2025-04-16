package com.example;

public class MainApps {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student s1 = new Student();
        s1.setName("Alice");
        s1.setAge(21);
        dao.createStudent(s1);

        Student read = dao.readStudent(1);
        System.out.println("Read: " + read.getName());

        read.setAge(22);
        dao.updateStudent(read);

        dao.deleteStudent(1);

        dao.listStudents().forEach(s -> System.out.println(s.getName()));
    }
}
