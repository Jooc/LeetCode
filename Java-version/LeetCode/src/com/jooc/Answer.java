package com.jooc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Answer {
    public static void main(String[] args) {
    }

    int[][] grid;

    public boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public int minimumTime(int[][] grid) {
        this.grid = grid;
        int[][] dirs = new int[][]{
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1}
        };
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        PriorityQueue<Event> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.time));
        pq.add(new Event(0, 0, 0));
        int[][] time = new int[grid.length][grid[0].length];
        int inf = (int) 1e9;
        for (int[] t : time) {
            Arrays.fill(t, inf);
        }

        while (!pq.isEmpty()) {
            var head = pq.remove();
            if (time[head.x][head.y] <= head.time) {
                continue;
            }
            time[head.x][head.y] = head.time;
            for (int[] d : dirs) {
                int x = head.x + d[0];
                int y = head.y + d[1];
                if (!check(x, y)) {
                    continue;
                }
                pq.add(new Event(x, y, Math.max(head.time + 1, grid[x][y] + (grid[x][y] % 2 != (x + y) % 2 ? 1 : 0))));
            }
        }

        return time[grid.length - 1][grid[0].length - 1];
    }
}

class Event {
    int x;
    int y;
    int time;

    public Event(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}


