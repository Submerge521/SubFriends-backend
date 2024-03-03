package com.submerge.subfriends.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.submerge.subfriends.model.domain.User;
import com.submerge.subfriends.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: PreCacheJob
 * Package: com.submerge.subfriends.job
 * Description: 缓存预热任务
 *
 * @Author Submerge--WangDong
 * @Create 2024-03-02 15:16
 * @Version 1.0
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 重点用户
    private List<Long> mainUserList = Arrays.asList(1L);

    /**
     * 每天执行，预热推荐用户
     */
    @Scheduled(cron = "0 59 13 * * *")
    public void doCacheRecommendUser() {
        for (Long userId : mainUserList) {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            Page<User> userPage = userService.page(new Page<>(1, 20), userQueryWrapper);
            String redisKey = String.format("subfrineds:user:recommend:%s", userId);
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            try {
                valueOperations.set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                log.error("redis set key error:", e);
            }
        }

    }

}
