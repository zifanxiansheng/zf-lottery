package top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow;

import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.utils.SpringBeanUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 10:58
 **/
@Component
public class StateConfig {

    protected static final Map<Constants.ActivityStateEnum, AbstractStateHandler> ACTIVITY_STATE_HANDLER_MAP = new ConcurrentHashMap<>();
    @Resource
    private SpringBeanUtils springBeanUtils;

    @PostConstruct
    public void initStateConfig() {

//        springBeanUtils.registerAnnotationMap(ActivityState.class, AbstractStateHandler.class, ACTIVITY_STATE_HANDLER_MAP);

    }

}
