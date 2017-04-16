package Demo13DI_Collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyBean
{
	private List<String> list;
	private Map<Integer,Object> map;
	private Set<String> set;
	Properties addressProp;
	private String[] array;
	public Set<String> getSet()
	{
		return set;
	}
	public Properties getAddressProp()
	{
		return addressProp;
	}
	public void setSet(Set<String> set)
	{
		this.set = set;
	}
	public void setAddressProp(Properties addressProp)
	{
		this.addressProp = addressProp;

	}
	public List<String> getList()
	{
		return list;
	}
	public String[] getArray()
	{
		return array;
	}
	public void setArray(String[] array)
	{
		this.array = array;
	}
	public Map<Integer, Object> getMap()
	{
		return map;
	}
	public void setList(List<String> list)
	{
		this.list = list;
	}
	public void setMap(Map<Integer, Object> map)
	{
		this.map = map;
	}
	@Override
	public String toString()
	{
		return "MyBean [list=" + list + ", map=" + map + ", set=" + set
				+ ", addressProp=" + addressProp + ", array="
				+ Arrays.toString(array) + "]";
	}
}
