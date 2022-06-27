/* Generated by: JavaCC 21 Parser Generator. Token.java */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class Token implements JasminParserConstants {
    private TokenType type;
    private JasminParserLexer tokenSource;
    private int beginOffset, endOffset;
    private boolean unparsed;
    private String image;
    public void setImage(String image) {
        this.image= image;
    }

    private Token prependedToken, appendedToken;
    private boolean inserted;
    public boolean isInserted() {
        return inserted;
    }

    public void preInsert(Token prependedToken) {
        if (prependedToken== this.prependedToken) return;
        prependedToken.appendedToken= this;
        Token existingPreviousToken= this.previousCachedToken();
        if (existingPreviousToken!=null) {
            existingPreviousToken.appendedToken= prependedToken;
            prependedToken.prependedToken= existingPreviousToken;
        }
        prependedToken.inserted= true;
        prependedToken.beginOffset= prependedToken.endOffset= this.beginOffset;
        this.prependedToken= prependedToken;
    }

    void unsetAppendedToken() {
        this.appendedToken= null;
    }

    /**
     * @param type the #TokenType of the token being constructed
     * @param image the String content of the token
     * @param tokenSource the object that vended this token.
     */
    public Token(TokenType type, String image, JasminParserLexer tokenSource) {
        this.type= type;
        this.image= image;
        this.tokenSource= tokenSource;
    }

    public static Token newToken(TokenType type, String image, JasminParserLexer tokenSource) {
        Token result= newToken(type, tokenSource, 0, 0);
        result.setImage(image);
        return result;
    }

    /**
     * It would be extremely rare that an application
     * programmer would use this method. It needs to
     * be public because it is part of the Node interface.
     */
    public void setBeginOffset(int beginOffset) {
        this.beginOffset= beginOffset;
    }

    /**
     * It would be extremely rare that an application
     * programmer would use this method. It needs to
     * be public because it is part of the Node interface.
     */
    public void setEndOffset(int endOffset) {
        this.endOffset= endOffset;
    }

    /**
     * @return the JasminParserLexer object that handles 
     * location info for the tokens. 
     */
    public JasminParserLexer getTokenSource() {
        JasminParserLexer flm= this.tokenSource;
        // If this is null and we have chained tokens,
        // we try to get it from there! (Why not?)
        if (flm== null) {
            if (prependedToken!=null) {
                flm= prependedToken.getTokenSource();
            }
            if (flm== null&&appendedToken!=null) {
                flm= appendedToken.getTokenSource();
            }
        }
        return flm;
    }

    /**
     * It should be exceedingly rare that an application
     * programmer needs to use this method.
     */
    public void setTokenSource(JasminParserLexer tokenSource) {
        this.tokenSource= tokenSource;
    }

    /**
     * Return the TokenType of this Token object
     */
    public TokenType getType() {
        return type;
    }

    protected void setType(TokenType type) {
        this.type= type;
    }

    /**
     * @return whether this Token represent actual input or was it inserted somehow?
     */
    public boolean isVirtual() {
        return type== TokenType.EOF;
    }

    /**
     * @return Did we skip this token in parsing?
     */
    public boolean isSkipped() {
        return false;
    }

    /**
     * @return the (1-based) line location where this Token starts
     */
    public int getBeginLine() {
        JasminParserLexer flm= getTokenSource();
        return flm== null?0:
        flm.getLineFromOffset(getBeginOffset());
    }

    ;
    /**
     * @return the (1-based) line location where this Token ends
     */
    public int getEndLine() {
        JasminParserLexer flm= getTokenSource();
        return flm== null?0:
        flm.getLineFromOffset(getEndOffset()-1);
    }

    ;
    /**
     * @return the (1-based) column where this Token starts
     */
    public int getBeginColumn() {
        JasminParserLexer flm= getTokenSource();
        return flm== null?0:
        flm.getCodePointColumnFromOffset(getBeginOffset());
    }

    ;
    /**
     * @return the (1-based) column offset where this Token ends
     */
    public int getEndColumn() {
        JasminParserLexer flm= getTokenSource();
        return flm== null?0:
        flm.getCodePointColumnFromOffset(getEndOffset());
    }

    public String getInputSource() {
        JasminParserLexer flm= getTokenSource();
        return flm!=null?flm.getInputSource():
        "input";
    }

    public int getBeginOffset() {
        return beginOffset;
    }

    public int getEndOffset() {
        return endOffset;
    }

    /**
     * @return the string image of the token.
     */
    public String getImage() {
        return image!=null?image:
        getSource();
    }

    /**
     * @return the next _cached_ regular (i.e. parsed) token
     * or null
     */
    public final Token getNext() {
        return getNextParsedToken();
    }

    /**
     * @return the previous regular (i.e. parsed) token
     * or null
     */
    public final Token getPrevious() {
        Token result= previousCachedToken();
        while (result!=null&&result.isUnparsed()) {
            result= result.previousCachedToken();
        }
        return result;
    }

    /**
     * @return the next regular (i.e. parsed) token
     */
    private Token getNextParsedToken() {
        Token result= nextCachedToken();
        while (result!=null&&result.isUnparsed()) {
            result= result.nextCachedToken();
        }
        return result;
    }

    /**
     * @return the next token of any sort (parsed or unparsed or invalid)
     */
    public Token nextCachedToken() {
        if (appendedToken!=null) return appendedToken;
        JasminParserLexer tokenSource= getTokenSource();
        return tokenSource!=null?tokenSource.nextCachedToken(getEndOffset()):
        null;
    }

    public Token previousCachedToken() {
        if (prependedToken!=null) return prependedToken;
        if (getTokenSource()== null) return null;
        return getTokenSource().previousCachedToken(getBeginOffset());
    }

    Token getPreviousToken() {
        return previousCachedToken();
    }

    public Token replaceType(TokenType type) {
        Token result= newToken(type, getTokenSource(), getBeginOffset(), getEndOffset());
        result.prependedToken= this.prependedToken;
        result.appendedToken= this.appendedToken;
        result.inserted= this.inserted;
        if (result.appendedToken!=null) {
            result.appendedToken.prependedToken= result;
        }
        if (result.prependedToken!=null) {
            result.prependedToken.appendedToken= result;
        }
        if (!result.inserted) {
            getTokenSource().cacheToken(result);
        }
        return result;
    }

    public String getSource() {
        if (type== TokenType.EOF) return"";
        JasminParserLexer flm= getTokenSource();
        return flm== null?null:
        flm.getText(getBeginOffset(), getEndOffset());
    }

    protected Token() {
    }

    public Token(TokenType type, JasminParserLexer tokenSource, int beginOffset, int endOffset) {
        this.type= type;
        this.tokenSource= tokenSource;
        this.beginOffset= beginOffset;
        this.endOffset= endOffset;
    }

    public boolean isUnparsed() {
        return unparsed;
    }

    public void setUnparsed(boolean unparsed) {
        this.unparsed= unparsed;
    }

    public void clearChildren() {
    }

    public String getNormalizedText() {
        if (getType()== TokenType.EOF) {
            return"EOF";
        }
        return getImage();
    }

    public String toString() {
        return getNormalizedText();
    }

    /**
     * @return An iterator of the tokens preceding this one.
     */
    public Iterator<Token> precedingTokens() {
        return new Iterator<Token> () {
            Token currentPoint= Token.this;
            public boolean hasNext() {
                return currentPoint.previousCachedToken()!=null;
            }

            public Token next() {
                Token previous= currentPoint.previousCachedToken();
                if (previous== null) throw new java.util.NoSuchElementException("No previous token!");
                return currentPoint= previous;
            }

        }
        ;
    }

    /**
     * @return a list of the unparsed tokens preceding this one in the order they appear in the input
     */
    public List<Token> precedingUnparsedTokens() {
        List<Token> result= new ArrayList<> ();
        Token t= this.previousCachedToken();
        while (t!=null&&t.isUnparsed()) {
            result.add(t);
            t= t.previousCachedToken();
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * @return An iterator of the (cached) tokens that follow this one.
     */
    public Iterator<Token> followingTokens() {
        return new java.util.Iterator<Token> () {
            Token currentPoint= Token.this;
            public boolean hasNext() {
                return currentPoint.nextCachedToken()!=null;
            }

            public Token next() {
                Token next= currentPoint.nextCachedToken();
                if (next== null) throw new java.util.NoSuchElementException("No next token!");
                return currentPoint= next;
            }

        }
        ;
    }

    public void copyLocationInfo(Token from) {
        setTokenSource(from.getTokenSource());
        setBeginOffset(from.getBeginOffset());
        setEndOffset(from.getEndOffset());
        appendedToken= from.appendedToken;
        prependedToken= from.prependedToken;
    }

    public void copyLocationInfo(Token start, Token end) {
        setTokenSource(start.getTokenSource());
        if (tokenSource== null) setTokenSource(end.getTokenSource());
        setBeginOffset(start.getBeginOffset());
        setEndOffset(end.getEndOffset());
        prependedToken= start.prependedToken;
        appendedToken= end.appendedToken;
    }

    public static Token newToken(TokenType type, JasminParserLexer tokenSource, int beginOffset, int endOffset) {
        return new Token(type, tokenSource, beginOffset, endOffset);
    }

    public String getLocation() {
        return getInputSource()+":"+getBeginLine()+":"+getBeginColumn();
    }

}
