/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package des.agendatest.daotest;

import ed.agenda.dao.AgendaDaoArrayList;
import ed.agenda.entidades.Contacto;
import ed.agenda.entidades.ContactoEmpresa;
import ed.agenda.entidades.ContactoPersona;
import ed.agenda.excepciones.ContactoNoEncontradoException;
import ed.agenda.excepciones.PosicionNoEncontradaException;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.*;

/**
 *
 * @author marco
 */
public class TestAgendaDaoArrayList {
    AgendaDaoArrayList dao;
    //Se ejecuta antes de cada test, para reiniciar la agenda
   
    @Before
    public void borrarAgenda() {
        dao = new AgendaDaoArrayList();
        dao.setContactos(new ArrayList<Contacto>());
    }
   
    @Test
    public void TestCrearContactoPersona (){
   
    ContactoPersona CP1 = new ContactoPersona("11221999", "Bill Gates", "+34 981 666666");
        //No hace falta iniciar agenda ya que se reinicia antes de cada test.
        //AgendaDaoArrayList dao = new AgendaDaoArrayList();

        //Verifico que la agenda esta vacia
        assertTrue(dao.getContactos().isEmpty());
        //Añado el cotnacto persona
        dao.crearContactoPersona(CP1);

        //Verifico que la agenda contiene el contacto que yo he añadido
        assertTrue(dao.getContactos().contains(CP1));
        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        assertTrue(dao.getContactos().size()==1);    
    }
   
   
    @Test
    public void TestCrearContactoPersonaConNombreInvalido (){
   
    ContactoPersona CP1 = new ContactoPersona("11221999", "Bi", "+34 981 666666");
        //Verifico que la agenda esta vacia
        assertTrue(dao.getContactos().isEmpty());
        //Añado el cotnacto persona
        dao.crearContactoPersona(CP1);

        //Verificamos que no se ha añadido ya que el nombre solo tiene 3 carcteres
        assertTrue(dao.getContactos().isEmpty());
       
        CP1.setNombre("asfdjaonvsoasnfbjinafpubnapjifnbihpabinadipvasodpvnpasidvipasndpivnasdnviSDVni");
        assertFalse(dao.crearContactoPersona(CP1));//Añado el cotnacto persona y devuelve false
        //Verificamos que no se ha añadido ya que el nombre solo tiene 3 carcteres
        assertTrue(dao.getContactos().isEmpty());
    }
   
   
   
   @Test
    public void TestCrearContactoEmpresa() {
        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft.com", "Microsoft", "789789987");

        assertTrue(dao.crearContactoEmpresa(CE2));
        //Añado el cotnacto empresa
        dao.crearContactoEmpresa(CE2);

        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        assertTrue(dao.getContactos().size() == 1);

    }
   @Test
    public void TestContactoEmpresaInvalido () {
        //Creo contacto invalido
        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft", "Microsoft", "789789987");
        //Compruebo lista esta vacia
        assertTrue(dao.getContactos().isEmpty());
        //Añado el cotnacto empresa a la lista
        assertFalse(dao.crearContactoEmpresa(CE2));
        //Verificao que la agenda sigue vacia
        assertTrue(dao.getContactos().isEmpty());
    }

    @Test
    public void TestBorrarContactoPorPosicion() throws PosicionNoEncontradaException {

        ContactoPersona CP1 = new ContactoPersona("11221999", "BillJobs", "+34 981 666666");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();

        //Verifico que la agenda no contiene a Billjobs y esta vacia
        assertTrue(dao.obtenerContactoPorNombre("BillJobs") == null);
        assertTrue(dao.getContactos().isEmpty());
        //Creo el contacto
        dao.crearContactoPersona(CP1);
        //Verifico que se añade el usuario
        assertTrue(dao.getContactos().size() == 1);
        //Eliminamos el usuario añadido
        dao.borrarContactoPorPosicion(0);
        //Comprobamos que el usuario no existe y la lista esta vacia
        assertTrue(dao.obtenerContactoPorNombre("BillJobs") == null);
        assertTrue(dao.getContactos().isEmpty());
    }

    @Test
    public void TestEliminarContactoPorNombre() throws ContactoNoEncontradoException {
        //Creo contacto empresa
        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft.com", "Microsoft", "789789987");
        //Verifico lista vacia
        assertTrue(dao.getContactos().isEmpty());
        //Añado el cotnacto empresa a la lista, verificamos que se añade
        dao.crearContactoEmpresa(CE2);
        assertTrue(dao.crearContactoEmpresa(CE2));      
        //Verifico que se añade el usuario
        assertTrue(dao.getContactos().size() == 1);
        //Eliminamos contacto, lo comprobamos, y miramos si la lista esta vacia
        dao.eliminarContactoPorNombre("Microsoft");
        assertTrue(dao.getContactos().remove(CE2));
        assertTrue(dao.getContactos().isEmpty());
    }
   
    /*@Test
    public void TestMostrarTrabajadoresEmpresa() throws ContactoNoEncontradoException {

        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft.com", "Microsoft", "789789987");
       

        assertTrue(dao.crearContactoEmpresa(CE2));
        //Añado el cotnacto empresa
        dao.crearContactoEmpresa(CE2);
        //assertEquals(CE2, dao.obtenerContactoPorNombre("Microsoft"));
        assertFalse(dao.obtenerContactoPorNombre("Microsoft")==null);
        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
       // assertTrue(dao.getContactos().size() == 1);
    }*/
    @Test
    public void TestMostrarTrabajadoresEmpresa() throws ContactoNoEncontradoException {
        //Creamos contactos
        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft.com", "Microsoft", "789789987");      
        ContactoPersona CP1 = new ContactoPersona("11221999", "BillGates", "+34 981 666666");
        //verificamos
        assertTrue(dao.crearContactoEmpresa(CE2));
        //Añado el cotnacto empresa
        dao.crearContactoEmpresa(CE2);
        //assertEquals(CE2, dao.obtenerContactoPorNombre("Microsoft"));
        //Verifico que existe la empresa en la agenda.
        assertFalse(dao.obtenerContactoPorNombre("Microsoft")==null);
        //Igual con rtabajador        
        //Añado el contacto persona
        dao.crearContactoPersona(CP1);
        //Verifico existe el contacto
        assertTrue(dao.crearContactoPersona(CP1));
        //Lo añadimos a la empresa
        CE2.setTrabajadores(new ArrayList<>(Arrays.asList(CP1)));
        //Verifico si se lanza la excepcion sino existiesen contactos en la empresa.
        Throwable exception = assertThrows(ContactoNoEncontradoException.class,
            ()->{dao.mostrarTrabajadoresEmpresa("Microsoft");} );
        assertEquals("No tiene trabajadores", exception.getMessage());
    }
    //
}
