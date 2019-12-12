package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;

import java.util.List;

public interface Dictionary {
    void defineWord(String word, String definition) throws AlreadyDefinedException;
    List<String> getDefinitions(String word) throws NotDefinedException;
}