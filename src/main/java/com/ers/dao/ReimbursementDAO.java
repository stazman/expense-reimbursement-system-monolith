package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.ers.models.Reimbursement;
import com.ers.models.ReimbursementStatus;
import com.ers.models.ReimbursementType;
import com.ers.utilities.ConnectionUtil;

public class ReimbursementDAO implements DAOControl<Reimbursement, Integer>, ReimbursementDAOInterface {

	ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	@Override
	public int create (Reimbursement reimb) {
					
		Integer reimbId = 0;
		
		try (Connection conn = cu.getConnection()) {
			
			conn.setAutoCommit(false);
						
			
			String sql = "INSERT INTO ers_reimb values(default,?,current_timestamp,null ,?, ?, ?, null, ?, ?)";

			String[] keys = {"reimb_id"};
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			
			pstmt.setDouble(1, reimb.getAmount());
			pstmt.setString(2, reimb.getDescription());
			pstmt.setString(3, reimb.getReceipt());
			pstmt.setInt(4, reimb.getReimbAuthor().getUserId());
			pstmt.setInt(6, reimb.getReimbStatus().getReimbStatusId());
			pstmt.setInt(7, reimb.getReimbType().getReimbTypeId());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				reimbId = rs.getInt(1);
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return reimbId;
	}

	@Override
	public Reimbursement update(Reimbursement reimb) {
		
		try (Connection conn = cu.getConnection()) {
			
			conn.setAutoCommit(false);
			
			String sql = "update ers_reimb set reimb_resolved = current_timestamp , reimb_resolver = ?, reimb_stat_id = ? where reimb_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, reimb.getReimbResolver().getUserId());
			pstmt.setInt(2, reimb.getReimbStatus().getReimbStatusId());
			pstmt.setInt(3, reimb.getReimbursementId());

			int rowsEffected = pstmt.executeUpdate();

			if (rowsEffected == 1) {
					conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public Set<Reimbursement> findAll() {

		Set<Reimbursement> allReimbs = new HashSet<>();

		try (Connection conn = cu.getConnection()) {

			String sql = "select reimb_id, reimb_amt, reimb_description, ers_reimb.reimb_stat_id, ers_reimb.reimb_type_id from ers_reimb "
					+ "join ers_reimb_stat on ers_reimb.reimb_stat_id = ers_reimb_stat.reimb_stat_id "
					+ "join ers_reimb_type on ers_reimb.reimb_type_id = ers_reimb_type.reimb_type_id;";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				Reimbursement reimb = new Reimbursement();
				reimb.setReimbursementId(rs.getInt("reimb_id"));
				reimb.setAmount(rs.getDouble("reimb_amt"));
				reimb.setDescription(rs.getString("reimb_description"));

				ReimbursementStatus reimbStatus = new ReimbursementStatus();
				reimbStatus.setReimbStatusId(rs.getInt("reimb_stat_id"));
				reimb.setReimbStatus(reimbStatus);

				ReimbursementType reimbType = new ReimbursementType();
				reimbType.setReimbTypeId(rs.getInt("reimb_type_id"));
				reimb.setReimbType(reimbType);

				allReimbs.add(reimb);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return allReimbs;
	}

	@Override
	public Set<Reimbursement> findByStatus(String status) {

		Set<Reimbursement> reimbsByStatus = new HashSet<>();

		try (Connection conn = cu.getConnection()) {

			String sql = "select reimb_id, reimb_amt, reimb_description, ers_reimb.reimb_stat_id, ers_reimb.reimb_type_id from ers_reimb "
					+ "join ers_reimb_stat on ers_reimb.reimb_stat_id = ers_reimb_stat.reimb_stat_id "
					+ "join ers_reimb_type on ers_reimb.reimb_type_id = ers_reimb_type.reimb_type_id where ers_reimb_stat.reimb_stat = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, status);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				Reimbursement reimb = new Reimbursement();
				reimb.setReimbursementId(rs.getInt("reimb_id"));
				reimb.setAmount(rs.getDouble("reimb_amt"));
				reimb.setDescription(rs.getString("reimb_description"));

				ReimbursementStatus reimbStatus = new ReimbursementStatus();
				reimbStatus.setReimbStatusId(rs.getInt("reimb_stat_id"));
				reimb.setReimbStatus(reimbStatus);

				ReimbursementType reimbType = new ReimbursementType();
				reimbType.setReimbTypeId(rs.getInt("reimb_type_id"));
				reimb.setReimbType(reimbType);

				reimbsByStatus.add(reimb);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return reimbsByStatus;
	}
}
