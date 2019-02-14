package com.ubn.ciss.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubn.ciss.model.AccountDetails;
import com.ubn.ciss.model.AccountDetailsChannels;
import com.ubn.ciss.model.ClosedStatistics;
import com.ubn.ciss.model.DormantStatistics;
import com.ubn.ciss.model.InternalAccounts;
import com.ubn.ciss.model.InternalAccountsFull;
import com.ubn.ciss.model.ListAccountsByBVN;
import com.ubn.ciss.model.ListStatistics;
import com.ubn.ciss.model.Signatories;
import com.ubn.ciss.model.SignatoriesWithNIN;
import com.ubn.ciss.model.TransactionDetails;
import com.ubn.ciss.model.TransactionDetailsChannels;
import com.ubn.ciss.model.cbnServiceResponse;
import com.ubn.ciss.utils.DBConnect;
import com.ubn.ciss.model.ListTIN_RCNo;
import com.ubn.ciss.model.PendingDebits;
import oracle.jdbc.OracleTypes;

@Repository
public class CbnCissRepositoryImpl implements CbnCissRepository {

	@Autowired
	DBConnect dBConnect;

	cbnServiceResponse cbnresp = null;

	@Override
	public cbnServiceResponse pr_transactiondetails(String StartDt, String EndDt, String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<TransactionDetails> data = new ArrayList<>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_transactiondetails(?,?,?,?)}");
			cll.setString(1, StartDt);
			cll.setString(2, EndDt);
			cll.setString(3, AccNo);
			cll.registerOutParameter(4, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(4);
				if (rs != null) {
					while (rs.next()) {
						TransactionDetails dataset = new TransactionDetails();
						dataset.setTRA_DATE(rs.getString("TRA_DATE"));
						dataset.setVal_DATE(rs.getString("VAL_DATE"));
						dataset.setNarration(rs.getString("NARRATION"));
						dataset.setCurrency(rs.getString("CURRENCY"));
						dataset.setTRA_AMT(rs.getString("TRA_AMT"));
						dataset.setTRA_TYPE(rs.getString("TRA_TYPE"));
						dataset.setDR_AMT(rs.getString("DR_AMT"));
						dataset.setCR_AMT(rs.getString("CR_AMT"));
						dataset.setSTART_BAL(rs.getString("START_BAL"));
						dataset.setTRA_BAL(rs.getString("TRA_BAL"));
						
						data.add(dataset);
					}
				} else
					data = null;
				cbnresp = new cbnServiceResponse("00", "Successful", data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse pr_transactiondetailschannels(String StartDt, String EndDt, String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<TransactionDetailsChannels> data = new ArrayList<>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_transactiondetailschannels(?,?,?,?)}");
			cll.setString(1, StartDt);
			cll.setString(2, EndDt);
			cll.setString(3, AccNo);
			cll.registerOutParameter(4, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(4);
				if (rs != null) {
					while (rs.next()) {
						TransactionDetailsChannels dataset = new TransactionDetailsChannels();
						dataset.setTRA_DATE(rs.getString("TRA_DATE"));
						dataset.setVal_DATE(rs.getString("VAL_DATE"));
						dataset.setNarration(rs.getString("NARRATION"));
						dataset.setCurrency(rs.getString("CURRENCY"));
						dataset.setTRA_AMT(rs.getString("TRA_AMT"));
						dataset.setTRA_TYPE(rs.getString("TRA_TYPE"));
						dataset.setDR_AMT(rs.getString("DR_AMT"));
						dataset.setCR_AMT(rs.getString("CR_AMT"));
						dataset.setTRA_BAL(rs.getString("TRA_BAL"));
						dataset.setTRA_CHANNEL(rs.getString("TRA_CHANNEL"));
						dataset.setPayment_Type(rs.getString("PAYMENT_TYPE"));
						
						data.add(dataset);
					}
				} else
					data = null;
				cbnresp = new cbnServiceResponse("00", "Successful", data);
			}
		} catch (Exception e) {
			// TODO: handle finally clause
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public AccountDetails pr_accountdetails(String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		AccountDetails dataset = new AccountDetails();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_accountdetails(?,?)}");
			cll.setString(1, AccNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						dataset.setStatus("00");
						dataset.setMsg("Successful");
						dataset.setName(rs.getString("ACCOUNT_HOLDER"));
						dataset.setType(rs.getString("ACCOUNT_TYPE"));
						dataset.setCategory(rs.getString("CATEGORY"));
						dataset.setTier(rs.getString("TIER"));
						dataset.setCLR_BAL(rs.getString("CLR_BAL"));
						dataset.setAVL_BAL(rs.getString("AVL_BAL"));
						dataset.setAccountNo(rs.getString("ACCOUNTNO"));
						dataset.setAddress(rs.getString("ADDRESS"));
						dataset.setEmail(rs.getString("EMAIL").toLowerCase());
						dataset.setTelephone(rs.getString("TELEPHONE"));
						dataset.setCurrency(rs.getString("CURRENCY"));
						dataset.setAOD(rs.getString("AOD"));
						dataset.setBVN(rs.getString("BVN"));
						dataset.setAccount_Status(rs.getString("ACCOUNT_STATUS"));
						dataset.setRestriction_Status(rs.getString("RESTRICTION_STATUS"));
					}
				} else
					dataset = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return dataset;
	}

