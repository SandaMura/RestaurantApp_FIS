package Review.services;
import java.nio.file.Paths;

import java.nio.file.Path;





public class FileSystemService{
    private static final String APPLICATION_FOLDER =  "database";
    private static final String REVIEW_FOLDER ="" ;
    public static final Path APPLICATION_HOME_PATH = Paths.get(REVIEW_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
}




