import java.util.Arrays;

public class Caesar {

    public static String encrypt(String message, int key){
        //MY NAME IS
        message = message.toUpperCase();
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int shift = 26 - key;
        String encr = "";
        String encryption = Alphabet.substring(shift)+ Alphabet.substring(0,shift);
        for (int i=0;i<message.length();i++){
            char c = message.charAt(i);
            int pos1 = Alphabet.indexOf(c);
            if(pos1==-1){
                encr = encr + " ";
            }
            else{
                char d = encryption.charAt(pos1);
                encr = encr + d;
            }

        }
        return encr;
    }
    public static String decrypt(String message, int key){
        message = message.toUpperCase();
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int shift = 26-key;
        String decr = "";
        String decryption = Alphabet.substring(shift)+Alphabet.substring(0,shift);
        for(int i=0;i<message.length();i++){
            char c = message.charAt(i);
            int pos1 = decryption.indexOf(c);
            if(pos1 == -1){
                decr = decr+" ";
            }
            else {
                char d = Alphabet.charAt(pos1);
                decr = decr + d;
            }
        }
        return decr;
    }

    public static int[] countOccurence(String message){
        int[] occurence = new int[26];
        message = message.toUpperCase();
        // Hi my name is mustafa
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i =0;i<message.length();i++){
            int count = alphabet.indexOf(message.charAt(i));
            if(count !=-1) {
                occurence[count] = occurence[count] + 1;
            }
        }
        return occurence;
    }
    public static int MaxNum(int[] occurence){
        int count =0;
        for(int i=0;i<occurence.length;i++){
            if(occurence[i]>occurence[count]){
                count = i;
            }
        }
        return count;
    }
    public static String BruteForcedecrypt(String message){
        int[] occur = countOccurence(message);
        int Max = MaxNum(occur);
        int dkey = Max-4;
        if(Max<4){
            dkey=23-(4-Max);
        }
        return decrypt(message,26-dkey);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("What the fuck is wrong why doesn't this cipher work",4));
        System.out.println(BruteForcedecrypt("SDWP PDA BQYG EO SNKJC SDU ZKAOJ P PDEO YELDAN SKNG"));

    }
}
