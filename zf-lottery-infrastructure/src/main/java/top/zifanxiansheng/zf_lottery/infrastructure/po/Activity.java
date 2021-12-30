package top.zifanxiansheng.zf_lottery.infrastructure.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 活动配置
 */
@Data
@Builder
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 自增ID
     */
    private Long id;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动描述
     */
    private String activityDesc;
    /**
     * 开始时间
     */
    private LocalDateTime beginDateTime;
    /**
     * 结束时间
     */
    private LocalDateTime endDateTime;
    /**
     * 库存
     */
    private Integer stockCount;
    /**
     * 库存剩余
     */
    private Integer stockSurplusCount;
    /**
     * 每人可参与次数
     */
    private Integer takeCount;
    /**
     * 抽奖策略ID
     */
    private Long strategyId;
    /**
     * 活动状态：1编辑、2提审、3撤审、4通过、5运行(审核通过后worker扫描状态)、6拒绝、7关闭、8开启
     */
    private Integer state;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}