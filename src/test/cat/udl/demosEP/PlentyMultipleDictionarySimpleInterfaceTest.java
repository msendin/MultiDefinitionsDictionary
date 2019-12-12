package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlentyMultipleDictionarySimpleInterfaceTest implements MultipleDictionarySimpleInterfaceTest, MultipleDictionarySimpleFullInterfaceTest {

    DictionaryImpl dictionary;

    @BeforeEach
    public void setUp() throws AlreadyDefinedException {
        dictionary = new DictionaryImpl();
        dictionary.defineWord("Hardware", "Definición de Hardware");
        dictionary.defineWord("Software", "Definición de Software");
        dictionary.defineWord("Licencia", "Definición 1 de Licencia");
        dictionary.defineWord("Licencia", "Definición 2 de Licencia");
    }

    @Override
    @Test
    public void getInexistentWordTest() {
        Throwable exception = assertThrows(NotDefinedException.class,
                () -> {
                    dictionary.getDefinitions("Middleware");
                });
    }

    @Override
    @Test
    public void defineWordTest() throws AlreadyDefinedException, NotDefinedException {
        List<String> defs = new ArrayList<String>();
        dictionary.defineWord("Sistema Operativo", "Definición de Sistema Operativo");
        defs.add("Definición de Sistema Operativo");
        assertEquals(defs, dictionary.getDefinitions("Sistema Operativo"));
    }

    @Override
    @Test
    public void getExistentWordTest() {
        Throwable exception = assertThrows(AlreadyDefinedException.class,
                () -> {
                    dictionary.defineWord("Hardware", "Definición de Hardware");
                });
    }

    @Override
    @Test
    public void getOneDefinitionTest() throws NotDefinedException {
        List<String> definitions = new ArrayList<>();
        definitions.add("Definición de Hardware");
        assertEquals(definitions, dictionary.getDefinitions("Hardware"));
    }

    @Test
    public void getMoreThanOneDefinitionTest() throws NotDefinedException{
        List<String> definitions = new ArrayList<>();
        definitions.add("Definición 1 de Licencia");
        definitions.add("Definición 2 de Licencia");
        assertEquals(definitions, dictionary.getDefinitions("Licencia"));
    }

    @Test
    void groupedAssertions() {
        assertAll("definiciones de Licencia y más",
                () -> assertEquals("Definición 1 de Licencia", dictionary.getDefinitions("Licencia").get(0)),
                () -> assertEquals("Definición 2 de Licencia", dictionary.getDefinitions("Licencia").get(1)),
                () -> assertThat("comparació valor 8 amb assertThat", 4+4, equalTo(8))
        );
    }
}
