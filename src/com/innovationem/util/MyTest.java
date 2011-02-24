package com.innovationem.util;

import com.google.gdata.client.http.AuthSubUtil;
import org.slim3.util.StringUtil;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: murali
 * Date: Aug 9, 2010
 * Time: 9:07:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyTest {
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
    }

    public static void main(String[] args) {
        System.out.println(prepareComboTerms("Rainbow Cafe Nice Cool"));

    }

    private static String prepareString(String termString) {
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
        return cleanTerms.toString();
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
        termList.add(prepareString(termString).toLowerCase());
        return termList;
    }

    public static void picasaTest() {
        try {
            String token = "%2FeIyjbToyqqXmKnSCORK7gb_NParu9cqSIZBMxb3t7h8";
            String picasaAuthToken = AuthSubUtil.exchangeForSessionToken(token, null);
            System.out.println(picasaAuthToken);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
