import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ReportLoader {
    public String[] readFile(String path) {
        try {
            String fileContents = Files.readString(Path.of(path));
            String[] lines = fileContents.split("\\n");
            return lines;
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно, файл не находится в нужной директории.");
        }
        return null;
    }
}