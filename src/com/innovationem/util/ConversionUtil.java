package com.innovationem.util;

import org.slim3.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: murali
 * Date: Jul 25, 2010
 * Time: 2:33:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConversionUtil {

    public static List<String> STOP_WORDS = new ArrayList<String>();

    static {
        STOP_WORDS.add("a");
        STOP_WORDS.add("an");
        STOP_WORDS.add("and");
        STOP_WORDS.add("the");
        STOP_WORDS.add("this");
        STOP_WORDS.add("of");
        STOP_WORDS.add("for");
        STOP_WORDS.add("to");
        STOP_WORDS.add("is");
    }

    public static void main(String[] args) {
        System.out.println(dateIntegerToString(20101001));
        System.out.println("" + dateStringToInteger("10/01/2010"));
    }

    // String date format 2009-10-28T15:36:15.000-0400, YYYYMMDD

    public static Integer extractDateIntegerFromString(String stringDate) {
        Integer integerDate = null;
        if (!StringUtil.isEmpty(stringDate)) {
            try {
                stringDate = stringDate.replaceAll("[-]", "");
                integerDate = Integer.parseInt(stringDate.substring(0, 8));
            } catch (Exception e) {
            }
        }
        return integerDate;
    }

    // Return format YYYYMMDD 20101001, input format 08/13/2010

    public static Integer dateStringToInteger(String date) {
        if (StringUtil.isEmpty(date)) return 0;
        String[] elements = date.split("[/]");
        if (elements[0].trim().length() == 1) elements[0] = "0" + elements[0];
        if (elements[1].trim().length() == 1) elements[1] = "0" + elements[1];
        String dateStr = elements[2] + elements[0] + elements[1];
        return Integer.parseInt(dateStr);
    }

    // Input format 20101001

    public static String dateIntegerToString(Integer date) {
        if (date == null || date.equals(0)) return "";
        String dateStr = "" + date;
        return dateStr.substring(4, 6) + "/" + dateStr.substring(6, 8) + "/" + dateStr.substring(0, 4);
    }

    public static Date dateIntegerToDate(Integer dateInteger) {
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
            return dateformat.parse("" + dateInteger);
        } catch (Exception e) {
        }
        return null;
    }

    public static String extension(String fileName) {
        return extractSuffix(fileName, ".");
    }

    public static String extractEmailPrefix(String name) {
        return extractPrefix(name, "@gmail.com");
    }

    public static String extractPrefix(String name, String suffixDelimiter) {
        if (!StringUtil.isEmpty(name)) {
            int index = name.lastIndexOf(suffixDelimiter);
            if (index > 0) {
                return name.substring(0, index);
            }
        }
        return name;
    }

    public static String extractSuffix(String name, String suffixDelimiter) {
        if (!StringUtil.isEmpty(name)) {
            int index = name.lastIndexOf(suffixDelimiter);
            if (index > 0) {
                return name.substring(index + 1, name.length());
            }
        }
        return name;
    }

    public static String extractID(String picasaID) {
        return extractSuffix(picasaID, "/");
    }

    public static List<String> extractTermsFromText(String string) {
        List<String> termList = new ArrayList<String>();
        if (StringUtil.isEmpty(string)) return termList;
        string = string.replaceAll(",", " ");
        string = string.replaceAll("<", " ");
        string = string.replaceAll(">", " ");
        string = string.replaceAll("text", " ");
        string = string.replaceAll("\\b\\s{2,}\\b", " "); // remove multiple white spaces
        if (!StringUtil.isEmpty(string)) {
            String[] terms = string.split(" ");
            for (String term : terms) {
                if (!STOP_WORDS.contains(term))
                    termList.add(term.toLowerCase());
            }
        }
        return termList;
    }

    public static String prepareString(String termString) {
        termString = termString.replaceAll(",", " ");
        termString = termString.replaceAll("\\b\\s{2,}\\b", " ");
        String[] terms = termString.split(" ");
        Set<String> termList = new LinkedHashSet<String>();

        for (String term : terms) {
            if (!STOP_WORDS.contains(term))
                termList.add(term.toLowerCase());
        }
        StringBuilder cleanTerms = new StringBuilder();
        for (String term : termList) {
            cleanTerms.append(term).append(" ");
        }
        return cleanTerms.toString().trim();
    }

    private static String[] _extractTerms(String termString) {
        if (StringUtil.isEmpty(termString)) return null;
        termString = prepareString(termString);
        termString = termString.toLowerCase();
        return termString.split(" ");
    }

    public static List<String> extractTerms(String termString) {
        List<String> termList = new ArrayList<String>();
        if (StringUtil.isEmpty(termString)) return termList;
        String[] terms = _extractTerms(termString);
        termList.addAll(Arrays.asList(terms));
        termList.add(termString.toLowerCase());
        return termList;
    }

    public static List<String> prepareComboTerms(String termString) {
        List<String> termList = new ArrayList<String>();
        if (StringUtil.isEmpty(termString)) return termList;
        String[] terms = _extractTerms(termString);

        List<String> comboList = new ArrayList<String>();
        for (int i = 0; i < terms.length - 1; i++) {
            comboList.add(terms[i] + " " + terms[i + 1]);
        }
        termList.addAll(Arrays.asList(terms));
        termList.addAll(comboList);
        if (terms.length > 2) termList.add(prepareString(termString).toLowerCase());
        return termList;
    }

    public static String mimeType(String fileName) {
        String extension = extension(fileName);
        String mimeType = "image/jpeg";
        if (!StringUtil.isEmpty(extension)) {
            if (extension.equalsIgnoreCase("png")) mimeType = "image/png";
            else if (extension.equalsIgnoreCase("gif")) mimeType = "image/gif";
        }
        return mimeType;
    }

    public static List<Long> stringArrayToLongList(String[] stringArray) {
        if (stringArray == null) return new ArrayList<Long>();
        List<Long> longList = new ArrayList<Long>(stringArray.length);
        for (String id : stringArray) {
            Long idLong = Long.parseLong(id);
            if (!longList.contains(idLong))
                longList.add(idLong);
        }
        return longList;
    }

    public static List<Long> stringToLongList(String idString) {
        if (StringUtil.isEmpty(idString)) return new ArrayList<Long>();
        String[] ids = idString.split(",");
        List<Long> longList = new ArrayList<Long>(ids.length);
        for (String id : ids) {
            Long idLong = Long.parseLong(id);
            if (!longList.contains(idLong))
                longList.add(idLong);
        }
        return longList;
    }

}
