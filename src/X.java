public class X {
    private Object[] elements;
    private int index;

    public X(int capacity) {
        elements = new Object[capacity];
        index = 0;
    }

    public void add(Object o){
        elements[index] = o;
        if (index<elements.length){
            index++;
        }
    }

    public Object get(int i){
        return elements[i];
    }
}
