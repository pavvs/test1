package XMLParsing;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 */
public class FillAnnotatedObject {
    private Appendable a;

    public void fillAnnotatedObject(Object object) {
        if (isSimpleObject(object)) {
            Field fields[] = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                FieldValue fieldValue = field.getClass().getAnnotation(FieldValue.class);
                System.out.println(field.getName());

                try {
                    if (field.getType().toString().equals("int"))
                        field.setInt(object, Integer.parseInt(fieldValue.value()));
                    if(field.getType().toString().equals("long"))
                        field.setLong(object, Long.parseLong(fieldValue.value()));
                    if(field.getType().toString().equals("short"))
                        field.setShort(object, Short.parseShort(fieldValue.value()));
                    if(field.getType().toString().equals("byte"))
                        field.setByte(object, Byte.parseByte(fieldValue.value()));
                    if(field.getType().toString().equals("double"))
                        field.setDouble(object, Double.parseDouble(fieldValue.value()));
                    if(field.getType().toString().equals("float"))
                        field.setFloat(object, Float.parseFloat(fieldValue.value()));
                    if(field.getType().toString().equals("char"))
                        field.setChar(object, stringToChar(fieldValue.value()));
                    if(field.getType().toString().equals("boolean"))
                        field.setBoolean(object, new Boolean(fieldValue.value()));
                    if(field.getType().equals(String.class))
                        System.out.println(fieldValue);

                        field.set(object,fieldValue.value());

                } catch (IllegalAccessException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        } else System.out.println("Error: the object is not simple: " + object.getClass().getName() + " !");


    }

    //    Checks if object's fields' types are simple(long, int, short, byte, double, float, char, boolean) and
// class java.lang.String
    private static boolean isSimpleObject(Object object) {
        Field fields[] = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().toString().equals("long") ||
                    field.getType().toString().equals("int") ||
                    field.getType().toString().equals("short") ||
                    field.getType().toString().equals("byte") ||
                    field.getType().toString().equals("double") ||
                    field.getType().toString().equals("float") ||
                    field.getType().toString().equals("char") ||
                    field.getType().toString().equals("boolean") ||
                    field.getType().toString().equals("class java.lang.String"))
                return true;
        }

        return false;
    }
    private static char stringToChar(String str){
        char[] chars = str.toCharArray();
        char c = ' ';
        for(char ch : chars){
            if(ch != ' ') {
                c=ch;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        FillAnnotatedObject fAO = new FillAnnotatedObject();
        Address address = new Address();
        AnnClass annClass = new AnnClass();
        fAO.fillAnnotatedObject(annClass);
        System.out.println(annClass);
    }
}
