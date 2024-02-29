package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class IslandCounter {

    public static class Cursor {
        int x;
        int y;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        IslandCounter app = new IslandCounter();
        app.countIslands(board);
    }

    public void countIslands(int[][] board) {
        int counter = 0;
        boolean[][] visited = new boolean[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    // dfsRecursive(i, j, board, visited, 1);
                    dfs(i, j, board, visited);
                    counter++;
                }
            }
        }
        log.info("there are {} islands", counter);
    }

    private void dfs(int i, int j, int[][] board, boolean[][] visited) {
        visited[i][j] = true;
        Cursor s = new Cursor();
        s.x = i;
        s.y = j;
        Queue<Cursor> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            Cursor n = q.poll();
            if (isSafe(n.x - 1, n.y, board, visited)) {
                visited[n.x - 1][n.y] = true;
                Cursor newNode = new Cursor();
                newNode.x = n.x - 1;
                newNode.y = n.y;
                q.add(newNode);
            }
            if (isSafe(n.x + 1, n.y, board, visited)) {
                visited[n.x + 1][n.y] = true;
                Cursor newNode = new Cursor();
                newNode.x = n.x + 1;
                newNode.y = n.y;
                q.add(newNode);
            }
            if (isSafe(n.x, n.y - 1, board, visited)) {
                visited[n.x][n.y - 1] = true;
                Cursor newNode = new Cursor();
                newNode.x = n.x;
                newNode.y = n.y - 1;
                q.add(newNode);
            }
            if (isSafe(n.x, n.y + 1, board, visited)) {
                visited[n.x][n.y + 1] = true;
                Cursor newNode = new Cursor();
                newNode.x = n.x;
                newNode.y = n.y + 1;
                q.add(newNode);
            }
        }
    }

    private void dfsRecursive(int i, int j, int[][] board, boolean[][] visited, int size) {
        visited[i][j] = true;
        if (isSafe(i - 1, j, board, visited)) {
            dfsRecursive(i - 1, j, board, visited, size + 1);
        }
        if (isSafe(i + 1, j, board, visited)) {
            dfsRecursive(i + 1, j, board, visited, size + 1);
        }
        if (isSafe(i, j - 1, board, visited)) {
             dfsRecursive(i, j - 1, board, visited, size + 1);
        }
        if (isSafe(i, j + 1, board, visited)) {
            dfsRecursive(i, j + 1, board, visited, size + 1);
        }
    }

    private boolean isSafe(int i, int j, int[][] board, boolean[][] visited) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j] && board[i][j] == 1;
    }
}
