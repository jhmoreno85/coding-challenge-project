package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

@Slf4j
public class RoomMeetingCounter {

    public static void main(String[] args) {
        log.info("{}", roomsMeetingNeeded(new int[][]{{17, 19}, {10, 12}, {10, 13}, {9, 10}, {10, 11}, {13, 16}, {16, 17}, {12, 14}}));
    }

    public static int roomsMeetingNeeded(int[][] intervals) {
        if (null == intervals || 0 == intervals.length) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = q.poll();
            assert prev != null;
            if (prev[1] > curr[0]) {
                q.add(prev);
            }
            q.add(curr);
        }
        return q.size();
    }
}
