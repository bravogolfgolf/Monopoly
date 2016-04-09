package main;

import presenters.Presenter;

public interface PresenterFactory {
    Presenter make(String presenter);
}
