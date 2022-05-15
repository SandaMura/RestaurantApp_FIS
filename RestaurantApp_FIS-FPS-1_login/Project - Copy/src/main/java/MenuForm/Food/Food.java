package MenuForm.Food;
import org.dizitart.no2.objects.Id;
public class Food {
    private String name;
    private String ingredients;
    private Integer time;
    private String picture;///retine path-ul pt imagine



    public Food(String name, String ingredients, Integer time, String picture) {
        this.name = name;
        this.ingredients = ingredients;
        this.time = time;
        this.picture=picture;
    }

    public String getName() {
        return name;
    }
    public String getIngredients() {
        return ingredients;
    }
    public Integer getTime() {return time;}
    public String getPicturePath(){return picture;}
}
