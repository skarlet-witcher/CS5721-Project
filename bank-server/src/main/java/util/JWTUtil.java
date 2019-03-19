package util;

import Const.Server;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import rpc.UserLoginReply;

import javax.crypto.SecretKey;
import java.util.Date;

public class JWTUtil {

    public static String tokenGenerate(UserLoginReply loginReply) {
        //The JWT signature algorithm we will be using to sign the token

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //We will sign our JWT with our ApiKey secret
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        byte[] keyBytes = Server.JWT_SECRETKEY.getBytes() ;
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .claim("User_id", loginReply.getUserId())
                .claim("Module name","Software Architecture")
                .setIssuedAt(now)
                .setIssuer("Nuclear Bank")
                .signWith(key);

        //if it has been specified, let's add the expiration
        if (Server.SESSION_TIME > 0) {
            long expMillis = nowMillis + Server.SESSION_TIME;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Jws verifyJWTToken(String jwtToken){
        jwtToken = " a";
        byte[] keyBytes = Server.JWT_SECRETKEY.getBytes() ;
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        try {
            Jws jws = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwtToken);
            return  jws;
        }catch (ExpiredJwtException expiredJwtException){
            throw new ExpiredJwtException(null,null,"Expired token");
        }catch (SignatureException e){
            throw new SignatureException("Invalid signature");
        }
    }
}
