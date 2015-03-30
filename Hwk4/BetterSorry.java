import java.util.concurrent.atomic.AtomicIntegerArray;

class BetterSorry implements State {
	private AtomicIntegerArray value;
	private byte maxval;
	
	BetterSorry(byte[] v) {
		int[] integerArray = new int[v.length];
		for(int i = 0; i < v.length; i++)
		{
			integerArray[i] = (int)v[i];
		}
		value = new AtomicIntegerArray(integerArray);

		maxval = 127;
	}

	BetterSorry(byte[] v, byte m) {
		int[] integerArray = new int[v.length];
		for(int i = 0; i < v.length; i++)
		{
			integerArray[i] = (int)v[i];
		}
		value = new AtomicIntegerArray(integerArray);

		maxval = m;
	}

	public int size() {
		return value.length();
	}

	public byte[] current() {
		byte[] v = new byte[value.length()];
		for(int k = 0; k < value.length(); k++)
		{
			v[k] = (byte)value.get(k); 
		}
		return v;
	}

	public boolean swap(int i, int j) {
		if (value.get(i) <= 0 || value.get(j) >= maxval) {
	    return false;
		}

		value.getAndDecrement(i);
		value.getAndIncrement(j);

		return true;
	}
}