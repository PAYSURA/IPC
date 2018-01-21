/**
 * 
 */
package com.paysura.util.jwt;

import java.security.Key;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paysura.exception.JWT.InvalidJwtTokenException;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * @author abaklizki
 * @since 21.01.2018
 * @version 1.0
 *
 */
public final class JWTUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JWTUtil.class);
	private static Key key = MacProvider.generateKey();

	/**
	 *
	 * @param payload
	 *            The payload for the key.
	 * @return {@link Jwt} token.
	 */
	public static final String signJWT(final String payload) {
		String jwt = Jwts.builder().setPayload(payload).signWith(SignatureAlgorithm.HS512, JWTUtil.key).compact();
		assert Jwts.parser().setSigningKey(JWTUtil.key).parseClaimsJws(jwt).getBody().equals(payload);
		return jwt;
	}

	/**
	 * Checks if the {@link JWT} token is valid or not.
	 * 
	 * @param jwt
	 *            The given token.
	 * @return True, if valid, false else.
	 */
	private static final boolean isValid(final String jwt) {
		boolean result;
		try {
			Jwts.parser().setSigningKey(JWTUtil.key).parseClaimsJws(jwt);
			result = true;
		} catch (SignatureException e) {
			result = false;
			LOGGER.error("JWT token is not valid", e);
		}
		return result;
	}

	/**
	 * Check and validate an given {@link Jwt} token.
	 * 
	 * @param token
	 *            The JWT token.
	 * @throws InvalidJwtTokenException
	 *             Will be thrown, if the token is not valid.
	 */
	public static final void isTokenValid(final String token) throws InvalidJwtTokenException {
		if (!JWTUtil.isValid(token)) {
			throw new InvalidJwtTokenException("JWT Token is not valid.");
		}

	}

	/**
	 * Private constructor.
	 */
	private JWTUtil() {

	}
}