package parsing;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 */
public class FillAnnotatedObject {

    public void fillAnnotatedObject(Object object) throws  IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            FieldValue fieldValue = field.getAnnotation(FieldValue.class);
            if (int.class == field.getType() ) {
                field.setInt(object, Integer.parseInt(fieldValue.value()));
            } else if (long.class == field.getType()) {
                field.setLong(object, Long.parseLong(fieldValue.value()));
            } else if (short.class == field.getType()) {
                field.setShort(object, Short.parseShort(fieldValue.value()));
            } else if (byte.class == field.getType()) {
                field.setByte(object, Byte.parseByte(fieldValue.value()));
            } else if (double.class == field.getType()) {
                field.setDouble(object, Double.parseDouble(fieldValue.value()));
            } else if (float.class == field.getType()) {
                field.setFloat(object, Float.parseFloat(fieldValue.value()));
            } else if (char.class == field.getType()) {
                field.setChar(object, (fieldValue.value()).charAt(0));
            } else if (boolean.class == field.getType()) {
                field.setBoolean(object, new Boolean(fieldValue.value()));
            } else if (String.class == field.getType()) {
                field.set(object, fieldValue.value());
            }else {
                throw new UnsupportedOperationException(field.getName() + " custom class (" +field.getType() +
                        ") is not supported yet!");
            }
        }
    }

//    public static void main(String[] args) throws IllegalAccessException {
//        FillAnnotatedObject fao = new FillAnnotatedObject();
//        AnnClass annClass = new AnnClass();
//        fao.fillAnnotatedObject(annClass);
//        System.out.println(annClass);
//    }
}
