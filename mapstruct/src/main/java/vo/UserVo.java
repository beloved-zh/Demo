package vo;

import enums.PaymentTypeView;
import lombok.Data;

import java.util.List;

/**
 * @Author: Beloved
 * @CreateTime: 2022-08-12 16:11
 * @Description: 测试 VO
 */
@Data
public class UserVo {

    private String id;

    private String name;
    
    private String age;
    
    private String phone;
    
    private String sex;
    
    private String deptName;

    private List<HobbyVo> hobbyList;

    private String dateOfBirth;

    private PaymentTypeView paymentType;
}
