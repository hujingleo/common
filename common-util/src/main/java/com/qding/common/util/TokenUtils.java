package com.qding.common.util;

import org.apache.commons.lang.StringUtils;

import com.qding.common.util.http.cookie.DESUtil;
import com.qding.common.util.http.cookie.XBase64;

public class TokenUtils {

	/**
	 * 生成token
	 * 
	 * @param userId
	 * @return
	 */
	public static String createToken(Long userId) {
		String token = null;
		try {
			token = DESUtil.encrypt(String.valueOf(userId).getBytes());
			token = XBase64.enReplace(token);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return token;
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	public static String parseToken(String token) {
		String detail = "";

		try {
			token = XBase64.deReplace(token);
			detail = DESUtil.decrypt(token.getBytes());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return detail;
	}

	/**
	 * 
	 * @param token
	 * @param userId
	 * @return
	 */
	public static Boolean isValidateToken(String token, Long userId) {
		if (StringUtils.isBlank(token) || null == userId) {
			return false;
		}
		String parsedUserId = parseToken(token);
		Long Id = MyMathUtil.getLong(parsedUserId);
		if (userId.equals(Id)) {
			return true;
		} else
			return false;
	}

}
