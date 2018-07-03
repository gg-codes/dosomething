package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GAURAV on 4/11/2018.
 */
public class GGNode<T> {
    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    private String align;

    public List<GGNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<GGNode<T>> children) {
        this.children = children;
    }

    private List<GGNode<T>> children = null;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    private T value;

    public GGNode(T value, String align) {
        this.children = new ArrayList<>();
        this.value = value;
        this.align = align;
    }

    public void addChild(GGNode<T> child) {
        children.add(child);
    }
}
