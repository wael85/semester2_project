package view.mainMenu;

import javafx.event.ActionEvent;
import view.ViewHandler;
import viewModel.ViewModelFactory;


    public class MainMenuController {
        private ViewHandler viewHandler;

        public void toMangeUsers(ActionEvent actionEvent) {
            viewHandler.openTabPaneManageUser();
        }

        public void toMangeRooms(ActionEvent actionEvent) {
            viewHandler.openManageRoom();
        }

        public void logout(ActionEvent actionEvent) {
            viewHandler.getCurrentUser().setCurrentUser(null);
            viewHandler.openLogin();
        }

        public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) {
            this.viewHandler=viewHandler;
        }
    }

