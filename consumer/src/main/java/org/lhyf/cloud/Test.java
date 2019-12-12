package org.lhyf.cloud;

import java.math.BigDecimal;

/**
 * @author yangfan
 * @date 2019/12/12 22:47
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        BigDecimal amount = BigDecimal.ZERO ;
        BigDecimal add = amount.add(new BigDecimal(100));
        System.out.println(amount);
        System.out.println(add);
    }
}
