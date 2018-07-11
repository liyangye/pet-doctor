package com.pet.clinic.security.api;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.pet.clinic.security.util.PropertiesUtil;

import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date;

/**
 * JWT类
 * @author yangye.li
 *
 */
public class JWT {
	
	private  String auth = "pet.doctor.auth.key";

	public  String createJWT(String id, String issuer, String subject, long ttlMillis) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		String authKey = PropertiesUtil.getValue(auth);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(authKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		return builder.compact();

	}

	public  Claims parseJWT(String jwt) {
		String authKey = PropertiesUtil.getValue(auth);
		
		if(jwt.split("\\.").length == 3){
			Claims claims = null;
			try {
				claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(authKey)).parseClaimsJws(jwt).getBody();
				String sign = createJWT(claims.getId(),claims.getIssuer(),claims.getSubject(),claims.getExpiration().getTime());
				if(sign.equals(jwt.split("\\.")[2])){
					return claims;
				}else{
					throw new RuntimeException("校验失败,Token验证非法异常");
				}
			} catch (Exception e) {
				throw new RuntimeException("校验失败,Token验证非法异常");
			}
		}else{
			throw new RuntimeException("校验失败,Token验证非法异常");
		}
	}
}
