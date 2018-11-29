package rpc.impl.bank_staff;

import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.StaffGetNewAppliesGrpc;
import io.grpc.stub.StreamObserver;
import service.IStaffService;
import service.impl.StaffService;

import java.util.logging.Logger;

public class BankStaffImpl extends StaffGetNewAppliesGrpc.StaffGetNewAppliesImplBase {
    private static final Logger logger = Logger.getLogger(BankStaffLoginImpl.class.getName());
    private static final IStaffService staffService = StaffService.getInstance();

    public void staffGetNewApplies(bankStaff_rpc.Empty request, StreamObserver<ListUserApplyArchiveEntitiesResponse> responseObserver) {
        try {
            //1 create result of service, which contains pin and some other attr
            ListUserApplyArchiveEntitiesResponse response = staffService.getUserApplyArchiveEntities();

            //2 set the above result to responseObserver
            responseObserver.onNext(response);
        } catch (Exception e) {
            responseObserver.onNext(ListUserApplyArchiveEntitiesResponse.newBuilder()
                    .build());
        }
        //3 Send all above to client
        responseObserver.onCompleted();
    }
}
