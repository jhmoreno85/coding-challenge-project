package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BiggestIsland {

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
                {1, 0, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        BiggestIsland app = new BiggestIsland();
        int result = app.getSizeBiggestIslands(board);
        System.out.println("Biggest Island is: " + result);
    }

    private int getSizeBiggestIslands(int[][] board) {
        boolean[][] visited = new boolean[board.length][board.length];
        int maxSize = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (1 == board[i][j] && !visited[i][j]) {
                    int size = dfs(i, j, board, visited);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    private int dfs(int i, int j, int[][] board, boolean[][] visited) {
        int size = 1;
        visited[i][j] = true;
        Cursor cursor = new Cursor();
        cursor.x = i;
        cursor.y = j;
        Queue<Cursor> q = new LinkedList<>();
        q.add(cursor);
        while (!q.isEmpty()) {
            Cursor currCursor = q.poll();
            // move up
            if (isSafe(currCursor.x, currCursor.y - 1, board, visited)) {
                visited[currCursor.x][currCursor.y - 1] = true;
                Cursor newCursor = new Cursor();
                newCursor.x = currCursor.x;
                newCursor.y = currCursor.y - 1;
                q.add(newCursor);
                size++;
            }
            // move down
            if (isSafe(currCursor.x, currCursor.y + 1, board, visited)) {
                visited[currCursor.x][currCursor.y + 1] = true;
                Cursor newCursor = new Cursor();
                newCursor.x = currCursor.x;
                newCursor.y = currCursor.y + 1;
                q.add(newCursor);
                size++;
            }
            // move left
            if (isSafe(currCursor.x - 1, currCursor.y, board, visited)) {
                visited[currCursor.x - 1][currCursor.y] = true;
                Cursor newCursor = new Cursor();
                newCursor.x = currCursor.x - 1;
                newCursor.y = currCursor.y;
                q.add(newCursor);
                size++;
            }
            // move right
            if (isSafe(currCursor.x + 1, currCursor.y, board, visited)) {
                visited[currCursor.x + 1][currCursor.y] = true;
                Cursor newCursor = new Cursor();
                newCursor.x = currCursor.x + 1;
                newCursor.y = currCursor.y;
                q.add(newCursor);
                size++;
            }
        }
        return size;
    }

    private boolean isSafe(int i, int j, int[][] board, boolean[][] visited) {
        return i >= 0 && i < board.length && j >= 0 && j < board.length && !visited[i][j] && board[i][j] == 1;
    }
}
