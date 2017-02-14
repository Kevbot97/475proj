package project1;

public class Key {
	
	// credit: http://stackoverflow.com/questions/14677993/how-to-create-a-hashmap-with-two-keys-key-pair-value

    private final int x;
    private final int y;

    public Key(int x, int y) {
    	if (x > y)
    	{
    		this.x = y;
    		this.y = x;
    	}
    	else {
    		this.x = x;
    		this.y = y;
    	}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return x == key.x && y == key.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
    
    public String toString()
    {
    	return x + ", " + y;
    }

}