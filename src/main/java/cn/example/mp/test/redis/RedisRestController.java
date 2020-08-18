package cn.example.mp.test.redis;

import cn.example.mp.test.common.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/rest/redis")
@Api(value="Redis云数据缓存接口", description="Redis云数据缓存接口")
public class RedisRestController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/test",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis Test信息(Content-Type为text/html)", notes="Redis Test(Content-Type为text/html)")
    public ResultBody  test(){
        redisUtils.set("Redis Test", "Redis Test");
        String string= redisUtils.get("Redis Test").toString();
        return ResultBody.success("测试成功",string);
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    @RequestMapping(value ="/removeList",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis remove接口(Content-Type为text/html)", notes="Redis remove接口(Content-Type为text/html)")
    public ResultBody removeList(@RequestParam(required=false) String keys) {
        String [] keysList=keys.split(",");
        for(String key:keysList) {
            redisUtils.remove(key);
        }
        return ResultBody.success("移除成功！");
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    @RequestMapping(value ="/removePattern",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis remove pattern接口(Content-Type为text/html)", notes="Redis remove pattern接口接口(Content-Type为text/html)")
    public ResultBody removePattern(@RequestParam(required=false) String pattern) {
        redisUtils.removePattern(pattern);
        return ResultBody.success("移除成功！");
    }

    @RequestMapping(value ="/removePatternShiroRedis",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis remove pattern Shiro Reids接口(Content-Type为text/html)", notes="Redis remove pattern Shiro Reids接口接口(Content-Type为text/html)")
    public ResultBody removePatternShiroReids(@RequestParam(required=false) String pattern) {
        redisUtils.removePatternShiroReids(pattern);
        return ResultBody.success("移除成功！");
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    @RequestMapping(value ="/remove",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis remove接口(Content-Type为text/html)", notes="Redis remove接口(Content-Type为text/html)")
    public ResultBody remove(@RequestParam(required=false) String key) {
        redisUtils.remove(key);
        return ResultBody.success("移除成功！");
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    @RequestMapping(value ="/exists",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis exists接口(Content-Type为text/html)", notes="Redis exists接口(Content-Type为text/html)")
    public ResultBody exists(@RequestParam(required=false) String key) {
        if(redisUtils.exists(key)) {
            return ResultBody.success("存在！");
        } else {
            return ResultBody.error("不存在！");
        }
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value ="/get",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis get接口(Content-Type为text/html)", notes="Redis get接口(Content-Type为text/html)")
    public ResultBody get(@RequestParam(required=false) String key) {
        if(redisUtils.exists(key)){
            Object obj=redisUtils.get(key);
            if(obj!=null) {
                return ResultBody.success(obj.toString());
            }
        }
        return ResultBody.error("不存在！");

    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    @RequestMapping(value ="/set",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis set接口(Content-Type为text/html)", notes="Redis set接口(Content-Type为text/html)")
    public ResultBody set(@RequestParam(required=false) String key, @RequestParam(required=false)  String value) {
        if(redisUtils.set(key,value)){
            return ResultBody.success("添加/更新成功！");
        }else{
            return ResultBody.error("添加/更新失败！");
        }
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    @RequestMapping(value ="/setExpireTime",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis set expireTime接口(Content-Type为text/html)", notes="Redis set expireTime接口接口(Content-Type为text/html)")
    public ResultBody set(@RequestParam(required=false) String key, @RequestParam(required=false) String value, @RequestParam(required=false) Long expireTime) {
        if(redisUtils.set(key,value,expireTime)){
            return ResultBody.success("添加/更新成功！");
        }else{
            return ResultBody.error("添加/更新失败！");
        }
    }

    /**
     * 获取keys
     *
     * @param pattern
     */
    @RequestMapping(value ="/getKyes",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis get kyes接口(Content-Type为text/html)", notes="Redis get kyes接口接口(Content-Type为text/html)")
    public ResultBody getKyes(@RequestParam(required=false) String pattern) {
        Set<String> keys = redisUtils.getKyes(pattern);
        return ResultBody.success("获取Keys成功！",keys);
    }

    @RequestMapping(value ="/getKyesAll",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis get kyes all接口(Content-Type为text/html)", notes="Redis get kyes all接口(Content-Type为text/html)")
    public ResultBody getKyesAll() {
        Set<String> keys = redisUtils.getKyesAll();
        return ResultBody.success("获取Keys成功！",keys);
    }

    /**
     * 获取keys
     *
     * @param pattern
     */
    @RequestMapping(value ="/getCount",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis get count接口(Content-Type为text/html)", notes="Redis get count接口(Content-Type为text/html)")
    public ResultBody getCount(@RequestParam(required=false) String pattern) {
        int count = redisUtils.getCount();
        return ResultBody.success("获取数量成功！",count);
    }

    @RequestMapping(value ="/getCountShiro",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis get count shiro接口(Content-Type为text/html)", notes="Redis get count shiro接口(Content-Type为text/html)")
    public ResultBody getCountShiro(@RequestParam(required=false) String pattern) {
        int countShiro = redisUtils.getCountShiro();
        return ResultBody.success("获取数量成功！",countShiro);
    }

    /**
     * 获取token的有效期（秒）
     * @param key
     */
    @RequestMapping(value ="/getExpireTime",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis get ExpireTime接口(Content-Type为text/html)", notes="Redis get ExpireTime接口接口(Content-Type为text/html)")
    public ResultBody getExpireTime(@RequestParam(required=false) String key){
        long expireTime = redisUtils.getExpireTime(key);
        return ResultBody.success("获取token的有效期（秒）成功！",expireTime);
    }

    /**
     * 获取缓存有效期成功
     */
    @RequestMapping(value ="/getExpire",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis get getExpire(Content-Type为text/html)", notes="Redis get getExpire(Content-Type为text/html)")
    public ResultBody getExpire(){
        String expire = RedisUtils.getExpire();
        return ResultBody.success("获取缓存有效期成功！",expire);
    }

    /**
     * 获取单点登录缓存有效期成功
     */
    @RequestMapping(value ="/getExpireShiro",method ={RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value="Redis get getExpireShiro(Content-Type为text/html)", notes="Redis get getExpireShiro(Content-Type为text/html)")
    public ResultBody getExpireShiro(){
        String expireShiro = RedisUtils.getExpireShiro();
        return ResultBody.success("获取单点登录缓存有效期成功！",expireShiro);
    }
}