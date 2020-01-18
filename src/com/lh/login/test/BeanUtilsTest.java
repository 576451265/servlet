package com.lh.login.test;

import com.lh.login.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @Description: BeanUtils测试类
 * @author LuoH
 * @date 2020/01/18
 */
public class BeanUtilsTest {

    /*
    1. setProperty()
    2. getProperty()
    3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中
     */
    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","zhangsan");
            BeanUtils.setProperty(user,"hehe","male");
            System.out.println(user);
            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
