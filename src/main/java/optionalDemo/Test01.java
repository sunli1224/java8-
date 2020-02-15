package optionalDemo;

import org.junit.Test;
import pojo.Employee;

import java.util.Optional;

/**
 * @author sunli
 * @date 2020/2/16 5:05
 */
public class Test01 {
    @Test
    public void test01() {
        Optional<Employee> op1 = Optional.of(new Employee(1, "张三", 15, "男"));
        System.out.println(op1.get());

        Optional<Object> o = Optional.ofNullable(null);
//        System.out.println(o.get());
    }
}
