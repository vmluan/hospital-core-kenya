/**
 *  Copyright 2011 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Hospital-core module.
 *
 *  Hospital-core module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Hospital-core module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Hospital-core module.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/


package org.openmrs.module.hospitalcore.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * <p> Class: InventoryStoreDrugTransaction </p>
 * <p> Package: org.openmrs.module.inventory.model </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Jan 5, 2011 1:28:02 PM </p>
 * <p> Update date: Jan 5, 2011 1:28:02 PM </p>
 **/
public class InventoryStoreDrugTransactionDetail implements  Serializable , Comparable<InventoryStoreDrugTransactionDetail>{

	 private static final long serialVersionUID = 1L;
	 private Integer id;
	 private InventoryStoreDrugTransaction transaction;
	 private InventoryDrug drug;
	 private InventoryDrugFormulation formulation;
	 private Integer quantity ;
	 private Integer currentQuantity ;
	 private Integer issueQuantity;
	 private BigDecimal unitPrice;
	 private BigDecimal totalPrice;
	 private BigDecimal VAT;
	 
	 private String batchNo;
	 private String companyName ;
	 private Date dateManufacture;
	 private Date dateExpiry;
	 private Date createdOn;
	 
	 private long openingBalance;
	 private long closingBalance;
	 
	 private InventoryStoreDrugTransactionDetail parent;
	 private Set<InventoryStoreDrugTransactionDetail> subDetails;
	 
	 private Date receiptDate;
	 
	 
    public InventoryStoreDrugTransactionDetail() {
	 
    }
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public InventoryStoreDrugTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(InventoryStoreDrugTransaction transaction) {
		this.transaction = transaction;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	public BigDecimal getVAT() {
		return VAT;
	}
	public void setVAT(BigDecimal vAT) {
		VAT = vAT;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getCompanyNameShort() {
		return StringUtils.isNotBlank(companyName) && companyName.length() > 10 ?companyName.substring(0, 7)+"..." : companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getDateManufacture() {
		return dateManufacture;
	}
	public void setDateManufacture(Date dateManufacture) {
		this.dateManufacture = dateManufacture;
	}
	public Date getDateExpiry() {
		return dateExpiry;
	}
	public void setDateExpiry(Date dateExpiry) {
		this.dateExpiry = dateExpiry;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(Integer currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public InventoryDrug getDrug() {
		return drug;
	}
	public void setDrug(InventoryDrug drug) {
		this.drug = drug;
	}
	public InventoryDrugFormulation getFormulation() {
		return formulation;
	}
	public void setFormulation(InventoryDrugFormulation formulation) {
		this.formulation = formulation;
	}
	public InventoryStoreDrugTransactionDetail getParent() {
		return parent;
	}
	public void setParent(InventoryStoreDrugTransactionDetail parent) {
		this.parent = parent;
	}
	public Set<InventoryStoreDrugTransactionDetail> getSubDetails() {
		return subDetails;
	}
	public void setSubDetails(Set<InventoryStoreDrugTransactionDetail> subDetails) {
		this.subDetails = subDetails;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public long getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(long openingBalance) {
		this.openingBalance = openingBalance;
	}
	public long getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(long closingBalance) {
		this.closingBalance = closingBalance;
	}
	public Integer getIssueQuantity() {
		return issueQuantity;
	}
	public void setIssueQuantity(Integer issueQuantity) {
		this.issueQuantity = issueQuantity;
	}
	public int getExpiryLessThan3Month(){
		Date currentDate = new Date();
		Date date3Month = DateUtils.addMonths(currentDate, 3);
		if(this.getTransaction().getTypeTransaction() == 1 && this.getCurrentQuantity() > 0 && this.dateExpiry.before(date3Month)){
			return 1;
		}
		return 0;
	}
	//03/07/2012: Kesavulu:sort Item Names  #300
	//10/7/2012: harsh #300 : deleted unused method
	 public int compareTo(InventoryStoreDrugTransactionDetail i) {
	 
	    return (this.drug).compareTo(i.drug);
	}
	 
}