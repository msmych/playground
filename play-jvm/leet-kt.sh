number=$1

line_number=$(grep -n "include(" "settings.gradle.kts" | cut -d: -f1)
sed -i '' "$line_number a\\
\"problems:leet-$number\",
" "settings.gradle.kts"

main_dir="problems/leet-$number/src/main/kotlin/uk/matvey/play/leet$number/kotlin1"
test_dir="problems/leet-$number/src/test/kotlin/uk/matvey/play/leet$number/kotlin1"
package="package uk.matvey.play.leet$number.kotlin1"

mkdir -p "$main_dir"
cat <<EOF > "$main_dir/Solution.kt"
$package

class Solution {
}
EOF

mkdir -p "$test_dir"
cat <<EOF > "$test_dir/SolutionTest.kt"
$package

import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
    }
}
EOF
