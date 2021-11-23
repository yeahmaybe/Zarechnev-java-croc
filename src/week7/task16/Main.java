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
        Map<Integer, HashSet<String>> persons = new TreeMap<>();

        while(!person.equals("END")) {

            String name = person.split(",")[0];
            int age = Integer.parseInt(person.split(",")[1]);

            if(!persons.containsKey(123-age)) {
                persons.put(123-age, new HashSet<>());
            }
            persons.get(123-age).add(name);

            person = scan.nextLine();
        }

        Iterator<Map.Entry<Integer, HashSet<String>>> aging = persons.entrySet().iterator();
        Integer counter = ages.size()-1; //индекс нижней границы текущей группы

        while(aging.hasNext()) {
            Map.Entry<Integer, HashSet<String>> next = aging.next();
            int age = 123-next.getKey();
            HashSet<String> names = next.getValue();

            while(counter > 0 && ages.get(counter) >= age) {
                counter--;
            }

            if(counter == ages.size()-1) {
                for(String name: names) {
                    System.out.println(
                            Integer.toString(ages.get(counter)+1) +
                            "+: " +
                            name + "(" + age + ")"
                    );
                }
            }
            else {
                for (String name : names) {
                    System.out.println(
                            Integer.toString(ages.get(counter)+1) +
                            "-" +
                            Integer.toString(ages.get(counter+1)) +
                            ": " +
                            name + "(" + age + ")"
                    );
                }
            }
        }
    }
}
