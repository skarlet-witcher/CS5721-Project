package rpc.impl.bank_staff;
import bankStaff_rpc.StaffLoginGrpc;
import bankStaff_rpc.StaffLoginResponse;
import io.grpc.stub.StreamObserver;
import service.IStaffService;
import service.impl.StaffService;

import java.util.logging.Logger;


public class BankStaffLoginImpl extends StaffLoginGrpc.StaffLoginImplBase {
    private static final Logger logger = Logger.getLogger(BankStaffLoginImpl.class.getName());
    private static final IStaffService staffService = StaffService.getInstance();

    @Override
    public void staffLogin(bankStaff_rpc.StaffLoginRequest request, StreamObserver<bankStaff_rpc.StaffLoginResponse> responseObserver) {
        Long userId = request.getStaffId();
        String password = request.getPassword();

        try {
            //1 create result of service, which contains pin and some other attr
            StaffLoginResponse staffLoginResponse = staffService.login(userId, password);

            //2 set the above result to responseObserver
            responseObserver.onNext(staffLoginResponse);
        } catch (Exception e) {
            responseObserver.onNext(StaffLoginResponse.newBuilder()
                    .setIsValid(false)
                    .setStatusCode(401)
                    .setDescription(e.getMessage())
                    .build());
        }
        //3 Send all above to client
        responseObserver.onCompleted();
    }
}
