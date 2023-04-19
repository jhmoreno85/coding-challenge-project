package org.example.stack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        stack.print();

        log.info("peek: {}", stack.peek());
        log.info("pop: {}", stack.pop());
        log.info("size: {}", stack.size());
        log.info("pop: {}", stack.pop());
        log.info("size: {}", stack.size());
        log.info("pop: {}", stack.pop());
        log.info("size: {}", stack.size());
        log.info("pop: {}", stack.pop());
        log.info("size: {}", stack.size());
        log.info("pop: {}", stack.pop());
        log.info("size: {}", stack.size());
        log.info("pop: {}", stack.pop());
        log.info("size: {}", stack.size());
        log.info("pop: {}", stack.pop());
        log.info("size: {}", stack.size());
    }
}
