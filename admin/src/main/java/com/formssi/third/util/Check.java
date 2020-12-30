package com.formssi.third.util;


public class Check {
	/***************************************************************************
	 * 检查目标对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	/***************************************************************************
	 * 检查目标对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj, String objName) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	/***************************************************************************
	 * 检查目标字符串是否为空字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) throws NullPointerException {
		// s不允许为空
		if (isNull(s)) {
			return true;
		}

		if (s.length() == 0) {
			return true;
		}
		return false;
	}

	/***************************************************************************
	 * 检查目标字符串是否等于给定长度
	 * 
	 * @param s
	 * @return
	 */
	public static boolean checkLength(String s, int length)
			throws NullPointerException {
		// s不允许为空
		if (isNull(s)) {
			return false;
		}

		if (s.length() == length) {
			return true;
		} else {
			return false;
		}

	}

	/***************************************************************************
	 * 比较两个对象
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static boolean equals(Object obj1, Object obj2) {
		// 判断是否为空
		if (isNull(obj1) || isNull(obj2)) {
			return false;
		}

		// 比较，比较规则由对象自己实现
		if (obj1.equals(obj2)) {
			return true;
		}

		return false;
	}

	/***************************************************************************
	 * 比较两个对象,如果相等输出错误信息
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static boolean equals(Object obj1, String obj1Name, Object obj2,
                                 String obj2Name) {
		if (equals(obj1, obj2)) {
			return true;
		}

		return false;
	}

	/***************************************************************************
	 * 比较两个整数,如果相等输出错误信息
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static boolean equals(int obj1, String obj1Name, int obj2,
                                 String obj2Name) {
		if (obj1 == obj2) {
			return true;
		}

		return false;
	}

	/***************************************************************************
	 * 是否boolean型值
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isBoolean(String s) {
		if (isNull(s)) {
			return false;
		}

		if ("false".equals(s.toLowerCase()) || "true".equals(s.toLowerCase())) {
			return true;
		}
		return false;
	}

	/***************************************************************************
	 * 是否double型值
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isDouble(String s) {
		if (isNull(s)) {
			return false;
		}

		if (s.indexOf(".") != s.lastIndexOf(".") || s.indexOf(".") == 0
				|| s.indexOf(".") == s.length() - 1) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '.') {
				if (c > '9' || c < '0') {
					return false;
				}
			}
		}

		return true;
	}

	/***************************************************************************
	 * 是否数字
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isDigit(String s) {
		if (isNull(s) || isEmpty(s)) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c > '9' || c < '0') {
				return false;
			}
		}

		return true;
	}

	/***************************************************************************
	 * 是否日期格式(yyyy-mm-dd)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isDate(String s) {
		if (!checkLength(s, 10)) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i == 4 || i == 7) {
				if (c != '-') {
					return false;
				}
			} else {
				if (c > '9' || c < '0') {
					return false;
				}
			}
		}

		return true;
	}

	/***************************************************************************
	 * 是否时间格式(hh:mm:ss)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isTime(String s) {
		if (!checkLength(s, 8)) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i == 2 || i == 5) {
				if (c != ':') {
					return false;
				}
			} else {
				if (c > '9' || c < '0') {
					return false;
				}
			}
		}

		return true;
	}

	// 判断是否为合法的全角
	public static boolean isSBC(String s) {
		int nLen = s.getBytes().length;

		// 判断是否有偶数个字节
		if ((nLen & 1) != 0) {
			return false;
		}

		for (int i = 0; i < nLen / 2; i++) {
			int lc = (byte) s.getBytes()[2 * i];
			lc = (lc >= 0 ? lc : 256 + lc);

			int rc = (byte) s.getBytes()[2 * i + 1];
			rc = (rc >= 0 ? rc : 256 + rc);

			if (lc <= 127 || rc <= 127) {
				return false;
			}
		}

		return true;
	}
}
