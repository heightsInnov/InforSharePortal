package com.ubn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubn.ciss.model.AccountDetails;
import com.ubn.ciss.model.AccountDetailsChannels;
import com.ubn.ciss.model.InternalAccounts;
import com.ubn.ciss.model.InternalAccountsFull;
import com.ubn.ciss.model.ListAccountsByBVN;
import com.ubn.ciss.model.ListStatistics;
import com.ubn.ciss.model.ListTIN_RCNo;
import com.ubn.ciss.model.ServiceRequest;
import com.ubn.ciss.model.Signatories;
import com.ubn.ciss.model.SignatoriesWithNIN;
import com.ubn.ciss.model.TransactionDetails;
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
	public @ResponseBody TransactionDetails transactionDetail(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_transactiondetails(request.getStartDate(), request.getEndDate(),
				request.getAccountNo());
	}

	@PostMapping("/TransactionDetailsChannels")
	public @ResponseBody TransactionDetails transactionDetailsChannel(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_transactiondetails(request.getStartDate(), request.getEndDate(),
				request.getAccountNo());
	}

	@PostMapping("/AccountDetails")
	public @ResponseBody AccountDetails accountDetail(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_accountdetails(request.getAccountNo());
	}

	@PostMapping("/AccountDetailsChannels")
	public @ResponseBody AccountDetailsChannels accountDetailsChannel(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_accountdetailschannels(request.getAccountNo());
	}

	@PostMapping("/Signatories")
	public @ResponseBody Signatories signatories(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_signatories(request.getAccountNo());
	}

	@PostMapping("/SignatoriesWithNIN")
	public @ResponseBody SignatoriesWithNIN signatoriesWithNIN(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_signatoriesWithNIN(request.getAccountNo());
	}

	@PostMapping("/ListAccountsByBVN")
	public @ResponseBody List<ListAccountsByBVN> listAccountsByBVN(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_listAccountsByBVN(request.getBvn());
	}

	@PostMapping("/ListAccountsByRCNo")
	public @ResponseBody List<String> listAccountsByRCNo(@RequestBody ServiceRequest request) {
		return cbnCissService.ListAccountsByRCNo(request.getRcNo());
	}

	@PostMapping("/ListAccountsByTIN")
	public @ResponseBody List<String> listAccountsByTIN(@RequestBody ServiceRequest request) {
		return cbnCissService.ListAccountsByTIN(request.getTin());
	}

	@PostMapping("/ListAccountsByNIN")
	public @ResponseBody List<String> listAccountsByNIN(@RequestBody ServiceRequest request) {
		return cbnCissService.ListAccountsByNIN(request.getNin());
	}
	
	@GetMapping("/ActiveTIN")
	public @ResponseBody String showActiveTIN() {
		return cbnCissService.ActiveTIN();
	}
	
	@GetMapping("/ActiveRCNo")
	public @ResponseBody String showActiveRCNo() {
		return cbnCissService.ActiveRCNo();
	}
	
	@GetMapping("/ActiveNIN")
	public @ResponseBody String showActiveNIN() {
		return cbnCissService.ActiveNIN();
	}
	
	@GetMapping("/ListTIN_RCNo")
	public @ResponseBody List<ListTIN_RCNo> LstTIN_RCNo() {
		return cbnCissService.LstTIN_RCNo();
	}
	
	@PostMapping("/ListInternalAccounts")
	public @ResponseBody List<InternalAccounts> ListInternalAccounts(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_ListInternalAccounts(request.getLedgerCode());
	}
	
	@PostMapping("/ListInternalAccountsFull")
	public @ResponseBody List<InternalAccountsFull> ListInternalAccountsFull(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_ListInternalAccountFull(request.getLedgerCode());
	}
	
	@PostMapping("/InternalAccountsSignatories")
	public @ResponseBody List<String> InternalAccountsSignatories(@RequestBody ServiceRequest request) {
		return cbnCissService.InternalAccountsSignatories(request.getLedgerCode());
	}
	
	@GetMapping("/ListStatistics")
	public @ResponseBody ListStatistics List_Statistics(@RequestBody ServiceRequest request) {
		return cbnCissService.List_Statistics();
	}
}
