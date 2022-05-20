package Review.services;

import MenuForm.Food.Food;
import MenuForm.exceptions.WrongFoodException;
import Review.Review;
import Review.UsernameDoesNotExistsException;
import jdk.jfr.internal.Repository;
import logIn.exceptions.UsernameAlreadyExistsException;
import logIn.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.Objects;

import static Review.services.FileSystemService1.getPathToFile2;
import static logIn.services.DBUtils.AlertBox;
import static logIn.services.FileSystemService.getPathToFile;
import static logIn.services.UserService.userRepository;

public class ReviewService {
    public static ObjectRepository<Review> reviewRepository;
    public static void initDatabase() {
        Nitrite database3 = Nitrite.builder()
                .filePath(getPathToFile2("Review-database.db").toFile())
                .openOrCreate("test", "test");

        reviewRepository = database3.getRepository(Review.class);
    }


    public static void checkUsername(String username) throws UsernameDoesNotExistsException {
        int exist = 0;
        for (User user : userRepository.find()) {

            if (Objects.equals(username, user.getUsername()))
                exist = 1;
        }
            if (exist == 0)
                throw new UsernameDoesNotExistsException(username);
        }


}

