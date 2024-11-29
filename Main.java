import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String basePath = "/Users/victoriakonshina/Games";
        StringBuilder log = new StringBuilder();

        createDirectory(basePath + "/src", log);
        createDirectory(basePath + "/res", log);
        createDirectory(basePath + "/savegames", log);
        createDirectory(basePath + "/temp", log);
        createDirectory(basePath + "/src/main", log);
        createDirectory(basePath + "/src/test", log);
        createFile(basePath + "/src/main/Main.java", log);
        createFile(basePath + "/src/main/Utils.java", log);
        createDirectory(basePath + "/res/drawables", log);
        createDirectory(basePath + "/res/vectors", log);
        createDirectory(basePath + "/res/icons", log);
        createFile(basePath + "/temp/temp.txt", log);

        try (FileWriter writer = new FileWriter(basePath + "/temp/temp.txt")) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога: " + e.getMessage());
        }
    }

    private static void createDirectory(String path, StringBuilder log) {
        File dir = new File(path);
        if (dir.mkdir()) {
            log.append("Директория создана: ").append(path).append("\n");
        } else {
            log.append("Не удалось создать директорию: ").append(path).append("\n");
        }
    }

    private static void createFile(String path, StringBuilder log) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("Файл создан: ").append(path).append("\n");
            } else {
                log.append("Не удалось создать файл: ").append(path).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла: ").append(path)
                    .append(" - ").append(e.getMessage()).append("\n");
        }
    }
}
