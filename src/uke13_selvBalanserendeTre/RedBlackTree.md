# Red-Black Tree: 
def: It is a binary tree where the nodes are labeled the colors **Red** or **Black**. 

### There are six conditions that a red-black tree must full fill: 
* Every node has a color **Red** og **Black**. 
* Root node is always **Black**.
* New node insertions are always **Red**. 
* Every path  from root to leaf(the deepest level) must have the same
number of **Black** nodes. 
* No path can have to **Red** nodes after each other.
* Nulls are **Black**. 

### Balancing the tree:
if any of those six conditions where violated, then the tree corrected.

Two ways of correcting a violation: 
We will look at the aunt (node.parent.parent.child) of the node that has
caused the violation in the tree. 

* if the aunt is **Red**: then we do a color flip. 
* if the aunt is **Black** or **null**: then we do a rotation. 