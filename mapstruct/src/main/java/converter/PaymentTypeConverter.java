package converter;

import enums.PaymentType;
import enums.PaymentTypeView;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @Author: Beloved
 * @CreateTime: 2022-08-15 17:08
 * @Description: 枚举转换器
 */
@Mapper
public interface PaymentTypeConverter {

    PaymentTypeConverter INSTANCE = Mappers.getMapper(PaymentTypeConverter.class);


    /**
     * 通过 ValueMapping 直接指定
     * @param paymentType
     * @return
     */
    @ValueMappings({
        @ValueMapping(source = "CARD_VISA", target = "CARD"),
        @ValueMapping(source = "CARD_MASTER", target = "CARD"),
        @ValueMapping(source = "CARD_CREDIT", target = "CARD")
    })
    PaymentTypeView paymentTypeToPaymentTypeView(PaymentType paymentType);

    @InheritInverseConfiguration(name = "paymentTypeToPaymentTypeView")
    PaymentType paymentTypeViewToPaymentType(PaymentTypeView view);
    /**
     * MappingConstants.ANY_REMAINING
     *  在目标枚举中找不到相同名称的枚举项,直接转换为对应的另一个枚举项。
     * @param paymentType
     * @return
     */
    @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "CARD")
    PaymentTypeView paymentTypeToPaymentTypeView2(PaymentType paymentType);

    /**
     * MappingConstants.ANY_UNMAPPED
     * 直接将所有未通过@ValueMapping注解做显式映射的值都转换为target值
     * @param paymentType
     * @return
     */
    @ValueMappings({
        @ValueMapping(source = "CHEQUE", target = "CHEQUE"),
        @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "CARD")
    })
    PaymentTypeView paymentTypeToPaymentTypeView3(PaymentType paymentType);
}
