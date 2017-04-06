
/**
 * @author Yasmin Chavez     16101
 * @author Rodrigo Alvarado  16106
 *
 */
public class Paciente<P  extends Comparable<P>, E, N> implements Comparable<Paciente<P, E, N>>{

	// Atributos
	private N nombre;
	private E enfermedad;
	private P prioridad;
	
	
	/**
	 * 
	 */
	public Paciente(){
		
	}
	
	/**
	 *
	 * @param <P>   prioridad del paciente
	 * @param <E>   enfermedad del paciente
	 * @param <N>   Nombre del paciente
	 */	
	public Paciente(N nombre, E enfermedad, P prioridad){
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.prioridad = prioridad;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other)
    {
        Paciente<P, E, N> otherPaciente = (Paciente<P, E, N>)other;
        return getPrioridad().equals(otherPaciente.getPrioridad());
    }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
	       return getPrioridad().hashCode();
	}
	 
	/**
	 * @return el nombre del paciente
	 */
	public N getNombre()
	{
	       return nombre;
	}
	 
	/**
	 * @return la enfermedad del paciente
	 */
	public E getEnfermedad()
	{
	        return enfermedad;
	}
	 
	/**
	 * @return la prioridad con la que se debe atender al paciente (A, B, C, D, E)
	 */
	public P getPrioridad()
	{
	       return prioridad;
	}
	  
	/**
	 * @param value  nuevo nombre
	 * @return el nuevo nombre del paciente
	 */
	public N setValue(N value)
	{
	     N oldValue = this.nombre;
	     this.nombre = value;
	     return oldValue;
	}
	  
	/**
	 * @param value enfermedad por la que se cambiara
	 * @return la enfermedad cambiada
	 */
	public E setEnfermedad(E value)
	{
	     E oldValue = this.enfermedad;
	     this.enfermedad = value;
	     return oldValue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
	     StringBuffer s = new StringBuffer();
	     s.append("("+getNombre()+", "+getEnfermedad() +", "+getPrioridad()+")");
	     return s.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Paciente<P, E, N> s) {
		return prioridad.compareTo(s.getPrioridad());
	}
}
