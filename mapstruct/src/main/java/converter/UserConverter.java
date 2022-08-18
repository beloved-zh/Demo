package converter;

import dto.DeptDto;
import dto.UserDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import vo.UserVo;

import java.util.UUID;

/**
 * @Author: Beloved
 * @CreateTime: 2022-08-12 16:14
 * @Description: User 转换器
 */
/*
 * @Mapper：标注是转换器
 *      uses：子对象映射，此转换器可以使用 uses 引用得转换器
 *      imports：表达式需要引用的类
 *      componentModel：依赖注入。可选值：spring、cdi、jsr330
 */
@Mapper(uses = {
        HobbyConverter.class,
        PaymentTypeConverter.class
}, imports = {
        UUID.class 
}
//, componentModel = "spring"
)
public interface UserConverter {
    
    // 获取对象
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    /**
     * 定义基本转化方法
     *      默认映射规则：同名同类型自动映射
     * @param userDto
     * @return UserVo
     */
    UserVo dtoToVo(UserDto userDto);

    /**
     * 同源不同属性名称
     * @param userDto
     * @return
     */
    @Mappings({
        @Mapping(source = "tel", target = "phone")
    })
    UserVo dtoToVo2(UserDto userDto);

    /**
     * 多源映射 source 可以指定源类
     *      如果多个源类包含同名字段，必须指定源类否则会抛出异常：Several possible source properties for target property "name" 
     * @param userDto
     * @param deptDto
     * @return
     */
    @Mappings({
        @Mapping(source = "userDto.tel", target = "phone"),
        @Mapping(source = "userDto.name", target = "name"),
        @Mapping(source = "deptDto.name", target = "deptName")
    })
    UserVo dtoToVo3(UserDto userDto, DeptDto deptDto);


    /**
     * 进阶操作
     *      ignore：排除映射
     *      constant：常量 ，无论可以映射什么值都始终是常量值
     *      defaultValue：如果 source 取值为null，则会使用默认值
     *      expression：类型一个常量，一直调用定义的 Java 表达式
     *      defaultExpression：如果 source 取值为null，则会使用表达式
     *          注意：表达式中使用的 Java 类需要 @Mapper 的 imports 中引入
     * @param userDto
     * @return
     */
    @Mappings({
        @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())"),
        @Mapping(target = "age", constant = "18"),
        @Mapping(source = "sex", target = "sex", defaultValue = "未知"),
        @Mapping(source = "dateOfBirth", target = "dateOfBirth", ignore = true)
    })
    UserVo dtoToVo4(UserDto userDto);

    /**
     * 自定义映射方法。可以自定义逻辑处理
     * @param userDto
     * @param deptDto
     * @return
     */
    default UserVo dtoToVo5(UserDto userDto, DeptDto deptDto) {
        UserVo userVo = this.dtoToVo2(userDto);
        userVo.setDeptName(deptDto.getName());
        return userVo;
    }

    /**
     * @BeforeMapping 每次映射之前执行
     * @param userDto
     */
    @BeforeMapping
    default void validate(UserDto userDto) {
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
    default void updateResult(@MappingTarget UserVo userVo) {
        userVo.setId(null);
    }

    /**
     * 继承映射配置 @InheritConfiguration
     *      name：需要继承的配置方法名
     * @param userDto
     * @param userVo
     */
    @InheritConfiguration(name = "dtoToVo4")
    void updateUser(UserDto userDto, @MappingTarget UserVo userVo);

    /**
     * 反向映射 @InheritInverseConfiguration
     *      name：需要反向映射的方法名
     * @param userVo
     * @return
     */
    @InheritInverseConfiguration(name = "dtoToVo2")
    UserDto voToDto(UserVo userVo);
}
