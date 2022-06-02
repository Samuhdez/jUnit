/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.agendatest.daotest;

import ed.agenda.dao.AgendaDaoArrayList;
import ed.agenda.entidades.ContactoPersona;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author marco
 */
public class TestAgendaDaoArrayList {
    
    @Test
    public void TestCrearContactoPersona (){
    
    ContactoPersona CP1 = new ContactoPersona("11221999", "BillGates", "+34 981 666666");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();

        //Verifico que la agenda esta vacia
        assertTrue(dao.getContactos().isEmpty());
        //Añado el cotnacto persona
        dao.crearContactoPersona(CP1);

        //Verifico que la agenda contiene el contacto que yo he añadido
        assertTrue(dao.getContactos().contains(CP1));
        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        assertTrue(dao.getContactos().size()==1);
        
        
        
        
    
    }
    
}
