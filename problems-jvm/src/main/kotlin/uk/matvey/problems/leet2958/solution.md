# Sliding window + HashMap + HashSet Kotlin solution with explanation

* We are iterating over the `nums` list from the left to the right using two indices, `right` and `left`, functioning as
  the head and tail of a sliding window, respectively
* We use a `HashMap` called `freq` to keep track of the frequency of each number within the current window (from `left`
  to `right`)
* At each iteration, we extend the subarray to the right by incrementing the `right` index
    * If current subarray is good, we update `maxLen` if current subarray length is greater
    * If current subarray is not good, we move `left` index forward
* **Note**: when some frequency exceeds `k`, we don't need to move `left` more than one step forward on every iteration.
  The task is to find `maxLen` so we can continue moving `right` as well
* Checking all values in `freq` on every step can be costly, so we use a `HashSet` called `problematic` to keep track of
  numbers with frequencies exceeding `k`
* `maxLen` is the answer
