package cat.udl.demosEP.exceptions;

import java.lang.Throwable;

public class AlreadyDefinedException extends Exception{
    public AlreadyDefinedException(String message){
        super(message);
    }
}
