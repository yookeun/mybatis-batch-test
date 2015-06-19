import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * utils class for Ibatis 
 * 
 * example:
 * <pre>
 * 	&lt;if test="@Ognl@isNotEmpty(userId)">
 *		and user_id = #{userId}
 *	&lt;/if>
 * </pre>
 * @author badqiu
 *
 */

/**
 * mybatis의 각 xml 파일에서 사용하는 클래스이다. 현재 디폴트 패키지를 그대로 유지할 것!!! 소스출처 :
 * http://code.google.com/p/mybatis/issues/detail?id=210
 * 
 * @author ykkim
 * 
 */
public class Ognl {

	/**
	 * test for Map,Collection,String,Array isEmpty
	 * 
	 * @param o
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object o) throws IllegalArgumentException {

		if (o == null)
			return true;

		if (o instanceof String) {
			if (((String) o).length() == 0) {
				return true;
			}
		} else if (o instanceof Collection) {
			if (((Collection) o).isEmpty()) {
				return true;
			}
		} else if (o.getClass().isArray()) {
			if (Array.getLength(o) == 0) {
				return true;
			}
		} else if (o instanceof Map) {
			if (((Map) o).isEmpty()) {
				return true;
			}
		} else {
			return false;
			// throw new
			// IllegalArgumentException("Illegal argument type,must be : Map,Collection,Array,String. but was:"+o.getClass());
		}

		return false;
	}

	/**
	 * test for Map,Collection,String,Array isNotEmpty
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}

	public static boolean isNotBlank(Object o) {
		return !isBlank(o);
	}



	public static boolean isBlank(Object o) {
		if (o == null)
			return true;
		if (o instanceof String) {
			String str = (String) o;
			return isBlank(str);
		}
		return false;
	}

	public static boolean isBlank(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}

		for (int i = 0; i < str.length(); i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 주어진 문자열이 존재하는 체크
	 * 
	 * @author ykkim
	 * @param o
	 * @param str
	 * @return
	 */
	public static boolean isEqual(Object o, String str) {
		if (o == null)
			return false;
		if (o instanceof String) {
			if (((String) o).equals(str)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * 주어진 문자열이 존재하지 않는 지 체크
	 * 
	 * @author ykkim
	 * @param o
	 * @param str
	 * @return
	 */
	public static boolean isNotEqual(Object o, String str) {
		return !isEqual(o, str);
	}	
}
