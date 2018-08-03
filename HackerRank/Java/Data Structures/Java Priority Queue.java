import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    String name;
    double cgpa;
    int id;
    
    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCGPA() {
        return this.cgpa;
    }
}
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if(a.getCGPA() > b.getCGPA()) {
            return -1;
        } else if(a.getCGPA() < b.getCGPA()) {
            return 1;
        } else {
           if(a.getName().compareTo(b.getName()) == 0) {
               return a.getID() > b.getID() ? -1 : 1;
           } else {
               return a.getName().compareTo(b.getName());
           }
        } 
    }
}
class Priorities {
    public List<Student> getStudents(List<String> events) {
        
        PriorityQueue<Student> studentList = new PriorityQueue<Student>(events.size(), new StudentComparator());
        List<Student> list = new ArrayList<Student>();
        
        for(int i = 0; i < events.size(); i++) {
            String s[] = events.get(i).split(" ");
            if(s[0].equals("ENTER")) {
               studentList.add(new Student(Integer.parseInt(s[3]), 
                                     s[1], Double.parseDouble(s[2])));
            } else 
                studentList.poll();
        }
        while(!studentList.isEmpty()) {
            list.add(studentList.poll());
        }
        return list;
       
    }
}
