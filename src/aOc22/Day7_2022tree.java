package aOc22;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day7_2022tree {
	static ArrayList<Day7_2022tree> list=new ArrayList<Day7_2022tree>();
	Day7_2022tree parent;
    List<Day7_2022tree> children;
    public String name;
	int tot;
	static int cu=0;

    public Day7_2022tree(String n) {
    	this.parent=this;
        this.name = n;
        this.children = new LinkedList<Day7_2022tree>();
    }

    public void addChild(String child) {
    	Day7_2022tree childNode = new Day7_2022tree(child);
        childNode.parent = this;
        this.children.add(childNode);
        list.add(childNode);
    }
    public Day7_2022tree getPar() {
    	return parent;
    }

    public Day7_2022tree find(String ee) throws Exception {
		for (Day7_2022tree nn:list) {
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
	public  Day7_2022tree getChild(String c) throws Exception {
		for (Day7_2022tree nn:children) {
			if (nn.name.equals(c)) {
				return nn;
			}
		}
		throw new Exception ("nope");
	}
	public long conta() {
		long tt=tot;
		if (children.size()>0) {
			for (Day7_2022tree chil:children) {
				tt=tt+chil.conta();
			}
		}
		return tt;
	}
}