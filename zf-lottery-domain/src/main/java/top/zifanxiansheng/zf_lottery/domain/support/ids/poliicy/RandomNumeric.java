package top.zifanxiansheng.zf_lottery.domain.support.ids.poliicy;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.support.ids.IDGenerator;
import top.zifanxiansheng.zf_lottery.domain.support.ids.annotation.Ids;

/**
 * @Author 梓樊先生
 * @Date 2021/12/30 14:18
 **/
@Component
@Ids(value = Constants.IdsEnum.RandomNumeric)
public class RandomNumeric implements IDGenerator {
    @Override
    public Long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
