package org.example;

public class PosterManager {
    private String[] films = new String[0];
    private int limit;

    // Конструктор по умолчанию
    public PosterManager() {
        this.limit = 5;
    }

    // Конструктор с пользовательским лимитом
    public PosterManager(int limit) {
        this.limit = limit;
    }

    public void add(String film) {
        String[] tmp = new String[films.length + 1];
        System.arraycopy(films, 0, tmp, 0, films.length);
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength = Math.min(films.length, limit);
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}
