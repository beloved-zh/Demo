import converter.UserConverter;
import converter.UserConverterAbs;
import dto.DeptDto;
import dto.HobbyDto;
import dto.UserDto;
import enums.PaymentType;
import org.junit.Before;
import org.junit.Test;
import vo.UserVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Beloved
 * @CreateTime: 2022-08-12 16:15
 * @Description:
 */
public class TestConverter {
    
    private UserDto userDto = null;
    private DeptDto deptDto = null;
    
    
    @Before
    public void buildUserDto() {
        userDto = new UserDto();
        userDto.setId(1);
        userDto.setAge(25);
        userDto.setSex(null);
        userDto.setName("张三");
        userDto.setTel("1234567890");
        
        deptDto = new DeptDto();
        deptDto.setDeptId(1);
        deptDto.setName("生产部");

        List<HobbyDto> hobbyList = new ArrayList<>();
        HobbyDto hobby = new HobbyDto();
        hobby.setId(1);
        hobby.setName("打篮球");
        hobbyList.add(hobby);
        userDto.setHobbyList(hobbyList);
        
        userDto.setDateOfBirth(new Date());
        userDto.setPaymentType(PaymentType.CASH);
    }
    
    @Test
    public void dtoToVo() {
        System.out.println(userDto);
        UserVo userVo = UserConverter.INSTANCE.dtoToVo(userDto);
        System.out.println(userVo);
    }

    @Test
    public void dtoToVo2() {
        System.out.println(userDto);
        UserVo userVo = UserConverter.INSTANCE.dtoToVo2(userDto);
        System.out.println(userVo);
    }

    @Test
    public void dtoToVo3() {
        System.out.println(userDto);
        System.out.println(deptDto);
        UserVo userVo = UserConverter.INSTANCE.dtoToVo3(userDto, deptDto);
        System.out.println(userVo);
    }

    @Test
    public void dtoToVo4() {
        System.out.println(userDto);
        UserVo userVo = UserConverter.INSTANCE.dtoToVo4(userDto);
        System.out.println(userVo);
    }

    @Test
    public void dtoToVo5() {
        System.out.println(userDto);
        UserVo userVo = UserConverter.INSTANCE.dtoToVo5(userDto, deptDto);
        System.out.println(userVo);
    }

    @Test
    public void dtoToVoAbs() {
        System.out.println(userDto);
        UserVo userVo = UserConverterAbs.INSTANCE.dtoToVo(userDto);
        System.out.println(userVo);
    }

    @Test
    public void updateUser() {
        System.out.println(userDto);
        UserVo userVo = UserConverter.INSTANCE.dtoToVo(userDto);
        System.out.println(userVo);

        UserDto userDto2 = new UserDto();
        userDto2.setName("李四");
        UserConverter.INSTANCE.updateUser(userDto2, userVo);
        System.out.println(userVo);
    }

    @Test
    public void voToDto() {
        System.out.println(userDto);
        UserVo userVo = UserConverter.INSTANCE.dtoToVo2(userDto);
        System.out.println(userVo);

       
        UserDto dto = UserConverter.INSTANCE.voToDto(userVo);
        System.out.println(dto);
    }
    
}
