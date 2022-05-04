package com.example.carleasingclub_monolith.common.utils;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-03 17:19
 */

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chennanjiang
 * @date Created in 2022/5/3 17:19
 * @description JwtToken工具类
 */
@Component
public class JwtTokenUtil {
    //定义荷载信息
    //用户名的key
    private static final String CLAIM_KEY_USERNAME="club";
    //创建时间
    private static final String CLAIM_KEY_CREATED="created";
    //通过@value(),获取配置中的密钥和失效时间
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /***
     * @Description  根据用户信获取Token
     * @author chennanjiang
     * @date 2022/5/3 17:43
     * @params [userDetails]
     * @return java.lang.String
     */
    public String getToken(UserDetails userDetails){
        //定义荷载
        Map<String,Object> claim=new HashMap<>();
        claim.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claim.put(CLAIM_KEY_CREATED,new Date());
        return createTokenByClaim(claim);
    }
    /***
     * @Description 根据荷载创建Token令牌
     * @author chennanjiang
     * @date 2022/5/3 17:50
     * @params [claims]
     * @return java.lang.String
     */
    private String createTokenByClaim(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                //生成失效时间与失效时间的转换
                .setExpiration(resoveExpitartionDate())
                //签名
                .signWith(SignatureAlgorithm.ES512,secret)
                .compact();
    }
    /***
     * @Description 生成失效时间
     * @author chennanjiang
     * @date 2022/5/3 17:54
     * @params []
     * @return java.util.Date
     */
    private Date resoveExpitartionDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }





    /**
     * @Description  从Token中获取登录用户的用户名
     * @author chennanjiang
     * @date 2022/5/3 18:05
     * @params [token]
     * @return java.lang.String
     */
    public String getUsenameByToken(String token){
        String username;
        //从Token中获取荷载
        try {
            Claims claims=getClaimsFromToken(token);
            username=claims.getSubject();
        } catch (Exception e) {
            username=null;
        }
        return username;
    }
    /**
     * @Description   从Token中获取荷载
     * @author chennanjiang
     * @date 2022/5/3 18:17
     * @params [token]
     * @return io.jsonwebtoken.Claims
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims=null;
        try {
            claims=Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }






    /***
     * @Description 验证Token是否有效
     * @author chennanjiang
     * @date 2022/5/3 18:23
     * @params [token, userDetails]
     * @return boolean
     */
    public boolean validateToken(String token,UserDetails userDetails){
        //获取token中的用户名
        String username=getUsenameByToken(token);
        //判断token中的用户名与UserDetails中的用户名是否一致，token是否过期
        return username.equals(userDetails.getUsername()) && isTokenExpired(token);

    }
    /***
     * @Description 判断token是否失效
     * @author chennanjiang
     * @date 2022/5/3 18:28
     * @params [token]
     * @return boolean
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate=getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }
    /***
     * @Description 从token中获取失效时间
     * @author chennanjiang
     * @date 2022/5/3 18:31
     * @params [token]
     * @return java.util.Date
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims=getClaimsFromToken(token);
        return claims.getExpiration();
    }



    /***
     * @Description 刷新Token
     * @author chennanjiang
     * @date 2022/5/3 18:41
     * @params [token]
     * @return java.lang.String
     */
    public String refreshToken(String token){
        Claims claims=getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return createTokenByClaim(claims);
    }



    /***
     * @Description 是否刷新token
     * @author chennanjiang
     * @date 2022/5/3 18:39
     * @params [token]
     * @return boolean
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

}
