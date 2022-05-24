package Review;
import java.util.Date;
import java.util.Objects;
public class Review {

    public static Object services;
    private String username;
        private String text;
        private Date date;

        public Review(String username, String text) {
            this.username = username;
            this.text = text;

        }

        public Review(){

        }

        public String getUsername() {
            return username;
        }

        public String getText() {
            return text;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public void setText(String text) {
            this.text = text;
        }



        }


