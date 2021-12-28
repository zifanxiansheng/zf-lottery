package top.zifanxiansheng.zf_lottery.domain.activity.service.assembler;

import org.mapstruct.Mapper;
import top.zifanxiansheng.zf_lottery.common.assembler.IMapping;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityInfo;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Activity;

@Mapper(componentModel = "spring")
public interface ActivityMapping extends IMapping<ActivityInfo, Activity> {


}
