import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> run1 = Files.readAllLines(Path.of("run1.log"));
        List<String> run2 = Files.readAllLines(Path.of("run2.log"));

        FlakyDetector flakyDetector = new FlakyDetector();

        List<String> flakyTest = flakyDetector.flaky(run1, run2);
        Map<String, Long> statusSummary = flakyDetector.statusSummary(run2);

        System.out.println("Flaky-кандидаты: " + flakyTest);
        System.out.println("Прогон 2, сводка: " + statusSummary);
    }
}