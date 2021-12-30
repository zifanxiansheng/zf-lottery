package top.zifanxiansheng.zf_lottery.domain.support.context;

import top.zifanxiansheng.zf_lottery.common.Constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 16:35
 **/
public final class LotteryContextHolder {


    private static final Map<Constants.IPair, Object> STRATEGY_CONTEXT_MAP = new ConcurrentHashMap<>();


    public static Map<Constants.IPair, Object> getStrategyContextMap() {
        return STRATEGY_CONTEXT_MAP;
    }


    public static <T> T get(Constants.IPair iPair, Class<T> cls) {


        return (T) STRATEGY_CONTEXT_MAP.get(iPair.get());
    }


}
