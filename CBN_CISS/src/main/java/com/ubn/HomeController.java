package com.ubn;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubn.ciss.model.AccountDetails;
import com.ubn.ciss.model.AccountDetailsChannels;
import com.ubn.ciss.model.ActiveTIN;
import com.ubn.ciss.model.CbnrespTransDetails;
import com.ubn.ciss.model.ClosedStatistics;
import com.ubn.ciss.model.DormantStatistics;
import com.ubn.ciss.model.ListStatistics;
import com.ubn.ciss.model.OauthResponse;
import com.ubn.ciss.model.ServiceRequest;
import com.ubn.ciss.model.cbnServiceResponse;
import com.ubn.ciss.service.CbnCissServiceImpl;

@RestController
public class HomeController {

	@Autowired
	CbnCissServiceImpl cbnCissService;
	

	@GetMapping("/echo")
	public String echo() {
		return "echo";
	}

	@PostMapping("/TransactionDetails")
	public @ResponseBody CbnrespTransDetails transactionDetail(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "TransactionDetails");
		return cbnCissService.pr_transactiondetails(request.getStartDate(), request.getEndDate(),
				request.getAccountNo());
	}

	@PostMapping("/TransactionDetailsChannels")
	public @ResponseBody cbnServiceResponse transactionDetailsChannel(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "TransactionDetailsChannels");
		return cbnCissService.pr_transactiondetailschannels(request.getStartDate(), request.getEndDate(),
				request.getAccountNo());
	}

	@PostMapping("/AccountDetails")
	public @ResponseBody AccountDetails accountDetail(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "AccountDetails");
		return cbnCissService.pr_accountdetails(request.getAccountNo());
	}

	@PostMapping("/AccountDetailsChannels")
	public @ResponseBody AccountDetailsChannels accountDetailsChannel(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "AccountDetailsChannels");
		return cbnCissService.pr_accountdetailschannels(request.getAccountNo());
	}

	@PostMapping("/Signatories")
	public @ResponseBody cbnServiceResponse signatories(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "Signatories");
		return cbnCissService.pr_signatories(request.getAccountNo());
	}

	@PostMapping("/SignatoriesWithNIN")
	public @ResponseBody cbnServiceResponse signatoriesWithNIN(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "SignatoriesWithNIN");
		return cbnCissService.pr_signatoriesWithNIN(request.getAccountNo());
	}

	@PostMapping("/ListAccountsByBVN")
	public @ResponseBody cbnServiceResponse listAccountsByBVN(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "ListAccountsByBVN");
		return cbnCissService.pr_listAccountsByBVN(request.getBvn());
	}

	@PostMapping("/ListAccountsByRCNo")
	public @ResponseBody cbnServiceResponse listAccountsByRCNo(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "ListAccountsByRCNo");
		return cbnCissService.ListAccountsByRCNo(request.getRcNo());
	}

	@PostMapping("/ListAccountsByTIN")
	public @ResponseBody cbnServiceResponse listAccountsByTIN(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "ListAccountsByTIN");
		return cbnCissService.ListAccountsByTIN(request.getTin());
	}

	@PostMapping("/ListAccountsByNIN")
	public @ResponseBody cbnServiceResponse listAccountsByNIN(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "ListAccountsByNIN");
		return cbnCissService.ListAccountsByNIN(request.getNin());
	}
	
	@GetMapping("/ActiveTIN")
	public @ResponseBody ActiveTIN showActiveTIN(HttpServletRequest req) {
		saveInfo(req,  "ActiveTIN");
		return cbnCissService.getActiveTIN();
	}
	
	@GetMapping("/ActiveRCNo")
	public @ResponseBody ActiveTIN showActiveRCNo(HttpServletRequest req) {
		saveInfo(req,  "ActiveRCNo");
		return cbnCissService.ActiveRCNo();
	}
	
	@GetMapping("/ActiveNIN")
	public @ResponseBody ActiveTIN showActiveNIN(HttpServletRequest req) {
		saveInfo(req,  "ActiveNIN");
		return cbnCissService.ActiveNIN();
	}
	
	@GetMapping("/ListTIN_RCNo")
	public @ResponseBody cbnServiceResponse LstTIN_RCNo(HttpServletRequest req) {
		saveInfo(req,  "ListTIN_RCNo");
		return cbnCissService.LstTIN_RCNo();
	}
	
	@PostMapping("/ListInternalAccounts")
	public @ResponseBody cbnServiceResponse ListInternalAccounts(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "ListInternalAccounts");
		return cbnCissService.pr_ListInternalAccounts(request.getLedgerCode());
	}
	
	@PostMapping("/ListInternalAccountsFull")
	public @ResponseBody cbnServiceResponse ListInternalAccountsFull(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "ListInternalAccountsFull");
		return cbnCissService.pr_ListInternalAccountFull(request.getLedgerCode());
	}
	
	@PostMapping("/InternalAccountsSignatories")
	public @ResponseBody cbnServiceResponse InternalAccountsSignatories(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "InternalAccountsSignatories");
		return cbnCissService.InternalAccountsSignatories(request.getLedgerCode());
	}
	
	@GetMapping("/ListStatistics")
	public @ResponseBody ListStatistics List_Statistics(HttpServletRequest req) {
		saveInfo(req,  "ListStatistics");
		return cbnCissService.List_Statistics();
	}
	
	@GetMapping("/DormantStatistics")
	public @ResponseBody DormantStatistics Dormant_Statistics(HttpServletRequest req) {
		saveInfo(req,  "DormantStatistics");
		return cbnCissService.Dormant_Statistics();
	}
	
	@GetMapping("/ClosedStatistics")
	public @ResponseBody ClosedStatistics Closed_Statistics(HttpServletRequest req) {
		saveInfo(req,  "ClosedStatistics");
		return cbnCissService.Closed_Statistics();
	}
	
	@PostMapping("/PendingDebits")
	public @ResponseBody cbnServiceResponse PendingDebits(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "PendingDebits");
		return cbnCissService.PendingDebit(request.getAccountNo());
	}
	
	@PostMapping("/getToken")
	public @ResponseBody OauthResponse getToken(HttpServletRequest req, @RequestBody ServiceRequest request) {
		saveInfo(req,  "getToken");
		return cbnCissService.getToken(request.getUsername(), request.getPassword());
	}
	
	private void saveInfo(HttpServletRequest req, String name) {
		String remoteAddress = "0.0.0.0";
		if(req!=null) {
			remoteAddress = req.getHeader("X-FOWARDED-FOR")!= null ? req.getHeader("X-FOWARDED-FOR") : req.getRemoteAddr();
		}
		cbnCissService.saveClientDetails(remoteAddress, name);
	}
}
