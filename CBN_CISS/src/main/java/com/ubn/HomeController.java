package com.ubn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubn.ciss.model.AccountDetails;
import com.ubn.ciss.model.AccountDetailsChannels;
import com.ubn.ciss.model.ListStatistics;
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
	public @ResponseBody cbnServiceResponse transactionDetail(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_transactiondetails(request.getStartDate(), request.getEndDate(),
				request.getAccountNo());
	}

	@PostMapping("/TransactionDetailsChannels")
	public @ResponseBody cbnServiceResponse transactionDetailsChannel(@RequestBody ServiceRequest request) {
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
	public @ResponseBody cbnServiceResponse signatories(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_signatories(request.getAccountNo());
	}

	@PostMapping("/SignatoriesWithNIN")
	public @ResponseBody cbnServiceResponse signatoriesWithNIN(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_signatoriesWithNIN(request.getAccountNo());
	}

	@PostMapping("/ListAccountsByBVN")
	public @ResponseBody cbnServiceResponse listAccountsByBVN(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_listAccountsByBVN(request.getBvn());
	}

	@PostMapping("/ListAccountsByRCNo")
	public @ResponseBody cbnServiceResponse listAccountsByRCNo(@RequestBody ServiceRequest request) {
		return cbnCissService.ListAccountsByRCNo(request.getRcNo());
	}

	@PostMapping("/ListAccountsByTIN")
	public @ResponseBody cbnServiceResponse listAccountsByTIN(@RequestBody ServiceRequest request) {
		return cbnCissService.ListAccountsByTIN(request.getTin());
	}

	@PostMapping("/ListAccountsByNIN")
	public @ResponseBody cbnServiceResponse listAccountsByNIN(@RequestBody ServiceRequest request) {
		return cbnCissService.ListAccountsByNIN(request.getNin());
	}
	
	@GetMapping("/ActiveTIN")
	public @ResponseBody cbnServiceResponse showActiveTIN() {
		return cbnCissService.ActiveTIN();
	}
	
	@GetMapping("/ActiveRCNo")
	public @ResponseBody cbnServiceResponse showActiveRCNo() {
		return cbnCissService.ActiveRCNo();
	}
	
	@GetMapping("/ActiveNIN")
	public @ResponseBody cbnServiceResponse showActiveNIN() {
		return cbnCissService.ActiveNIN();
	}
	
	@GetMapping("/ListTIN_RCNo")
	public @ResponseBody cbnServiceResponse LstTIN_RCNo() {
		return cbnCissService.LstTIN_RCNo();
	}
	
	@PostMapping("/ListInternalAccounts")
	public @ResponseBody cbnServiceResponse ListInternalAccounts(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_ListInternalAccounts(request.getLedgerCode());
	}
	
	@PostMapping("/ListInternalAccountsFull")
	public @ResponseBody cbnServiceResponse ListInternalAccountsFull(@RequestBody ServiceRequest request) {
		return cbnCissService.pr_ListInternalAccountFull(request.getLedgerCode());
	}
	
	@PostMapping("/InternalAccountsSignatories")
	public @ResponseBody cbnServiceResponse InternalAccountsSignatories(@RequestBody ServiceRequest request) {
		return cbnCissService.InternalAccountsSignatories(request.getLedgerCode());
	}
	
	@GetMapping("/ListStatistics")
	public @ResponseBody ListStatistics List_Statistics(@RequestBody ServiceRequest request) {
		return cbnCissService.List_Statistics();
	}
}
