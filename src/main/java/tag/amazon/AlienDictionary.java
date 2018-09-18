package tag.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by GAURAV on 9/15/2018.
 */
public class AlienDictionary {
    //    static String[] dict = {"caa", "aaa", "aab"};
//    static int alphabetCount = 3;
//    static String[] dict = {"baa", "abcd", "abca", "cab", "cad", "ce"};
//    static int alphabetCount = 4;
//    static String[] dict = {"bf", "biifablhhfekcjfhdklefkiihffedfjkklldcbfdldddbf", "bikjidjifidghfklddjchiebjbibdjadlgji", "bkblijbgjbkillhcblbjacadceahebbcafichcjedhbajlfkei", "bldgbfhkfdbcihbdkfejkdgikeclih", "cbielkdheejdicfjfeclbdliidkdcfifdgehlleikkdb", "cccfckhbglgfi", "cjjgibfkgegchldfaclliejhhcbjickadahbcdkialldfb", "eclbbfcjdfecfdkiblddaceclddfkaabjgalgiggacjdegf", "efdjhebdfebhhccahifhaififjbadhc", "eghcflfgkllde", "eidbdkcjicecjaiddfdcjkfj", "ejifhhdiclkkejdhidkhbhjdihbdkckfkgiidhadjdje", "elacahafeeghdgkic", "fag", "fbeidhlbfhcbjebaegidflileilejkijdfjdkiclabdfjeejeg", "gebfadchbgcikgkfifaga", "gialjghjjhhedflkkdjlhajdkhdakhadkkajgllgllbghk", "helekchjgeb", "iehdjcjefggkcafllgedfhjhhiahgc", "ike", "ikgjliklfblbagfafe", "ilfeajblklchcebejiggjhfbdcla", "jdlfbhdfjbdblgcceihcgiaachlhlhjhcglhcaf", "jeahcekiahlkidflijakdj", "jfhgbkchhgckahefbjcgaceibkiehallgiffddchacigefa", "jhlfhckghgkgfb", "kfcahfciklbakdgehkgfadggdcjcfaijkjlffjf", "kiidkhfcclldfceahaabjfgdi", "kjbchgcbbdghhk", "lfkdjkkeebibdidhjfkldkhecllebheehjhcaileeggafii", "lhd", "lkkkldcfbfekbjdfalhiddaiegkf", "lljjjgj"};
//    static int alphabetCount = 12;
//    static String[] dict = {"bhhb", "blkbggfecalifjfcbkjdicehhgikkdhlachlgbhji", "cfjjhcifladadbgcleggjgbcieihabcglblflgajgkejccj", "dlgdhiha", "ehggedljjhfldcajeceaeehkalkfeidhigkifjl", "gdalgkblahcldahledfghjb", "geldbblaaflegjhlfjlgblfbdc", "ibjceciedbiilkjliijgklcgliaeeic", "jcebjkfgfibfckfiikklecihik", "jdkcabjjjckgdblkljf", "jijlbjbliigkffhkchkclkhafbiiiblcglhfjkflbjjkih", "kfd", "lhdgidialgabfklffahiihceflebfidl"};
    static String[] dict = {"ajcckaehkjfagilhkdjljallcfbdfbgkgehifjcchekbeffcbl","bfdhkciacljaldcceibeekkhljgdekiifgahgdeeicbe","chcicjiaejkhkekggeakleibbbaackdeklajfk","chjalfhchfagfebdecgklk","cklikajaacgagkifchlec","efdljeecegkajik","ehbjcldikicjgghjaegijjkcclfkl","eijhkidjlgbdjldcdfkakljhkbcefgdeaeegjeldbegig","eljaafeklgigififfgfhfkaeecekkhjiifjdchejflffbdgdb","jeegbibaddbl","jfelahhdkhedakjedhbfcbcg","kcgdghfgaidbjefcdifggdcfgjliecjkhkkcijik","kdikglgefhj","kiaifgfkecajablj","kickgieghlhckl","kkbcehagbdjclkibdejfjhgjkllddbdjifkijdialj","lbakdalbihdheafcflhcehdghklhjgaiaejbhcach","lcgedkcajkdkdggabhggjdfbhcibkgbj","libefdiclhdcelhbjdg"};
    static int alphabetCount = 12;


