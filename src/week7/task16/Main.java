 package week7.task16;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //String[] _args = {"18", "25", "35", "45", "60", "80", "100"};
        String[] _args = args;
        ArrayList<Integer> ages = new ArrayList<>();

        //представляем возрасты в интеджеры
        ages.add(0);
        for(String age: _args) {
            ages.add(Integer.parseInt(age));
        }

        Scanner scan = new Scanner(System.in);
        String person = scan.nextLine();
        Map<Integer, TreeSet<String>> persons = new TreeMap<>();

        while(!person.equals("END")) {

            String name = person.split(",")[0];
            int age = Integer.parseInt(person.split(",")[1]);

            if(!persons.containsKey(123-age)) {
                persons.put(123-age, new TreeSet<>());
            }
            persons.get(123-age).add(name);

            person = scan.nextLine();
        }

        Iterator<Map.Entry<Integer, TreeSet<String>>> aging = persons.entrySet().iterator();
        Integer counter = ages.size()-1; //индекс нижней границы текущей группы

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i< ages.size(); i++) {
           list.add(new ArrayList<Integer>());
        }

        while(aging.hasNext()) {
            Map.Entry<Integer, TreeSet<String>> next = aging.next();
            boolean changed = false;
            for(int i=0; i<ages.size()-1; i++) {
                if(123-next.getKey() > ages.get(i) && 123-next.getKey() <= ages.get(i+1)) {
                    list.get(ages.size()-1-i).add(123-next.getKey());
                    changed = true;
                }
            }
            if(!changed) list.get(0).add(123-next.getKey());
        }

        for(int i=0; i < list.size(); i++) {
            if(list.get(i).size() > 0) {
                if (i > 0)
                    System.out.print('\n' + "" + (ages.get(list.size() - 1 - i) + 1) + "-" + ages.get(list.size() - i) + ": ");
                else if (i == 0) {
                    System.out.print("\n"+(ages.get(list.size() - i -1) + 1) + "+: ");
                }
            }


            for(Integer age: list.get(i)) {
                for(String human: persons.get(123-age))
                System.out.print(human + " (" + age + "), ");
            }
        }
    }
}
