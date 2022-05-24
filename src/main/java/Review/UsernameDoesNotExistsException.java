package Review;

import static logIn.services.DBUtils.AlertBox;

public class UsernameDoesNotExistsException extends Exception{

        private String username;

        public UsernameDoesNotExistsException(String username) {
            super(String.format("The name %s does not exist!", username));
            AlertBox("This username is invalid, please try again!");
            this.username = username;
        }

        public String getName() {
            return username;
        }
    }

