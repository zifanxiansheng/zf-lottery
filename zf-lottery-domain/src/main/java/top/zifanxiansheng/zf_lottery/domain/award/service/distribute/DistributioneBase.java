package top.zifanxiansheng.zf_lottery.domain.award.service.distribute;

import lombok.extern.slf4j.Slf4j;
import top.zifanxiansheng.zf_lottery.domain.award.repository.IOrderRepository;

import javax.annotation.Resource;

@Slf4j
public class DistributioneBase {

    @Resource
    IOrderRepository orderRepository;

    protected boolean updateAwardState(String uId, Long orderId, Integer awardState, String awardId) {
        int count = orderRepository.updateAwardState(uId, awardId, orderId, awardState);
        return count == 1;
    }
}
