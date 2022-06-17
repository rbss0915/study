package com.yedam.java.history;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;

public class HistoryDAO extends DAO{
	//싱글톤
	private static HistoryDAO historyDAO = null;
	private HistoryDAO() {}
	public static HistoryDAO getInstance() {
		if(historyDAO == null) {
			historyDAO = new HistoryDAO();
		}
		return historyDAO;
	}

	//CRUD
	//등록
	public void insert(History his) {
		try {
			connect();
			String sql = "INSERT INTO product_history VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, his.getProductId());
			pstmt.setInt(2, his.getProductCategory());
			pstmt.setInt(3, his.getProductAmount());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("등록이 완료료되었습니다.");
			}else {
				System.out.println("등록되지 않았습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//수정	-수량
	public void update(History his) {
		try {
			connect();
			String sql = "UPDATE product_history product_amount = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,his.getProductId());
			pstmt.setInt(2,his.getProductAmount());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정되지않음");
			}
			System.out.println(result + "건이 완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//삭제
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM product_history WHERE product_id = " + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result > 0) {
				System.out.println("정상 삭제");
			}else {
				System.out.println("정상삭제되지 않음");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//단건조회1-각 상품에 대한 입고
	public int selectInAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM product_history WHERE product_id = ? AND product_category = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("SUM(product_amount)");
				//result = rs.getInt("sum"); 같음
				//result = rs.getInt("1"); 같음
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	//단건조회2-각 상품에 대한 출고량
	public int selectOutAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM product_history WHERE product_id = ? AND product_category = 2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("SUM(product_amount)");
				//result = rs.getInt("sum"); 같음
				//result = rs.getInt("1"); 같음
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;

	}
	/*public History selectOne(int historyId) {
		History his = null;
		try {
			connect();
			String sql = "SELECT*FROM product_history WHERE history_id = " + historyId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				his = new History();
				his.setProductId(rs.getInt("product_id"));
				his.setProductCategory(rs.getInt("product_category"));
				his.setProductAmount(rs.getInt("product_amount"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return his;
	}*/
	//전체조회	-전체 상품의 각 재고
	public Map<Integer, Integer> selectAllAmount() {
		Map<Integer, Integer> list = new HashMap<>();
		try {
			connect();
			//각 제품에 따른 입고량과 출고량
			String sql = "SELECT product_id, product_category, SUM(product_amount) as amount FROM product_history GROUP BY product_id, product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//입고와 출고에 따른 각각의 목록
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			while(rs.next()) {
				int category = rs.getInt("product_category");
				if(category == 1) {
					inList.put(rs.getInt("product_id"), rs.getInt("amount"));
				}else {
					outList.put(rs.getInt("product_id"), rs.getInt("amount"));
				}
			}
			
			Set<Integer> keySet = inList.keySet();
			for(int key : keySet) {
				int intAmount = inList.get(key);
				Integer outAmount = outList.get(key);
				if(outAmount != null) {
					list.put(key, (intAmount - outAmount));
				}else {
					list.put(key,intAmount);
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		}
		return list;
	}
	/*public List<History> selectAll(){
		List<History> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM product_history");
			while(rs.next()) {
				History his = new History();
				his.setProductId(rs.getInt("product_id"));
				his.setProductCategory(rs.getInt("product_category"));
				his.setProductAmount(rs.getInt("product_amount"));
				list.add(his);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}*/

}
