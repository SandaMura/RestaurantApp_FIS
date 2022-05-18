package MenuForm.services;

//import logIn.exceptions.UsernameAlreadyExistsException;
//import logIn.model.User;
import MenuForm.exceptions.WrongFoodException;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
//import logIn.exceptions.UsernameAlreadyExistsException;
import MenuForm.Food.Food;
import MenuForm.exceptions.foodAlreadyExistsException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;




import static MenuForm.services.FileSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class MenuService {

    public static ObjectRepository<Food> foodRepository;


    public static void initDatabase() {


        Nitrite database2 = Nitrite.builder()
                .filePath(MenuForm.services.FileSystemService.getPathToFile("Food-database.db").toFile())
                .openOrCreate("test", "test");



        foodRepository = database2.getRepository(Food.class);



    }


    public static void addFood(String name, String ingredients, Integer time, String picturePath, Double price) throws foodAlreadyExistsException{

        foodRepository.insert(new Food(name, ingredients, time, picturePath, price));
    }
    public static Food checkDelete(String name) throws WrongFoodException {
        Food fFound = null;
        for (Food f : foodRepository.find()) {
            if (Objects.equals(name, f.getName())) {
                fFound = f;
                foodRepository.remove(fFound);
            }
        }
        if (fFound == null)
            throw new WrongFoodException(name);
        return fFound;
    }


    public static  void UpdateTime(String name, Integer time){
        for (Food f : foodRepository.find()){
            if(name.equals(f.getName()))
                f.setTime(time);
        }
    }
    private static void checkFoodDoesNotAlreadyExist(String name) throws foodAlreadyExistsException {

        for (Food food : foodRepository.find()) {
            //System.out.println("MURARARARAR2");
            if (Objects.equals(name, food.getName()))
                throw new foodAlreadyExistsException(name);
        }
    }

    public static Cursor<Food> getAllFood(){
        return foodRepository.find();
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
