number=$1

line_number=$(grep -n "include(" "settings.gradle.kts" | cut -d: -f1)
sed -i '' "$line_number a\\
\"problems:leet-$number\",
" "settings.gradle.kts"

main_dir="problems/leet-$number/src/main/java/uk/matvey/play/leet$number/java1"
test_dir="problems/leet-$number/src/test/java/uk/matvey/play/leet$number/java1"
package="package uk.matvey.play.leet$number.java1;"

mkdir -p "$main_dir"
cat <<EOF > "$main_dir/Solution.java"
$package

public class Solution {
}
EOF

mkdir -p "$test_dir"
cat <<EOF > "$test_dir/SolutionTest.java"
$package

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void case1() {
    }
}
EOF
