package top.zifanxiansheng.zf_lottery.domain.strategy.service.handler;

import top.zifanxiansheng.zf_lottery.domain.strategy.model.req.DrawExecReq;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.res.DrawExecRes;

public interface DrawExec {

    /**
     * 对外提供抽奖的统一入口
     *
     * @param req 抽奖请求包装
     * @return 抽奖结果包装
     */
    DrawExecRes drawExec(DrawExecReq req);

    //TODO 抽奖抽奖统一入口，动态选择执行策略
}
