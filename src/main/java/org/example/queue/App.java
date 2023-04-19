package org.example.queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        queue.add("6");
        queue.add("7");
        log.info("peek: {}", queue.peek());
        queue.print();
        log.info("poll: {}", queue.poll());
        queue.print();
    }
}
