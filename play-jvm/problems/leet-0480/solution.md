# Sliding window + 2 heaps Kotlin solution with explanation
* Naive approach: slide through the array, on every step sort the window and get median from it. The problem is that sorting is quite costly operation and we don't want to perform it many times
* To improve sorting performance we can use heap; on every step we'll add new element on the right and remove leftmost element from the heap. The problem here is that heap is not great at getting its middle element as this requires scrolling through half of its elements
* To solve this we can use two heaps. The first one's head will point to the largest element of the smaller half of the window, the second one's head will point to the smallest element of the larger half of the window. This way both heads are pointed to the elements we calculate median from. We just need to maintain balance between elements while sliding through the array

So the algorithm is:
1. **Initialization**
   - Start by taking the first `k` elements from `nums`, creating a subarray, and sorting it
   - Divide the sorted subarray into two halves: the smaller half (`firstHalf`) and the larger half (`secondHalf`)
   - Use two heaps: `firstHalf`, with a reverse order comparator, and `secondHalf` with a natural order comparator
2. **Sliding window iteration**. Iterate over the remaining elements in `nums` from `0` to `nums - k`
      1. Add the new element to the appropriate heap (`firstHalf` or `secondHalf`)
      2. Remove the element that is being replaced from the corresponding heap
      3. Rebalance if needed. For example, when you add a new element to `secondHalf` and remove an old element from `firstHalf`, the heaps may become unbalanced. In such cases, move one element from the bigger heap to the smaller one to maintain balance
      4. Calculate the sliding median using the heads of the heaps, taking care to handle overflows if necessary
3. **Special case**. If `k == nums.size` then `nums` is the answer

```kotlin
class Solution {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        if (k == 1) {
            return nums.map { it.toDouble() }.toDoubleArray()
        }
        val slidingMedian = DoubleArray(nums.size - k + 1)
        val (leftHalf, rightHalf) = initHeaps(k, nums)
        slidingMedian[0] = median(k, leftHalf, rightHalf)
        (0 until nums.size - k).forEach { i ->
            val left = nums[i]
            if (left < rightHalf.peek()) {
                leftHalf.remove(left)
            } else {
                rightHalf.remove(left)
            }
            val right = nums[i + k]
            if (rightHalf.isNotEmpty() && right < rightHalf.peek() || rightHalf.isEmpty() && right < leftHalf.peek()) {
                leftHalf.offer(right)
            } else {
                rightHalf.offer(right)
            }
            if (leftHalf.size < rightHalf.size - 1) {
                leftHalf.offer(rightHalf.poll())
            } else if (rightHalf.size < leftHalf.size) {
                rightHalf.offer(leftHalf.poll())
            }
            slidingMedian[i + 1] = median(k, leftHalf, rightHalf)
        }
        return slidingMedian
    }

    private fun initHeaps(
        k: Int,
        nums: IntArray,
    ): Pair<PriorityQueue<Int>, PriorityQueue<Int>> {
        val leftHalf = PriorityQueue<Int>(k / 2, Comparator.reverseOrder())
        val rightHalf = PriorityQueue<Int>(if (k % 2 == 0) k / 2 else k / 2 + 1)
        (0 until k).map { nums[it] }.sorted().forEachIndexed { i, n ->
            if (i < k / 2) {
                leftHalf.offer(n)
            } else {
                rightHalf.offer(n)
            }
        }
        return leftHalf to rightHalf
    }

    private fun median(
        k: Int,
        leftHalf: PriorityQueue<Int>,
        rightHalf: PriorityQueue<Int>
    ) = if (k % 2 == 0) (leftHalf.peek().toLong() + rightHalf.peek()) / 2.0 else rightHalf.peek().toDouble()
}
```
