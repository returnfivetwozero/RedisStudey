package com.heima.controller;/**
 * @author Mr.Wang
 * @create 2023-10-22-16:21
 */

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@ClassName RedisContoller
 *@Description TODO
 *@Author Mr.Wang
 *@Date 2023/10/22 16:21
 *@Version 1.0
 */
@RestController
public class RedisContoller {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/get/{key}")
    public String get(@PathVariable(value = "key") String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
    @GetMapping("/set/{key}/{value}")
    public String set(@PathVariable(value = "key")String key , @PathVariable String value){
        stringRedisTemplate.opsForValue().set(key,value);
        return "success";
    }
}


