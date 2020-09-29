package collection;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

class ProductSearchData{
	
	Map<String, String> map;
	
	public ProductSearchData() {
		
		map = new HashMap<String, String>();
		
		map.put("세탁기", "드럼 세탁기 최신형");
		map.put("냉장고", "지펠 냉장고 최신형");
		map.put("TV", "HDTV 150인치 최신 모델");
	}
	
	String search(String productName) {
		String str = null;
		
		if(map.containsKey(productName)) {
			str = map.get(productName);
		}
		return str;
		
	}
}

public class Exam02 {

	public static void main(String[] args) {
		
		ProductSearchData psd = new ProductSearchData();
		
		String prodName = JOptionPane.showInputDialog("검색할 상품명을 입력하세요.");
		
		try {
			psd.search(prodName).length();
			JOptionPane.showMessageDialog(null, psd.search(prodName));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "해당 상품이 없습니다.");
		}

	}

}
