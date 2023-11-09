import java.util.*;
import java.io.*;
//in arr - 0-9 = 0-9, 10 - 35 = a-z, 36 - 61 = A-Z
//in ascii - 0-9 = 48-57, a-z = 97-122, A-Z = 65 - 90

public class FileAnalyzer {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter text file to be analyzed");
        String TF = s.next();
        int range;
        int sum;
        double avg;
        double median;
        TF = TF + ".txt";
        String[][] f;
        System.out.println("Enter type of Data Report Required : Ascending, Descending, Alphabetical");
        String choice = s.next();
        s.close();
        if (choice.equals("Ascending")){

            System.out.println("Character : Occurrence");
            f = AscSort(CharCounter(TF));
            for (int j =0;j<=61;j++){
                System.out.println(f[j][0] + "          : " + f[j][1] );
            }

        }

        if (choice.equals("Alphabetical")){

            System.out.println("Character : Occurrence");
            f = CharCounter(TF);
            for (int j =0;j<=61;j++){
                System.out.println(f[j][0] + "          : " + f[j][1] );
            }

        }

        if (choice.equals("Descending")){

            System.out.println("Character : Occurrence");
            f = DescSort(CharCounter(TF));
            for (int j =0;j<=61;j++){
                System.out.println(f[j][0] + "          : " + f[j][1] );
            }


        }


        f = DescSort(CharCounter(TF));
        sum = 0;
        avg = 0.0;
        range = Integer.valueOf(f[0][1]) - Integer.valueOf(f[61][1]);
        median = (Integer.valueOf(f[30][1]) + Integer.valueOf(f[31][1]))/2;


        for (int i =0; i<=61; i++){
            sum = sum + Integer.valueOf(f[i][1]);
            avg = sum/(i+1);
        }

        System.out.println("Maximum frequency is     :" + f[0][1]);
        System.out.println("Minimum frequency is     :" + f[61][1]);
        System.out.println("Range of Frequencies is  :" + range);
        System.out.println("Mode of text file is     :" + f[0][0]);
        System.out.println("Mean of Frequencies is   :" + avg);
        System.out.println("Median of Frequencies is :" + median);
    }

    public static String[][] AscSort(String str[][]){
        boolean notswap;
        do {
            notswap = false;
            for(int l =0; l<61; l++){
                if(Integer.valueOf(str[l][1])>Integer.valueOf(str[l+1][1])){
                    String temp1 = str[l][0];
                    str[l][0] = str[l+1][0];
                    str[l+1][0] = temp1;
                    String temp2 = str[l][1];
                    str[l][1] = str[l+1][1];
                    str[l+1][1] = temp2;
                    notswap = true;
                }
            }
        } while (notswap);
        return str;
    }


    public static String[][] DescSort(String st[][]){
        boolean notswap;
        do {
            notswap = false;
            for(int l =0; l<61; l++){
                if(Integer.valueOf(st[l][1])<Integer.valueOf(st[l+1][1])){
                    String temp1 = st[l][0];
                    st[l][0] = st[l+1][0];
                    st[l+1][0] = temp1;
                    String temp2 = st[l][1];
                    st[l][1] = st[l+1][1];
                    st[l+1][1] = temp2;
                    notswap = true;
                }
            }
        } while (notswap);
        return st;
    }
    


    public static String[][] CharCounter(String FileName){
        String line = " ";
        String[][] arr = new String[62][2];
        arr[0][0] = "0";
        arr[1][0] = "1";
        arr[2][0] = "2";
        arr[3][0] = "3";
        arr[4][0] = "4";
        arr[5][0] = "5";
        arr[6][0] = "6";
        arr[7][0] = "7";
        arr[8][0] = "8";
        arr[9][0] = "9";
        arr[10][0] = "a";
        arr[11][0] = "b";
        arr[12][0] = "c";
        arr[13][0] = "d";
        arr[14][0] = "e";
        arr[15][0] = "f";
        arr[16][0] = "g";
        arr[17][0] = "h";
        arr[18][0] = "i";
        arr[19][0] = "j";
        arr[20][0] = "k";
        arr[21][0] = "l";
        arr[22][0] = "m";
        arr[23][0] = "n";
        arr[24][0] = "o";
        arr[25][0] = "p";
        arr[26][0] = "q";
        arr[27][0] = "r";
        arr[28][0] = "s";
        arr[29][0] = "t";
        arr[30][0] = "u";
        arr[31][0] = "v";
        arr[32][0] = "w";
        arr[33][0] = "x";
        arr[34][0] = "y";
        arr[35][0] = "z";
        arr[36][0] = "A";
        arr[37][0] = "B";
        arr[38][0] = "C";
        arr[39][0] = "D";
        arr[40][0] = "E";
        arr[41][0] = "F";
        arr[42][0] = "G";
        arr[43][0] = "H";
        arr[44][0] = "I";
        arr[45][0] = "J";
        arr[46][0] = "K";
        arr[47][0] = "L";
        arr[48][0] = "M";
        arr[49][0] = "N";
        arr[50][0] = "O";
        arr[51][0] = "P";
        arr[52][0] = "Q";
        arr[53][0] = "R";
        arr[54][0] = "S";
        arr[55][0] = "T";
        arr[56][0] = "U";
        arr[57][0] = "V";
        arr[58][0] = "W";
        arr[59][0] = "X";
        arr[60][0] = "Y";
        arr[61][0] = "Z";
        for (int k =0; k<=61; k++){
            arr[k][1] = "0";
        }
        try {
        FileReader fr = new FileReader(FileName);
        BufferedReader br = new BufferedReader(fr);
        line = br.readLine();
        char c = ' ';
        while (line != null){
            for (int i =0;i<line.length();i++){
                c = line.charAt(i);
                if (c >= 48 && c <= 57) {
                    arr[c - 48][1] = Integer.toString(Integer.valueOf(arr[c - 48][1]) + 1);
                }
                if (c >= 97 && c <= 122) {
                    arr[10 + (c - 'a')][1] = Integer.toString(Integer.valueOf(arr[10 + (c - 'a')][1]) + 1);
                }
                if (c >= 65 && c <= 90) {
                    arr[36 + (c - 'A')][1] = Integer.toString(Integer.valueOf(arr[36 + (c - 'A')][1]) + 1);
                }
                
            }
            line = br.readLine();
        }
        br.close();
        }
        catch(IOException ex) {
            System.out.println("Error");
        }
        return arr;
    }
}
