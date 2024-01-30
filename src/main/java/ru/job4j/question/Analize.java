package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, String> mapPrevious = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user : current) {
            if (!mapPrevious.containsKey(user.getId())) {
                added++;
            }
            if (mapPrevious.containsKey(user.getId())
                    && !user.getName().equals(mapPrevious.get(user.getId()))) {
                changed++;
            }
        }
        int deleted = previous.size() - current.size() + added;
        return new Info(added, changed, deleted);
    }
}
