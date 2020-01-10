public class List<T> {

	private T[] LIST = null;
	public int length = 0;

	public void print() {
		if (this.LIST != null) {
			System.out.print("[");
			for (int i = 0; i < this.LIST.length; i++) {
				if (i == this.LIST.length - 1) {
					System.out.print(this.LIST[i] + "]");
				}
				else System.out.print(this.LIST[i] + ", ");
			}
		}
	}

	public void println() {
		print();
		System.out.println();
	}

	public void append(T data) {
		this.length++;
		if (this.LIST != null) {
			T[] newArray = (T[]) new Object[this.length];

			int x = 0;
			for (T e : this.LIST) {
				newArray[x] = e;
				x++;
			}

			newArray[newArray.length - 1] = data;
			this.LIST = newArray;
		} else {
			this.LIST = (T[]) new Object[this.length];
			this.LIST[0] = data;
		}
	}

	public void remove(T data) {
		if (this.LIST != null) {
			boolean found = false;
			for (T e : this.LIST) {
				if (data == e) {
					found = true;
					break;
				}
			}

			if (found) {
				this.length--;
				if (this.length == 0) {
					this.LIST = null;
				} else {
					T[] newArray = (T[]) new Object[this.length];
					int i = 0;
					for (T e : this.LIST) {
						if (e != data) {
							newArray[i] = e;
							i++;
						}
					}
					this.LIST = newArray;
				}
			}
		}
	}

	public void pop(int index) {
		if (this.LIST != null && index < this.LIST.length) {
			this.length--;
			if (this.length == 0 && (index == 0 || index == -1)) {
				this.LIST = null;
			}
			else if (this.length > 0) {
				T[] newArray = (T[]) new Object[this.length];
				int i = 0;
				for (T e : this.LIST) {
					if (index < 0) {
						if (e != this.LIST[this.length + index + 1]) {
							newArray[i] = e;
							i++;
						}
					} else {
						if (e != this.LIST[index]) {
							newArray[i] = e;
							i++;
						}
					}
				}
				this.LIST = newArray;
			}
		}
	}

	public T getElement(int index) {
		if (index < this.LIST.length) {
			if (index < 0)
				return this.LIST[index + this.LIST.length];
			else
				return this.LIST[index];
		} return null;
	}

	public boolean isExisting(T data) {
		for (int i = 0; i < length; i++) {
			if (data == LIST[i]) {
				return true;
			}
		} return false;
	}

	public Integer getIndex(T data) {
		for (int i = 0; i < this.LIST.length; i++) {
			if (data == this.LIST[i]) {
				return i;
			}
		} return null;
	}
}