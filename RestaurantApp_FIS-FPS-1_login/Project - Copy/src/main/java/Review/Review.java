package Review;
import java.util.Date;
import java.util.Objects;
public class Review {

        private String username;
        private String text;
        private Date date;

        public Review(String username, String text, Date date) {
            this.username = username;
            this.text = text;
            this.date = date;
        }

        public Review(){

        }

        public String getUsername() {
            return username;
        }

        public String getText() {
            return text;
        }

        public Date getDate() {
            return date;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        }

