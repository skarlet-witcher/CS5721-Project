package adapter;

import java.lang.reflect.Method;
import java.util.Vector;

public class UserPayeeTableData implements TableData {

    private String[] methodArr;
    private Vector dataVector;

    public UserPayeeTableData() {
        this.dataVector = new Vector();
    }

    public void register(String[] methodName) {
        this.methodArr = methodName;
    }


    /**
     * @param obj : Object is UserPayeeModel in our scenario.
     * The method is to adapt the UserPayeeModel type to match the dataVector type,
     *
     * The use of reflection is that the client only needs to provide the name of "Get" method, ignores datatype of input
     */
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
    @Override
    public Vector getDataVector() {
        return dataVector;
    }
}