    int[][] graph;

    public static void main(String[] args) {
//        new AlienDictionary().printAlienDictionary(dict, alphabetCount);
        new AlienDictionary().printAlienDictionaryUsingMatrix(dict, alphabetCount);

    }

    private void printAlienDictionaryUsingMatrix(String[] dict, int alphabetCount) {

        graph = new int[alphabetCount][alphabetCount];

        String word1;
        String word2;
        char char1;
        char char2;
        int char1Index;
        int char2Index;


        for (int dictIndex = 0; dictIndex < dict.length - 1; dictIndex++) {
            word1 = dict[dictIndex];
            word2 = dict[dictIndex + 1];

            for (int charIndex = 0; charIndex < Math.min(word1.length(), word2.length()); charIndex++) {

                char1 = word1.charAt(charIndex);
                char2 = word2.charAt(charIndex);

                if (char1 != char2) {
                    char1Index = getIndex(char1);
                    char2Index = getIndex(char2);
                    if (graph[char2Index][char1Index] != 1) {
                        graph[char1Index][char2Index] = 1;
                        break;
                    }
                }
            }
        }
        for (int[] arr : graph) {
            System.out.println(Arrays.toString(arr));
        }

        topologicalSort(graph);
    }

    private void topologicalSort(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Character> stack = new Stack<>();

        for (int alphabetIndex = 0; alphabetIndex < graph.length; alphabetIndex++) {
            if (!visited[alphabetIndex]) {
                recursiveTopology(alphabetIndex, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "");
        }
    }

    private void recursiveTopology(int alphabetIndex, boolean[] visited, Stack<Character> stack) {

        visited[alphabetIndex] = true;
        int[] alphabetEdges = graph[alphabetIndex];

        int edgeItr = 0;
        for (int edge : alphabetEdges) {
            if (edge == 1 && !visited[edgeItr]) {
                recursiveTopology(edgeItr, visited, stack);
            }
            edgeItr++;
        }
        stack.push(getAlphabet(alphabetIndex));
    }


    private char getAlphabet(int i) {
        return (char) (97 + i);
    }

    class DictionaryNode {
        char nodeChar;
        DictionaryNode prevNode;
        DictionaryNode nextNode;

        public DictionaryNode(char nodeChar) {
            this.nodeChar = nodeChar;
        }

    }

    private void printAlienDictionary(String[] dict, int alphabetCount) {

        LinkedList<Character>[] graph = new LinkedList[alphabetCount];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        char firstChar = dict[0].charAt(0);

        for (int dictIndex = 0; dictIndex < dict.length - 1; dictIndex++) {
            char c = dict[dictIndex].charAt(0);
            int charIndex = getIndex(c);
            graph[charIndex].add(c);
        }

        String word1;
        String word2;
        int minLength;
        char char1;
        char char2;

        for (int dictIndex = 0; dictIndex < dict.length - 1; dictIndex++) {
            word1 = dict[dictIndex];
            word2 = dict[dictIndex + 1];
            minLength = word1.length() < word2.length() ? word1.length() : word2.length();
            System.out.println(word1 + "_" + word2);

            for (int charIndex = 0; charIndex < minLength; charIndex++) {
                char1 = word1.charAt(charIndex);
                char2 = word2.charAt(charIndex);

                if (char1 != char2) {
                    graph[getIndex(char1)].add(char2);
                }
            }
        }
        System.out.println(graph);
    }

    private int getIndex(char character) {

        int temp = (int) character;
        int lowerCase = 97; //for lower case
        int upperCase = 65; //for upper case

        if (temp >= 97 & temp <= 122) {
            return temp - lowerCase;
        }
        if (temp >= 65 & temp <= 90) {
            return temp - upperCase;
        }
        return -1;
    }
}
