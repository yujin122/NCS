package sist;

import javax.swing.JOptionPane;

public class ProductSearch {

	public static void main(String[] args) {
		
		ProductSearchData psd = new ProductSearchData();
		
		String prdName = JOptionPane.showInputDialog("검색할 상품명을 입력하세요.");
		
		try {
			psd.search(prdName).length();
			JOptionPane.showMessageDialog(null, psd.search(prdName));
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "해당 상품이 없습니다.");
		}
	}
}