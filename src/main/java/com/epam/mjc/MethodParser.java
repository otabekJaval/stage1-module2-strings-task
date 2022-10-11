package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     * <p>
     * * @param signatureString source string to parse
     *
     * @return {@link MethodSignature} object filled with parsed values from source string
     */

    public MethodSignature parseFunction(String signatureString) {


        int startOfP1 = signatureString.indexOf('(');
        int endOfP1 = signatureString.indexOf(')');

        List<MethodSignature.Argument> argsList = new ArrayList<>();

        if (endOfP1 - startOfP1 > 2) {
            String[] split = signatureString.substring(startOfP1 + 1, endOfP1).split(",");

            for (String s : split) {
                s = s.trim();
                String[] s1 = s.split(" ");

                MethodSignature.Argument argument = new MethodSignature.Argument(s1[0], s1[1]);
                argsList.add(argument);
            }
        }


        if (!argsList.isEmpty()) {
            signatureString = signatureString.substring(0, startOfP1);
        }


        if (signatureString.contains("()"))
            signatureString = signatureString.replace("()", "");

        String[] s = signatureString.split(" ");

        String methodName = s[s.length - 1];
        String methodType = s[s.length - 2];
        String modifier = null;

        if (s.length > 2) {
            modifier = s[s.length - 3];
        }

        MethodSignature ms = new MethodSignature(methodName, argsList);
        ms.setReturnType(methodType);
        ms.setAccessModifier(modifier);

        return ms;


    }
}
