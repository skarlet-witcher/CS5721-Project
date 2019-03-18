package rpc.impl;

import bankStaff_rpc.AcceptApplicationGrpc;
import bankStaff_rpc.AcceptedResponse;
import io.grpc.stub.StreamObserver;
import service.IStaffService;
import service.impl.StaffService;

import java.util.logging.Logger;

import static Const.ResponseStatusType.OPERATION_FAIL;


public class BankStaffAcceptApplysImpl extends AcceptApplicationGrpc.AcceptApplicationImplBase {
    private static final Logger logger = Logger.getLogger(BankStaffLoginImpl.class.getName());
    private static final IStaffService staffService = StaffService.getInstance();
    public void acceptApplication(bankStaff_rpc.AcceptedRequest request, StreamObserver<AcceptedResponse> responseObserver) {
        try {
            //1 create result of service, which contains pin and some other attr
            AcceptedResponse response = staffService.acceptApplication(request);

            //2 set the above result to responseObserver
            responseObserver.onNext(response);
        } catch (Exception e) {
            responseObserver.onNext(AcceptedResponse.newBuilder()
                    .setIsAccepted(false)
                    .setStatusCode(OPERATION_FAIL)
                    .build());
        }
        //3 Send all above to client
        responseObserver.onCompleted();
    }
}
