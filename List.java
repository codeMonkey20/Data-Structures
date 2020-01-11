import java.util.Arrays;

/**
 * Constructor Summary:
 * 		List(boolean enableNull) 			- toggles insertion of null object
 * 		List(List<? extends E> list) 		- constructs a list containing the elements of the specified list
 * 		List()								- constructs empty list
 * 
 * Method Summary:
 * 		add(List<? extends E> list)			- appends to this list containing the elements of the specified list
 * 		append(E data)						- appends the specified element to the end of this list
 * 		removeAll(E data)					- removes all elements of the specified element from this list
 * 		removeAll()							- removes all elements of the list.
 * 		remove(E data)						- removes the first occurence of the specified element from this list
 * 		pop(int index)						- removes an element based on index where it is located from this list
 * 		print()								- prints elements in the list
 * 		isExisting(E data)					- returns boolean indicates existence of the argument
 * 		toString()							- returns string of elements in the list
 * 		getIndex(E data)					- returns index address of corresponding element argument
 * 		getElement(int index)				- returns element data of corresponding index address
 * 
 * @author Juliard Actub
 *
 * @param <E> data type to be accessed to this object
 */

public class List<E> {
	
	/**
	 *  List is basically an unfixed array.
	 * 	MAIN_LIST is an array of data type E element(generic).
	 * 	Every append/remove replaces array object pointing to MAIN_LIST.
	 * 	Initalizes as null to reduce memory leak and indicate as empty.
	 */
	private E[] MAIN_LIST = null;
	
	
	
	/**
	 * 	Returns number of elements in the MAIN_LIST.
	 * 	Declared as public for ease of access.
	 */
	public int length = 0;
	
	
	
	/**
	 * 	Toggles insertion of null objects in the list.
	 * 	At object instantation, this is set as false in default.
	 */
	private boolean toggleNull = false;
	
	
	
	/**
	 * Toggles insertion of null objects in the list
	 * 
	 * @param enableNull to be the state toggled.
	 */
	public List(boolean enableNull) {
		this.toggleNull = enableNull;
	}
	
	
	
	
	/**
	 * Constructs a list containing the elements of the specified list
	 * 
	 * @param list containing elements of collection to be
	 *        copied in MAIN_LIST
	 * @throws NullPointerException if the specified list is null or
	 *         specified list has a null element and toggleNull is disabled
	 */
	@SuppressWarnings("unchecked")
	public List(List<? extends E> list) {
		
		//	Throws NullPointerException if param list is null
		if (list == null) {
			throw new NullPointerException();
		}
		
		MAIN_LIST = (E[]) new Object[list.length];
		
		//	Copies all elements of param list to the MAIN_LIST
		for (int i = 0; i < list.length; i++) {
			
			//	Throws NullPointerException if one of the elements is null
			if (list.getElement(i) == null && !toggleNull) {
				throw new NullPointerException();
			}
			MAIN_LIST[i] = list.getElement(i);
		}
		length = list.length;
	}
	
	
	
	
	/**
	 * Constructs an empty list (default constructor)
	 */
	public List() {
	}
	
	
	
	
	/**
	 * Appends to the MAIN_LIST containing the elements of the specified list
	 * Creates new array with the appended data to be pointed to MAIN_LIST.
	 * 
	 * @param list containing elements of collection to be
	 *        added in MAIN_LIST
	 * @throws NullPointerException if the specified list is null or
	 *         specified list has a null element and toggleNull is disabled
	 */
	@SuppressWarnings("unchecked")
	public void add(List<? extends E> list) {
		if (list == null) {
			throw new NullPointerException();
		}
		
		E[] newArray = (E[]) new Object[length + list.length];
		
		//	Iterates the whole new array
		for (int i = 0; i < list.length + length; i++) {
			
			// Copies all the elements of old array into new array
			if (i < length) {
				newArray[i] = MAIN_LIST[i];
			}
			
			//	Copies all the element of param list into the new array
			else {
				
				//	Throws NullPointerException if there is null element in param list
				if (list.getElement(i - length) == null && !toggleNull) {
					throw new NullPointerException();
				}
				newArray[i] = list.getElement(i - length);
			}
		}
		
		//	MAIN_LIST points to the new array and deletes the old array
		length = length + list.length;
		MAIN_LIST = newArray;
		System.gc();
	}
	
	
	
	
	
