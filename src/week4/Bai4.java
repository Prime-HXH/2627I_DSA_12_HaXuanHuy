package week4;

import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + cgpa;
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student x, Student y) {

        int result = Double.compare(y.getCgpa(), x.getCgpa());

        if (result != 0) {
            return result;
        }


        result = x.getName().compareTo(y.getName());

        if (result != 0) {
            return result;
        }

        return Integer.compare(x.getId(), y.getId());
    }
}


public class Bai4 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            studentList.add(new Student(id, name, cgpa));
        }

        Collections.sort(studentList, new StudentComparator());

        for (Student student : studentList) {
            System.out.println(student);
        }

        sc.close();
    }
}
