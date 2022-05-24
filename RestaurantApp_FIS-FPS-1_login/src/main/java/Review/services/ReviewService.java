package Review.services;


import Review.Review;
import Review.exception.UsernameDoesNotExistsException;
import logIn.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.Objects;

import static Review.services.FileSystemService.getPathToFile;
import static logIn.services.UserService.userRepository;

public class ReviewService {
   public static ObjectRepository<Review> reviewRepository;
    public static void initDatabase() {
        Nitrite database3 = Nitrite.builder()
                .filePath(getPathToFile("Review-database.db").toFile())
                .openOrCreate("test", "test");
        reviewRepository = database3.getRepository(Review.class);
    }
   public static void addReview(String username, String text) throws UsernameDoesNotExistsException {

        reviewRepository.insert(new Review(username, text));
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
    public static Cursor<Review> getAllReview(){
        return reviewRepository.find();
    }


}

