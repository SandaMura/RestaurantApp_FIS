package Review.services;
import java.nio.file.Path;
import java.nio.file.Paths;

import static logIn.services.FileSystemService.USER_FOLDER;

public class FileSystemService1 {
    private static final String APPLICATION_FOLDER =  "database";
    private static final String REVIEW_FOLDER ="" ;
    public static final Path APPLICATION_HOME_PATH = Paths.get(REVIEW_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile2(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
}


