package com.submerge.subfriends.common;

import lombok.Data;

/**
 * ClassName: PageRequest
 * Package: com.submerge.subfriends.common
 * Description: 分页请求参数
 *
 * @Author Submerge--WangDong
 * @Create 2024-03-09 16:53
 * @Version 1.0
 */
@Data
public class PageRequest {

    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前是第几页
     */
    protected int pageNum = 1;
}
