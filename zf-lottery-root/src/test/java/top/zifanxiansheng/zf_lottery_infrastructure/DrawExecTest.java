package top.zifanxiansheng.zf_lottery_infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.req.DrawExecReq;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.res.DrawExecRes;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.handler.DrawExec;

import javax.annotation.Resource;

@Slf4j
public class DrawExecTest extends BaseTest {

    @Resource
    private DrawExec drawExec;

    @Test
    public void draw_exec_test() {

        DrawExecRes drawExecRes = drawExec.drawExec(DrawExecReq.builder().strategyId(10001L).uId("张三").build());
        log.info("drawExecRes: {}", JSON.toJSONString(drawExecRes));
    }
}
