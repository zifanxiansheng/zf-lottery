package top.zifanxiansheng.zf_lottery.domain.support.ids.poliicy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.support.ids.IDGenerator;
import top.zifanxiansheng.zf_lottery.domain.support.ids.annotation.Ids;

import javax.annotation.PostConstruct;

/**
 * @Author 梓樊先生
 * @Date 2021/12/30 14:15
 **/
@Component
@Ids(value = Constants.IdsEnum.SnowFlake)
public class SnowFlake implements IDGenerator {
    private Snowflake snowflake;

    @PostConstruct
    public void init() {
        // 0 ~ 31 位，可以采用配置的方式使用
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }

        workerId = workerId >> 16 & 31;

        final long dataCenterId = 1L;
        snowflake = IdUtil.getSnowflake(workerId, dataCenterId);
    }

    @Override
    public synchronized Long nextId() {
        return snowflake.nextId();
    }

}
