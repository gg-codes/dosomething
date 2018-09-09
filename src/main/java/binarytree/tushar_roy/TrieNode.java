package binarytree.tushar_roy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GAURAV on 8/29/2018.
 */
class TrieNodeBuilder {

    TrieNode rootNode;

    public TrieNodeBuilder() {
        rootNode = new TrieNode();
    }

    public static void main(String[] args) {

        TrieNodeBuilder trieNodeBuilder = new TrieNodeBuilder();
        trieNodeBuilder.build();
        trieNodeBuilder.getWordSuggestionFromTree("ab");
        System.out.println("");
    }

    private void build() {
        addWordToTree("abc");
        addWordToTree("abd");
    }

    List<String> getWordSuggestionFromTree(String partialString) {

        TrieNode current = rootNode;

        for (Character ch : partialString.toCharArray()) {

            TrieNode trieNode = current.getCharToTrieNodeMap().get(ch);

            if (trieNode == null) {
                break;
            }
            current = trieNode;
        }

        printChildNodes(current);
        return null;
    }

    private void printChildNodes(TrieNode current) {

        for (Map.Entry<Character, TrieNode> entry : current.getCharToTrieNodeMap().entrySet()) {
            System.out.println(entry.getKey());
        }

    }

    void addWordToTree(String word) {

        TrieNode current = rootNode;

        for (Character ch : word.toCharArray()) {

            TrieNode trieNode = current.getCharToTrieNodeMap().get(ch);

            if (trieNode == null) {
                trieNode = new TrieNode();
                current.getCharToTrieNodeMap().put(ch, trieNode);
            }
            current = trieNode;
        }
        current.setLast(true);
    }
}

class TrieNode {
    private Map<Character, TrieNode> charToTrieNodeMap;
    boolean isLast;

    public TrieNode() {
        charToTrieNodeMap = new HashMap<>();
    }

    public Map<Character, TrieNode> getCharToTrieNodeMap() {
        return charToTrieNodeMap;
    }

    public void setCharToTrieNodeMap(Map<Character, TrieNode> charToTrieNodeMap) {
        this.charToTrieNodeMap = charToTrieNodeMap;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    @Override
    public String toString() {
        return isLast + "_" + charToTrieNodeMap.toString();
    }
}