	/**
	 * Appends the specified element to the end of this list.
	 * Creates new array with the appended data to be pointed to MAIN_LIST.
	 *
	 * @param data element to be appended to this list
	 * @throws UnsupportedOperationException if the operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements and toggleNull is disabled
	 * @throws IllegalArgumentException if some property of this element
	 *         prevents it from being added to this list
	 */
	@SuppressWarnings("unchecked")
	public void append(E data) {
		if (data == null && !toggleNull) {
			throw new NullPointerException();
		}
		
		try {
			
			//	If MAIN_LIST is not empty, Creates duplicated array with the appended
			//	data to be pointed to MAIN_LIST.
			if (MAIN_LIST != null) {
				E[] newArray = (E[]) new Object[length + 1];
				
				//	Copies all elements from the old array to the new array
				for (int i = 0; i < MAIN_LIST.length; i++) {
					newArray[i] = MAIN_LIST[i];
				}
				
				//	Appends the data to the last index of new array
				newArray[length] = data;
				
				//	MAIN_LIST points to the new array and deletes the old array
				MAIN_LIST = newArray;
				System.gc();
			}
			
			//	If MAIN_LIST is empty, creates array of size 1 and appends the data
			else {
				MAIN_LIST = (E[]) new Object[1];
				MAIN_LIST[0] = data;
			}
			
			length++;
		}
		catch (ClassCastException e) {
			throw e;
		}
		catch (UnsupportedOperationException e) {
			throw e;
		}
		catch (IllegalArgumentException e) {
			throw e;
		}
	}
	
	
	
	
	/**
	 * Removes all elements of the specified element from this list,
	 * If this list does not contain the element, it is unchanged.
	 *
	 * @param data element to be removed from this list, if present
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 * @throws UnsupportedOperationException if the {@code remove} operation
	 *         is not supported by this list
	 */
	@SuppressWarnings("unchecked")
	public void removeAll(E data) {
		if (data == null && !toggleNull) {
			throw new NullPointerException();
		}
		
		try {
			
			//	Remove method only engages if MAIN_LIST is not empty
			//	Tests if element exists in MAIN_LIST
			if (MAIN_LIST != null && isExisting(data)) {
					
				//	Counts number of element/s to be deleted
				int c = 0;
				for (E e : MAIN_LIST) {
					if (e == data) {
						c++;
					}
				}
				
				//	If MAIN_LIST has only 1 element or all are to be deleted, 
				//	simply set it to null for efficiency
				if (length == 1 || (c == length)) {
					MAIN_LIST = null;
				} 
				
				//	If MAIN_LIST has more than 1 element, creates new duplicated array.
				//	New duplicated array copies all elements from old array except from 
				//	the argument(removed element/s)
				else {
					E[] newArray = (E[]) new Object[length - c];
					
					//	Copies all elements from old except from the argument(removed element)
					int i = 0;
					for (E e : MAIN_LIST) {
						if (e != data) {
							newArray[i] = e;
							i++;
						}
					}
					
					//	MAIN_LIST points to the new array and deletes the old array
					MAIN_LIST = newArray;
					System.gc();
					length--;
				}
			}
		}
		catch (ClassCastException e) {
			throw e;
		}
		catch (UnsupportedOperationException e) {
			throw e;
		}
	}
	
	
	
	
	/**
	 * Removes all elements of the list.
	 */
	public void removeAll() {
		MAIN_LIST = null;
		length = 0;
		System.gc();
	}
	
	
	
	
	/**
	 * Removes the first occurence of the specified element from this list,
	 * If this list does not contain the element, it is unchanged.
	 *
	 * @param data element to be removed from this list, if present
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 * @throws UnsupportedOperationException if the {@code remove} operation
	 *         is not supported by this list
	 */
	@SuppressWarnings("unchecked")
	public void remove(E data) {
		if (data == null && !toggleNull) {
			throw new NullPointerException();
		}
		
		try {
			
			//	Remove method only starts if MAIN_LIST is not empty
			//	Tests if element exists in MAIN_LIST
			if (MAIN_LIST != null && isExisting(data)) {
				
				//	If MAIN_LIST has only 1 element, simply set it to null for efficiency
				if (length == 1) {
					MAIN_LIST = null;
				}
				
				//	If MAIN_LIST has more than 1 element, creates new duplicated array.
				//	New duplicated array copies all elements from old array except from 
				//	the argument(removed element)
				else {
					E[] newArray = (E[]) new Object[length - 1];
					
					//	Copies elements from start up to index where it has to be deleted
					for (int i = 0; i != getIndex(data); i++) {
						newArray[i] = MAIN_LIST[i];
					}
					
					//	Continues to copy elements after the index where it has been deleted up to length
					for (int i = getIndex(data) + 1; i < MAIN_LIST.length; i++) {
						newArray[i-1] = MAIN_LIST[i];
					}
					
					//	MAIN_LIST points to the new array and deletes the old array
					MAIN_LIST = newArray;
					System.gc();
					length--;
				}
			}
		}
		catch (ClassCastException e) {
			throw e;
		}
		catch (UnsupportedOperationException e) {
			throw e;
		}
	}
	
	
	
	
	/**
	 * Removes an element based on index where it is located from this list,
	 *
	 * @param index is index to be removed from this list
	 * @throws IndexOutOfBoundsException if the argument is out of bounds from this list
	 */
	@SuppressWarnings("unchecked")
	public void pop(int index) {
		if (index >= length) {
			throw new IndexOutOfBoundsException();
		}
		
		if (MAIN_LIST != null) {
			
			//	Set to null if only 1 element remain
			if (length == 1) {
				MAIN_LIST = null;
			}
			
			//	If MAIN_LIST has more than 1 element, creates new duplicated array.
			//	New duplicated array copies all elements from old array except from 
			//	the argument(removed element)	
			else {
				E[] newArray = (E[]) new Object[length - 1];
				
				//	Copies elements from start up to index where it has to be deleted
				for (int i = 0; i != index; i++) {
					newArray[i] = MAIN_LIST[i];
				}
				
				//	Continues to copy elements after the index where it has been deleted up to length
				for (int i = index + 1; i < MAIN_LIST.length; i++) {
					newArray[i-1] = MAIN_LIST[i];
				}
				
				//	MAIN_LIST points to the new array and deletes the old array	
				MAIN_LIST = newArray;
				length--;
				System.gc();
			}
		}
	}
	
	
	

	/**
	 * Returns existence of param element
	 * 
	 * @param data
	 * @return true if exist, else false
	 */
	public boolean isExisting(E data) {
		for (E e : MAIN_LIST) {
			if (e == data) {
				return true;
			}
		} return false;
	}
	
	
	
	/**
	 * Prints elements in the list
	 */
	public void print() {
		if (MAIN_LIST != null) {
			System.out.println(Arrays.toString(MAIN_LIST));
		}
	}
	
	
	
	
	/**
	 * 
	 * @return String of elements in this list
	 */
	public String toString() {
		return Arrays.toString(MAIN_LIST);
	}
	
	
	
	
	/**
	 * Returns index address of corresponding element argument
	 * 
	 * @param data element
	 * @return integer index, returns -1 if element param data does not exists
	 */
	public int getIndex(E data) {
		for (int i = 0; i < MAIN_LIST.length; i++) {
			if (MAIN_LIST[i] == data) {
				return i;
			}
		} return -1;
	}
	
	
	
	
	/**
	 * Returns element data of corresponding index address
	 * @param index address
	 * @return data type E generic of corresponding index address
	 */
	public E getElement(int index) {
		return MAIN_LIST[index];
	}
}
