package top.zifanxiansheng.zf_lottery.domain.award.repository;

public interface IOrderRepository {


    int updateAwardState(String uId, String awardId, Long orderId, Integer grantState);
}
