public class Umandana {
    /**
     * Mengembalikan kata yang telah diubah menjadi bahasa Umandana
     * Huruf a menjadi "aiden"
     * Huruf i menjadi "ipri"
     * Huruf u menjadi "upru"
     * Huruf e menjadi "epre"
     * Huruf o menjadi "opro"
     * Huruf mati yang tidak diikuti huruf vokal menjadi huruf tersebut + "es"
     * Suku kata "ng" yang tidak diikuti huruf vokal menjadi "strengen"
     * Suku kata "ng" yang diikuti huruf vokal tetap menjadi "ng"
     * Suku kata "ny" yang diikuti huruf vokal tetap menjadi "ny"
     * Selain ketentuan di atas, huruf/karakter tidak diubah
     * *
     * 
     * @param words
     * @return kata yang telah diubah menjadi bahasa Umandana
     * 
     */
    public static String toUmandana(String words) {
        String rew = "";
        for (int i=0; i<words.length(); i++) {
            char c = words.charAt(i);
            if (c == 'a') {
                rew += "aiden";
            } else if (c == 'i') {
                rew += "ipri";
            } else if (c == 'u') {
                rew += "upru";
            } else if (c == 'e') {
                rew += "epre";
            } else if (c == 'o') {
                rew += "opro";
            } else if (c == 'n' && i+1 < words.length() && words.charAt(i+1) == 'g' && (i+2 >= words.length() || !(words.charAt(i+2) == 'a' || words.charAt(i+2) == 'i' || words.charAt(i+2) == 'u' || words.charAt(i+2) == 'e' || words.charAt(i+2) == 'o'))) {
                rew += "strengen";
                i++;
            } else if (c == 'n' && i+1 < words.length() && words.charAt(i+1) == 'g') {
                rew += "ng";
                i++;
            } else if (c == 'n' && i+1 < words.length() && words.charAt(i+1) == 'y' && i+2 < words.length() && (words.charAt(i+2) == 'a' || words.charAt(i+2) == 'i' || words.charAt(i+2) == 'u' || words.charAt(i+2) == 'e' || words.charAt(i+2) == 'o')) {
                rew += "ny";
                i++;
            } else if (Character.isLetter(c) && !(c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') && (i+1 >= words.length() || !(words.charAt(i+1) == 'a' || words.charAt(i+1) == 'i' || words.charAt(i+1) == 'u' || words.charAt(i+1) == 'e' || words.charAt(i+1) == 'o'))) {
                rew += c + "es";
            } else {
                rew += c;
            }
        }
        return rew;
    }

    /**
     * Mengembalikan kata Umandana ke bentuk normal
     * *
     * 
     * @param words kata dalam bahasa Umandana
     * @return kata telah diubah ke bentuk normal
     */
    public static String deUmandana(String words) {
        String rew = "";
        for (int i=0; i<words.length(); i++) {
            if (i+4 < words.length() && words.substring(i, i+5).equals("aiden")) {
                rew += 'a';
                i += 4;
            } else if (i+3 < words.length() && words.substring(i, i+4).equals("ipri")) {
                rew += 'i';
                i += 3;
            } else if (i+3 < words.length() && words.substring(i, i+4).equals("upru")) {
                rew += 'u';
                i += 3;
            } else if (i+3 < words.length() && words.substring(i, i+4).equals("epre")) {
                rew += 'e';
                i += 3;
            } else if (i+3 < words.length() && words.substring(i, i+4).equals("opro")) {
                rew += 'o';
                i += 3;
            } else if (i+7 < words.length() && words.substring(i, i+8).equals("strengen")) {
                rew += "ng";
                i += 7;
            } else if (i+1 < words.length() && words.substring(i, i+2).equals("ng")) {
                rew += "ng";
                i += 1;
            } else if (i+1 < words.length() && words.substring(i, i+2).equals("ny")) {
                rew += "ny";
                i += 1;
            } else if (i+2 < words.length() && words.charAt(i+1) == 'e' && words.charAt(i+2) == 's' && Character.isLetter(words.charAt(i)) && !(words.charAt(i) == 'a' || words.charAt(i) == 'i' || words.charAt(i) == 'u' || words.charAt(i) == 'e' || words.charAt(i) == 'o')) {
                rew += words.charAt(i);
                i += 2;
            } else {
                rew += words.charAt(i);
            }
        }
        return rew;
    }

}