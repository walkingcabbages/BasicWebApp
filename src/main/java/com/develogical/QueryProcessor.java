package com.develogical;

import java.util.ArrayList;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("name")) {
            return "what is going on";
        }

        if (query.toLowerCase().contains("which of the following numbers is the largest: ")) {
            String[] parts = query.split(": ");
            String[] nums = parts[1].split(", ");
            int max = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++) {
                max = Integer.max(max, Integer.parseInt(nums[i]));
            }
            return String.valueOf(max);
        }

        if (query.toLowerCase().contains("which of the following numbers is both a square and a cube: ")) {
            String[] parts = query.split(": ");
            String[] nums = parts[1].split(", ");

            ArrayList<String> result = new ArrayList<String>();

            for(int i=0; i<nums.length; i++) {
                int num = Integer.parseInt(nums[i]);
                Double sqrt = Math.sqrt(Double.valueOf(num));
                Double sqrt_floor = Math.floor(sqrt);
                Double cbrt = Math.cbrt(Double.valueOf(num));
                Double cbrt_floor = Math.floor(cbrt);
                if(sqrt.equals(sqrt_floor) && cbrt.equals(cbrt_floor)) {
                    result.add(String.valueOf(num));
                }
            }
            return String.join(", ", result);
        }
        return "";
    }
}
