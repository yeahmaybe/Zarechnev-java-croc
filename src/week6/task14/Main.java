package week6.task14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        // Количество просмотров подсчитывается только по избранным в пункте 1 историям

        String filmsList = "films.txt";
        String historyList = "history.txt";
        int filmsNum = 0;

        Scanner scan = new Scanner(System.in);
        String history = scan.nextLine();

        List<String> list = List.of(history.split(","));
        Set<String> historySet = new HashSet<String>(list);
        filmsNum = historySet.size();


        Map<Integer, Integer> views = new TreeMap<Integer, Integer>();

        //получаем коллекцию Map фильмов, которые пользователь не смотрел
        try (BufferedReader read = new BufferedReader(new FileReader(historyList))) {

            String line = read.readLine();

            while (line != null) {
                //все просмотренные человеком X фильмы
                List<String> allWatched = Arrays.stream(line.split(","))
                        .collect(Collectors.toList());

                //смотрим, какие фильмы Пользователь уже посмотрел
                List<String> alreadyWatched = allWatched.stream()
                        .filter(historySet::contains)
                        .collect(Collectors.toList());

                Set<String> currentHistorySet = new HashSet<String>(alreadyWatched);

                //должна быть хотя бы половина
                if (filmsNum / 2 + filmsNum%2 > currentHistorySet.size()) {
                    line = read.readLine();
                    continue;
                }

                //все просмотренные человеком X фильмы, которые Пользователь не видел
                List<String> newWatched = allWatched.stream()
                        .filter(film -> !list.contains(film))
                        .collect(Collectors.toList());

                //подсчитываем просмотры этих фильмов на данный момент
                for (String film : newWatched) {
                    int filmNum = Integer.parseInt(film);
                    if (views.containsKey(filmNum)) {
                        views.put(filmNum, views.get(filmNum) + 1);
                    } else {
                        views.put(filmNum, 1);
                    }
                }

                line = read.readLine();
            }
        }

        int topViews = 0;
        int recomendation = 0;

        //ищем максимальное количество просмотров и фильмы с этим количеством
        Iterator<Map.Entry<Integer, Integer>> film = views.entrySet().iterator();
        while (film.hasNext()) {

            int nextFilmNum = film.next().getKey();
            int nextFilmViews = views.get(nextFilmNum);

            if (nextFilmViews > topViews) {
                topViews = nextFilmViews;
                recomendation = nextFilmNum;
            }
        }

        //расшифровываем номера фильмов из файла
        String offer = new String();
        try (BufferedReader read = new BufferedReader(new FileReader(filmsList))) {
            String line = read.readLine();
            while (line != null) {
                if (recomendation == Integer.parseInt(line.split(",")[0])) {
                    offer = line.split(",")[1];
                }
                line = read.readLine();
            }
        }
        System.out.println(offer);
    }
}
