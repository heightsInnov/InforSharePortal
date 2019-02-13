package com.ubn.ciss.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubn.ciss.model.AccountDetails;
import com.ubn.ciss.model.AccountDetailsChannels;
import com.ubn.ciss.model.InternalAccounts;
import com.ubn.ciss.model.InternalAccountsFull;
import com.ubn.ciss.model.ListAccountsByBVN;
import com.ubn.ciss.model.ListStatistics;
import com.ubn.ciss.model.Signatories;
import com.ubn.ciss.model.SignatoriesWithNIN;
import com.ubn.ciss.model.TransactionDetails;
import com.ubn.ciss.model.TransactionDetailsChannels;
import com.ubn.ciss.utils.DBConnect;
import com.ubn.ciss.model.ListTIN_RCNo;

import oracle.jdbc.OracleTypes;

@Repository
public class CbnCissRepositoryImpl implements CbnCissRepository {

	@Autowired
	DBConnect dBConnect;

	@Override
	public TransactionDetails pr_transactiondetails(String StartDt, String EndDt, String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		TransactionDetails dataset = new TransactionDetails();

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
						dataset.setTra_Date(rs.getString("TRA_DATE"));
						dataset.setVal_Date(rs.getString("VAL_DATE"));
						dataset.setCurrency(rs.getString("CURRENCY"));
						dataset.setTra_Amt(rs.getString("TRA_AMT"));
						dataset.setTra_Type(rs.getString("TRA_TYPE"));
						dataset.setNarration(rs.getString("NARRATION"));
						dataset.setTra_Bal(rs.getString("TRA_BAL"));
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
	public TransactionDetailsChannels pr_transactiondetailschannels(String StartDt, String EndDt, String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		TransactionDetailsChannels dataset = new TransactionDetailsChannels();

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
						dataset.setTra_Date(rs.getString("TRA_DATE"));
						dataset.setVal_Date(rs.getString("VAL_DATE"));
						dataset.setCurrency(rs.getString("CURRENCY"));
						dataset.setTra_Amt(rs.getString("TRA_AMT"));
						dataset.setTra_Type(rs.getString("TRA_TYPE"));
						dataset.setNarration(rs.getString("NARRATION"));
						dataset.setTra_Bal(rs.getString("TRA_BAL"));
						dataset.setTra_Channel(rs.getString("TRA_CHANNEL"));
						dataset.setPayment_Type(rs.getString("PAYMENT_TYPE"));
					}
				} else
					dataset = null;
			}
		} catch (Exception e) {
			// TODO: handle finally clause
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return dataset;
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
						dataset.setName(rs.getString("ACCOUNT_HOLDER"));
						dataset.setType(rs.getString("ACCOUNT_TYPE"));
						dataset.setStatus(rs.getString("STATUS"));
						dataset.setBVN(rs.getString("BVN"));
						dataset.setCategory(rs.getString("CATEGORY"));
						dataset.setCLR_BAL(rs.getString("CLR_BAL"));
						dataset.setAVL_BAL(rs.getString("AVL_BAL"));
						dataset.setNuban(rs.getString("NUBAN"));
						dataset.setAddress(rs.getString("ADDRESS"));
						dataset.setEmail(rs.getString("EMAIL").toLowerCase());
						dataset.setTelephone(rs.getString("TELEPHONE"));
						dataset.setCurrency(rs.getString("CURRENCY"));
						dataset.setAOD(rs.getString("AOD"));
						dataset.setAccount_Status(rs.getString("ACCOUNT_STATUS"));
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
						dataset.setName(rs.getString("ACCOUNT_HOLDER"));
						dataset.setType(rs.getString("ACCOUNT_TYPE"));
						dataset.setStatus(rs.getString("STATUS"));
						dataset.setBVN(rs.getString("BVN"));
						dataset.setCategory(rs.getString("CATEGORY"));
						dataset.setCLR_BAL(rs.getString("CLR_BAL"));
						dataset.setAVL_BAL(rs.getString("AVL_BAL"));
						dataset.setNuban(rs.getString("NUBAN"));
						dataset.setAddress(rs.getString("ADDRESS"));
						dataset.setEmail(rs.getString("EMAIL").toLowerCase());
						dataset.setTelephone(rs.getString("TELEPHONE"));
						dataset.setCurrency(rs.getString("CURRENCY"));
						dataset.setAOD(rs.getString("AOD"));
						dataset.setAccount_Status(rs.getString("ACCOUNT_STATUS"));
						dataset.setTax_ID_Number(rs.getString("TAX_ID_NUMBER"));
						dataset.setRC_Number(rs.getString("RC_NUMBER"));
						dataset.setNIN(rs.getString("NIN"));
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
	public Signatories pr_signatories(String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		Signatories dataset = new Signatories();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_signatoriesWithNIN(?,?)}");
			cll.setString(1, AccNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						dataset.setName(rs.getString("NAME"));
						dataset.setBVN(rs.getString("BVN"));
						dataset.setDate_of_birth(rs.getString("DATE_OF_BIRTH"));
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
	public SignatoriesWithNIN pr_signatoriesWithNIN(String AccNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		SignatoriesWithNIN dataset = new SignatoriesWithNIN();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_signatoriesWithNIN(?,?)}");
			cll.setString(1, AccNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						dataset.setName(rs.getString("NAME"));
						dataset.setBVN(rs.getString("BVN"));
						dataset.setDate_of_birth(rs.getString("DATE_OF_BIRTH"));
						dataset.setNIN(rs.getString("NIN"));
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
	public List<ListAccountsByBVN> pr_listAccountsByBVN(String BVN) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<ListAccountsByBVN> dataset = new ArrayList<ListAccountsByBVN>();

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
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}
		return dataset;
	}

	@Override
	public List<String> ListAccountsByRCNo(String RCNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<String> dataset = new ArrayList<String>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_listAccountsByRCNo(?,?)}");
			cll.setString(1, RCNo);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						String Nuban = rs.getString("NUBAN");

						dataset.add(Nuban);
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
	public List<String> ListAccountsByTIN(String TIN) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<String> dataset = new ArrayList<String>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_listAccountsByTIN(?,?)}");
			cll.setString(1, TIN);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						String Nuban = rs.getString("NUBAN");

						dataset.add(Nuban);
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
	public List<String> ListAccountsByNIN(String NIN) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<String> dataset = new ArrayList<String>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ListAccountsByNIN(?,?)}");
			cll.setString(1, NIN);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						String Nuban = rs.getString("NUBAN");

						dataset.add(Nuban);
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
	public String ActiveTIN() {
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		String Percentage = null;

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ActiveTIN(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						Percentage = rs.getString("PERCENTAGE_OF_ACCTIVE_CORP_TIN");
					}
				} else
					Percentage = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}

		return Percentage;
	}

	@Override
	public String ActiveRCNo() {
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		String Percentage = null;

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ActiveRCNo(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						Percentage = rs.getString("PERTGE_OF_ACCTIVE_CORP_RCNO");
					}
				} else
					Percentage = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}

		return Percentage;
	}

	@Override
	public String ActiveNIN() {
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		String Percentage = null;

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ActiveNIN(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						Percentage = rs.getString("pertge_of_acctive_corp_NIN");
					}
				} else
					Percentage = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dBConnect.CloseConnect(conn, cll, rs);
		}

		return Percentage;
	}

	@Override
	public List<ListTIN_RCNo> LstTIN_RCNo() {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<ListTIN_RCNo> dataset = new ArrayList<ListTIN_RCNo>();
		ListTIN_RCNo data = new ListTIN_RCNo();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ListTIN_RCNo(?)}");
			cll.registerOutParameter(1, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(1);
				if (rs != null) {
					while (rs.next()) {
						data.setNuban(rs.getString("NUBAN"));
						data.setTIN(rs.getString("TIN"));
						data.setRCNo(rs.getString("RC_NO"));

						dataset.add(data);
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
	public List<InternalAccounts> pr_ListInternalAccounts(String ledgerCode) {
		// TODO Auto-generated method stub

		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<InternalAccounts> dataset = new ArrayList<InternalAccounts>();
		InternalAccounts data = new InternalAccounts();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_ListInternalAccounts(?,?)}");
			cll.setString(1, ledgerCode);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						data.setNuban(rs.getString("NUBAN"));
						data.setNonNuban(rs.getString("NON_NUBAN"));

						dataset.add(data);
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
	public List<InternalAccountsFull> pr_ListInternalAccountFull(String ledgerCode) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
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
						data.setNuban(rs.getString("NUBAN"));
						data.setNonNuban(rs.getString("NON_NUBAN"));
						data.setStatus(rs.getString("STATUS"));
						data.setCurrency(rs.getString("CURRENCY"));
						data.setDescription(rs.getString("DESCRIPTION"));

						dataset.add(data);
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
	public List<String> InternalAccountsSignatories(String ledgerCode) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cll = null;
		ResultSet rs = null;
		List<String> dataset = new ArrayList<String>();

		try {
			conn = dBConnect.getConn();
			cll = conn.prepareCall("{call ubn_cbn_info_shared_pkg.pr_InternalAccountsSignatorie(?,?)}");
			cll.setString(1, ledgerCode);
			cll.registerOutParameter(2, OracleTypes.CURSOR);

			if (cll.executeUpdate() != Statement.EXECUTE_FAILED) {
				rs = (ResultSet) cll.getObject(2);
				if (rs != null) {
					while (rs.next()) {
						String data = rs.getString("NAME");

						dataset.add(data);
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
}
