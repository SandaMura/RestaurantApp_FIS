package MenuForm.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    private static final String APPLICATION_FOLDER = "database";
    private static final String FOOD_FOLDER = "";
    public static final Path APPLICATION_HOME_PATH = Paths.get(FOOD_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {


        System.out.println("DEBUG: Urmeaza sa path-ul bazei de date: ");
        return APPLICATION_HOME_PATH.resolve(Paths.get("", path));


    }

    public static Path getApplicationHomeFolder() {
        return Paths.get(FOOD_FOLDER, APPLICATION_FOLDER);
    }

    public static void initDirectory() {
        Path applicationHomePath = getApplicationHomeFolder();
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
}