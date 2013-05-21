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

    public void fillAnnotatedObject(Object object) throws RuntimeException, IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            FieldValue fieldValue = field.getAnnotation(FieldValue.class);
            System.out.println(fieldValue.value());
            if (field.getType() == int.class) {
                field.setInt(object, Integer.parseInt(fieldValue.value()));
            } else if (field.getType() == long.class ) {
                field.setLong(object, Long.parseLong(fieldValue.value()));
            } else if (field.getType().toString().equals("short")) {
                field.setShort(object, Short.parseShort(fieldValue.value()));
            } else if (field.getType().toString().equals("byte")) {
                field.setByte(object, Byte.parseByte(fieldValue.value()));
            } else if (field.getType().toString().equals("double")) {
                field.setDouble(object, Double.parseDouble(fieldValue.value()));
            } else if (field.getType().toString().equals("float")) {
                field.setFloat(object, Float.parseFloat(fieldValue.value()));
            } else if (field.getType().toString().equals("char")) {
                field.setChar(object, stringToChar(fieldValue.value()));
            } else if (field.getType().toString().equals("boolean")) {
                field.setBoolean(object, new Boolean(fieldValue.value()));
            } else if (field.getType().equals(String.class)) {
                field.set(object, fieldValue.value());


            }
        }
    }



    private static char stringToChar(String str) {
        char[] chars = str.toCharArray();
        char c = ' ';
        for (char ch : chars) {
            if (ch != ' ') {
                c = ch;
            }
        }
        return c;
    }

    public static void main(String[] args) throws IllegalAccessException {
        FillAnnotatedObject fao = new FillAnnotatedObject();
        Address address = new Address();
        AnnClass annClass = new AnnClass();
        fao.fillAnnotatedObject(annClass);
        System.out.println(annClass);
    }
}
