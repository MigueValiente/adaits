package adaits.cursoJava.mvc;

public interface CRUDable {
    public void add(Object obj);

    public int getIndex(Object obj);
    public Object seek (Object key);

    public int delete(Object obj);
    public void set(Object key,String campo, String valor);
    public int getSize();
}
