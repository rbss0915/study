package com.yedam.app.products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductsDAO extends DAO{
	//싱글톤
	private static ProductsDAO productsDAO = null;
	private ProductsDAO() {}
	public static ProductsDAO getInstance() {
		if(productsDAO == null) {
			productsDAO = new ProductsDAO();
		}
		return productsDAO;
	}
	
	//등록
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO products (product_id, product_name, product_price) " + "VALUE(products_seq.nextval, ?,?)";	//""+합쳐도 나눠도 됨	나눌때 공백주의
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상 등록 완료");
			}else {
				System.out.println("정상 등록 실패");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//수정 - 재고
	public void updateStock(Product product) {
		try {
			connect();
			String sql = "UPDATE products "
					     +"SET product_stock = " + product.getProductStock()		//물음표 쓰면 pstmt 물음표 안쓰면 stmt하고 뒤에 값가져오는 2개방법
					     +"WHERE product_id = " + product.getProductId();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result > 0){
				System.out.println("정상 수정 완료");
			}else {
				System.out.println("정상 수정 실패");
			}
					     
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정 - 이름, 가격
	public void updateInfo(Product product) {
		try {
			connect();
			String sql = "UPDATE products "
						+"SET product_name = ?,"
						+" product_price =? "
						+"WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductId());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상 수정 완료");
			}else {
				System.out.println("정상 수정 실패");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(int productId) {		//잘못해서 여러개 삭제될수도 있으니 다가져올필요 없어 단일값이 좋데 Product product
		try {
			connect();
			String sql = "DELETE FROM products "
						+"WHERE product_id = " + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result > 0) {
				System.out.println("정삭 삭제 완료");
			}else {
				System.out.println("정상 삭제 실패");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//단건조회 - 재고이름으로		리턴타입, 변수 중요
	public Product selectOne(String productName) {
		Product product = null;		//리턴타입의 변수에 넣도록
		try {
			connect();
			String sql = "SELECT * FROM products "
						+ "WHERE product_name = ?";		//네임은 키도없고 중복도 가능하니까 쿼리 짤때 주의, 딴거는 중복없고 하나만있으니 하나만 수정됨
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {					//while써도 한개값 가져오긴함. 한개가져와서 와일돌고 덮고 딴거또 가져와서 덮고 담고. 단건조회로 보이긴하나,,쿼리는 단건조회가 아니지만 자바에서 컨트롤함. 자바에서 컨트롤 비추천. 값가져오도록만 추천. SQL문활용
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return product;
		
	}
	
	//전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM products "
						+"ORDER BY  product_id";	//순서굿
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
				
				list.add(product);	//빠트림 주의
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
		
	}

}
