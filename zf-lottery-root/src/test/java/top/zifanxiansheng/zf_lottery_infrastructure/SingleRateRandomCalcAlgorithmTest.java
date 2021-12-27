package top.zifanxiansheng.zf_lottery_infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SingleRateRandomCalcAlgorithmTest extends BaseTest {
    private final int HASH_INCREMENT = 0x61c88647; // 黄金分割线
    private final int RATE_TUPLE_LENGTH = 128;


    @Test
    public void test_hash_index() {

        for (int i = 20; i < 200; i++) log.info(hashIdx(i) + "");

    }

    public int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }

    @Test
    public void lottery_algorithm_handler_map_test() {


    }
}
