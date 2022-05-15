package MenuForm.Food;
import org.dizitart.no2.objects.Id;
public class Food {
    private String name;
    private String ingredients;
    private Integer time;
    private String picture;///retine path-ul pt imagine

    private Double price;

    public Food(String name, String ingredients, Integer time, String picture, Double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.time = time;
        this.picture=picture;
        this.price=price;
    }

    public String getName() {
        return name;
    }
    public String getIngredients() {
        return ingredients;
    }
    public Integer getTime() {return time;}
    public String getPicturePath(){return picture;}

    public Double getPrice(){return price;}
}
