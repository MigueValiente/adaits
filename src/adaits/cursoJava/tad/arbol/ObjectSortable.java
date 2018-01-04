package adaits.cursoJava.tad.arbol;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ObjectSortable implements Comparable<ObjectSortable>{
    private Comparable value;
    public ObjectSortable(Comparable obj){
        if (isInteger(obj)){
            value = new Integer((Integer)obj);
        }
        if (isDate(obj)){
            value = obj;
        }
    }

    public boolean mayorQue(Comparable a) {
        return this.compareTo((ObjectSortable)a) == 1;
    }

    public boolean menorQue(Comparable a) {
        return this.compareTo((ObjectSortable)a) == -1;
    }

    public boolean igualQue(Comparable a) {
        return this.compareTo((ObjectSortable)a) == 0;
    }


    private boolean isInteger(Object obj){
        return obj.getClass().getSimpleName().equals("Integer");
    }

    private boolean isDate(Object obj){
        return obj.getClass().getSimpleName().equals("GregorianCalendar");
    }


    @Override
    public String toString() {
        if (this.value.getClass().getSimpleName().equals("Integer")){
            return this.value.toString();
        }
        if (this.value.getClass().getSimpleName().equals("GregorianCalendar")){
            return ((GregorianCalendar)(this.value)).getTime().toString();
        }
        return "";
    }

    @Override
    public int compareTo(ObjectSortable o) {
        if (isInteger(o)){
            if ((Integer)this.value < (Integer)o.value){
                return -1;
            }
            if ((Integer)this.value > (Integer)o.value){
                return 1;
            }
            return 0;
        }
        if (isDate(o)){
            if (((Calendar)this.value).before(o.value)){
                return -1;
            }
            if (((Calendar)this.value).after(o.value)){
                return 1;
            }
            return 0;
        }
        return 0;
    }
}
