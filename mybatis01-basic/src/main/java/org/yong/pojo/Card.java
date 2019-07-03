package org.yong.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    private Integer cardNo;
    private Integer userId;
    private Integer bankId;
    private String cardType;
}
