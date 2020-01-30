package com.epam.task_6;

public interface Deque {
    int MIN_SIZE = 16;

    void add(Object t);

    void addFirst(Object t);

    void addLast(Object t);

    Object getFirst();

    Object getLast();

    void remove();

    void removeFirst();

    void removeLast();

    int size();
}
