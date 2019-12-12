package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public interface MultipleDictionarySimpleFullInterfaceTest {
    @Test
    void getExistentWordTest();

    @Test
    void getOneDefinitionTest() throws NotDefinedException;
}
