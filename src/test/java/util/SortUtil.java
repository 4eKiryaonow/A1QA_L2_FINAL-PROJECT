package util;

import lombok.experimental.UtilityClass;
import model.TestModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SortUtil {
    public static List<TestModel> sortTestList(List<TestModel> testModelList) {
        return testModelList
                .stream()
                .sorted(Comparator.comparing(TestModel::getStartTime).reversed())
                .collect(Collectors.toList());
    }
}