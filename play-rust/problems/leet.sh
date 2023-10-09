number=$1

line_number=$(grep -n "members = \[" "Cargo.toml" | cut -d: -f1)

sed -i '' "$line_number a\\
\"leet-$number\",
" "Cargo.toml"

cargo new leet-$number --lib

cat <<EOF > "leet-$number/src/lib.rs"
struct Solution;

impl Solution {
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
    }
}
EOF
