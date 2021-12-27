package top.zifanxiansheng.zf_lottery.domain.award.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistributeRes {

    private String uId;
    private Integer code;
    private String info;
    /**
     * 结算单ID，如：发券后有券码、发货后有单号等，用于存根查询
     */
    private String statementId;
}
