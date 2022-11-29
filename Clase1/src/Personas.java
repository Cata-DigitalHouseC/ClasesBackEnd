import java.util.ArrayList;
import java.util.List;

public class Personas {

    private List<Persona> listaPersonas = new ArrayList<>();


    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void setPersona(Persona persona){
        //Mayo a 18
        //nombre 5 letras o mas
        //Solo sean letras
        if(persona.getEdad()>=18 && persona.getNombre().length()>4 && persona.getNombre().matches("[a-zA-Z]+")){
            listaPersonas.add(persona);
        }
    }
}
