package com.ubn.ciss.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubn.ciss.model.AccountDetails;
import com.ubn.ciss.model.AccountDetailsChannels;
import com.ubn.ciss.model.InternalAccounts;
import com.ubn.ciss.model.InternalAccountsFull;
import com.ubn.ciss.model.ListAccountsByBVN;
import com.ubn.ciss.model.ListStatistics;
import com.ubn.ciss.model.ListTIN_RCNo;
import com.ubn.ciss.model.Signatories;
import com.ubn.ciss.model.SignatoriesWithNIN;
import com.ubn.ciss.model.TransactionDetails;
import com.ubn.ciss.repository.CbnCissRepositoryImpl;

@Service
public class CbnCissServiceImpl implements CbnCissService {

	@Autowired
	CbnCissRepositoryImpl cbnCissRepositoryImpl;

	private String convertDate(String strDate) {
		String convdate = "";
		String dtformat = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(dtformat);
		try {
			Date dt = sdf.parse(strDate);
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
			convdate = sdf2.format(dt);
			System.out.println(convdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convdate;
	}

	@Override
	public TransactionDetails pr_transactiondetails(String StartDt, String EndDt, String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_transactiondetails(!StartDt.isEmpty() ? convertDate(StartDt) : null,
				!EndDt.isEmpty() ? convertDate(EndDt) : null, AccNo);
	}

	@Override
	public TransactionDetails pr_transactionDetailsChannels(String StartDt, String EndDt, String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_transactiondetailschannels(!StartDt.isEmpty() ? convertDate(StartDt) : null,
				!EndDt.isEmpty() ? convertDate(EndDt) : null, AccNo);
	}

	@Override
	public AccountDetails pr_accountdetails(String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_accountdetails(AccNo);
	}

	@Override
	public AccountDetailsChannels pr_accountdetailschannels(String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_accountdetailschannels(AccNo);
	}

	@Override
	public Signatories pr_signatories(String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_signatories(AccNo);
	}

	@Override
	public SignatoriesWithNIN pr_signatoriesWithNIN(String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_signatoriesWithNIN(AccNo);
	}

	@Override
	public List<ListAccountsByBVN> pr_listAccountsByBVN(String BVN) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_listAccountsByBVN(BVN);
	}

	@Override
	public List<String> ListAccountsByRCNo(String RCNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.ListAccountsByRCNo(RCNo);
	}

	@Override
	public List<String> ListAccountsByTIN(String TIN) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.ListAccountsByTIN(TIN);
	}

	@Override
	public List<String> ListAccountsByNIN(String NIN) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.ListAccountsByNIN(NIN);
	}

	@Override
	public String ActiveTIN() {
		return cbnCissRepositoryImpl.ActiveTIN();
	}

	@Override
	public String ActiveRCNo() {
		return cbnCissRepositoryImpl.ActiveRCNo();
	}

	@Override
	public String ActiveNIN() {
		return cbnCissRepositoryImpl.ActiveNIN();
	}

	@Override
	public List<ListTIN_RCNo> LstTIN_RCNo() {
		return cbnCissRepositoryImpl.LstTIN_RCNo();
	}

	@Override
	public List<InternalAccounts> pr_ListInternalAccounts(String ledgerCode) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_ListInternalAccounts(ledgerCode);
	}

	@Override
	public List<InternalAccountsFull> pr_ListInternalAccountFull(String ledgerCode) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_ListInternalAccountFull(ledgerCode);
	}

	@Override
	public List<String> InternalAccountsSignatories(String ledgerCode) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.InternalAccountsSignatories(ledgerCode);
	}

	@Override
	public ListStatistics List_Statistics() {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.List_Statistics();
	}
}
