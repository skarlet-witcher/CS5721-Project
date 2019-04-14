package rpc.impl;

import ATM_rpc.ATMResponse;
import ATM_rpc.ATMWithdrawGrpc;
import Const.ResponseStatusType;
import service.IATMService;
import service.impl.ATMService;

import java.util.logging.Logger;

public class BankATMImpl extends ATMWithdrawGrpc.ATMWithdrawImplBase {
    private static final Logger logger = Logger.getLogger(BankATMImpl.class.getName());
    private static final IATMService atmService = ATMService.getInstance();

    public void aTMGetBalance(ATM_rpc.ATMLoginRequest request,
                              io.grpc.stub.StreamObserver<ATM_rpc.ATMResponse> responseObserver) {
        try {
            //1 create result of service, which contains pin and some other attr
            ATMResponse response = atmService.getBalance(request);

            //2 set the above result to responseObserver
            responseObserver.onNext(response);
        } catch (Exception e) {
            responseObserver.onNext(ATMResponse.newBuilder().setStatusCode(ResponseStatusType.OPERATION_FAIL)
                    .build());
        }
        //3 Send all above to client
        responseObserver.onCompleted();
    }
    public void aTMWithDraw(ATM_rpc.ATMLoginRequest request,
                            io.grpc.stub.StreamObserver<ATM_rpc.ATMResponse> responseObserver) {
        try {
            //1 create result of service, which contains pin and some other attr
            ATMResponse response = atmService.withdraw(request);

            //2 set the above result to responseObserver
            responseObserver.onNext(response);
        } catch (Exception e) {
            responseObserver.onNext(ATMResponse.newBuilder().setStatusCode(ResponseStatusType.OPERATION_FAIL)
                    .build());
        }
        //3 Send all above to client
        responseObserver.onCompleted();
    }
}
