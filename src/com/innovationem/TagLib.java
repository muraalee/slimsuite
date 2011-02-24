package com.innovationem;

import com.innovationem.util.ConversionUtil;

import org.slim3.util.StringUtil;

/**
 * Created by IntelliJ IDEA. User: Murali Date: Jun 20, 2010 Time: 6:29:20 PM To
 * change this template use File | Settings | File Templates.
 */
public class TagLib {

	public static boolean contains(java.util.List list, java.lang.Object key) {
		return list != null && list.contains(key);
	}

	public static boolean containsList(java.util.List sourceList,
			java.util.List targetList) {
		if (sourceList == null || targetList == null)
			return false;
		for (Object item : targetList) {
			if (sourceList.contains(item))
				return true;
		}
		return false;
	}

	public static java.lang.String thumbNail(String picasaURI, String fileName,
			java.lang.Integer size) {
		if (StringUtil.isEmpty(picasaURI))
			if (size == 32)
				return "/images/noprofile32.jpg";
			else
				return "/images/noprofile.jpg";
		else
			return picasaURI + "s" + size + "/" + fileName;
	}

	public static java.lang.String toDateString(java.lang.Integer date) {
		return ConversionUtil.dateIntegerToString(date);
	}

	public static java.lang.String truncate(String name, int length) {
		if (StringUtil.isEmpty(name))
			return name;
		if (name.length() < length)
			return name;
		name = name.substring(0, length - 3) + "...";
		return name;
	}

}
