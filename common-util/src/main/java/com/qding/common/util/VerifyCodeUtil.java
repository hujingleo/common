package com.qding.common.util;

import java.util.Random;

public class VerifyCodeUtil {

	/**
	 * 获取4位随即数
	 * 
	 * @return
	 */
	public static int getVerificationCode() {
		int retValue = 0;
		Random random = new Random();

		do {
			retValue = random.nextInt(9999);
		} while (retValue < 1000 || retValue > 9999);

		return retValue;
	}

}
