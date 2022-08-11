package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class SnakeLadders {

    public static class Node {
        int pos;
        int dist;

        public Node(int pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[] board = new int[100];
        // ladders
        board[10] = 10;
        board[30] = 10;
        board[50] = 10;
        board[70] = 10;
        // snakes
        board[15] = -10;
        board[35] = -10;
        board[55] = -10;
        board[75] = -10;
        board[95] = -10;

        SnakeLadders app = new SnakeLadders();
        log.info("{}", app.minDiceThrows(board));
    }

    public int minDiceThrows(int[] board) {
        boolean[] visited = new boolean[board.length];
        visited[0] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.pos == board.length - 1) {
                return node.dist;
            }
            for (int i = 1; i <= 6; i++) {
                if (node.pos + i < board.length && !visited[node.pos + i] && board[node.pos + i] >= 0) {
                    int position = node.pos + i + board[node.pos + i];
                    q.add(new Node(position, node.dist + 1));
                    visited[node.pos + i] = true;
                    if (board[node.pos + i] > 0) {
                        visited[node.pos + i + board[node.pos + i]] = true;
                    }
                }
            }
        }
        return -1;
    }
}
