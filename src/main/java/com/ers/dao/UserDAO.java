package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.ers.models.*;
import com.ers.utilities.ConnectionUtil;

import javax.xml.transform.Result;

public class UserDAO implements DAOControl<User, Integer>, UserDAOInterface {

	ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	@Override
	public int create(User u) {
		
		Integer userId = 0;
		
		try (Connection conn = cu.getConnection()) {
			
			conn.setAutoCommit(false);
			
			String sql = "insert into ers_usrs values (default, ?, ?, ?, ?, ?, ?)";
			
			String[] keys = {"ers_usrs_id"};
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getFirstName());
			pstmt.setString(4, u.getLastName());
			pstmt.setString(5, u.getEmail());
			pstmt.setInt(6, u.getRole().getUserRoleId());
			
			pstmt.executeUpdate();
			

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				userId = rs.getInt(1);
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return userId;
	}

	
	public User findById(Integer i) {

		User u = new User();

		try (Connection conn = cu.getConnection()) {
			
			String sql = "select ers_usrs.ers_usrs_id, ers_usrs.ers_usrnm, ers_usrs.ers_pswd, ers_usrs.usr_fst_nm, ers_usrs.usr_lst_nm, ers_usrs.usr_eml, " +
					"(select ers_usr_roles.usr_role from ers_usr_roles where ers_usr_roles.ers_usr_role_id = ers_usrs.usr_role_id) " +
					"from ers_usrs where ers_usrs_id = ?";
						
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, i);
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				u.setUserId(rs.getInt("ers_usrs_id"));
				u.setUsername(rs.getString("ers_usrnm"));
				u.setPassword(rs.getString("ers_pswd"));
				u.setFirstName(rs.getString("usr_fst_nm"));
				u.setLastName(rs.getString("usr_lst_nm"));
				u.setEmail(rs.getString("usr_eml"));
				
				UserRole r = new UserRole();

				r.setUserRole(rs.getString("usr_role"));
				
				u.setRole(r);
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return u;
	}

	public Set<Reimbursement> findReimbursementsByUserId (int userId){

		Set<Reimbursement> allReimbs = new HashSet<>();

		try (Connection conn = cu.getConnection()) {

			String sql = "select * from ers_reimb where reimb_author = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				Reimbursement reimb = new Reimbursement();
				reimb.setReimbursementId(rs.getInt("reimb_id"));
				reimb.setAmount(rs.getDouble("reimb_amt"));
				reimb.setDescription(rs.getString("reimb_description"));

				ReimbursementStatus reimbStatus = new ReimbursementStatus();
				reimbStatus.setReimbStatusId(rs.getInt("reimb_stat_id"));
//				reimbStatus.setReimbStatus(rs.getString("reimb_stat"));
				reimb.setReimbStatus(reimbStatus);

				ReimbursementType reimbType = new ReimbursementType();
				reimbType.setReimbTypeId(rs.getInt("reimb_type_id"));
//				reimbType.setReimbType(rs.getString("reimb_type"));
				reimb.setReimbType(reimbType);

				allReimbs.add(reimb);


				return allReimbs;

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public UserRole getRoleById(int id) {
		String sql = "select * from ers_usr_roles where ers_usr_role_id = ?";
		UserRole r = new UserRole();

		try(Connection conn = cu.getConnection()){

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				r.setUserRoleId(id);
				r.setUserRole(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public User getUserByUsername(String username) {

		try (Connection conn = cu.getConnection()) {

			String sql = "select * from ers_usrs join ers_usr_roles on ers_usrs.usr_role_id" +
					" = ers_usr_roles.ers_usr_role_id where ers_usrs.ers_usrnm = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				User u = new User();

				u.setUserId(rs.getInt("ers_usrs_id"));
				u.setUsername(rs.getString("ers_usrnm"));
				u.setPassword(rs.getString("ers_pswd"));
				u.setFirstName(rs.getString("usr_fst_nm"));
				u.setLastName(rs.getString("usr_lst_nm"));
				u.setEmail(rs.getString("usr_eml"));

				UserRole r = new UserRole();

				r.setUserRoleId(rs.getInt("ers_usr_role_id"));
				r.setUserRole(rs.getString("usr_role"));

				u.setRole(r);


				return u;

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public User checkUsernamePassword(String username, String password) {
		String sql = "{call validateUser(?,?)}";

		User u = null;

		try (Connection conn = cu.getConnection()) {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, password);
			cs.setString(2, username);

			ResultSet rs = cs.executeQuery();

			if (rs.next()) {
				UserRole ur = getRoleById(rs.getInt(7));
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), ur);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