	@Override
	public AccountDetailsChannels pr_accountdetailschannels(String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		AccountDetailsChannels dataset = new AccountDetailsChannels();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_accountdetailschannels(?,?)}");
			cll.setString(1, AccNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						dataset.setStatus("00");
						dataset.setMsg("Successful");
						dataset.setName(rs.getString("ACCOUNT_HOLDER"));
						dataset.setType(rs.getString("ACCOUNT_TYPE"));
						dataset.setCategory(rs.getString("CATEGORY"));
						dataset.setTier(rs.getString("TIER"));
						dataset.setCLR_BAL(rs.getString("CLR_BAL"));
						dataset.setAVL_BAL(rs.getString("AVL_BAL"));
						dataset.setAccountNo(rs.getString("ACCOUNTNO"));
						dataset.setAddress(rs.getString("ADDRESS"));
						dataset.setEmail(rs.getString("EMAIL").toLowerCase());
						dataset.setTelephone(rs.getString("TELEPHONE"));
						dataset.setCurrency(rs.getString("CURRENCY"));
						dataset.setAOD(rs.getString("AOD"));
						dataset.setBVN(rs.getString("BVN"));
						dataset.setAccount_Status(rs.getString("ACCOUNT_STATUS"));
						dataset.setRestriction_Status(rs.getString("RESTRICTION_STATUS"));
						dataset.setTax_ID_Number(rs.getString("TAX_ID_NUMBER"));
						dataset.setNIN(rs.getString("NIN"));
						dataset.setRC_Number(rs.getString("RC_NUMBER"));
					}
				} else
					dataset = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return dataset;
	}

	@Override
	public cbnServiceResponse pr_signatories(String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<Signatories> data = new ArrayList<>();
		cbnresp = new cbnServiceResponse("99", "Error", null);
		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_signatoriesWithNIN(?,?)}");
			cll.setString(1, AccNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						Signatories dataset = new Signatories();
						dataset.setName(rs.getString("NAME"));
						dataset.setBVN(rs.getString("BVN"));
						dataset.setDate_of_birth(rs.getString("DATE_OF_BIRTH"));

						data.add(dataset);
					}
				} else {
					data = null;
				}
				cbnresp = new cbnServiceResponse("00", "Successful", data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse pr_signatoriesWithNIN(String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<SignatoriesWithNIN> data = new ArrayList<>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_signatoriesWithNIN(?,?)}");
			cll.setString(1, AccNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						SignatoriesWithNIN dataset = new SignatoriesWithNIN();
						dataset.setName(rs.getString("NAME"));
						dataset.setBVN(rs.getString("BVN"));
						dataset.setDate_of_birth(rs.getString("DATE_OF_BIRTH"));
						dataset.setNIN(rs.getString("NIN"));

						data.add(dataset);
					}
				} else
					data = null;
				cbnresp = new cbnServiceResponse("00", "Successful", data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse pr_listAccountsByBVN(String BVN) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<ListAccountsByBVN> dataset = new ArrayList<ListAccountsByBVN>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ListAccountsByBVN(?,?)}");
			cll.setString(1, BVN);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						ListAccountsByBVN data = new ListAccountsByBVN();
						data.setNuban(rs.getString("NUBAN"));
						data.setBank_Code(rs.getString("BANK_CODE"));
						data.setAVL_BAL(rs.getString("AVL_BAL"));
						data.setCurrency(rs.getString("CURRENCY"));

						dataset.add(data);
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse ListAccountsByRCNo(String RCNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<Map<String, String>> dataset = new ArrayList<Map<String, String>>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_listAccountsByRCNo(?,?)}");
			cll.setString(1, RCNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						Map<String, String> acc = new HashMap<String, String>();
						acc.put("Nuban", rs.getString("NUBAN"));

						dataset.add(acc);
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse ListAccountsByTIN(String TIN) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<Map<String, String>> dataset = new ArrayList<Map<String, String>>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_listAccountsByTIN(?,?)}");
			cll.setString(1, TIN);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						Map<String, String> acc = new HashMap<String, String>();
						acc.put("Nuban", rs.getString("NUBAN"));

						dataset.add(acc);
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse ListAccountsByNIN(String NIN) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<Map<String, String>> dataset = new ArrayList<Map<String, String>>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ListAccountsByNIN(?,?)}");
			cll.setString(1, NIN);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						Map<String, String> acc = new HashMap<String, String>();
						acc.put("Nuban", rs.getString("NUBAN"));

						dataset.add(acc);
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse ActiveTIN() {
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		Map<String, String> dataset = new HashMap<String, String>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ActiveTIN(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						dataset.put("Percentage", rs.getString("PERCENTAGE_OF_ACCTIVE_CORP_TIN"));
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse ActiveRCNo() {
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		Map<String, String> dataset = new HashMap<String, String>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ActiveRCNo(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						dataset.put("Percentage", rs.getString("PERTGE_OF_ACCTIVE_CORP_RCNO"));
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse ActiveNIN() {
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		Map<String, String> dataset = new HashMap<String, String>();
		cbnresp = new cbnServiceResponse("99", "Error", null);

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ActiveNIN(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						dataset.put("Percentage", rs.getString("pertge_of_acctive_corp_NIN"));
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}

		return cbnresp;
	}

	@Override
	public cbnServiceResponse LstTIN_RCNo() {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		cbnresp = new cbnServiceResponse("99", "Error", null);
		List<ListTIN_RCNo> dataset = new ArrayList<ListTIN_RCNo>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ListTIN_RCNo(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						ListTIN_RCNo data = new ListTIN_RCNo();
						data.setNuban(rs.getString("NUBAN"));
						data.setTIN(rs.getString("TIN"));
						data.setRCNumber(rs.getString("RC_NO"));

						dataset.add(data);
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse pr_ListInternalAccounts(String ledgerCode) {
		// TODO Auto-generated method stub

		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		cbnresp = new cbnServiceResponse("99", "Error", null);
		List<InternalAccounts> dataset = new ArrayList<InternalAccounts>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ListInternalAccounts(?,?)}");
			cll.setString(1, ledgerCode);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						InternalAccounts data = new InternalAccounts();
						data.setAccountNo(rs.getString("ACCOUN_NO"));

						dataset.add(data);
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse pr_ListInternalAccountFull(String ledgerCode) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		cbnresp = new cbnServiceResponse("99", "Error", null);
		List<InternalAccountsFull> dataset = new ArrayList<InternalAccountsFull>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ListInternalAccountsFull(?,?)}");
			cll.setString(1, ledgerCode);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						InternalAccountsFull data = new InternalAccountsFull();
						data.setAccountNo(rs.getString("ACCOUN_NO"));
						data.setStatus(rs.getString("STATUS"));
						data.setCurrency(rs.getString("CURRENCY"));
						data.setDescription(rs.getString("DESCRIPTION"));
						data.setTRA_BAL(rs.getString("TRA_BAL"));

						dataset.add(data);
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public cbnServiceResponse InternalAccountsSignatories(String ledgerCode) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<Map<String, String>> dataset = new ArrayList<>();
		Map<String, String> data = new HashMap<String, String>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_InternalAccountsSignatorie(?,?)}");
			cll.setString(1, ledgerCode);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						data.put("Name",rs.getString("NAME"));

						dataset.add(data);
					}
				} else
					dataset = null;
				cbnresp = new cbnServiceResponse("00", "Successful", dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return cbnresp;
	}

	@Override
	public ListStatistics List_Statistics() {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		ListStatistics dataset = new ListStatistics();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_liststatistics(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						dataset.setStatus("00");
						dataset.setMsg("Successful");
						dataset.setActiveAccounts(rs.getString("ACTIVEACCOUNTS"));
						dataset.setActiveCorporate(rs.getString("ACTIVECORPORATE"));
						dataset.setActiveindividual(rs.getString("ACTIVEINDIVIDUAL"));
						dataset.setActiveTier1(rs.getString("ACTIVETIER1"));
						dataset.setActiveTier2(rs.getString("ACTIVETIER2"));
						dataset.setActiveTier3(rs.getString("ACTIVETIER3"));
					}
				} else
					dataset = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return dataset;
	}
	
	public DormantStatistics Dormant_Statistics() {
		// TODO Auto-generated method stub
				Connection conn = null;
				CallableStatement cll = null;
				ResultSet rs = null;
				DormantStatistics dataset = new DormantStatistics();
				
				try {
					conn = dBConnect.getConn();
					cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_DormantStatistics(?)}");
					cll.registerOutParameter(1, OracleTypes.CURSOR);

					if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
						rs = (ResultSet) cll.getObject(1);
						if (rs != null) {
							while (rs.next()) {
								dataset.setStatus("00");
								dataset.setMsg("Successful");
								dataset.setDormantAccounts(rs.getString("DORMANTACCOUNTS"));
								dataset.setDormantAccountsAmt(rs.getString("DORMANTACCOUNTSAMT"));
								dataset.setDormantCorporate(rs.getString("DORMANTCORPORATE"));
								dataset.setDormantCorpAccountsAmt(rs.getString("DORMANTCORPACCOUNTSAMT"));
								dataset.setDormantIndividual(rs.getString("DORMANTINDIVIDUAL"));
								dataset.setDormantIndAccountsAmt(rs.getString("DORMANTINDACCOUNTSAMT"));
								dataset.setDormantTier1(rs.getString("DORMANTTIER1"));
								dataset.setDormantTier2(rs.getString("DORMANTTIER2"));
								dataset.setDormantTier3(rs.getString("DORMANTTIER3"));
							}
						} else
							dataset = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					dBConnect.CloseConnect(conn, cll, rs);
				}
				
		return dataset;
	}
	
	@Override
	public ClosedStatistics Closed_Statistics() {
		// TODO Auto-generated method stub
				Connection conn = null;
				CallableStatement cll = null;
				ResultSet rs = null;
				ClosedStatistics dataset = new ClosedStatistics();
				
				try {
					conn = dBConnect.getConn();
					cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ClosedStatistics(?)}");
					cll.registerOutParameter(1, OracleTypes.CURSOR);

					if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
						rs = (ResultSet) cll.getObject(1);
						if (rs != null) {
							while (rs.next()) {
								dataset.setStatus("00");
								dataset.setMsg("Successful");
								dataset.setClosedAccounts(rs.getString("CLOSEDACCOUNTS"));
								dataset.setClosedCorporate(rs.getString("CLOSEDCORPORATE"));
								dataset.setClosedIndividual(rs.getString("CLOSEDINDIVIDUAL"));
								dataset.setClosedTier1(rs.getString("CLOSEDTIER1"));
								dataset.setClosedTier2(rs.getString("CLOSEDTIER2"));
								dataset.setClosedTier3(rs.getString("CLOSEDTIER3"));
							}
						} else
							dataset = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					dBConnect.CloseConnect(conn, cll, rs);
				}
				
		return dataset;
	}
	
	@Override
	public cbnServiceResponse PendingDebit(String AccountNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		cbnServiceResponse resultSet = new cbnServiceResponse("99", "Unsuccessful", null);
		List<PendingDebits> dataset = new ArrayList<PendingDebits>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_PendingDebits(?,?)}");
			cll.setString(1, AccountNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						PendingDebits data = new PendingDebits();
						data.setBeneficiaryAccountNo(rs.getString("BENEFICIARYACCOUNTNO"));
						data.setBeneficiaryBank(rs.getString("BENEFICIARYBANK"));
						data.setInitiatedDate(rs.getString("INITIATEDDATE"));
						data.setPaymentDate(rs.getString("PAYMENTDATE"));
						data.setType(rs.getString("TYPE"));
						
						dataset.add(data);
					}
				} else {
					dataset = null;
				}
				resultSet = new cbnServiceResponse("00","Successful",dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return resultSet;
	}
}
