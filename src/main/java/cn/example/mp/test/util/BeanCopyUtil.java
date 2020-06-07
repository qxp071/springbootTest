package cn.example.mp.test.util;

import cn.example.mp.test.annotation.PropertyName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * describe dto转换为 java bean
 * @author lik
 * @date 2019/10/30 15:57
 */
public class BeanCopyUtil {
    private static Logger logger = LoggerFactory.getLogger(BeanCopyUtil.class);

    private BeanCopyUtil(){
        throw new IllegalStateException("Utility class");
    }

    public static <O, T> T beanCopy(O source, Class<T> target)  {
        Field[] fields = getAllFields(source);
        T instance = null;
        //创建实体
        try {
            instance = target.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("对象创建失败!",e);
        }
        for (Field field : fields) {
            //获取带有注解属性
            PropertyName propertyName = field.getAnnotation(PropertyName.class);
            if(null != propertyName && !"".equals(propertyName.value())){
                Object value = Reflections.getFieldValue(source,field.getName());
                String fieldName = propertyName.value();

                try {
                    Reflections.setFieldValue(instance,fieldName,value);
                } catch (IllegalArgumentException e) {
                   logger.error("属性不存在！");
                }

            }
        }
        return instance;
    }

    /**
     * 获取所有属性包括父类
     * @param object
     * @return
     */
    public static Field[] getAllFields(Object object){
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}