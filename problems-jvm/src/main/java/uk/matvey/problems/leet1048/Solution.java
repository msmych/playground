package uk.matvey.problems.leet1048;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private Map<Integer, List<String>> wordsByLength;
    private final Map<Set<String>, Boolean> predecessorsMemo = new HashMap<>();
    private final Map<MemoKey, Integer> longestWordChainMemo = new HashMap<>();

    private static class MemoKey {
        String word;
        int i;

        public MemoKey(String word, int i) {
            this.word = word;
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemoKey memoKey = (MemoKey) o;
            return i == memoKey.i && Objects.equals(word, memoKey.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word, i);
        }
    }

    public int longestStrChain(String[] words) {
        wordsByLength = Arrays.stream(words).collect(Collectors.groupingBy(String::length));
        var sortedLengths = wordsByLength.keySet().stream().sorted().toList();
        var maxLen = sortedLengths.stream().mapToInt(i -> i).max().getAsInt();
        var max = 0;
        for (var len : sortedLengths) {
            if (maxLen - len < max) {
                break;
            }
            var localMax = wordsByLength.get(len).stream()
                .mapToInt(word -> longestWordChainStep(word, len + 1))
                .max()
                .orElse(0)
                + 1;
            if (localMax > max) {
                max = localMax;
            }
        }
        return max;
    }

    private int longestWordChainStep(String word, int i) {
        MemoKey memoKey = new MemoKey(word, i);
        if (longestWordChainMemo.containsKey(memoKey)) {
            return longestWordChainMemo.get(memoKey);
        }
        if (!wordsByLength.containsKey(i)) {
            return 0;
        }
        var nextMax = 0;
        for (var next : wordsByLength.get(i)) {
            if (!isPredecessor(word, next)) {
                continue;
            }
            var localNextMax = longestWordChainStep(next, i + 1) + 1;
            if (localNextMax > nextMax) {
                nextMax = localNextMax;
            }
        }
        longestWordChainMemo.put(memoKey, nextMax);
        return nextMax;
    }

    private boolean isPredecessor(String word, String next) {
        if (next.length() - word.length() != 1) {
            return false;
        }
        var memoKey = Set.of(word, next);
        if (predecessorsMemo.containsKey(memoKey)) {
            return predecessorsMemo.get(memoKey);
        }
        for (int i = 0; i < next.length(); i++) {
            String other = next.substring(0, i) + next.substring(i + 1);
            if (word.equals(other)) {
                predecessorsMemo.put(memoKey, true);
                return true;
            }
        }
        predecessorsMemo.put(memoKey, false);
        return false;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var words = new String[]{"a", "b", "ba", "bca", "bda", "bdca"};

        int result = new Solution().longestStrChain(words);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        var words = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};

        int result = new Solution().longestStrChain(words);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case3() {
        var words = new String[]{"abcd", "dbqca"};

        int result = new Solution().longestStrChain(words);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        var words = new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"};

        int result = new Solution().longestStrChain(words);

        assertThat(result).isEqualTo(7);
    }

    @Test
    public void case5() {
        var words = new String[]{"qyssedya", "pabouk", "mjwdrbqwp", "vylodpmwp", "nfyqeowa", "pu", "paboukc", "qssedya", "lopmw", "nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda", "neo", "qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo", "nfqwa", "pabuk", "nfyqwa", "qssdya", "qsdya", "qyssedhya", "pabu", "nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr"};

        int result = new Solution().longestStrChain(words);

        assertThat(result).isEqualTo(8);
    }

    @Test
    public void case6() {
        var words = new String[]{"uiykgmcc", "jrgbss", "mhkqodcpy", "lkj", "bwqktun", "s", "nrctyzifwytjblwy", "wrp", "scqlcwmxw", "irqvnxdcxoejuu", "gmlckvofwyifmrw", "wbzbyrcppaljigvo", "lk", "kfeouqyyrer", "efzzpvi", "ubkcitcmwxk", "txihn", "mdwdmbtx", "vuzvcoaif", "jwmboqvhpqodsj", "wscfvrfl", "pzye", "waxyoxftvrgqmkg", "wwdidopozinxxn", "dclpg", "xjsvlxktxs", "ajj", "pvsdastm", "tatjxhygidhn", "feafycxdxagn", "irqvnxxoeuu", "kwjo", "tztoovsyfwz", "prllrw", "sclmx", "bbmjnwaxcwaml", "gl", "wiax", "uzvcoaif", "ztovyfwz", "qxy", "zuexoxyp", "qxyyrl", "pvsdasvtm", "femafycxdxaagn", "rspvccjcm", "wvyiax", "vst", "efzi", "fjmdcc", "icsinrbpql", "ctybiizlcr", "ntyzfwytjblw", "tatjxhygidhpn", "e", "kykizdandafusu", "pnepuwcsxl", "kfeuqyyrer", "afplzhbqguu", "hvajtj", "prll", "ildzdimea", "zueoxp", "ezi", "lqr", "jkaagljikwamaqvf", "mlzwhkxsn", "rspvccbcjjtcm", "wscfvrl", "m", "msygukwlkrqboc", "pifojogoveub", "bkcmwx", "jercgybhss", "wrpi", "aicsinkgrbpqli", "aplzbuu", "sclcmxw", "atpepgsz", "govrcuuglaer", "bdxjpsvlxkytxs", "uikgm", "bm", "wvyhiqax", "znvaasgfvqi", "hatpepgsz", "hrzebpa", "bnfz", "lybtqrfzw", "taxhygihn", "bjnfzk", "mhqp", "ide", "znvcaasgfvqi", "ftv", "afplzhbqsguuu", "thn", "pdbccbe", "mxevopfoimgjww", "fjmdrcce", "rspvccjjcm", "jv", "motnfwohwule", "xjsvlxtxs", "bqeb", "eug", "jftavwgl", "rzebpa", "lybtqrfazw", "zuexoxp", "jercgybhsys", "hajtj", "bkcitcmwxk", "mbpvxsdastvtm", "mowlznwhkxsn", "dvenn", "rsacxe", "tatjxhygihn", "cotybiizlcr", "bbmnaxaml", "pkwrpsi", "nqpdbccbkxens", "mbpbovxsdastvtm", "mj", "pxpsvikwekuq", "qeug", "dmelddga", "aicsinkgrbpxqli", "bdxjpsvlxktytxs", "pkrllrxw", "jkgljikwmaqf", "iddie", "ctybiizcr", "nyzfwytjblw", "yvuhmiuehspi", "keuqre", "wzbypaigvo", "sck", "uzcoaf", "dlpg", "ubkcpitlscmwxk", "molzwhkxsn", "pepuwcsxl", "laplm", "dclpgc", "mahkxqodcpy", "sclcmx", "hvrzebpaz", "bgovrcuuglaer", "clazpulmw", "yvuyhmiuehspiq", "wzbycpaljigvo", "sceqalciwmxw", "hjytflmvsgv", "u", "hjyvxytfflhmvsgv", "jkgjikwmaqf", "fefycxdxagn", "ftvw", "ofncgxrkqvcr", "spvcjc", "pvsdastvtm", "kykzdandaus", "wbzbycppaljigvo", "haytpepgsz", "jmowlznwhkxsn", "aplzhbguu", "zvyz", "nfvqi", "jfvtavwsgl", "xejnllhfulns", "zhhvbiqiw", "jkgljikwmaqvf", "tyizc", "irqvnxcxoejuu", "clvazzpulmw", "oncgxrqvcr", "qlupvpdkhrm", "mtnfwohwule", "wwdidopzozinxxn", "auiykgmcc", "wscfvrfyl", "pfksmrullrxw", "jwmoqvhpqods", "ftavwg", "iddiea", "kcmw", "ykkwjwo", "pe", "aplzbguu", "eu", "bbmnaxal", "ntyswtnlab", "zhhhvbhbiqiw", "jwmoqvpqods", "kykzdndaus", "bbmjnaxcwaml", "zunvcaasgfvqi", "icsingrbpql", "sceqalciwmsxyw", "yvuhmiuehsp", "bxjsvlxktxs", "waxoxftvrgqmkg", "cogxxpaknks", "scllvazzpulmw", "tatjxhygeidhpn", "ftvwg", "tyz", "nafvqi", "oby", "pgzpkhqog", "irqvnxxoejuu", "oxwpkxlakcp", "bnf", "oxwnpkxlakcp", "bwqktu", "ufybbaozoqk", "ntydswtnlab", "zvyfz", "znaafvqi", "npdbccbke", "mhkqocpy", "kuq", "bjnfz", "taxhyihn", "kwrpsi", "qifepmcatbdjlf", "lzwhks", "kfeuqre", "mxevopfoimgww", "spvcjcm", "oncgxrkqvcr", "jftavwsgl", "soifcbya", "jpzyeg", "jwmboqvhpqods", "lapulm", "jrgbhss", "xejfnllhfulns", "zhhhvbbiqiw", "km", "kuqre", "scxlzlvazzpulmw", "ztvyfwz", "wbzbycpaljigvo", "rzbpa", "vsastm", "uybaooqk", "dn", "ykwjwo", "ufybmvbaozoqk", "nknm", "mbpvsdastvtm", "dpgzpxykhqog", "wzbypajigvo", "bnjnfzk", "eollbigtftpdrd", "zhbiqiw", "yvuhiuehp", "zhhhvbhbiqiwg", "pfksrullrxw", "pzyeg", "aplzhbqguu", "z", "hvrzecbpazw", "clvazpulmw", "tajxhygihn", "pgzpxykhqog", "fefyxdxagn", "wimomuvhn", "lqrzw", "xejnlhfulns", "jhrc", "xsxxs", "slmx", "jrgss", "uikgmc", "ncgqvcr", "womuhn", "aryouvtnmme", "uzco", "zhhhvbiqiw", "hjytflhmvsgv", "znvaasfvqi", "kuqr", "ojrpp", "ztoovyfwz", "zvz", "pxpsviweuq", "ufybaooqk", "xy", "jfvvtavwksvgl", "raiachv", "bmnaxl", "rspvccjjtcm", "pgzpxkhqog", "xhbtfnqebaj", "sceqalciwmsxw", "jssctk", "uzvcoaf", "fefydxagn", "jhrvc", "mbj", "raiahv", "nrtyzifwytjblwy", "mhqcp", "jkgjkwmaqf", "wscfvrfylhi", "lqrz", "ahabucermswyrvl", "wxoxftvrgqmkg", "ku", "uyaoq", "mhqocp", "ykwjo", "vstm", "ofncgxrkqvcwr", "dqvh", "taxyihn", "idie", "bwqtu", "tztoovyfwz", "rspvcccjjtcm", "uojrpp", "wmomuhn", "cotycbiizlxcr", "nrtyzfwytjblw", "ocbya", "sceqlciwmxw", "ajtj", "rspvccbcjjthcm", "kfeuqyyre", "dmelddg", "txyihn", "ubkcitlscmwxk", "ntyswtnla", "bdxjpstvlxktytxs", "odqdvbh", "pxpsvikeewekuq", "mdwdmbdtux", "vs", "bma", "wzbypigvo", "qxyy", "vsstm", "hbtnqeba", "hrzebpaz", "xhbtfnjsqebbaj", "ahaucermswyrv", "ddmbtx", "zhhbiqiw", "pxpsvikewekuq", "odqdvgbh", "bxjpsvlxktxs", "jsck", "fjmdc", "mdwdmbdtx", "jqxyyrl", "pxpsvikweuq", "ctybizcr", "dqvbh", "lpl", "lqrfzw", "ufybaozoqk", "znvaafvqi", "yvuhmiuehp", "hvrzebpazw", "pfksrllrxw", "alzuu", "xjsvxtxs", "afplzhbqguuu", "icsingrbpqli", "hjxytflhmvsgv", "femafycxdxagn", "uyaoqk", "gmlckvofwyifrw", "cinrbpql", "jrcgbhss", "oxwpkxlkcp", "jkagljikwamaqvf", "eollbigtftpdrdy", "rspvcjcm", "socbya", "clapulm", "qeb", "kwrpi", "efzpi", "hbtfnqebaj", "kykizdnandafusu", "sclvazzpulmw", "efzzpvvi", "jfvvtavwsvgl", "mhqocpy", "v", "mbpbvxsdastvtm", "irqvnxouu", "hvaajtj", "ofnlcgxrkqvcwr", "hbtqeba", "hbtqeb", "jwmqpds", "ntrnlhujdslco", "zv", "npdbccbken", "mhp", "ddb", "prllw", "mddmbtx", "clazpulm", "cogxxpaknkse", "bkitcmwxk", "oxwpklkcp", "tyiz", "jwmqvpqods", "waxyoxftvrgqmkgb", "afplzhbbqsgujuu", "bwtu", "jercgbhss", "rsacx", "mahkqodcpy", "cotycbiizlcr", "ahabucermswyrv", "lupvpkhr", "dvnn", "b", "atpepsz", "ncgxqvcr", "qe", "ubkcitlcmwxk", "lyqrfzw", "wimomuhn", "bbmnaxl", "motnfwohrwule", "yvuyhmiuehspi", "jfvvtavwsgl", "rac", "fefdxagn", "bwqkctun", "uotjrpp", "ddbtx", "afplzhbbqsguuu", "xss", "xsxs", "wvyiqax", "kykizdandaus", "npdbccbkens", "r", "oxwnpkxjlakcp", "tzmteoovsyfwz", "kykizdnandafuspu", "ahabulcermswyrvl", "xjsxxs", "qxyyr", "ck", "xhbtfnqebbaj", "nqpdbccbkens", "mpvsdastvtm", "zuexqoxyp", "gmlkvofwyifrw", "kmw", "txhn", "kykizdandausu", "molznwhkxsn", "lupvpdkhr", "jwmqvpds", "bktcmwx", "wyiax", "hzvaajtj", "ddbx", "pifojogveub", "naafvqi", "motnfwjohrwule", "odqvbh", "aicsingrbpqli", "jopzyeg", "lybtqrfazrw", "pijogveub", "xzejfnllhfulns", "scxllvazzpulmw", "irqyvnxdcxfoejuu", "cogxpaknks", "pdkwrpsi", "wzbycpajigvo", "xjsxtxs", "irqvnxdcxfoejuu", "xhbtfnjqebbaj", "uybaoqk", "oncgxqvcr", "aj", "pepuwsxl", "lytqrfzw", "nkm", "jrgs", "pkrllrw", "wscfvrfyli", "bbmjnaxcaml", "jftavwg", "vuzvcozaif", "pifjogveub", "cmogxxpaknkse", "cinrbql", "scqlciwmxw", "ztvyfz", "mxyevopfoimgjpww", "soicbya", "lupvpdkhrm", "ahaucermsyrv", "ufybmvbaouzoqk", "bdxjpsvlxktxs", "hjxytfflhmvsgv", "hjvxytfflhmvsgv", "nqpdbccbzkxens", "wr", "kykzdndus", "iddimea", "fjmdrcc", "efzzpi", "vsdastm", "btqeb", "pfkrllrxw", "ocby", "irqvnxxouu", "ildzpdimea", "lzwhkxsn", "ilddimea", "ufybvbaozoqk", "mxyevopfoimgjww", "jhr", "kcmwx", "dvn", "uzcof", "glw", "hbtnqebaj", "riahv", "w", "qeugv", "kfeuqyre", "ilrdzpdimea", "lplm", "icinrbpql", "scqlcmxw", "bbmjnaxaml", "e", "rsac", "bf", "jwmqvpqds", "tzteoovsyfwz", "rc", "lzwhkxs", "jkgljikwamaqvf", "tybizc", "aplzuu", "nrtyzifwytjblw", "pze", "bktcmwxk", "uiykgmc", "jsctk", "npdbccbe", "tybizcr"};

        int result = new Solution().longestStrChain(words);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void case7() {
        var words = new String[]{"klmnowx", "abcdefgiklmno", "fgij", "bcfghijklmno", "fgjpqrst", "uy", "abceklmnouvw", "pqrstuwy", "fghijlno", "mnouvwxy", "klmnopqt", "klmnopqrstuy", "aeuvw", "muvw", "abcdeklmnow", "fhijpqrst", "mpqrst", "klmnoprt", "fghijklno", "abcdelmo", "klnuvwxy", "klmnopst", "abcdeklmnov", "fghj", "luvwxy", "ghklmnopqrst", "pqrstwx", "abcdklmno", "cdefghij", "pqrs", "efghijklmno", "fghjklmno", "adeklmno", "rs", "kuvwxy", "ghij", "befghijklmno", "ln", "hijklmnopqrst", "ghpqrst", "fgiklmnopqrst", "pqrtuvwxy", "pqrsty", "jklmnopqrst", "lnouvwxy", "klmnoqsuvwxy", "abcdeghklmno", "fi", "fghijlnpqrst", "abdklmnouvw", "uwx", "abcdekln", "klmno", "abcdekn", "abcdemuvw", "pqs", "fghijpqt", "klmnopqrstuw", "n", "nopqrstuvwxy", "abcdefghj", "fghiklmnopqrst", "klmnorst", "abcdemnouvw", "fgh", "pqt", "abfghij", "o", "nouvw", "abcdklmnouvw", "abeklmno", "abcden", "klmnopqrstwxy", "q", "fghijklmnoprt", "klmnovx", "abceuvw", "klmnopsuvwxy", "hj", "abcdefgh", "fhjklmno", "klmnoquvwxy", "wxy", "klmnopqrstuvwy", "kln", "abcdegklmno", "mno", "gklmno", "klnouvw", "fghijklmnoqr", "fghijpqrst", "mnuvwxy", "ghipqrst", "klmnoqrtuvwxy", "acdfghij", "uwy", "fghjklmnopqrst", "mnpqrstuvwxy", "abcdeknouvw", "abcdefghijklmno", "klmnorsuvwxy", "abcdeh", "klmnost", "iklmnopqrst", "abcdegijklmno", "fghijklmopqrst", "fghijklmnors", "pqrstux", "abcdefghijlm", "abcdem", "klmn", "opqrst", "ghjklmnopqrst", "cdfghij", "kluvwxy", "ceklmno", "abcdeghijklmno", "lmo", "bklmno", "fghijs", "cdeklmnouvw", "abcdeknuvw", "cdklmnouvw", "abcdeklmnovw", "klmnopr", "fghijklmnopqrst", "klmnopqtuvwxy", "abcdefhijklmno", "abcdeuv", "abcdefhklmno", "x", "abcdeouvw", "fjklmno", "a", "klmnopqrstuv", "abdklmno", "fghijlm", "bcefghijklmno", "quvwxy", "fghi", "klmnopqrstuwx", "r", "klmnuvw", "kn", "abcdeklmn", "abcdeklmno", "ps", "klmnoqrt", "pstuvwxy", "klmnopqrsty", "lmn", "d", "abcdefghijmo", "fghijmnopqrst", "ghiklmno", "mouvwxy", "abcdeghj", "fghijklmnopr", "kmnouvwxy", "fghijklmnopqst", "klmnox", "nouvwxy", "adefghijklmno", "kmo", "klmnovy", "klmnopqrstuvwxy", "cde", "y", "klmnouy", "fgklmnopqrst", "nuvwxy", "kluvw", "abcdefghijkno", "abcdekl", "fghijno", "ceuvw", "abcdelo", "bcdklmno", "gij", "abcdeijklmno", "klmnopqrt", "abcdeklm", "pqruvwxy", "klnuvw", "fijklmno", "knpqrstuvwxy", "fghijklmnor", "ace", "abcdekluvw", "deklmnouvw", "lpqrstuvwxy", "abcdefhiklmno", "fijpqrst", "klmnopqrstvwy", "mn", "kmpqrst", "ipqrst", "fghijkmnpqrst", "uvxy", "bklmnouvw", "fghijkmnopqrst", "fghijklnopqrst", "kopqrstuvwxy", "pqrstuwxy", "abdeuvw", "acefghij", "jklmno", "k", "fghijqs", "abcdefghijno", "fghijklmnort", "adeuvw", "vwx", "gjklmno", "hi", "abcdefghijm", "nuvw", "fklmnopqrst", "abcdehklmno", "fghijklmnoqrt", "klmnoruvwxy", "abcdemnuvw", "klmnovw", "klmnopqrstvw", "klmnoqtuvwxy", "klmnoy", "wx", "ouvwxy", "lmopqrst", "fghjpqrst", "lnuvwxy", "vy", "abdfghijklmno", "kmnouvw", "uvy", "klmnoqst", "klmnort", "pqrstuxy", "qs", "lopqrstuvwxy", "mnouvw", "abdeklmno", "abcdelnouvw", "pruvwxy", "qrsuvwxy", "cklmno", "bc", "acdfghijklmno", "j", "fghijpqs", "fghijknopqrst", "fgijklmno", "fghijnopqrst", "mpqrstuvwxy", "knopqrst", "acdeuvw", "lnouvw", "fghijklmn", "klmnouvxy", "abcdefghiklmno", "abcdefghij", "hij", "abcdekuvw", "klmnopqs", "aklmnouvw", "acdefghijklmno", "cfghij", "fghijpqst", "cfghijklmno", "abcdefhi", "kmouvwxy", "pquvwxy", "pqrstuy", "pqrstuwx", "ce", "klmnopqrstv", "deklmno", "klmnouvw", "abcdeno", "fghijkmo", "knouvwxy", "fpqrst", "hklmno", "fghijkmopqrst", "abcdefghjklmno", "kmpqrstuvwxy", "dklmnouvw", "abcdefghijkmo", "abcdel", "giklmnopqrst", "buvw", "klmo", "klmnoqrsuvwxy", "uvwy", "abcdeluvw", "klmnostuvwxy", "bceklmno", "fghijm", "defghijklmno", "ijklmno", "pqr", "abcduvw", "fghijklmnopqt", "hijklmno", "klmnoprsuvwxy", "aeklmno", "lo", "klmnouxy", "cdklmno", "fghijpr", "muvwxy", "lmnouvwxy", "abce", "kmnopqrst", "pt", "klmnoptuvwxy", "abde", "abcdeghiklmno", "klmnopqsuvwxy", "klmnouvx", "efghij", "klmnouwy", "bceklmnouvw", "klmnuvwxy", "ad", "klmnoux", "gjpqrst", "abcdegij", "fghijkpqrst", "fghijlmnopqrst", "abcdefj", "fghijklmnops", "fghijklmnoqs", "ghi", "fghijqst", "abcdemo", "abcdefghijkl", "fghklmnopqrst", "no", "klmnopqrstuwxy", "klmnopqrstvwx", "abcdeklmnou", "abdefghijklmno", "klmnopqrstxy", "acfghij", "pqrstuvwy", "kuvw", "abcdehi", "de", "fghijpq", "lmuvwxy", "abcdelmouvw", "abdfghij", "knuvwxy", "acde", "cuvw", "uw", "kmopqrstuvwxy", "abcfghij", "fghij", "abcdeklmo", "abcdehij", "abcdek", "fghijklmnoqrst", "pqrstvx", "klmnopqrstvx", "abc", "klmnoqrstuvwxy", "acklmnouvw", "afghijklmno", "abcdeklmnuvw", "abcdei", "fgiklmno", "klmnopqrstuvw", "abcklmnouvw", "abcdelmnuvw", "abcdehj", "abcdefghijlo", "fghpqrst", "acfghijklmno", "abcdeg", "klpqrst", "klmouvw", "bdfghijklmno", "aefghijklmno", "fijklmnopqrst", "fghijps", "fghijklnpqrst", "fghijklmnop", "fklmno", "klmnopqrstw", "abcdfghijklmno", "fj", "lnopqrst", "fghijkmpqrst", "fghijlnopqrst", "ux", "fgjklmno", "fghijklmnopqr", "abcdeghjklmno", "abcdefghijkmn", "abcdegiklmno", "abcdefiklmno", "acdeklmno", "klmnops", "fghijklmnopqrt", "fghijklmnoqt", "abcdegj", "acdklmno", "abcdeghi", "abcdelmuvw", "abcdefg", "fghijkl", "gjklmnopqrst", "hipqrst", "klmnopqstuvwxy", "lnuvw", "ghijpqrst", "pqrstuvwxy", "klmnovwx", "klmnoqstuvwxy", "bcklmnouvw", "abdeklmnouvw", "fghijklmnopq", "abcdefghijk", "abcdefghijklno", "fiklmnopqrst", "klmnopq", "npqrstuvwxy", "klmnopqrstwx", "abcdefi", "lpqrst", "ghijklmnopqrst", "bd", "bcuvw", "hjklmnopqrst", "adfghijklmno", "klmnosuvwxy", "louvwxy", "bce", "gpqrst", "fghijklmnot", "wy", "pqrstvwxy", "fghijkln", "lmouvw", "gi", "fghijn", "fhklmnopqrst", "ghj", "klpqrstuvwxy", "abcdefgklmno", "fghijlmo", "fghijo", "fhpqrst", "klmnoprs", "abcefghij", "abcdeklno", "abcdefghijlmno", "kmnpqrst", "fghijklmnoq", "abcdefhij", "fghijklmnopt", "klmnopt", "abcdefklmno", "abcdelno", "pqrstw", "fghijlopqrst", "bfghij", "abuvw", "abcdefghijln", "ac", "aefghij", "prs", "lmnopqrstuvwxy", "abcdefghijn", "klmnopqrstux", "luvw", "giklmno", "kpqrst", "jpqrst", "fghijrt", "fghijlo", "abcdefij", "fghijklmnorst", "fghijqrst", "tuvwxy", "fghijlmopqrst", "klmnouwxy", "bdeuvw", "fghijprt", "klmnoprst", "pqrstuvy", "fghijpqrt", "fgj", "pqrstvxy", "abdefghij", "abcdegh", "abefghij", "lno", "klmnopuvwxy", "klmnouvwxy", "fghijrst", "cd", "euvw", "hijpqrst", "pqrst", "klopqrst", "gijpqrst", "klmnopqrs", "fghijk", "klopqrstuvwxy", "rtuvwxy", "klmnorstuvwxy", "stuvwxy", "abcdevw", "cdefghijklmno", "bdeklmno", "pqstuvwxy", "fghipqrst", "fghijpst", "kmn", "mo", "abcdeuw", "qst", "fghijklmnost", "klnopqrst", "abcdekm", "abcdefgj", "klmnopqrstuvy", "kouvw", "abcdelmnouvw", "abefghijklmno", "fgipqrst", "klm", "klmnopstuvwxy", "abcdekmno", "fghijmno", "pqrstvw", "kmouvw", "cdeklmno", "st", "fij", "fhiklmno", "abcdefghklmno", "lmnuvwxy", "klmnovwy", "klmnow", "mnuvw", "fghijklmnpqrst", "klmnoxy", "fghklmno", "b", "lopqrst", "pqrstuvw", "abcdekmouvw", "abcdeklmnouw", "acduvw", "klmnoq", "bde", "pqrstxy", "qrs", "bcdeklmnouvw", "abcdekmo", "abcdefghijkn", "kno", "abcdefghijklm", "abcdefgij", "kmopqrst", "kmnuvwxy", "pqrstuvwx", "fghijkmn", "acdefghij", "fghijmn", "qr", "l", "kmnopqrstuvwxy", "abcdefghijl", "afghij", "auvw", "abcdew", "klmnopqrstwy", "adfghij", "abcdeghij", "lmopqrstuvwxy", "abcdefghijklmn", "uvx", "km", "abcdefijklmno", "abcdeij", "pq", "lnpqrst", "bdfghij", "abcdefhj", "mopqrstuvwxy", "fghijklmnopqs", "fghijqt", "ade", "abcdejklmno", "fghijklmpqrst", "pqrstuvxy", "mouvw", "mopqrst", "lmnopqrst", "abcdefhjklmno", "acdklmnouvw", "bcklmno", "nopqrst", "qrt", "fghijlmnpqrst", "pqrstuv", "klmnos", "pqrstwxy", "fgjklmnopqrst", "pqrstuw", "klmnopqrstuvxy", "fhijklmno", "abcdekmnuvw", "ghjklmno", "klmnoprtuvwxy", "abcdefghijlmn", "klmouvwxy", "abcdegjklmno", "p", "hiklmnopqrst", "rstuvwxy", "gh", "cdfghijklmno", "klmnou", "iklmno", "klmnopqrstvxy", "lmpqrstuvwxy", "prtuvwxy", "klmnovwxy", "pqst", "klmnortuvwxy", "lmnpqrstuvwxy", "fghijmpqrst", "ghiklmnopqrst", "klmpqrst", "klmnoprstuvwxy", "ghklmno", "fghijopqrst", "klmnoqruvwxy", "abcdeklmouvw", "ae", "abcfghijklmno", "vw", "fghijr", "kmnpqrstuvwxy", "fghijklpqrst", "vwxy", "uxy", "cklmnouvw", "abcdefghijkm", "uvw", "bcd", "bcefghij", "abcdeiklmno", "klmnot", "cduvw", "fghijmo", "eklmnouvw", "klmnopqrstuwy", "kmnuvw", "lmouvwxy", "abcdefghijlmo", "cefghij", "klmnoqs", "klmnouwx", "kmuvwxy", "ceklmnouvw", "fghijklmnoqrs", "abduvw", "abceklmno", "ghijklmno", "abcdefghijmn", "bcdfghij", "pqrstvwx", "fghijlpqrst", "gijklmnopqrst", "abcdelnuvw", "pqrstvwy", "pr", "fghijklmnos", "c", "fghijklmno", "abcdefghijkmno", "abcuvw", "abcdev", "abeuvw", "pqrstuvx", "klo", "fghijln", "klmnpqrstuvwxy", "abcdefghijlno", "fghijklmnopst", "acd", "gipqrst", "w", "abcdenuvw", "deuvw", "abcdeklmnouvw", "fg", "cdeuvw", "lmnuvw", "abcdenouvw", "klmnoqt", "hklmnopqrst", "klmnouvwy", "gijklmno", "klmnopqrst", "fghijmopqrst", "kmno", "f", "uv", "fhij", "knuvw", "klmnor", "klnouvwxy", "bcdeuvw", "bdklmno", "abklmnouvw", "abcdehjklmno", "bcde", "fghijklmo", "abcdefghijklmo", "ko", "abcdeklmuvw", "bcdefghijklmno", "beuvw", "qstuvwxy", "aeklmnouvw", "h", "t", "kmuvw", "fhi", "fjklmnopqrst", "hiklmno", "fhipqrst", "qrtuvwxy", "abcdeklnuvw", "fghijqrt", "pqrstx", "bdefghijklmno", "gj", "abcdelmno", "abcdefjklmno", "fhjpqrst", "klnpqrst", "fgijklmnopqrst", "abcdelm", "fghijrs", "klmnouw", "fhklmno", "abcdeln", "fgijpqrst", "fghijklmnoqst", "abeklmnouvw", "klmuvw", "i", "lmno", "fghijklo", "fghijkm", "g", "adklmnouvw", "be", "abcdefgjklmno", "prst", "puvwxy", "qrstuvwxy", "klmnov", "klmnopqrstuvwx", "acefghijklmno", "fghijpqrs", "fhj", "abklmno", "abcd", "fiklmno", "ijpqrst", "fghijnpqrst", "lmnouvw", "suvwxy", "knouvw", "duvw", "fghijkmno", "bdefghij", "aceklmno", "fgklmno", "fghijst", "adefghij", "fghijklmnopqrs", "bcdefghij", "abcdefghijko", "klmnotuvwxy", "klmnopruvwxy", "klmnovxy", "qtuvwxy", "fhjklmnopqrst", "klmnoqrst", "prt", "fghijt", "uvwx", "abcdekmnouvw", "dfghij", "abcdehiklmno", "klmnopqrstu", "adeklmnouvw", "abcdefghijmno", "klmnopquvwxy", "abcdefghijkln", "mnpqrst", "fghijlmn", "lnopqrstuvwxy", "pqrt", "fghijpt", "abcde", "ij", "bcdklmnouvw", "fghijkn", "pst", "bdklmnouvw", "abcdeko", "fh", "fjpqrst", "fghijqr", "beklmno", "fghijklopqrst", "lmuvw", "klouvw", "fghijpqr", "abcdegi", "psuvwxy", "klnopqrstuvwxy", "abcdelmn", "fhiklmnopqrst", "fghijprst", "lnpqrstuvwxy", "qruvwxy", "aduvw", "abcdekmuvw", "adklmno", "abcdeu", "cefghijklmno", "lm", "hjklmno", "abcdefghijklo", "klmnoqrs", "fghijko", "ouvw", "pqrstu", "mnopqrst", "louvw", "prsuvwxy", "abcdekno", "klmnopqruvwxy", "kpqrstuvwxy", "abcdefgijklmno", "klmnors", "abcdefghijo", "npqrst", "knopqrstuvwxy", "vx", "fghijqrs", "klmnopqrstuxy", "u", "aceuvw", "klmnopqrtuvwxy", "uvwxy", "fipqrst", "klmnowxy", "befghij", "gklmnopqrst", "abe", "mnopqrstuvwxy", "fghijklmnoprs", "abcdeo", "eklmno", "fgi", "fghijlmpqrst", "qt", "abcdefghi", "bcduvw", "bduvw", "klouvwxy", "kouvwxy", "fghiklmno", "abcdemno", "pqsuvwxy", "ab", "klmnopqrstvwxy", "pqrstv", "abfghijklmno", "beklmnouvw", "fghijklm", "pqrsuvwxy", "acdeklmnouvw", "vwy", "ghjpqrst", "fghijl", "klmnopqrstvy", "abcdelouvw", "fhijklmnopqrst", "klmpqrstuvwxy", "abcdef", "bcfghij", "fghijkno", "kopqrst", "rsuvwxy", "abcdekmn", "aklmno", "dfghijklmno", "abcdeklouvw", "klmnpqrst", "abcdeklmnouv", "knpqrst", "aceklmnouvw", "kl", "fghijprs", "rt", "klmnopqrsuvwxy", "bfghijklmno", "klmnouv", "abcdefh", "s", "klmnouvwx", "fghijp", "uwxy", "fghijq", "klmnoqr", "vxy", "fgpqrst", "fghijlmno", "defghij", "pqtuvwxy", "dklmno", "klno", "klmnowy", "abcdemn", "abcdeklnouvw", "ptuvwxy", "abcdehijklmno", "acuvw", "bcdfghijklmno", "abcdemouvw", "abcdefgi", "opqrstuvwxy", "v", "lmpqrst", "abcdeuvw", "abcdekouvw", "qrst", "klmopqrstuvwxy", "prstuvwxy", "lmnpqrst", "pqrstvy", "abcdfghij", "klmnop", "ijklmnopqrst", "klnpqrstuvwxy", "klmnopqr", "xy", "abcdeklo", "abd", "klmnouvy", "klmuvwxy", "abcefghijklmno", "fghijkopqrst", "fghijklmnoprst", "ruvwxy", "m", "e", "abcdej", "hpqrst", "bceuvw", "fghijmnpqrst", "pqrstwy", "klmnopqrstx", "qsuvwxy", "fghijknpqrst", "bcdeklmno", "klmopqrst", "bdeklmnouvw", "klmnopqst", "klmnopqrstuvx", "acklmno", "hjpqrst", "abcklmno", "rst"};

        int result = new Solution().longestStrChain(words);

        assertThat(result).isEqualTo(15);
    }
}
