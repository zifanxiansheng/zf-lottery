package top.zifanxiansheng.zf_lottery.domain.strategy.model.req;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DrawExecReq {

    private Long strategyId;

    private String uId;

    private String uuid;
}
