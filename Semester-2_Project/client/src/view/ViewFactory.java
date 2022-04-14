package view;

import viewModel.ViewModelFactory;

public class ViewFactory {
    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory){
        this.viewHandler=viewHandler;
        this.viewModelFactory=viewModelFactory;

    }
    // todo, add Region for every view.

}
