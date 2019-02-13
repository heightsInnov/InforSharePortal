package com.ubn.ciss.service;

import java.util.List;

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

public interface CbnCissService {

	TransactionDetails pr_transactiondetails(String StartDt, String EndDt, String AccNo);
	TransactionDetails pr_transactionDetailsChannels(String StartDt, String EndDt, String AccNo);
	AccountDetails  pr_accountdetails(String AccNo);
	AccountDetailsChannels  pr_accountdetailschannels(String AccNo);
	Signatories  pr_signatories(String AccNo);
	SignatoriesWithNIN  pr_signatoriesWithNIN(String AccNo);
	List<ListAccountsByBVN>  pr_listAccountsByBVN(String BVN);
	List<String> ListAccountsByRCNo(String RCNo);
	List<String> ListAccountsByTIN(String TIN);
	List<String> ListAccountsByNIN(String NIN);
	String ActiveTIN();
	String ActiveRCNo();
	String ActiveNIN();
	List<ListTIN_RCNo> LstTIN_RCNo();
	List<InternalAccounts> pr_ListInternalAccounts(String  ledgerCode);
	List<InternalAccountsFull> pr_ListInternalAccountFull(String ledgerCode);
	List<String> InternalAccountsSignatories(String ledgerCode);
	ListStatistics List_Statistics();
}
