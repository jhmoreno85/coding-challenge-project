package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.TRUE;

@Slf4j
public class FindApartment {

    private static final String GYM = "gym";
    private static final String SCHOOL = "school";
    private static final String STORE = "store";

    public static void main(String[] args) {
        FindApartment app = new FindApartment();
        List<String> reqs = List.of(GYM, STORE, SCHOOL);
        List<Map<String, Boolean>> blocks = List.of(
                Map.of(GYM, false, SCHOOL, true, STORE, false),
                Map.of(GYM, true, SCHOOL, false, STORE, false),
                Map.of(GYM, true, SCHOOL, true, STORE, false),
                Map.of(GYM, false, SCHOOL, true, STORE, false),
                Map.of(GYM, false, SCHOOL, true, STORE, true));
        app.solve(blocks, reqs);
    }

    private void solve(List<Map<String, Boolean>> blocks, List<String> reqs) {
        int blockIndex = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.size(); i++) {
            int currMinDist = 0;
            Map<String, Boolean> block = blocks.get(i);
            List<String> missingReqs = new ArrayList<>(reqs);
            missingReqs.removeIf(req -> TRUE.equals(block.get(req)));
            int dist = 1;
            while (!missingReqs.isEmpty()) {
                // left
                if (i - dist >= 0) {
                    Map<String, Boolean> leftBlock = blocks.get(i - dist);
                    missingReqs.removeIf(req -> TRUE.equals(leftBlock.get(req)));
                }
                // right
                if (i + dist < blocks.size()) {
                    Map<String, Boolean> rightBlock = blocks.get(i + dist);
                    missingReqs.removeIf(req -> TRUE.equals(rightBlock.get(req)));
                }
                currMinDist++;
                dist++;
            }
            if (currMinDist < minDist) {
                minDist = currMinDist;
                blockIndex = i;
            }
        }
        log.info("Best apartment location, index={}, dist={}", blockIndex, minDist);
    }
}
