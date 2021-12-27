package top.zifanxiansheng.zf_lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 策略配置
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Strategy implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 自增ID
     */
    private Long id;
    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 策略描述
     */
    private String strategyDesc;
    /**
     * 策略方式（1:单项概率、2:总体概率）
     */
    private Integer strategyMode;
    /**
     * 发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）
     */
    private Integer grantType;
    /**
     * 发放奖品时间
     */
    private LocalDateTime grantDate;
    /**
     * 扩展信息
     */
    private String extInfo;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 策略模式  1. 单项  2.总体
     */
    private Integer strategyModel;


}