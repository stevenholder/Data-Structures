
public class OurBinarySearchTree extends OurBinaryTree<Comparable> {
	
	public OurBinarySearchTree() {
		super();
	}

	public OurBinarySearchTree(Comparable data) {
		super(data, new OurBinarySearchTree(), new OurBinarySearchTree());
	}
	
	public OurBinarySearchTree(Comparable data, OurBinarySearchTree left, OurBinarySearchTree right) {
		super(data, left, right);
	}
	
	public OurBinarySearchTree getLeftTree() {
		return (OurBinarySearchTree) super.getLeftTree();
	}
	
	public OurBinarySearchTree getRightTree() {
		return (OurBinarySearchTree) super.getRightTree();
	}
	
	public OurBinarySearchTree getLeftMost() {
		return (OurBinarySearchTree) super.getLeftMost();
	}
	
	public OurBinarySearchTree getRightMost() {
		return (OurBinarySearchTree) super.getRightMost();
	}	
	
	public boolean contains(Comparable target) {
		if(isEmpty())
			return false;
		else {
			int comparison = getData().compareTo(target);
			if(comparison == 0)
				return true;
			else {
				if(comparison < 0) {
					return getRightTree().contains(target);
				} else {
					return getLeftTree().contains(target);
				}
			}
		}
	}
	
	public boolean add(Comparable target) {
		if(isEmpty()) {
			setData(target);
			this.setLeftTree(new OurBinarySearchTree());
			this.setRightTree(new OurBinarySearchTree());
			return true;
		} else {
			int comparison = getData().compareTo(target);
			if(comparison == 0)
				return false;
			else {
				if(comparison < 0) {
					return getRightTree().add(target);
				} else {
					return getLeftTree().add(target);
				}
			}
		}
	}
	
	public OurBinarySearchTree find(Comparable target) {
		if(isEmpty())
			return null;
		else {
			int comparison = getData().compareTo(target);
			if(comparison == 0)
				return this;
			else {
				if(comparison < 0) {
					return getRightTree().find(target);
				} else {
					return getLeftTree().find(target);
				}
			}
		}
	}	
	
	public Comparable delete(Comparable target) {
		if(isEmpty())
			return null;
		else {
			int comparison = getData().compareTo(target);
			if(comparison == 0) {
				Comparable tempData = getData();
				if(isLeaf()) {
					setData(null);
				}else if(!getLeftTree().isEmpty() && !getRightTree().isEmpty()){
					setData(getLeftTree().getRightMost().delete(getLeftTree().getRightMost().getData()));
				}else {
					OurBinarySearchTree notEmptyChild = (!getLeftTree().isEmpty())? getLeftTree() : getRightTree();
					setData(notEmptyChild.getData());
					notEmptyChild.setData(null);
				}				
				return tempData;
			} else {
				if(comparison < 0) {
					return getRightTree().delete(target);
				} else {
					return getLeftTree().delete(target);
				}
			}
		}
	}
	
	public boolean remove(Comparable target) {
		if(isEmpty()) {
			return false;
		} else {
			delete(target);
			return true;
		}
	}
	
	
	public static void main(String[] args) {
		OurBinarySearchTree lay = new OurBinarySearchTree("lay");
		lay.add("charles");
		lay.add("ball");
		lay.add("seven");
		
		lay.delete("seven");
		lay.remove("charles");
		
		System.out.println(lay.contains("lay"));
		System.out.println(lay.contains("charles"));
		System.out.println(lay.contains("ball"));
		System.out.println(lay.contains("seven"));
	}
}
