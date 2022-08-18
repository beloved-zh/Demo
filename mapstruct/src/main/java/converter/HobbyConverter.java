package converter;

import dto.HobbyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vo.HobbyVo;

/**
 * @Author: Beloved
 * @CreateTime: 2022-08-15 16:35
 * @Description: Hobby转换器
 */
@Mapper
public interface HobbyConverter {

    // 获取对象
    HobbyConverter INSTANCE = Mappers.getMapper(HobbyConverter.class);

    HobbyVo dtoToVo(HobbyDto hobbyDto);
}
