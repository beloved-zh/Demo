package converter;

import dto.UserDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import vo.UserVo;

/**
 * @Author: Beloved
 * @CreateTime: 2022-08-18 11:13
 * @Description: 抽象类映射实现
 */
@Mapper(uses = {
        HobbyConverter.class,
        PaymentTypeConverter.class
})
public abstract class UserConverterAbs {

    public static UserConverterAbs INSTANCE = Mappers.getMapper(UserConverterAbs.class);
    
    @Mappings({
            @Mapping(source = "tel", target = "phone")
    })
    public abstract UserVo dtoToVo(UserDto userDto);

    /**
     * @BeforeMapping 每次映射之前执行
     * @param userDto
     */
    @BeforeMapping
    protected void validate(UserDto userDto) {
        if (userDto.getSex() == null) {
            userDto.setSex("未知");
        }
    }

    /**
     * @AfterMapping 每次映射之后执行
     *      @MappingTarget 表示入参已经是转换之后的
     * @param userVo
     */
    @AfterMapping
    protected void updateResult(@MappingTarget UserVo userVo) {
        userVo.setId(null);
    }
}
