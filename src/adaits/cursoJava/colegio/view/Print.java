package adaits.cursoJava.colegio.view;

import adaits.cursoJava.interfaces.Printable;

import java.util.ArrayList;
import java.util.Iterator;

public class Print implements Printable {
    @Override
    public String printConsola() {
        return null;
    }

    @Override
    public String printHTML() {
        return null;
    }

    @Override
    public String printJSON() {
        return null;
    }

    @Override
    public String list(Object obj) {
        String output = "";
        if (obj.getClass().getSimpleName().equals("ArrayList")){
            ArrayList objCollection = (ArrayList) obj;
            Iterator it = objCollection.iterator();
            while(it.hasNext()) {
                output += it.next().toString() + "\n";
            }
        }else{
            output = obj.toString();
        }
        return output;
    }
}
