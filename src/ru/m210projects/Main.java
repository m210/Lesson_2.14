package ru.m210projects;

public class Main {

    public static void main(String[] args) {
        StringArrayList list = new StringArrayList(5);

        list.add(0, "1Hello");
        list.add(0, "2Hello");
        list.add("Hello1");
        list.add("Hello2");
        list.add("Hello3");
        list.add("Hello4");

        System.out.println("Contains " +  list.contains("Hello2"));
        System.out.println("Size " +  list.size());
        System.out.println("Remove " +  list.remove("2Hello"));
        System.out.println("Set " +  list.set(0, "World"));
        System.out.println("Size " +  list.size());
        list.add("Hello3");
        list.add("Hello3");
        list.add("Hello3");
        list.add("Hello3");
        list.add("End");

        System.out.println(list);
        System.out.println("indexOf " +  list.indexOf("Hello3"));
        System.out.println("lastIndexOf " +  list.lastIndexOf("Hello3"));
        System.out.println("Get " +  list.get(4));

        String[] arr = list.toArray();
        StringArrayList list2 = new StringArrayList(1);
        for(String s : arr) {
            list2.add(0, s);
        }
        System.out.println(list2);

        System.out.println("Equals list2 " + list.equals(list2));

        System.out.println(list2.size());

        StringArrayList list3 = new StringArrayList(0);
        for(String s : arr) {
            list3.add(s);
        }
        System.out.println("Equals list3 " + list.equals(list3));
    }
}
