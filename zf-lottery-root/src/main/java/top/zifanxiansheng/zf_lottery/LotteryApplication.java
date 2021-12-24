package top.zifanxiansheng.zf_lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 11:27
 **/
@SpringBootApplication
@MapperScan(basePackages = "top.zifanxiansheng.zf_lottery.infrastructure")
public class LotteryApplication {

    public static void main(String[] args) {

    }
}
