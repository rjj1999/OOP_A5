package simpledatabase;
import java.util.ArrayList;

public class Projection extends Operator{
	
	ArrayList<Attribute> newAttributeList;
	private String attributePredicate;


	public Projection(Operator child, String attributePredicate){
		
		this.attributePredicate = attributePredicate;
		this.child = child;
		newAttributeList = new ArrayList<Attribute>();
		
	}
	
	
	/**
     * Return the data of the selected attribute as tuple format
     * @return tuple
     */
	@Override
	public Tuple next(){
		Tuple tuple = child.next();
		newAttributeList = new ArrayList<Attribute>();
		Tuple newTuple;
		if (tuple == null){
			return null;
			}
		else{
			for(Attribute attribute:tuple.getAttributeList()){
				if(attribute.getAttributeName().equals(attributePredicate)){
					newAttributeList.add(attribute);
				}
			}
			newTuple = new Tuple(newAttributeList);
			return newTuple;
		}
	}
		

	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return child.getAttributeList();
	}

}