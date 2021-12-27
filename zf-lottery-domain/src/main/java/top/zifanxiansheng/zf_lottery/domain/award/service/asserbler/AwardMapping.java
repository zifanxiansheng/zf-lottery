package top.zifanxiansheng.zf_lottery.domain.award.service.asserbler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.common.assembler.IMapping;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Award;

@Mapper(componentModel = "spring")
public interface AwardMapping extends IMapping<Award, AwardInfo> {

    @Mapping(target = "awardType", expression = "java(top.zifanxiansheng.zf_lottery.common.EnumUtils.getEnumByCode(var1.getAwardType(), top.zifanxiansheng.zf_lottery.common.Constants.AwardTypeEnum.class))")
    @Override
    AwardInfo sourceToTarget(Award var1);

    @Override
    Award targetToSource(AwardInfo var1);

    default Integer map(Constants.AwardTypeEnum awardTypeEnum) {
        return awardTypeEnum.key();
    }
}
