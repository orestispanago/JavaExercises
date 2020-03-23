package mypackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class PlayWithCollections {

    static List<String> names = new ArrayList();
    static List<Student> students = new ArrayList();

    public static void addNames() {
        names.add("Nick");
        names.add("Jack");
        names.add("Mary");
        names.add("Andy");
    }

    public static void addStudents() {
        students.add(new Student("Nick", 15, 70));
        students.add(new Student("Mary", 18, 85));
        students.add(new Student("Andy", 22, 90));
    }

    public static Collection populateWithNames(Collection collection) {
        for (Object name : names) {
            collection.add(name);
        }
        return collection;
    }

    public static Collection populateWithStudents(Collection collection) {
        for (Student student : students) {
            collection.add(student);
        }
        return collection;
    }

    public static void printCollection(Collection group) {
        for (Object item : group) {
            System.out.print(item + ",");
        }
    }

    public static void playWithNames() {
        ArrayList<String> names = new ArrayList();
        populateWithNames(names);
        printCollection(names);
        LinkedList<String> linkedListNames = new LinkedList();
        populateWithNames(linkedListNames);
        printCollection(linkedListNames);
    }

    public static void playWithLists() {
        List<Student> generalStudents = Student.getLinkedListOfGeneralStudents();
        Student.printListOfStudents(generalStudents, "\n***Printing General Students***");
        List<Student> javaStudents = Student.getListOfJavaStudents(generalStudents);
        Student.printListOfStudents(javaStudents, "\n***Printing Java Students***");
        Student.printListOfStudents(generalStudents, "\n***Printing General Students***");
    }

    public static void playWIthHashSet() {
        Set<String> hashSet = new HashSet();
        populateWithNames(hashSet);
        printCollection(hashSet);
    }

    public static void stringTreeSet() {
        Set<String> treeSet = new TreeSet();
        populateWithNames(treeSet);
        System.out.println("****Printing TreeSet of names****");
        printCollection(treeSet);

    }

    public static void stringHashSet() {
        Set<String> names = new HashSet();
        populateWithNames(names);
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if (name.equals("Nick")) {
                it.remove();
            }
        }
        System.out.println(names);
    }

    public static void intHashSet() {
        Set<Integer> set = new HashSet();
        set.add(4);
        set.add(5);
        set.add(1);
        set.add(0);
        for (int number : set) {
            System.out.print(number + ",");
        }
        set.remove(1);
        System.out.println("Removed 1");
        for (int number : set) {
            System.out.print(number + ",");
        }
    }

    public static void studentArrayList() {
        Student s1 = students.get(0);
        Student s2 = students.get(1);
        List<Student> list = new ArrayList();
        list.add(s1);
        System.out.println("list.contains(s1):" + list.contains(s1));
        System.out.println("list.contains(s2):" + list.contains(s2));
    }

    public static void studentLinkedHashSet() {
        Student s1 = students.get(0);
        Student s2 = students.get(1);
        Set<Student> setOfStudents = new LinkedHashSet();
        System.out.println("s1==s2:" + (s1 == s2));
        System.out.println("s1.equals(s2):" + s1.equals(s2));
        populateWithStudents(setOfStudents);
        printCollection(setOfStudents);
    }

    public static Set<Student> studentTreeSet() {
        Set<Student> treeSetStudents = new TreeSet();
        populateWithStudents(treeSetStudents);
        treeSetStudents.add(new Student("Andy", 18, 85));
        System.out.println("****Printing TreeSet of Students****");
        printCollection(treeSetStudents);
        return treeSetStudents;
    }

    public static void printByName(Set<Student> treeSetStudents) {
        StudentComparatorName myComparator = new StudentComparatorName();
        TreeSet<Student> treeSetStudentByName = new TreeSet(myComparator);
        treeSetStudentByName.addAll(treeSetStudents);
        System.out.println("****Printing TreeSet of Students By Name****");
        printCollection(treeSetStudents);
    }

    public static void playingWithMaps() {
        System.out.println("\n****Playing with Maps*****");
        Map<String, Integer> map = new HashMap();
        map.put("Nick", 80);
        map.put("Mary", 60);
        map.put("Jack", 90);
        map.put("Nick", 90);
        boolean exists = map.containsKey("Mary");
        System.out.println("exists:" + exists);
        map.replace("Mary", 100);
        int grade = map.get("Mary");
        System.out.println("grade:" + grade);
        System.out.println("**Printing Map ****");
        Set<String> keysOfMap = map.keySet();
        for (String key : keysOfMap) {
            int bathmos = map.get(key);
            System.out.println(key + "->" + bathmos);
        }
        System.out.println("****Printing only values***");
        Collection<Integer> values = map.values();
        for (int value : values) {
            System.out.println(value);
        }
        System.out.println("****Printing Map.Entries****");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "--->>>" + entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addNames();
        addStudents();

        playWithNames();
        playWithLists();
        playWIthHashSet();
        stringTreeSet();
        intHashSet();
        studentArrayList();
        studentLinkedHashSet();
        Set<Student> treeSetStudents = studentTreeSet();
        printByName(treeSetStudents);
        playingWithMaps();

    }

}
