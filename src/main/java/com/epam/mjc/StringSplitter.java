package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    
    public  List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        System.out.println("source = " + source);
        System.out.println("delimiters = " + delimiters);

        List<String> res = new ArrayList<>();

        StringBuilder con = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {

            if (!delimiters.contains(source.charAt(i) + "")) {
                con.append(source.charAt(i));
            } else {
                if(con.length()==0)continue;
                res.add(con.toString());
                con = new StringBuilder();
            }
        }
        if (!con.toString().equals(""))
            res.add(con.toString());

        return res;

    }
}
