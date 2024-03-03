package org.example;

import org.example.queue.Queue;

public class MazeScape {

    private static final int MAZE_WALL = 1;
    private static final int MAZE_ENTRY = 2;
    private static final int MAZE_EXIT = 3;
    private static final int[][] DIRECTIONS = {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};

    public static void main(String[] args) {
        int[][] board = {
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 2, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 0, 0, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 0, 3 },
                { 1, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        };
        MazeScape app = new MazeScape();
        int minDist = app.getMinDist(board);
        System.out.println("Min distance to scape is: " + minDist);
    }

    private int getMinDist(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length]; // could be a Set also
        // find maze entry
        Node start = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == MAZE_ENTRY) {
                    visited[i][j] = true;
                    start = new Node(i, j, 0);
                    break;
                }
            }
        }
        if (null == start) {
            throw new IllegalStateException("There is no maze entry");
        }

        Queue<Node> q = new Queue<>();
        q.add(start);
        while (!q.isEmpty()) {
            Node currNode = q.poll();
            if (MAZE_EXIT == board[currNode.x][currNode.y]) {
                return currNode.dist;
            }
            for (int[] direction : DIRECTIONS) {
                int newX = currNode.x + direction[0];
                int newY = currNode.y + direction[1];
                if (isSafe(newX, newY, board, visited)) {
                    q.add(new Node(newX, newY, currNode.dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }

    private boolean isSafe(int x, int y, int[][] board, boolean[][] visited) {
        return x >= 0 &&
                x < board.length &&
                y >= 0 &&
                y < board[0].length &&
                board[x][y] != MAZE_WALL &&
                !visited[x][y];
    }

    private static class Node {
        int dist;
        int x;
        int y;

        public Node(int x, int y, int dist) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
}
