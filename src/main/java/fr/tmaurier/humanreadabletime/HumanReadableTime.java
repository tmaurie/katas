package fr.tmaurier.humanreadabletime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanReadableTime {
    public String formatDuration(int seconds) {
        class TimeUnit {
            private final String name;
            private final int value;

            TimeUnit(String name, int value) {
                this.name = name;
                this.value = value;
            }
        }

        if (seconds == 0) {
            return "now";
        }

        List<TimeUnit> time = new ArrayList<>();
        time.add(new TimeUnit("year", seconds / 31536000));
        time.add(new TimeUnit("day", (seconds % 31536000) / 86400));
        time.add(new TimeUnit("hour", ((seconds % 31536000) % 86400) / 3600));
        time.add(new TimeUnit("minute", (((seconds % 31536000) % 86400) % 3600) / 60));
        time.add(new TimeUnit("second", (((seconds % 31536000) % 86400) % 3600) % 60));

        return time.stream()
                .filter(t -> t.value > 0)
                .map(t -> t.value + " " + t.name + (t.value > 1 ? "s" : ""))
                .collect(Collectors.joining(", "))
                .replaceAll(", (?!.+,)", " and ");
    }
}
