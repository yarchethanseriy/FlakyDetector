import java.util.*;

public class FlakyDetector {

    public Set<String> failed(List<String> run) {
        Set<String> failed = new HashSet<>();
        for (String s : run) {
            String[] split = s.split("\\|");
            if (split[1].equals("FAILED")) {
                failed.add(split[0]);
            }
        }

        return failed;
    }

    public Set<String> passed(List<String> run) {
        Set<String> passed = new HashSet<>();
        for (String s : run) {
            String[] split = s.split("\\|");
            if (split[1].equals("PASSED")) {
                passed.add(split[0]);
            }
        }

        return passed;
    }

    public List<String> flaky(List<String> run1, List<String> run2) {
        Set<String> failed = failed(run1);
        Set<String> passed = passed(run2);
        List<String> retainedList = new ArrayList<>(passed);
        retainedList.retainAll(failed);

        return retainedList;
    }

    public Map<String, Long> statusSummary(List<String> run) {
        HashMap<String, Long> map = new HashMap<>();

        for (String s : run) {
            String[] split = s.split("\\|");
            String key = split[1];
            map.merge(key, 1L, Long::sum);
        }
        return map;
    }

}
