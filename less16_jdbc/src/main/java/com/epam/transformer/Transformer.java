package com.epam.transformer;


import com.epam.model.Annotation.Column;
import com.epam.model.Annotation.PrimaryKeyComposite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Transformer<T> {
    private final Class<T> clazz;

    public Transformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Object fromResultSetToEntity(ResultSet rs)
            throws SQLException {
        //create new object
        Object entity = null;
        ResultSetMetaData rsMetaData = rs.getMetaData();
        try {
            entity= clazz.getConstructor().newInstance();
            List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
              for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(PrimaryKeyComposite.class)){
                    field.set(entity, new Transformer(field.getType().getConstructor().newInstance().getClass()).
                            fromResultSetToEntity(rs));

                }else if(field.isAnnotationPresent(Column.class)){
                    Column column = field.getAnnotation(Column.class);
                    for(int i= 1; i<=rsMetaData.getColumnCount(); i++){
                        if(column.name().equalsIgnoreCase(rsMetaData.getColumnName(i))){
                            field.set(entity, rs.getObject(i));
                        }
                    }
                }
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return entity;
    }


}
