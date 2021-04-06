package e04word.textTransforms;

public interface TextTransform {
    void invokeOn(StringBuilder text, int startIndex, int endIndex);
}
