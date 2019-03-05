package com.ubn.ciss.service;

import com.ubn.ciss.model.AccountDetails;
import com.ubn.ciss.model.AccountDetailsChannels;
import com.ubn.ciss.model.ActiveTIN;
import com.ubn.ciss.model.CbnrespTransDetails;
import com.ubn.ciss.model.ClosedStatistics;
import com.ubn.ciss.model.DormantStatistics;
import com.ubn.ciss.model.ListStatistics;
import com.ubn.ciss.model.OauthResponse;
import com.ubn.ciss.model.cbnServiceResponse;

public interface CbnCissService {

	CbnrespTransDetails pr_transactiondetails(String StartDt, String EndDt, String AccNo);
	cbnServiceResponse  pr_transactiondetailschannels(String StartDt, String EndDt, String AccNo);
	AccountDetails  pr_accountdetails(String AccNo);
	AccountDetailsChannels  pr_accountdetailschannels(String AccNo);
	cbnServiceResponse  pr_signatories(String AccNo);
	cbnServiceResponse  pr_signatoriesWithNIN(String AccNo);
	cbnServiceResponse  pr_listAccountsByBVN(String BVN);
	cbnServiceResponse ListAccountsByRCNo(String RCNo);
	cbnServiceResponse ListAccountsByTIN(String TIN);
	cbnServiceResponse ListAccountsByNIN(String NIN);
	ActiveTIN getActiveTIN();
	ActiveTIN ActiveRCNo();
	ActiveTIN ActiveNIN();
	cbnServiceResponse LstTIN_RCNo();
	cbnServiceResponse pr_ListInternalAccounts(String ledgerCode);
	cbnServiceResponse pr_ListInternalAccountFull(String ledgerCodes);
	cbnServiceResponse InternalAccountsSignatories(String ledgerCode);
	ListStatistics List_Statistics();
	DormantStatistics Dormant_Statistics();
	ClosedStatistics Closed_Statistics();
	cbnServiceResponse PendingDebit(String AccountNo);
	OauthResponse getToken(String user, String pass);
	void saveClientDetails(String clientip, String methodname);
}
