class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            s = s.toLowerCase();
            String[] parts = s.split("@");
            String name = parts[0];
            String domain = parts[1];

            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
        } else {
            String digits = s.replaceAll("[^0-9]", "");
            String local = digits.substring(digits.length() - 10);
            String last4 = local.substring(6);

            int countryLen = digits.length() - 10;
            StringBuilder sb = new StringBuilder();

            if (countryLen > 0) {
                sb.append("+");
                for (int i = 0; i < countryLen; i++) sb.append("*");
                sb.append("-");
            }

            sb.append("***-***-").append(last4);
            return sb.toString();
        }
    }
}
