package user_state;

import users_model.User;

public  class UserState {
    private User currentUser;

    public UserState(){
        currentUser = null;
    }

    public  User getCurrentUser() {
        return currentUser;
    }

    public  void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
