package co.devhack.todoapp.helpers;

/**
 * Created by cdcalvo on 2/12/17.
 */

public interface Callback<T> {

    void success(T result);

    void error(Exception error);
}
