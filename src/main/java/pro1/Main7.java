package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Deadline;
import pro1.apiDataModel.DeadlinesList;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main7 {
    public static String specializationDeadlines(int year) {
        String json = Api.getSpecializations(year);
        DeadlinesList list = new Gson().fromJson(json, DeadlinesList.class);

        return list.items.stream()
                .filter(d -> d.deadline != null && d.deadline.value != null)
                .map(d -> d.deadline.value)
                .distinct()
                .sorted(Comparator.comparing((String t) -> {
                    String[] parts = t.split("\\.");
                    return Integer.parseInt(parts[2]) * 10000 +
                            Integer.parseInt(parts[1]) * 100 +
                            Integer.parseInt(parts[0]);
                }))
                .collect(Collectors.joining(","));
    }
}


