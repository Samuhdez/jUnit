/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.agendatest.entidades;

import ed.agenda.dao.AgendaDaoArrayList;
import ed.agenda.entidades.ContactoEmpresa;
import ed.agenda.entidades.ContactoPersona;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author DAW
 */
public class TestAgendaDaoEntidades {
    @Test
    public void TestObtenerContactoPorPosicion (){
    
    ContactoPersona CP1 = new ContactoPersona("11221999", "BillGates", "+34 981 666666");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();

        //Verifico que la agenda esta vacia
        assertTrue(dao.getContactos().isEmpty());
        //Añado el cotnacto persona
        dao.crearContactoPersona(CP1);

        //Verifico que la agenda contiene el contacto que yo he añadido
        assertTrue(dao.getContactos().contains(CP1));
        //Validar que el contacto se encuentra en la posicion esperada
        assertTrue((dao.obtenerContactoPorPosicion(0))==CP1);     
    }
    
    @Test
    public void AñadirContactoEmpresa (){
        ContactoPersona CP1 = new ContactoPersona("11221999", "BillGates", "+34 981 666666");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();
        ContactoEmpresa CE1 = new ContactoEmpresa("pagWebEmpresa", "Apllosoft", "+34 343434334");

        //Añado el cotnacto persona
        dao.crearContactoPersona(CP1);
        //Añado el cotnacto empresa
        dao.crearContactoEmpresa(CE1);
        //Verifico que la agenda contiene el contacto que yo he añadido
        assertTrue(dao.getContactos().contains(CE1));  
    }
    
}
