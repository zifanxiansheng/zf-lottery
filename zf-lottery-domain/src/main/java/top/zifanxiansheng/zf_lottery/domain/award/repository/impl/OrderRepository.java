package top.zifanxiansheng.zf_lottery.domain.award.repository.impl;

import org.springframework.stereotype.Repository;
import top.zifanxiansheng.zf_lottery.domain.award.repository.IOrderRepository;

/**
 * @Author 梓樊先生
 * @Date 2021/12/28 13:26
 **/
@Repository
public class OrderRepository implements IOrderRepository {
    @Override
    public int updateAwardState(String uId, String awardId, Long orderId, Integer grantState) {
        return 0;
    }
}
