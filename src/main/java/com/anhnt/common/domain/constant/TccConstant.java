package com.anhnt.common.domain.constant;

public class TccConstant{

    public static enum CoordinateStatus {TRYING,CONFIRMING, CONFIRMED,CANCELING,CANCELED};
    public static enum ParticipantStatus{INIT,RESERVED,CONFIRMED,CANCELED};
    public static enum FunctionName{CREATE_CUSTOMER}
    public static enum ParticipantId{CUSTOMER_SERVICE,PAYMENT_SERVICE}

}
