package com.ratana.model;

import java.sql.Date;

public class Loan {
    private int id;
    private int customerId;
    private int creditOfficerId;
    private Double balanceInUS;
    private Double balanceInKhmer;
    private Double borrowBalance;
    private int interest;
    private Date firstPaidDate;
    private Integer currencyId;
    private Integer groupId;
    private int dayAmount;
    private Date createdAt;
}
