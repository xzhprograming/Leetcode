# LeetCode 算法题解 (Java)

本项目是 LeetCode 算法题目的 Java 实现，按照算法类型分类整理，包含详细的解题思路和代码实现。

## 项目结构

```
src/
├── array/                  # 数组相关
│   └── diffarray/          # 差分数组
├── backtrack/              # 回溯算法
├── binarysearchtree/       # 二叉搜索树
├── binarytree/             # 二叉树
│   ├── construct/          # 二叉树构造
│   ├── serialize/          # 二叉树序列化
│   ├── thought/            # 二叉树解题思路
│   └── traversetree/       # 二叉树遍历
├── common/                 # 公共数据结构
│   ├── ListNode.java       # 链表节点
│   ├── TreeNode.java       # 二叉树节点
│   └── Node.java           # 多叉树/N叉树节点
├── dfs/                    # 深度优先搜索
├── doublepointer/          # 双指针
│   ├── array/              # 数组双指针
│   ├── linkedlist/         # 链表双指针
│   └── slidewindow/        # 滑动窗口
├── dp/                     # 动态规划
│   └── stock/              # 股票买卖问题
├── greed/                  # 贪心算法
├── hash/                   # 哈希表
├── heap/                   # 堆/优先队列
├── interval/               # 区间问题
├── linkedList/             # 链表
├── monotonicstack/         # 单调栈
├── prefixsum/              # 前缀和
├── sort/                   # 排序算法
├── stack/                  # 栈
├── string/                 # 字符串
└── twodimensionalarray/    # 二维数组
```

## 数据结构定义

### 链表节点 (ListNode)
```java
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) { this.val = val; }
}
```

### 二叉树节点 (TreeNode)
```java
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) { this.val = val; }
}
```

## 算法分类与题目列表

### 1. 双指针 (Double Pointer)

双指针技巧主要用于数组和链表的遍历，通过两个指针的相对移动来解决问题。

