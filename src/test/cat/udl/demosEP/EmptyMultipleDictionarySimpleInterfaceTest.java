package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import cat.udl.demosEP.testInterfaces.MultipleDictionarySimpleInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmptyMultipleDictionarySimpleInterfaceTest implements MultipleDictionarySimpleInterfaceTest {

    private DictionaryImpl dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new DictionaryImpl();
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
                () -> dictionary.getDefinitions("Middleware"));
    }
}
