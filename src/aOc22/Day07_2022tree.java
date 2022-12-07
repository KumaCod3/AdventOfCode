package aOc22;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day07_2022tree {
	static ArrayList<Day07_2022tree> list=new ArrayList<Day07_2022tree>();
	Day07_2022tree parent;
    List<Day07_2022tree> children;
    public String name;
	int tot;
	static int cu=0;

    public Day07_2022tree(String n) {
    	this.parent=this;
        this.name = n;
        this.children = new LinkedList<Day07_2022tree>();
    }

    public void addChild(String child) {
    	Day07_2022tree childNode = new Day07_2022tree(child);
        childNode.parent = this;
        this.children.add(childNode);
        list.add(childNode);
    }
    public Day07_2022tree getPar() {
    	return parent;
    }

    public Day07_2022tree find(String ee) throws Exception {
		for (Day07_2022tree nn:list) {
			if (ee.equals(nn.name)) {
				return nn;
			}
		}
		throw new Exception("nope");
	}
    
	public int getTot() {
		return tot;
	}
	void add(int x) {
		tot=tot+x;
	}
	public  Day07_2022tree getChild(String c) throws Exception {
		for (Day07_2022tree nn:children) {
			if (nn.name.equals(c)) {
				return nn;
			}
		}
		throw new Exception ("nope");
	}
	public long conta() {
		long tt=tot;
		if (children.size()>0) {
			for (Day07_2022tree chil:children) {
				tt=tt+chil.conta();
			}
		}
		return tt;
	}
}