package com.develogical;

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
        return "";
    }
}
