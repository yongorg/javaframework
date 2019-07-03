package org.yong.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankUser {
    private Integer uid;
    private String username;
    private Integer bankId;
    private Integer money;
    private String password;
    private String name;
    private Bank bank; // 封装Bank对象
    private List<Card> cards;  // 封装银行卡
}
