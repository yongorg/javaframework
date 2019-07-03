package org.yong.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页对象
 * @param <E>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<E> {

    private int totalCount;     // 总记录数
    private int totalPage;      // 总页码
    private List<E> list;       // 数据
    private int currentPage;    // 当前页码
    private int rows;           // 每页显示条数

}
