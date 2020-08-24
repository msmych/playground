class StreamChecker {

    public StreamChecker(String[] words) {
        
    }
    
    public boolean query(char letter) {
        return false;    
    }

    public static void main(String... args) {
        var checker = new StreamChecker(new String[]{ "cd", "f", "kl" });
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('a'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('b'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('c'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('d'), true));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('e'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('f'), true));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('g'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('h'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('i'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('j'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('k'), false));
        System.out.println(String.format("Output: %s | Expected: %s", checker.query('l'), true));
    }

}
