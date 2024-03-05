package org.example;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class ServerLogs {

    private static final String EVENT_ERROR = "error";

    public static void main(String[] args) {
        ServerLogs app = new ServerLogs();
        int counter = app.failureCounter(List.of(
                "s1 sucess",
                "s1 sucess",
                "s2 sucess",
                "s1 error",
                "s1 error",
                "s2 error",
                "s2 sucess",
                "s2 error",
                "s2 error",
                "s3 error"));
        System.out.println("failureCounter: " + counter);
    }

    private int failureCounter(List<String> logs) {
        if (null == logs || logs.isEmpty()) {
            return 0;
        }
        return (int) logs.stream()
                .map(Log::new)
                .filter(log -> EVENT_ERROR.equals(log.getEvent()))
                .collect(Collectors.groupingBy(Log::getServerId, Collectors.mapping(Log::getEvent, Collectors.toList())))
                .values().stream()
                .filter(events -> events.size() >= 3)
                .count();
    }

    @Data
    private static class Log {

        private static final String SPACE = " ";

        private String serverId;
        private String event;

        public Log(String s) {
            String[] strLog = s.split(SPACE);
            this.serverId = strLog[0];
            this.event = strLog[1];
        }
    }
}
