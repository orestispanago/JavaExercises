package mypackage;

import java.util.Comparator;

public class StudentComparatorName implements Comparator<Student>{
    
    public StudentComparatorName(){
        
    }
    
    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getName().compareTo(o2.getName());
        if(result == 0){
            result = o1.getAge() - o2.getAge();
        }
        if(result == 0){
            result = o1.getGrade() - o2.getGrade();
        }
        return result;
    }
    
}
