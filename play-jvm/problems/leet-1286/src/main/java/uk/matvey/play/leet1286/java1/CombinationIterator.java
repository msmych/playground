package uk.matvey.play.leet1286.java1;

class CombinationIterator {

    private final String characters;
    private final int[] indexes;

    private boolean hasNext = true;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        indexes = new int[combinationLength];
        for (var i = 0; i < combinationLength; i++) {
            indexes[i] = i;
        }
    }

    public String next() {
        var sb = new StringBuilder();
        for (var index : indexes) {
            sb.append(characters.charAt(index));
        }
        updateIndexes();
        return sb.toString();
    }

    public boolean hasNext() {
        return hasNext;
    }

    private void updateIndexes() {
        for (var i = indexes.length - 1; i >= 0; i--) {
            if (indexes[i] < characters.length() - indexes.length + i) {
                indexes[i]++;
                for (var j = i + 1; j < indexes.length; j++) {
                    indexes[j] = j > 0 ? indexes[j - 1] + 1 : 0;
                }
                return;
            }
        }
        hasNext = false;
    }
}
