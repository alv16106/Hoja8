import java.util.Vector;

/**
 * @author Yasmin Chavez     16101
 * @author Rodrigo Alvarado  16106
 *
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueueNuestro<E>
{
	
	 /**
     * los datos, mantener el heap en orden.
     */
    protected Vector<E> data;  // the data, kept in heap order

    /**
     *
     * @post construir un nuevo priority queue
     */
    public VectorHeap()
    {
        data = new Vector<E>();
    }

    /**
     *     
     * @post construir un nuevo priority queue desde un vector desordenado
     */
    public VectorHeap(Vector<E> v)
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        {   // add elements to heap
            add(v.get(i));
        }
    }

    /**
     * Regresa el index del padre
     * @param i a node index
     * @return padre del node en i
     * @pre 0 <= i < size
     * @post regresa la locacion en i del nodo
     */
    protected static int parent(int i)
    {
        return (i-1)/2;
    }

    /**
     * Regresa el index del hijo izquierda
     * @param i un node index
     * @return hijo de la izquierda del nodo en la posicion i
     * @pre 0 <= i < size
     * @post regresa el index del hijo de la izquierda del nodo en la locacion i 
     */
    protected static int left(int i)
    {
        return 2*i+1;
    }

    /**
     * Regresa el index del hijo de la derecha.
     * @param i un index del nodo
     * @return hijo de la derecha del nodo en la posicion i
     * @pre 0 <= i < size
     * @post regresa el index del hijo de la derecha del nodo en la locacion i 
     */
    protected static int right(int i)
    {
        return 2*(i+1);
    }

    /**
     * busca el valor más pequeno (con mayor prioridad) del queue.
     *
     * @pre no esta vacio el queue
     * @post returns el minimo valor del priority queue
     * 
     * @return el mas pequeno valor del queue.
     */
    public E getFirst()
    {
        return data.get(0);
    }

    /**
     * Returns el valor minimo del queue.
     *
     * @pre  no debe estar vacie el queue 
     * @post regresa y mueve el valor minimo desde el queue
     * 
     * @return El valor miimo en el quee.
     */
    public E remove()
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Anade un valor al priority queue.
     *
     * @pre el valor no es null
     * @post el valor se anade a priority queue
     * 
     * @param valor, el valor que se desea anadir.
     */
    public void add(E value)
    {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Determina si el queue esta vacio.
     *
     * @post regresa verdadero si no hay elementos en el queue
     *  
     * @return verdadero si el queue esta vacio.
     */
    public boolean isEmpty()
    {
        return data.size() == 0;
    }

    /**
     * mover un nodo hacia arriba a una posicion apropiada en el heap.
     * @param el index de la hoja del nodo en el heap.
     * @pre 0 <= leaf < size
     * @post mueve el nodo a un index del hijo a una apropiada posicion
     */
    protected void percolateUp(int leaf)
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
          (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     *  mover el nodo hacia abajo en una posicion apropiada dentro del subheap.
     * @param Index  de la rama del subheap.
     * @pre 0 <= root < size
     * @post mueve el index del nodo abajo a una posicion apropiada en el subtree
     *   
     */
    protected void pushDownRoot(int root)
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                  ((data.get(childpos+1)).compareTo
                   (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                    (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }       
        }
    }

    /**
     * Determina el tamano del queue.
     *
     * @post regresa el numero de elementos en el queue
     * 
     * @return el numero de los elementos en el queue.
     */
    public int size()
    {
        return data.size();
    }

    /**
     * Remueve todos los elementos del queue.
     *
     * @post remueve todos los elementos del queue
     */
    public void clear()
    {
        data.clear();
    } 
    
    /**
     * Construir una cadena que represente el heap.
     *
     * @post regresa un string que representa el heap
     * 
     * @return El string que representa el heap.
     */
    public String toString()
    {
        return "<VectorHeap: "+data+">";
    }
}	

