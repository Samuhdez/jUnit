package ed.agenda.dao;

import ed.agenda.entidades.Contacto;
import ed.agenda.entidades.ContactoEmpresa;
import ed.agenda.entidades.ContactoPersona;
import ed.agenda.excepciones.ContactoNoEncontradoException;
import ed.agenda.excepciones.PosicionNoEncontradaException;



public interface AgendaDao {

	public boolean crearContactoPersona(ContactoPersona c);
	
	public boolean crearContactoEmpresa(ContactoEmpresa c);
	
	public boolean borrarContactoPorPosicion(int index) throws PosicionNoEncontradaException;
	
	public Contacto obtenerContactoPorPosicion (int index) throws PosicionNoEncontradaException ;
	
	public Contacto obtenerContactoPorNombre (String nombre) throws ContactoNoEncontradoException;
        
        public void listarContactos();
        
        public boolean eliminarContactoPorNombre(String nombre) throws ContactoNoEncontradoException;
        
	public void mostrarTrabajadoresEmpresa(String nombre)throws ContactoNoEncontradoException;
}
