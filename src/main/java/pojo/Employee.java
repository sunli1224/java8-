package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunli
 * @date 2020/2/16 1:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Integer id;
    private String empName;
    private Integer age;
    private String gender;

}
