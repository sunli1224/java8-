package StreamDemo;

import org.junit.Test;
import pojo.Employee;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author sunli
 * @date 2020/2/16 1:31
 */
public class Test01 {

    List<Employee> employeeList = Arrays.asList(
            new Employee(1,"张三",15,"男"),
            new Employee(2,"李四",50,"男"),
            new Employee(3,"王五",34,"男"),
            new Employee(4,"张雪",14,"女"),
            new Employee(4,"张雪",14,"女"),
            new Employee(4,"张雪",14,"女"));

    @Test
    public void test01(){
        employeeList.stream()
                .filter((item) -> item.getAge() > 0 )
                .sorted((x,y) -> y.getAge() - x.getAge())
                .forEach(System.out :: println);
    }


    /**
     * 筛选与切片
     * filter 筛选，接受lambda表达式，
     * limit  截断流,输出的元素数量不超过指定的数量
     * skip 跳过几个元素，加载后几个
     * distinct 通过hashcode和equals进行去重操作
     *
     */
    @Test
    public void test02() {
//        employeeList.stream()
//                .filter(item -> {
//                    System.out.println("中断！！");
//                    return item.getAge() > 45;
//                })
//                .limit(2)
//                .forEach(System.out :: println);
//        employeeList.stream()
//                .distinct()
//                .forEach(System.out :: println);
//        employeeList.stream()
//                .skip(1)
//                .forEach(System.out :: println);
//        employeeList.stream()
//                .limit(2)
//                .forEach(System.out :: println);
//        Random random = new Random();
//        random.ints().limit(10).sorted().forEach(System.out::println);
    }
    /**
     * map  返回item
     * flatmap  返回Stream
     */
    @Test
    public void test03(){
        List<String> lists = Arrays.asList("aaa", "bbb", "ccc", "ddd");
//        lists.stream()
//                .map(item -> item.toUpperCase())
//                .forEach(System.out :: println);
        lists.stream()
                .flatMap(Test01::exchangeList)
                .forEach(System.out :: println);
    }
    
    public static Stream<Character> exchangeList(String str){
        ArrayList<Character> arr = new ArrayList<>();
        for (Character it:
             str.toCharArray()) {
            arr.add(it);
        }
        return arr.stream();
    }

    /**
     * sorted 排序
     *Comparator  --定制排序
     * Comparable  --自然排序
     */
    @Test
    public void test05() {
//        List<String> lists = Arrays.asList("aaa", "bbb", "ccc", "ddd");
//        lists.stream()
//                .sorted()
//                .forEach(System.out :: println);

        employeeList.stream()
                .sorted((o1,o2) -> {
                    if (o1.getAge().equals(o2.getAge())){
                        return o1.getEmpName().compareTo(o2.getEmpName());
                    }else {
                        return o1.getId().compareTo(o2.getId());
                    }
                }).forEach(System.out :: println);

    }

}
