/* Generated by: JavaCC 21 Parser Generator. Do not edit. BaseNode.java */
import java.util.*;
/**
 * The base concrete class for non-terminal Nodes
 */
@SuppressWarnings("rawtypes")
public class BaseNode implements Node {
    private JasminParserLexer tokenSource;
    public JasminParserLexer getTokenSource() {
        if (tokenSource== null) {
            for (Node child : children()) {
                tokenSource= child.getTokenSource();
                if (tokenSource!=null) break;
            }
        }
        return tokenSource;
    }

    public void setTokenSource(JasminParserLexer tokenSource) {
        this.tokenSource= tokenSource;
    }

    static private Class listClass= ArrayList.class;
    /**
     * Sets the List class that is used to store child nodes. By default,
     * this is java.util.ArrayList. There is probably very little reason
     * to ever use anything else, though you could use this method 
     * to replace this with LinkedList or your own java.util.List implementation even.
     * @param listClass the #java.util.List implementation to use internally 
     * for the child nodes. By default #java.util.ArrayList is used.
     */
    static public void setListClass(Class<?extends List> listClass) {
        BaseNode.listClass= listClass;
    }

    @SuppressWarnings("unchecked")
    private List<Node> newList() {
        try {
            return(List<Node> ) listClass.getDeclaredConstructor().newInstance();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * the parent node
     */
    protected Node parent;
    /**
     * the child nodes
     */
    protected List<Node> children= newList();
    private int beginOffset, endOffset;
    private boolean unparsed;
    public boolean isUnparsed() {
        return this.unparsed;
    }

    public void setUnparsed(boolean unparsed) {
        this.unparsed= unparsed;
    }

    public void setParent(Node n) {
        parent= n;
    }

    public Node getParent() {
        return parent;
    }

    public void addChild(Node n) {
        children.add(n);
        n.setParent(this);
    }

    public void addChild(int i, Node n) {
        children.add(i, n);
        n.setParent(this);
    }

    public Node getChild(int i) {
        return children.get(i);
    }

    public void setChild(int i, Node n) {
        children.set(i, n);
        n.setParent(this);
    }

    public Node removeChild(int i) {
        return children.remove(i);
    }

    public void clearChildren() {
        children.clear();
    }

    public int getChildCount() {
        return children.size();
    }

    public List<Node> children() {
        return Collections.unmodifiableList(children);
    }

    public int getBeginOffset() {
        return beginOffset;
    }

    public void setBeginOffset(int beginOffset) {
        this.beginOffset= beginOffset;
    }

    public int getEndOffset() {
        return endOffset;
    }

    public void setEndOffset(int endOffset) {
        this.endOffset= endOffset;
    }

    public String toString() {
        StringBuilder buf= new StringBuilder();
        for (Token t : getRealTokens()) {
            buf.append(t);
        }
        return buf.toString();
    }

}
