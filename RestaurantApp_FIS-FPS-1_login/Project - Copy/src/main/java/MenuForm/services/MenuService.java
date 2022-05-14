package MenuForm.services;

//import logIn.exceptions.UsernameAlreadyExistsException;
//import logIn.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
//import logIn.exceptions.UsernameAlreadyExistsException;
import MenuForm.Food.Food;
import MenuForm.exceptions.foodAlreadyExistsException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static MenuForm.services.FileSystemService.getPathToFile;

public class MenuService {

    private static ObjectRepository<Food> foodRepository;

    public static void initDatabase() {


        Nitrite database2 = Nitrite.builder()
                .filePath(MenuForm.services.FileSystemService.getPathToFile("Food-database.db").toFile())
                .openOrCreate("test", "test");



        foodRepository = database2.getRepository(Food.class);



    }

    public static void addFood(String name, String ingredients, Integer time, String picturePath) throws foodAlreadyExistsException{

        foodRepository.insert(new Food(name, ingredients, time, picturePath));
    }

    private static void checkFoodDoesNotAlreadyExist(String name) throws foodAlreadyExistsException {

        for (Food food : foodRepository.find()) {
            //System.out.println("MURARARARAR2");
            if (Objects.equals(name, food.getName()))
                throw new foodAlreadyExistsException(name);
        }
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

}
