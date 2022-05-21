package MenuForm.Food;
import javafx.scene.control.CheckBox;
import org.dizitart.no2.objects.Id;
public class Food {
    @Id
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

    public Food(){}
    public String getName() {
        return name;
    }
    public String getIngredients() {
        return ingredients;
    }
    public Integer getTime() {return time;}
    public String getPicturePath(){return picture;}

    public Integer setTime(Integer time) {
        this.time = time;
        return time;
    }

    public Double getPrice(){return price;}

    public void setName(String name) {
        this.name=name;
    }

    public void setIngredients(String ingredients) {
        this.ingredients=ingredients;
    }

    public void setPrice(Double price) {
        this.price=price;
    }

    public void setPicture(String pictureh) {
        this.picture=picture;
    }
}