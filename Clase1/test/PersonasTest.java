import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class PersonasTest
{

    @BeforeEach
    void setUp() {
    }

    @Test
     public void validarPersona(){
        //Arrange
        Persona persona1 = new Persona("Juan",20);
        Persona persona2 = new Persona("Pedro",17);
        Persona persona3 = new Persona("Ana",22);
        Persona persona4 = new Persona("Luz",18);
        Persona persona5 = new Persona("Julian",32);
        Personas personas = new Personas();

        //Act
        personas.setPersona(persona1);
        personas.setPersona(persona2);
        personas.setPersona(persona3);
        personas.setPersona(persona4);
        personas.setPersona(persona5);

        //Assert
        Assertions.assertEquals(2,personas.getListaPersonas().size());

    }

}