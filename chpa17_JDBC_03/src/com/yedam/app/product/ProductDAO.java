package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO {
	//싱글톤
	private static ProductDAO productDAO = null;
	private ProductDAO() {}
	public static ProductDAO getInstance() {
		if(productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}
	
	//CRUD
	//등록
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO product VALUES (product_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상 등록");
			}else {
				System.out.println("정상 등록되지 않음");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정-가격 무엇을수정할건지
	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET product_price = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setInt(2, product.getProductId());
				
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("정상 수정");
			}else {
				System.out.println("정상 수정되지 않음");
			}
			
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
			String sql = "DELETE FROM product WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
				
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("정상 삭제");
			}else {
				System.out.println("정상 삭제되지 않음");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
			
		}
	}
	//단건조회-제품번호 무엇을 기준으로 조회할건지
	public Product selectOne(int productId){
		Product pro = new Product();
			try {
				connect();
				String sql = "SELECT * FROM product WHERE product_id =" + productId;
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if(rs.next()){
					pro.setProductId(rs.getInt("product_id"));
					pro.setProductName(rs.getString("product_name"));
					pro.setProductPrice(rs.getInt("product_price"));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return pro;
	}
	//단건조회-제품이름
	public Product selectOne(String productName){
		Product pro = null;
			try {
				connect();
				String sql = "SELECT * FROM product WHERE product_name = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, productName);
				rs = pstmt.executeQuery();
				if(rs.next()){
					pro = new Product();
					pro.setProductId(rs.getInt("product_id"));
					pro.setProductName(rs.getString("product_name"));
					pro.setProductPrice(rs.getInt("product_price"));
				}
			}catch (SQLException e) {
				e.printStackTrace();

			}finally {
				disconnect();
			}
			return pro;
	}
	//전체조회
	public List<Product> selectAll(){
		List<Product> list = new ArrayList <Product>();
			try {
				connect();
				String sql = "SELECT * FROM product ORDER BYE product_id";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
				Product pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
				list.add(pro);
				}
			}catch (SQLException e) {
				
			}finally {
				disconnect();
			}
			return list;
	}
	
 }
