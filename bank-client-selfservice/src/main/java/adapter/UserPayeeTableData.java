package adapter;

import java.lang.reflect.Method;
import java.util.Vector;

public class UserPayeeTableData implements TableData { // Pluggable adapter // UserPayeeData

    private String[] methodArr;
    private Vector dataVector;

    public UserPayeeTableData() {
        this.dataVector = new Vector();
    }

    public void register(String[] methodName) {
        this.methodArr = methodName;
    }

    @Override
    public Vector getDataVector() {
        return dataVector;
    }

    public void setDataVector(Object obj) {

        try {
            Vector rowVector = new Vector();
            for(int i = 0; i < methodArr.length; i++) {

                for(Method m : obj.getClass().getDeclaredMethods()) {
                    if(m.getName() == methodArr[i]) {
                        String value = m.invoke(obj).toString();
                        rowVector.add(value);
                    }
                }
            }
            dataVector.add(rowVector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
