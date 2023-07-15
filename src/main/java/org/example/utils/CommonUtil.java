package org.example.utils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CommonUtil {

    private static final String DOT_REGEX = "\\.";
    private static final String REGEX_ARRAY_BRACKETS = "^\\[\\d+]?";

    private CommonUtil() {
        throw new IllegalStateException("CommonUtil class");
    }

    public static <T> Optional<T> getObjFromMap(Map<String, Object> map, String targetPath, Class<T> clazz) {
        if (null == targetPath || targetPath.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(clazz.cast(getObjFromMap(map, targetPath.split(DOT_REGEX), 0)));
    }

    @SuppressWarnings("unchecked")
    private static Object getObjFromMap(Object object, String[] targetPath, int currIndex) {
        if (object instanceof Map) {
            if (((Map<String, Object>) object).containsKey(targetPath[currIndex])) {
                return currIndex == targetPath.length - 1 ?
                        ((Map<String, Object>) object).get(targetPath[currIndex]) :
                        getObjFromMap(((Map<String, Object>) object).get(targetPath[currIndex]), targetPath, currIndex + 1);
            }
        } else if (object instanceof List && targetPath[currIndex].matches(REGEX_ARRAY_BRACKETS)) {
            int elementIndex = Integer.parseInt(targetPath[currIndex].substring(1, targetPath[currIndex].length() - 1));
            if (elementIndex < ((List<Object>) object).size()) {
                return currIndex == targetPath.length - 1 ?
                        ((List<Object>) object).get(elementIndex) :
                        getObjFromMap(((List<Object>) object).get(elementIndex), targetPath, currIndex + 1);
            }
        }
        return null;
    }
}
