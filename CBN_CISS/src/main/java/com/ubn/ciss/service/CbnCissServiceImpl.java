package com.ubn.ciss.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubn.ciss.model.AccountDetails;
import com.ubn.ciss.model.AccountDetailsChannels;
import com.ubn.ciss.model.ActiveTIN;
import com.ubn.ciss.model.CbnrespTransDetails;
import com.ubn.ciss.model.ClosedStatistics;
import com.ubn.ciss.model.DormantStatistics;
import com.ubn.ciss.model.ListStatistics;
import com.ubn.ciss.model.OauthResponse;
import com.ubn.ciss.model.cbnServiceResponse;
import com.ubn.ciss.repository.CbnCissRepositoryImpl;
import com.ubn.config.GenerateToken;

@Service
public class CbnCissServiceImpl implements CbnCissService {

	@Autowired
	CbnCissRepositoryImpl cbnCissRepositoryImpl;

	@Autowired
	GenerateToken tokenGenerator;

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
	public CbnrespTransDetails pr_transactiondetails(String StartDt, String EndDt, String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_transactiondetails(!StartDt.isEmpty() ? convertDate(StartDt) : null,
				!EndDt.isEmpty() ? convertDate(EndDt) : null, AccNo);
	}

	@Override
	public cbnServiceResponse pr_transactiondetailschannels(String StartDt, String EndDt, String AccNo) {
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
	public cbnServiceResponse pr_signatories(String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_signatories(AccNo);
	}

	@Override
	public cbnServiceResponse pr_signatoriesWithNIN(String AccNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_signatoriesWithNIN(AccNo);
	}

	@Override
	public cbnServiceResponse pr_listAccountsByBVN(String BVN) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_listAccountsByBVN(BVN);
	}

	@Override
	public cbnServiceResponse ListAccountsByRCNo(String RCNo) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.ListAccountsByRCNo(RCNo);
	}

	@Override
	public cbnServiceResponse ListAccountsByTIN(String TIN) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.ListAccountsByTIN(TIN);
	}

	@Override
	public cbnServiceResponse ListAccountsByNIN(String NIN) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.ListAccountsByNIN(NIN);
	}

	@Override
	public ActiveTIN getActiveTIN() {
		return cbnCissRepositoryImpl.getActiveTIN();
	}

	@Override
	public ActiveTIN ActiveRCNo() {
		return cbnCissRepositoryImpl.ActiveRCNo();
	}

	@Override
	public ActiveTIN ActiveNIN() {
		return cbnCissRepositoryImpl.ActiveNIN();
	}

	@Override
	public cbnServiceResponse LstTIN_RCNo() {
		return cbnCissRepositoryImpl.LstTIN_RCNo();
	}

	@Override
	public cbnServiceResponse pr_ListInternalAccounts(String ledgerCode) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_ListInternalAccounts(ledgerCode);
	}

	@Override
	public cbnServiceResponse pr_ListInternalAccountFull(String ledgerCode) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.pr_ListInternalAccountFull(ledgerCode);
	}

	@Override
	public cbnServiceResponse InternalAccountsSignatories(String ledgerCode) {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.InternalAccountsSignatories(ledgerCode);
	}

	@Override
	public ListStatistics List_Statistics() {
		// TODO Auto-generated method stub
		return cbnCissRepositoryImpl.List_Statistics();
	}

	@Override
	public DormantStatistics Dormant_Statistics() {
		return cbnCissRepositoryImpl.Dormant_Statistics();
	}

	@Override
	public ClosedStatistics Closed_Statistics() {
		return cbnCissRepositoryImpl.Closed_Statistics();
	}

	@Override
	public cbnServiceResponse PendingDebit(String AccountNo) {
		return cbnCissRepositoryImpl.PendingDebit(AccountNo);
	}

	@Override
	public OauthResponse getToken(String user, String pass) {
		OauthResponse resp = null;
		try {
			resp = tokenGenerator.getToken(user, pass);
		} catch (IOException io) {
			io.printStackTrace();
		}
		return resp;
	}

	@Override
	public void saveClientDetails(String clientip, String methodname) {
		// TODO Auto-generated method stub
		cbnCissRepositoryImpl.saveClientDetails(clientip, methodname);
	}
}
