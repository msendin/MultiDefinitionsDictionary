package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cat.udl.demosEP.exceptions.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OneWordMultipleDictionarySimpleInterfaceTest implements MultipleDictionarySimpleInterfaceTest, MultipleDictionarySimpleFullInterfaceTest {

    private DictionaryImpl dictionary;

    @BeforeEach
    void setUp() throws AlreadyDefinedException {
        dictionary = new DictionaryImpl();
        dictionary.defineWord("Hardware", "Definición de Hardware");
    }


    @Override
    @Test
    public void getExistentWordTest() {
        Throwable exception = assertThrows(AlreadyDefinedException.class,
                () -> dictionary.defineWord("Hardware", "Definición de Hardware"));
    }

    @Override
    @Test
    public void defineWordTest() throws AlreadyDefinedException, NotDefinedException {
        List<String> defs = new ArrayList<>();
        dictionary.defineWord("Sistema Operativo", "Definición de Sistema Operativo");
        defs.add("Definición de Sistema Operativo");
        assertEquals(defs, dictionary.getDefinitions("Sistema Operativo"));
    }

    @Override
    @Test
    public void getInexistentWordTest() {
        Throwable exception = assertThrows(NotDefinedException.class,
                () -> dictionary.getDefinitions("Framework"));
    }

    @Override
    @Test
    public void getOneDefinitionTest() throws NotDefinedException {
        List<String> definitions = new ArrayList<>();
        definitions.add("Definición de Hardware");
        assertEquals(definitions, dictionary.getDefinitions("Hardware"));
    }
}