#### 数组双指针
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 11 | [盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/) | [Solution11.java](src/doublepointer/array/Solution11.java) | Medium |
| 15 | [三数之和](https://leetcode.cn/problems/3sum/) | [Solution15.java](src/doublepointer/array/Solution15.java) | Medium |
| 18 | [四数之和](https://leetcode.cn/problems/4sum/) | [Solution18.java](src/doublepointer/array/Solution18.java) | Medium |
| 26 | [删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/) | [Solution26.java](src/doublepointer/array/Solution26.java) | Easy |
| 27 | [移除元素](https://leetcode.cn/problems/remove-element/) | [Solution27.java](src/doublepointer/array/Solution27.java) | Easy |
| 42 | [接雨水](https://leetcode.cn/problems/trapping-rain-water/) | [Solution42.java](src/doublepointer/array/Solution42.java) | Hard |
| 88 | [合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/) | [Solution88.java](src/doublepointer/array/Solution88.java) | Easy |
| 167 | [两数之和 II](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/) | [Solution167.java](src/doublepointer/array/Solution167.java) | Medium |
| 283 | [移动零](https://leetcode.cn/problems/move-zeroes/) | [Solution283.java](src/doublepointer/array/Solution283.java) | Easy |
| 658 | [找到 K 个最接近的元素](https://leetcode.cn/problems/find-k-closest-elements/) | [Solution658.java](src/doublepointer/array/Solution658.java) | Medium |

#### 滑动窗口
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 3 | [无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) | [Solution3.java](src/doublepointer/slidewindow/Solution3.java) | Medium |
| 53 | [最大子数组和](https://leetcode.cn/problems/maximum-subarray/) | [Solution53.java](src/doublepointer/slidewindow/Solution53.java) | Medium |
| 76 | [最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/) | [Solution76.java](src/doublepointer/slidewindow/Solution76.java) | Hard |
| 438 | [找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/) | [Solution438.java](src/doublepointer/slidewindow/Solution438.java) | Medium |
| 567 | [字符串的排列](https://leetcode.cn/problems/permutation-in-string/) | [Solution567.java](src/doublepointer/slidewindow/Solution567.java) | Medium |

#### 链表双指针
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 83 | [删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/) | [Sloution83.java](src/doublepointer/linkedlist/Sloution83.java) | Easy |

---

### 2. 链表 (Linked List)

| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 21 | [合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/) | [Solution21.java](src/linkedList/Solution21.java) | Easy |
| 23 | [合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/) | [Solution23.java](src/linkedList/Solution23.java) | Hard |
| 25 | [K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/) | [Solution25.java](src/linkedList/Solution25.java) | Hard |
| 61 | [旋转链表](https://leetcode.cn/problems/rotate-list/) | [Solution61.java](src/linkedList/Solution61.java) | Medium |
| 86 | [分隔链表](https://leetcode.cn/problems/partition-list/) | [Solution86.java](src/linkedList/Solution86.java) | Medium |
| 92 | [反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/) | [Solution92.java](src/linkedList/Solution92.java) | Medium |
| 142 | [环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/) | [Solution142.java](src/linkedList/Solution142.java) | Medium |
| 146 | [LRU 缓存](https://leetcode.cn/problems/lru-cache/) | [Solution146.java](src/linkedList/Solution146.java) | Medium |
| 148 | [排序链表](https://leetcode.cn/problems/sort-list/) | [Solution148.java](src/linkedList/Solution148.java) | Medium |
| 160 | [相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/) | [Solution160.java](src/linkedList/Solution160.java) | Easy |

**核心技巧：**
- 反转链表
- 反转前 K 个节点
- 链表有环问题（快慢指针）
- 双向链表 + 哈希表实现 LRU

---

### 3. 二叉树 (Binary Tree)

#### 基本操作
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 104 | [二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/) | [Solution104.java](src/binarytree/Solution104.java) | Easy |
| 116 | [填充每个节点的下一个右侧节点指针](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/) | [Solution116.java](src/binarytree/thought/Solution116.java) | Medium |
| 124 | [二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) | [Solution124.java](src/binarytree/Solution124.java) | Hard |
| 226 | [翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/) | [Solution226.java](src/binarytree/thought/Solution226.java) | Easy |
| 236 | [二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/) | [Solution236.java](src/binarytree/Solution236.java) | Medium |
| 296 | [最佳的碰头地点](https://leetcode.cn/problems/best-meeting-point/) | [Solution296.java](src/binarytree/serialize/Solution296.java) | Hard |

#### 二叉树构造
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 105 | [从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | [Solution105.java](src/binarytree/construct/Solution105.java) | Medium |
| 106 | [从后序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | [Solution106.java](src/binarytree/construct/Solution106.java) | Medium |
| 889 | [根据前序和后序遍历构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/) | [Solution889.java](src/binarytree/construct/Solution889.java) | Medium |

#### 二叉搜索树 (BST)
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 96 | [不同的二叉搜索树](https://leetcode.cn/problems/unique-binary-search-trees/) | [Solution96.java](src/binarysearchtree/Solution96.java) | Medium |
| 98 | [验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/) | [Solution98.java](src/binarysearchtree/Solution98.java) | Medium |
| 152 | [二叉搜索树的最小共同祖先](https://leetcode.cn/problems/maximum-product-subarray/) | [Solution152.java](src/binarysearchtree/Solution152.java) | Medium |
| 230 | [二叉搜索树中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/) | [Solution230.java](src/binarysearchtree/Solution230.java) | Medium |
| 450 | [删除二叉搜索树中的节点](https://leetcode.cn/problems/delete-node-in-a-bst/) | [Solution450.java](src/binarysearchtree/Solution450.java) | Medium |
| 538 | [把二叉搜索树转换为累加树](https://leetcode.cn/problems/convert-bst-to-greater-tree/) | [Solution538.java](src/binarysearchtree/Solution538.java) | Medium |
| 700 | [二叉搜索树中的搜索](https://leetcode.cn/problems/search-in-a-binary-search-tree/) | [Solution700.java](src/binarysearchtree/Solution700.java) | Easy |

**二叉树解题思维模式：**
1. **遍历模式**：通过遍历一遍二叉树得到答案，使用 `traverse` 函数配合外部变量
2. **分解问题模式**：定义递归函数，通过子问题（子树）的答案推导出原问题的答案

**引申扩展**：动归/DFS/回溯算法都可以看做二叉树问题的扩展：
- 动态规划：分解问题（分治）思路，关注整棵「子树」
- 回溯算法：遍历思路，关注节点间的「树枝」
- DFS：遍历思路，关注单个「节点」

---

### 4. 动态规划 (Dynamic Programming)

#### 经典 DP 问题
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 5 | [最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/) | [Solution5.java](src/dp/Solution5.java) | Medium |
| 152 | [乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/) | [Solution152.java](src/dp/Solution152.java) | Medium |
| 198 | [打家劫舍](https://leetcode.cn/problems/house-robber/) | [Solution198.java](src/dp/Solution198.java) | Medium |
| 213 | [打家劫舍 II](https://leetcode.cn/problems/house-robber-ii/) | [Solution213.java](src/dp/Solution213.java) | Medium |
| 300 | [最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/) | [Solution300.java](src/dp/Solution300.java) | Medium |
| 322 | [零钱兑换](https://leetcode.cn/problems/coin-change/) | [Solution322.java](src/dp/Solution322.java) | Medium |
| 337 | [打家劫舍 III](https://leetcode.cn/problems/house-robber-iii/) | [Solution337.java](src/dp/Solution337.java) | Medium |
| 354 | [俄罗斯套娃信封问题](https://leetcode.cn/problems/russian-doll-envelopes/) | [Solution354.java](src/dp/Solution354.java) | Hard |
| 1143 | [最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/) | [Solution1143.java](src/dp/Solution1143.java) | Medium |

#### 股票买卖问题
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 121 | [买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/) | [Solution121.java](src/dp/stock/Solution121.java) | Easy |
| 122 | [买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/) | [Solution122.java](src/dp/stock/Solution122.java) | Medium |
| 123 | [买卖股票的最佳时机 III](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/) | [Solution123.java](src/dp/stock/Solution123.java) | Hard |

**DP 解题框架：**
1. 定义 base case
2. 明确「状态」
3. 明确「选择」
4. 定义 dp 数组/函数的含义

```java
// 自顶向下递归的动态规划
def dp(状态1, 状态2, ...):
    for 选择 in 所有可能的选择:
        result = 求最值(result, dp(状态1, 状态2, ...))
    return result

// 自底向上迭代的动态规划
dp[0][0][...] = base case
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        dp[状态1][状态2][...] = 求最值(选择1，选择2...)
```

---

### 5. 回溯算法 (Backtracking)

| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 17 | [电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/) | [Solution17.java](src/backtrack/Solution17.java) | Medium |
| 39 | [组合总和](https://leetcode.cn/problems/combination-sum/) | [Solution39.java](src/backtrack/Solution39.java) | Medium |
| 46 | [全排列](https://leetcode.cn/problems/permutations/) | [Solution46.java](src/backtrack/Solution46.java) | Medium |
| 47 | [全排列 II](https://leetcode.cn/problems/permutations-ii/) | [Solution47.java](src/backtrack/Solution47.java) | Medium |
| 51 | [N 皇后](https://leetcode.cn/problems/n-queens/) | [Solution51.java](src/backtrack/Solution51.java) | Hard |
| 77 | [组合](https://leetcode.cn/problems/combinations/) | [Solution77.java](src/backtrack/Solution77.java) | Medium |
| 78 | [子集](https://leetcode.cn/problems/subsets/) | [Solution78.java](src/backtrack/Solution78.java) | Medium |
| 79 | [单词搜索](https://leetcode.cn/problems/word-search/) | [Solution79.java](src/backtrack/Solution79.java) | Medium |
| 90 | [子集 II](https://leetcode.cn/problems/subsets-ii/) | [Solution90.java](src/backtrack/Solution90.java) | Medium |

**核心思想**：尝试所有可能的选择，找到一个选择使得问题得到解决，然后返回到上一个选择，并尝试下一个选择（进行选择并撤销）。

**问题类型**：
- 排列问题
- 组合问题（子集问题）
- N 皇后问题

---

### 6. DFS / BFS

| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 62 | [不同路径](https://leetcode.cn/problems/unique-paths/) | [Solution62.java](src/dfs/Solution62.java) | Medium |
| 200 | [岛屿数量](https://leetcode.cn/problems/number-of-islands/) | [Solution200.java](src/dfs/Solution200.java) | Medium |
| 329 | [矩阵中的最长递增路径](https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/) | [Solution329.java](src/dfs/Solution329.java) | Hard |
| 1020 | [飞地的数量](https://leetcode.cn/problems/number-of-enclaves/) | [Solution1020.java](src/dfs/Solution1020.java) | Medium |
| 1254 | [统计封闭岛屿的数目](https://leetcode.cn/problems/number-of-closed-islands/) | [Solution1254.java](src/dfs/Solution1254.java) | Medium |
| 1905 | [统计子岛屿](https://leetcode.cn/problems/count-sub-islands/) | [Solution1905.java](src/dfs/Solution1905.java) | Medium |

---

### 7. 贪心算法 (Greedy)

| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 45 | [跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/) | [Solution45.java](src/greed/Solution45.java) | Medium |
| 55 | [跳跃游戏](https://leetcode.cn/problems/jump-game/) | [Solution55.java](src/greed/Solution55.java) | Medium |

---

### 8. 排序算法 (Sort)

| 算法 | 文件 |
|------|------|
| 冒泡排序 | [BubbleSort.java](src/sort/BubbleSort.java) |
| 选择排序 | [SelectSort.java](src/sort/SelectSort.java) |
| 插入排序 | [InsertionSort.java](src/sort/InsertionSort.java) |
| 快速排序 | [QuickSort.java](src/sort/QuickSort.java) |
| 归并排序 | [MergeSort.java](src/sort/MergeSort.java) |

---

### 9. 单调栈 (Monotonic Stack)

| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 496 | [下一个更大元素 I](https://leetcode.cn/problems/next-greater-element-i/) | [Solution496.java](src/monotonicstack/Solution496.java) | Easy |
| 503 | [下一个更大元素 II](https://leetcode.cn/problems/next-greater-element-ii/) | [Solution503.java](src/monotonicstack/Solution503.java) | Medium |
| 739 | [每日温度](https://leetcode.cn/problems/daily-temperatures/) | [Solution739.java](src/monotonicstack/Solution739.java) | Medium |

---

### 10. 其他算法

#### 哈希表
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 49 | [字母异位词分组](https://leetcode.cn/problems/group-anagrams/) | [Solution49.java](src/Solution49.java) | Medium |
| 128 | [最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/) | [Solution128.java](src/hash/Solution128.java) | Medium |
| 170 | [两数之和 III](https://leetcode.cn/problems/two-sum-iii-data-structure-design/) | [Solution170.java](src/Solution170.java) | Easy |

#### 堆
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 215 | [数组中的第 K 个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/) | [Solution215.java](src/heap/Solution215.java) | Medium |

#### 数组
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 33 | [搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/) | [Solution33.java](src/array/Solution33.java) | Medium |
| 169 | [多数元素](https://leetcode.cn/problems/majority-element/) | [Solution169.java](src/array/Solution169.java) | Easy |

#### 前缀和
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 303 | [区域和检索 - 数组不可变](https://leetcode.cn/problems/range-sum-query-immutable/) | [Solution303.java](src/prefixsum/Solution303.java) | Easy |
| 304 | [二维区域和检索 - 矩阵不可变](https://leetcode.cn/problems/range-sum-query-2d-immutable/) | [Solution304.java](src/prefixsum/Solution304.java) | Medium |
| 560 | [和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/) | [Solution560.java](src/prefixsum/Solution560.java) | Medium |

#### 差分数组
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 370 | [区间加法](https://leetcode.cn/problems/range-addition/) | [Solution370.java](src/array/diffarray/Solution370.java) | Medium |
| 1094 | [拼车](https://leetcode.cn/problems/car-pooling/) | [Solution1094.java](src/array/diffarray/Solution1094.java) | Medium |
| 1109 | [航班预订统计](https://leetcode.cn/problems/corporate-flight-bookings/) | [Solution1109.java](src/array/diffarray/Solution1109.java) | Medium |

#### 栈
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 1209 | [删除字符串中的所有相邻重复项 II](https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string-ii/) | [Solution1209.java](src/stack/Solution1209.java) | Medium |
| 1249 | [移除无效的括号](https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/) | [Solution1249.java](src/stack/Solution1249.java) | Medium |

#### 字符串
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 14 | [最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/) | [Solution14.java](src/string/Solution14.java) | Easy |
| 28 | [找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/) | [Solution28.java](src/string/Solution28.java) | Easy |

#### 区间
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 56 | [合并区间](https://leetcode.cn/problems/merge-intervals/) | [Solution56.java](src/interval/Solution56.java) | Medium |

#### 二维数组
| # | 题目 | 文件 | 难度 |
|---|------|------|------|
| 48 | [旋转图像](https://leetcode.cn/problems/rotate-image/) | [Solution48.java](src/twodimensionalarray/Solution48.java) | Medium |
| 54 | [螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/) | [Solution54.java](src/twodimensionalarray/Solution54.java) | Medium |

## 递归

递归是编程和数学中的一个重要概念，它指的是一个函数（或算法）直接或间接调用自身的处理方式。

**基本要素：**
- **基准情况（Base Case）**：递归终止的条件，避免函数无限地调用自身
- **递归步骤（Recursive Step）**：函数调用自己来解决比原问题规模更小的子问题

## 贡献

欢迎提交 Issue 或 PR 来完善题解！
