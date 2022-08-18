package dto;

import enums.PaymentType;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: Beloved
 * @CreateTime: 2022-08-12 16:11
 * @Description: 测试 DTO
 */
@Data
public class UserDto {
    
    private int id;
    
    private String name;
    
    private int age;
    
    private String sex;
    
    private String tel;
    
    private List<HobbyDto> hobbyList;

    private Date dateOfBirth;
    
    private PaymentType paymentType;
}